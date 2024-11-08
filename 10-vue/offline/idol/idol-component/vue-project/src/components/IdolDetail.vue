<script setup>
import axios from 'axios';
import { ref } from 'vue';
const idol = ref({});
const emit = defineEmits([
  {requestIdolList: String},
])
const props = defineProps([
  {no: String},

]);
const requestDetailIdol = async () => {
  const { data } = await axios.get(`http://192.168.210.40:8080/api/idol/${props.no}`);
  console.log(data)
  idol.value = data;
}
const requestIdolList = async () => {
  emit('requestIdolList');
}
const deleteIdol = async(no) => {
  await axios.delete(`http://192.168.210.40:8080/api/idol/${no}`);
  requestIdolList();
}
requestDetailIdol();
</script>



<template>
  <div id="detail">
    <div>
      <p>번호 : {{ idol.no }} </p>
      <p>이름 : {{ idol.name }} </p>
      <p>성별 : {{ idol.gender }} </p>
    </div>
    <button @click="requestIdolList">목록버튼</button>
    <button @click="deleteIdol(idol.no)">삭제버튼</button>
  </div>
</template>





<style scoped></style>