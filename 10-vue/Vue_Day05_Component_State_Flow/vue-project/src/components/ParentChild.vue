<template>
  <div>
    <h4>자식컴포넌트</h4>
    <p>{{ myMsg }}</p>
    <p v-text="myMsg"></p>
    <p>{{ dynamicName }}</p>
    <p>{{ person }}</p>
    <hr>
    <button @click="$emit('someEvent')">부모전송</button>
    <button @click="buttonClick">부모전송2</button>
    <button @click="emitArgs">추가인자전달</button>
    <hr>
    <ParentGrandChild @update-namee="updateNameee" :my-msg="myMsg"/>

  </div>
</template>

<script setup>
//부모로부터 받은 props를 사용하기 위한 방법은 크게 2가지
defineProps(['myMsg']) //너무나도 심플한 받기
// 적어도 타입정도는 알려줘 더 자세히 써주면 좋고... 
const props = defineProps({
  myMsg: String,
  dynamicName: String,
  person: Object
});

import ParentGrandChild from './ParentGrandChild.vue';



const emit = defineEmits(["someEvent", 'emitArgss', 'updateNameeee'])
//복잡할 경우엔 메서드를 이용해서 작성을 하는것 조금 더 가독성과 작업을 하기 좋다
const buttonClick = function() {
    emit("someEvent")
}
const emitArgs = function(){
    emit('emitArgss', 1, 2, 3)
}

const updateNameee = function(namee){
    console.log(namee)
    emit('updateNameeee', namee)
}
console.log(props.myMsg)
</script>

<style scoped></style>
