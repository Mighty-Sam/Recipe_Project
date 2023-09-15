<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Recipe",
  props: ['id']
})
</script>

<template>
  <div id="app">
    <h2>這是第一層router</h2>
    <h2>this is our recipe page!</h2>
    <p>我們的id:  {{id}}</p>
    <router-link :to="{name: 'recipe-info1', params: {id: 2}}">第一資訊</router-link>   |
    <router-link :to="{name: 'recipe-info2', params: {id: 4}}">第二資訊</router-link>
    <router-view/>
  </div>

</template>

<style scoped>
    #app{
      width: 500px;
      height: 500px;
      margin: auto ;
    }
    h2{
      color: cadetblue;
      background-color: #545c64;
    }
    p{
      margin: 60px;
    }
</style>

