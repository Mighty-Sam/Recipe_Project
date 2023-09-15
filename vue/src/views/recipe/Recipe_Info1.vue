<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Recipe_Info1",
  data(){
    return {
      countdown: 3,
      timer: null
    }
  },
  methods:{

    redirectToHomePage() {

      this.timer = setInterval(() => {

        if (this.countdown > 0) {
          this.countdown--;
          if (this.countdown === 0) {
            setTimeout(()=>{
              clearInterval(this.timer);
              this.timer = null;
              this.$router.push({ name: 'home' });
            },1000);
          }
        }
      }, 1000); // 每秒执行一次
    },

    stopCountdown() {
      if (this.timer) {
        clearInterval(this.timer);
        this.timer = null;
      }
    }
  }
})
</script>

<template>
  <div id="app">
    <h2>第二級router</h2>
    <br>
    <h2>這是在recipe_info<span> 1 </span>的頁面</h2>
    <br>
    <br>

    <router-link :to="{name:'recipe-info2', query:{data:'我傳遞數據來了褲吧'}}">
      <button>
      點我跳轉至info2頁面
      </button>
    </router-link>

    <button @click="redirectToHomePage">點我跳轉頁面 <span class="timer">{{countdown}}</span>s</button>
    <button @click="stopCountdown" v-show="countdown !==3">停止跳轉</button>
  </div>

</template>

<style scoped>
#app{
  display: flex;
  flex-direction: column;
  align-items: center;
}
span{
  background-color: #ef0e0e;
  color: #f3dc47;
}
button{
  width: 250px;
  height: 40px;
  margin: 10px;
  font-size: larger;
}
</style>