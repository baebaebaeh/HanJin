<script setup>
import IdolList from '@/components/IdolList.vue';
import IdolDetail from '@/components/IdolDetail.vue';
import IdolRegist from '@/components/IdolRegist.vue';
import { ref } from 'vue';
const currentView = ref("list");
const no = ref(0);
const doDetailView = (idolNo) => {
  no.value = idolNo;
  currentView.value = "detail";
}
const doIdolList = () => {
  currentView.value = "list";
}
const doRegistIdol = () => {
  currentView.value = "registForm";
}
</script>

<template>
  <div>
    <IdolList @detailView="doDetailView" @registIdol="doRegistIdol"
              v-if="currentView === 'list'" />
    <IdolDetail @requestIdolList="doIdolList" 
                :no="no"
                v-if="currentView === 'detail'" />
    <IdolRegist @requestIdolList="doIdolList"
                v-if="currentView === 'registForm'" />
  </div>
</template>

<style scoped>

</style>