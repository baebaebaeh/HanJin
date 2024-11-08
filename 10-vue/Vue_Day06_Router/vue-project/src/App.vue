<template>
  <div>
    <h2>App.vue</h2>
    <nav>
      <!-- <RouterLink :to="{ path: '/' }">HomeName</RouterLink>  -->
      <RouterLink to="/">Home</RouterLink> | 
      <RouterLink to="/about">about</RouterLink> |
      <RouterLink :to="{ name: 'home' }">HomeName</RouterLink> |
      <RouterLink :to="{ name: 'about' }">aboutName</RouterLink> |

      <!-- <RouterLink to="/user/godqhr">양띵균</RouterLink> -->
      <RouterLink :to="{ name: 'user', params: { id: a } }">양띵균</RouterLink> |


      <!-- <RouterLink to="/user?id=godqhr">양띵균</RouterLink> -->
      <!-- <RouterLink :to="{ name: 'user', query: { id: a } }">양띵균</RouterLink> -->


      <RouterLink :to="{ name: 'user', params: { id: 'ssafy' } }">김싸피</RouterLink> |
      <RouterLink :to="{ name: 'login' }">로그인</RouterLink> |
      <RouterLink :to="{ name: 'board' }">보드</RouterLink> |
    </nav>

    <RouterView />
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router';
import { ref } from 'vue';
const a = ref('godqhr');
</script>

<style scoped></style>
