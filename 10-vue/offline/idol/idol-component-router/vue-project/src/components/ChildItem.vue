<script setup>
import { ref } from 'vue';
import axios from 'axios';
const props = defineProps([
  'name',
  'age'
  ])
console.log(props.name)
console.log(props.age)
</script>


<template>
  <div>
    <h3>이름 : {{ name }}</h3>
    <h3>나이 : {{ age }}</h3>
  </div>
</template>


<style scoped>

</style>