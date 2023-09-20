<script>
import NavigationLogo from '@/components/navigation_bar/NavigationLogo.vue';
import NavigationMenu from '@/components/navigation_bar/NavigationMenu.vue';
import NavigationLogin from '@/components/navigation_bar/NavigationLogin.vue';
import MinNavLogo from '@/components/navigation_bar/MinNavLogo.vue';

export default {
  name: 'NavigationBar',
  components: {
    NavigationLogo,
    NavigationMenu,
    NavigationLogin,
    MinNavLogo,
  },
};
</script>
<template>
  <div class="nbd">
    <nav class="navbar navbar-content">
      <div class="container">
        <div class="navigation-div col-12">
          <NavigationLogo></NavigationLogo>
          <NavigationMenu :menu="'블로그'"></NavigationMenu>
          <NavigationMenu :menu="'포트폴리오'"></NavigationMenu>
          <NavigationLogin></NavigationLogin>
        </div>
      </div>
    </nav>
    <nav class="navigation-mobile">
      <div class="navbar-mobile-content">
        <MinNavLogo></MinNavLogo>
      </div>
    </nav>
  </div>
</template>
<style scoped>
.navigation-div {
  width: 1140px;
  height: 100px;
  padding-top: 15px;
  padding-bottom: 25px;
  justify-content: center;
  align-items: center;
  gap: 46px;
  display: flex;
  margin: 0;
}
.navigation-mobile {
  display: flex;
  justify-content: center;
}
/* 기본 스타일 */
.navbar-content {
  display: block;
}

.navbar-mobile-content {
  display: none;
}

/* 576px 이하에서의 스타일 */
@media (max-width: 576px) {
  .navbar-content {
    display: none;
  }
  .navbar-mobile-content {
    display: block;
    height: 100px;
  }
}
</style>
