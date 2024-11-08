<script setup>
import { ref } from 'vue';
import axios from 'axios';

const emit = defineEmits([
  "requestIdolList",
])

const idol = ref({
  name: '',
  gender: '',
})

const registerIdol = async() => {
  await axios.post(`http://192.168.210.40:8080/api/idol`, idol.value);
  requestIdolList();
}
const requestIdolList = () => {
  emit('requestIdolList');
}
</script>



<template>
  <div id="detail">
    <form @submit.prevent="registerIdol">
      <p>이름 : <input type="text" v-model="idol.name"></p>
      <p>성별 : <input type="text" v-model="idol.gender"></p>
      <button>등록</button>
    </form>
    <button @click="requestIdolList">목록버튼</button>
  </div>
</template>



<style scoped></style>