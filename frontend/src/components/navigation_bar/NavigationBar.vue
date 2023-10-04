<script>
import NavigationLogo from '@/components/navigation_bar/NavigationLogo.vue';
import NavigationMenu from '@/components/navigation_bar/NavigationMenu.vue';
import NavigationLogin from '@/components/navigation_bar/NavigationLogin.vue';
import NavigationProfile from '@/components/navigation_bar/NavigationProfile.vue';
import NavigationBlogWrite from '@/components/navigation_bar/NavigationBlogWrite.vue';

export default {
  name: 'NavigationBar',
  components: {
    NavigationLogo,
    NavigationMenu,
    NavigationLogin,
    NavigationProfile,
    NavigationBlogWrite,
  },
};
</script>
<template>
  <div class="nbd">
    <nav class="navbar navbar-content">
      <div class="container">
        <div class="navigation-div col-xs-12 col-12">
          <NavigationLogo linkTo="/"></NavigationLogo>
          <NavigationMenu menu="블로그" linkTo="/"></NavigationMenu>
          <NavigationMenu menu="포트폴리오" linkTo="/"></NavigationMenu>
          <NavigationBlogWrite></NavigationBlogWrite>
          <navigationProfile></navigationProfile>
          <NavigationLogin></NavigationLogin>
        </div>
      </div>
    </nav>
  </div>
</template>
<style scoped>
.navigation-div {
  height: 100px;
  padding-top: 15px;
  padding-bottom: 25px;
  justify-content: center;
  align-items: center;
  gap: 46px;
  display: flex;
  margin: 0;
}
</style>
