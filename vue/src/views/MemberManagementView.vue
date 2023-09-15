<script>
import {defineComponent} from 'vue'
import axios from "axios";

export default defineComponent({
  name: "MemberManagementView",
  data(){
    return{
      members:''
    }
  },
  mounted() {
    // url是填後端的
    axios.get("http://localhost:8080/user/search").then(res => {
      if (res.data.code){
        this.members = res.data.data;
        console.log("user接收成功")
      }
    })
  }
})
</script>

<template>
    <div id="app" >
        <ul v-for="(item, index) in members">
          <li>{{index +1}}. username: {{item.username}}</li>
          <li> password: {{item.password}}</li>
          <li> nickname: {{item.nickname}}</li>
        </ul>
    </div>
</template>

<style scoped>
  #app{
    width: 600px;
    aspect-ratio: 1;
    background-color: rgba(255, 255, 0, 0.68);
  }
</style>