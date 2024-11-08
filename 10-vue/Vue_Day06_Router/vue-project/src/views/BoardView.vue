<template>
  <div>
    <h3>BoardView</h3>
    <RouterLink to="/board">게시글 목록</RouterLink> |
    <RouterLink :to="{name : 'boardList'}">게시글 목록</RouterLink> |
    <RouterLink to="/board/create">게시글 등록</RouterLink> |
    <RouterLink :to="{name : 'boardCreate'}">게시글 등록</RouterLink> |
    <hr>
    <RouterView/>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter();

function moveCreate() {
  /*
  {
    path: '/board/create/:no',
    name: 'boardCreate',
  }
  */
  // 프로그램상에서 페이지 이동
  router.push("/board/create"); // path형태로 이동
  router.push({name : 'boardCreate', params: {no: 10}}); // name 방식으로 이동
  router.push({name : 'boardCreate', params: {no: 10}}); // name 방식으로 이동
  // 위처럼 작성하면
  // /board/create?no=10 으로 가겠구나
  router.push({path : '/board/create/10', }); // path 방식으로 이동


}
</script>

<style scoped>

</style>
