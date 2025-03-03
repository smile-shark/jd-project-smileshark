<template>
  <router-view/>
  <sidebar-view/> 
</template>
<style>
  body{
    margin:0;
    overflow-x: hidden;
  }
</style>
<script>
import SidebarView from '@/views/sidebar/SidebarView.vue';
export default{
  components:{
    SidebarView
  }
}
</script>