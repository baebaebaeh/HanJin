<template>
  <div>
    <h3>UserView</h3>
    <!-- 아래와 같이 바로 접근이 되기는 하지만... 권장은 x -->
    <p>{{ $route.params.id }}</p>
    <!-- 아래의 방식으로 사용하는 것을 권장 -->
    <p>{{ userId }}</p>
    <p>{{ userId2 }}</p>

    <hr>

    <button @click="goHome">홈으로</button>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter } from 'vue-router';

  const route = useRoute()
  const router = useRouter()

  const userId = ref(route.params.id)
  const userId2 = ref(route.params.id)
  watch(()=>route.params.id,(newId)=>{
    userId.value = newId
  })

  const goHome = function() {
    //직접 URL 경로를 작성할 수 있음.
    // router.push('/')
    // 이름으로 호출도 할 수 있음
    // router.push({name: 'about'})
    router.replace({name: 'home'})
  }

  // 떠날때
  onBeforeRouteLeave(()=>{
    const answer = confirm("정말로 떠나실 건가요?")
    console.log(answer)
    // if(!answer) return false
    return answer
  })

  // 매개변수가 업데이트 될때
  onBeforeRouteUpdate((to)=>{
    userId2.value = to.params.id
  })

</script>

<style scoped>

</style>
