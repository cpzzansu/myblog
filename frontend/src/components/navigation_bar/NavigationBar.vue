<script>
import NavigationLogo from '@/components/navigation_bar/NavigationLogo.vue';
import NavigationMenu from "@/components/navigation_bar/NavigationMenu.vue";
import NavigationLogin from "@/components/navigation_bar/NavigationLogin.vue";

export default {
  name: 'NavigationBar',
  components:{
    NavigationLogo,
    NavigationMenu,
    NavigationLogin
  }
}
</script>
<template>
  <div class="navigation-div">
    <NavigationLogo></NavigationLogo>
    <NavigationMenu :menu="'블로그'"></NavigationMenu>
    <NavigationMenu :menu="'포트폴리오'"></NavigationMenu>
    <NavigationLogin></NavigationLogin>
  </div>
</template>
<style scoped>
.navigation-div{
  width: 1170px;
  height: 70px;
  padding-top: 4px;
  padding-bottom: 16px;
  justify-content: center;
  align-items: center;
  gap: 46px;
  display: flex;
  margin: 0 auto;
}
</style>