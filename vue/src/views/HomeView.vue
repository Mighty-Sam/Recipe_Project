
<script>

export default {

  data() {
    return {
      input: '',
      loginInfo: ''
    }
  },
  name: 'HomeView',
  mounted() {
    this.loginInfo = this.$store.state.loginInfo


  },

  methods:{
    open4() {
      this.$message.error('密碼錯誤!');
    }
  }
}
</script>


<template>
  <div id="app">
    <p>登入狀態: {{loginInfo}}</p>
    <h1>歡迎來到主頁!!!!!!</h1>

    <button>測試按鈕</button>
    <el-button type="primary" plain size="mini">主要按钮</el-button>
    <el-button type="danger" icon="el-icon-delete" circle></el-button>
    <el-button type="warning" round>警告按钮</el-button>
    <br>
    <el-input placeholder="請輸入密碼" v-model="input" show-password></el-input>
    <p>look at me!{{input}}</p>
    <el-button type="danger" @click="open4">wrong</el-button>
  </div>
</template>

