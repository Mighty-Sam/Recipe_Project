import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import VideoView from "@/views/VideoView.vue";
import RecipeView from "@/views/RecipeView.vue";
import Recipe_Info1 from "@/views/recipe/Recipe_Info1.vue";
import Recipe_Info2 from "@/views/recipe/Recipe_Info2.vue";
import AboutView from "@/views/AboutView.vue"
import MemberManagementView from "@/views/MemberManagementView.vue";
import Calculator from "@/components/Calculator.vue";
import FarmMapView from "@/views/FarmMapView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView // 可以在上面先import component, 也可像AboutView一樣後續再import
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView
  },
  {
    path: '/video',
    name: 'video',
    component: VideoView
  },
  {
    path: '/recipe/:id', // :代表可以動態接收參數， 這裡接收id
    name: 'recipe',
    component: RecipeView,
    props: true,
    children: [
      {path: 'info1', name: 'recipe-info1', component: Recipe_Info1},
      {path: 'info2', name: 'recipe-info2', component: Recipe_Info2}
    ]
  },
  {
    path: '/user/search',
    name: 'user',
    component: MemberManagementView
  },
  {
    path: '/farmMap',
    name: 'farm-map',
    component: FarmMapView
  }
  // {
  //   path: '/calculator',
  //   name: 'calculator',
  //   component: Calculator
  // },
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to,from,next)=>{
  console.log('路由觸發了')
  next()
})

export default router
