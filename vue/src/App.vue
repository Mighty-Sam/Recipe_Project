<template>
  <div id="app">
    <el-container>
      <el-header style="background-color: #3a3838; height: 10vh; position: relative; display: flex; align-items: center">
        <!--  logo -->
        <img src="@/assets/logo.png" alt="logo" style="width: 10vh; ">
        <span style="font-size: 50px; margin-left: 15px; color: white">Sam's kitchen</span>
        <!--  menu-->
        <el-menu
            class="el-menu-demo"
            mode="horizontal"
            background-color="#3a3838"
            text-color="#fff"
            style="display: flex; flex-direction: row;"
            active-text-color="#ffd04b">

          <router-link to="/">
            <el-menu-item index="1">首頁</el-menu-item>
          </router-link>

          <router-link to="/about">
          <el-menu-item index="2">處理豬新</el-menu-item>
          </router-link>

          <router-link to="/video">
            <el-menu-item index="3">影片區</el-menu-item>
          </router-link>

          <router-link :to="{name: 'recipe', params: {id: 55}}">
            <el-menu-item index="4">食譜區</el-menu-item>
          </router-link>

          <router-link to="/user/search">
            <el-menu-item index="5">會員管理</el-menu-item>
          </router-link>

          <el-submenu index="6">
            <template slot="title">我的工作台</template>
            <el-menu-item index="6-1">1</el-menu-item>
            <el-menu-item index="6-2">2</el-menu-item>
            <el-menu-item index="6-3">3</el-menu-item>
            <el-submenu index="6-4">
              <template slot="title">4</template>
              <el-menu-item index="6-4-1">1</el-menu-item>
              <el-menu-item index="6-4-2">2</el-menu-item>
              <el-menu-item index="6-4-3">3</el-menu-item>
            </el-submenu>
          </el-submenu>

          <router-link to="/farmMap">
            <el-menu-item index="7">農場猩據點</el-menu-item>
          </router-link>

          <el-menu-item index="8"><a href="#">登出</a></el-menu-item>


        </el-menu>
      </el-header>
    </el-container>

    <el-container>
<!--      <el-aside style="overflow: hidden; min-height: calc(100vh - 10vh); background-color: #545c64; width: 250px">-->
<!--        <router-view name="video"></router-view>-->
<!--      </el-aside>-->
      <el-main>
        <router-view/>
<!--        <el-switch-->
<!--            v-model="value1"-->
<!--            active-text="開啟"-->
<!--            inactive-text="關閉">-->
<!--        </el-switch>-->
<!--        <el-switch-->
<!--            style="display: block"-->
<!--            v-model="value2"-->
<!--            active-color="#13ce66"-->
<!--            inactive-color="#ff4949"-->
<!--            active-text="開啟"-->
<!--            inactive-text="關閉">-->
<!--        </el-switch>-->
      </el-main>
    </el-container>


  </div>
</template>
<script>
export default {
  data() {
    return {
      value1: true,
      value2: true
    }
  }
};
</script>

