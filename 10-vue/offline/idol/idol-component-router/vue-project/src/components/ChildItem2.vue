<script setup>
import { ref } from 'vue';
const msg = ref("");
const emit = defineEmits([
  'recvData',
])
const sendData = () => {
  console.log(msg.value);
  emit('recvData', msg.value)
}
</script>


<template>
  <div>
    <h2>자식 컴포넌트 2</h2>
    <input type="text" v-model="msg" />
    <button @click="sendData">데이터 전달</button>
  </div>
</template>


<style scoped>

</style>