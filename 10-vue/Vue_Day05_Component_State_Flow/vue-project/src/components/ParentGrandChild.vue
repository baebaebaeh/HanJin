<template>
    <div>
        <h5>손자컴포넌트</h5>
        <p>{{ myMsg }}</p>
        <input type="text" v-model="name">
        <p>신청 이름 : {{ name }}</p>
        <button @click="updateName">이름 개명 신청</button>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    defineProps({
        myMsg: String
    })

    const emit = defineEmits(['updateNamee'])
    const updateName = function(){
        emit('updateNamee', name.value)
        name.value = "" //개명 신청 후 input 창 비웠다.
    }

    const name = ref("")

</script>

<style scoped>

</style>