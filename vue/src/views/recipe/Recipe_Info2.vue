<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Recipe_Info2",
  data(){
    return{
      deliveredData: null
    }
  },
  created() {
    this.deliveredData= this.$route.query.data
  }
})
</script>

<template>
  <div id="app">
    <h2>這是在recipe_info<span> 2 </span>的頁面</h2>
    <p>傳遞來的訊息: {{deliveredData == null? '無新訊息!' : deliveredData}}</p>

  </div>

</template>

<style scoped>
    span{
      background-color: black;
      color: aquamarine;
    }
</style>