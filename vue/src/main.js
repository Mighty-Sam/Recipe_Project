// 系統在執行時，最先會先去執行import,再來才是其他的事項

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store' //如果後面沒接要用哪個文件，系統會自動找index.js
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/Global.css'

Vue.config.productionTip = false

Vue.use(ElementUI)

let vvvue = new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

console.log('vue對象實力', vvvue)
