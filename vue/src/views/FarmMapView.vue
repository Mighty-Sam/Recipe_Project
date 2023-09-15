<script>
import {defineComponent} from 'vue'
import axios from "axios";
import cityName from "@/assets/CityName.json";
import L from "leaflet";
let osmMap = {};

// const iconsConfig = {
//   iconSize: [25, 41],
//   iconAnchor: [12, 41],
//   popupAnchor: [1, -34],
//   shadowSize: [41, 41],
// };
// const icons = {
//   green: new L.Icon({
//     iconUrl: 'https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png',
//     ...iconsConfig,
//   }),
// }

export default defineComponent({
  name: "FarmMapView",
  data(){
    return{
      result: [],
      cityName,
      select: {
        city: "桃園市",
        area: "大溪區"
      },
    }
  },
  methods:{

    // 選擇不同縣市後，插上對應圖標
    updateMap(){
      const farms = this.result.filter((farm) =>(
          // 因為資料的經緯度有些是""空的，所以要多加判斷來確保filter過的資料是都有提供經緯度的
          farm.City === this.select.city && farm.Latitude !== "" && farm.Longitude !== ""));

      farms.forEach((farm) =>{
        L.marker([
            farm.Latitude,
            farm.Longitude
        ]).addTo(osmMap).bindPopup(`
        <strong><i class="bi bi-bookmark-check-fill"></i><span style="color: #5353ad; font-weight: bold; font-size: large">${farm.Name}</span></strong> <br><br>
        <span style="background-color: #5353ad; color: white; border-radius: 5px; margin-right: 5px">地址:</span>${farm.Address} <br><br>
        <span style="background-color: #5353ad; color: white; border-radius: 5px; margin-right: 5px">電話:</span>${farm.Tel !== "" ? farm.Tel : "無"} <br><br>
        <span style="background-color: #5353ad; color: white; border-radius: 5px; margin-right: 5px">簡介:</span>${farm.FoodFeature}`
        );
      })
      console.log("farms: " + farms.length)
      // 地圖會跳到選中縣市的第一個農場位置
      this.penTo(farms[0])
    },

    // 更換縣市時，先將原本的縣市markers給移除
    removeMarker(){
      osmMap.eachLayer((layer)=>{
        if(layer instanceof L.Marker){ // 要注意Marker是大寫開頭的
          osmMap.removeLayer(layer);
        }
      })
    },
    penTo(item){
      osmMap.panTo([item.Latitude, item.Longitude]).setZoom(15)

    },
    updateSelect() {
      this.removeMarker();
      this.updateMap();
      const farms = this.result.find(item => item.Town === this.select.area);

      osmMap.penTo(farms);
    },
  },
  mounted() {

    // 串接農場資料
    axios.get("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx?IsTransData=1&UnitId=193")
        .then((res) => {
          this.result = res.data;
          this.updateMap();


          // this.updateSelect();
          console.log(res.data)
        })
        .catch((error) => {
          console.error("API請求失敗:", error);
        });

    //設定初始地圖中心位置
    osmMap = L.map('map').setView([24.854966, 121.282727], 11);

    // 加入地圖
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(osmMap);

  }

})
</script>

<template>
  <div id="app">
    <div class="row no-gutters">
      <div class="col-sm-3">
        <div class="toolbox">
          <div class="sticky-top bg-white shadow-sm p-2">
            <div class="form-group d-flex">
              <label for="cityName" class="mr-2 col-form-label text-right">縣市</label>
              <div class="flex-fill">
                <select id="cityName" class="form-control" v-model="select.city" @change="removeMarker(); updateMap()">
                  <option value="">-- Select One --</option>
                  <option :value="c.CityName" v-for="c in cityName" :key="c.CityName">{{c.CityName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group d-flex">
              <label for="area" class="mr-2 col-form-label text-right">地區</label>
              <div class="flex-fill">
                <select id="area" class="form-control" v-if="select.city.length"
                        v-model="select.area" @change="updateSelect">
                  <option value="">-- Select One --</option>
                  <option :value="a.AreaName"
                          v-for="a in cityName.find((city) => city.CityName === select.city).AreaList"
                          :key="a.AreaName">
                    {{ a.AreaName }}
                  </option>
                </select>
              </div>
            </div>
            <p class="mb-0 small text-muted text-right">請先選擇區域查看!</p>
          </div>
          <ul class="list-group">
            <template v-for="(item, key) in result">
              <a class="list-group-item text-left" :key="key"
                 v-if="item.City === select.city
                && item.Town === select.area"

                 @click="penTo(item)">
                <h3>{{ item.Name }}</h3>
                <p class="mb-0">
                  縣市：{{ item.City}} | 鄉鎮：{{ item.Town}}
                </p>
                <p class="mb-0">地址：<a :href="`https://www.google.com.tw/maps/place/${item.Address}`"
                                        target="_blank" title="Google Map">
                  {{ item.Address }}</a>
                </p>
                <p class="mb-0">電話： {{item.Tel}}</p>
              </a>
            </template>
          </ul>
        </div>
      </div>
      <div class="col-sm-9">
        <div id="map"></div>
      </div>
    </div>
  </div>
</template>

<style scope>
@import "../../node_modules/bootstrap";

#map {
  height: 85vh;
  border-radius: 10px;
}
select{
  margin: 0 5px;
}
.highlight {
  background: #e9ffe3;
}
.toolbox {
  height: 85vh;
  overflow-y: auto;
}
.toolbox a{
  cursor:progress;

}

.form-group{
  margin-bottom: 20px;
}
</style>