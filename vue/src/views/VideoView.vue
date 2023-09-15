<script>
import {defineComponent} from 'vue'
import Calculator from '@/components/Calculator.vue';

export default defineComponent({
  name: "Video",
  components:{Calculator}
})
</script>

<template>
  <div>
    <h3>this is the video vue component!</h3>
    <Calculator />
  </div>

</template>

<style scoped>
  h3{
    color: mediumvioletred;
  }

</style>

