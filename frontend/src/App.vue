<template>
  <div>
    <NavigationBar></NavigationBar>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
import NavigationBar from '@/components/navigation_bar/NavigationBar.vue';
import Footer from '@/components/footer/Footer.vue';

export default {
  name: 'App',
  components: {NavigationBar, Footer},
};
</script>

<style>
#app {
  width: 1170px;
  display: flex;
  justify-content: center;
}
body {
  @font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
      format('woff');
    font-weight: 400;
    font-style: normal;
  }
  font-family: Pretendard-Regular;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: flex;
  justify-content: center;
  text-align: center;
  background-color: #1c1c20 !important;
}
</style>
