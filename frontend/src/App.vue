<template>
  <div class="container">
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
  // eslint-disable-next-line
  components: {NavigationBar, Footer},
};
</script>

<style>
body {
  @font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
      format('woff');
    font-weight: 400;
    font-style: normal;
  }
  font-family: Pretendard-Regular, 'Apple SD Gothic Neo';
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: flex;
  justify-content: center;
  text-align: center;
  background-color: #1c1c20 !important;
}

@media (min-width: 1400px) {
  .container,
  .container-lg,
  .container-md,
  .container-sm,
  .container-xl,
  .container-xxl {
    max-width: 1140px;
  }
}
</style>
