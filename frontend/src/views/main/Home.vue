<script>
import NavigationBar from '@/components/navigation_bar/NavigationBar.vue';
import BannerImage from '@/components/banner/BannerImage.vue';
import MainContent from '@/components/main_content/MainContent.vue';

export default {
  name: 'HomePage',
  components: {
    NavigationBar,
    BannerImage,
    MainContent,
  },
};
</script>

<template>
  <div>
    <NavigationBar></NavigationBar>
    <BannerImage></BannerImage>
    <MainContent></MainContent>
  </div>
</template>
<style>
.container {
  padding: 0;
}
</style>
