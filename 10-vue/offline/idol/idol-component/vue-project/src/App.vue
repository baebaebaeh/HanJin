<script setup>
import IdolIndex from './views/IdolIndex.vue';
import axios from 'axios';
import { ref } from 'vue';
import ChildItem from './components/ChildItem.vue';
import ChildItem2 from './components/ChildItem2.vue';
const peoples = ref([
  {name: '홍길동', age: '20'},
  {name: '이순신', age: '30'},
  {name: '장보고', age: '40'},
])
const msg = ref('');
const recvData = (data) => {
  msg.value = data;
}
</script>



<template>
  <div>
    <h2>컴포넌트의 세계로 오신걸 환영합니다.</h2>
    <ChildItem2 @recvData="recvData" />
    <h2>자식컴포넌트에서 전송된 메시지 : {{ msg }}</h2>
    <template v-for="people in peoples">
      <ChildItem :name="people.name" :age="people.age"/>
    </template>
  </div>



  <div>
    <IdolIndex/>
  </div>



  
</template>



<style scoped>

</style>
