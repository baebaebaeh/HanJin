<template>
    <div>
        <h3>부모 컴포넌트</h3>
        <ParentChild @update-nameeee="updateNameeeee"  @some-event="someCallback" @emit-argss="getNumber"
        my-msg="message" :dynamic-name="name" :person="person"/>
    </div>
</template>

<script setup>
    import {ref} from 'vue';
    import ParentChild from './ParentChild.vue';

    const name = ref("Kim")
    const person = ref({
        name:"Yang",
        age: 45
    })

    const someCallback = function() {
        console.log("어떠한 이벤트가 발생했습니다.")
    }

    const getNumber = function(...args){
        console.log(args)
    }

    const updateNameeeee = function(newName){
        name.value = newName
    }

</script>

<style  scoped>

</style>