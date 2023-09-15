<script>
// import Calculator from '@/components/Calculator.vue';
import {defineComponent} from 'vue'
export default defineComponent({
  name: "Calculator",
  data(){
    return{
      n:1
    }
  },
  methods:{
    increment(){

    },
    decrement(){

    },
    incrementOdd(){

    },
    incrementWait(){
      setTimeout(()=>{

      },1000)
    }
  }
})
</script>

<template>
  <div>
    <h1>當前求和為: </h1>
    <select v-model.number="n">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
    </select>
    <button @click="increment">+</button>
    <button @click="decrement">-</button>
    <button @click="incrementOdd">當前總和為奇數再加</button>
    <button @click="incrementWait">等一秒再加</button>
  </div>
</template>

<style scoped>
    button{
      margin: 10px;
      padding: 10px;
    }

</style>