<script>
import BannerImage from '@/components/banner/BannerImage.vue';
import MainContent from '@/components/main_content/MainContent.vue';
import Footer from '@/components/footer/Footer.vue';
import ArticleProfile from '@/components/ArticleProfile/AricleProfile.vue';

export default {
  name: 'HomePage',
  components: {
    BannerImage,
    MainContent,
    Footer,
    ArticleProfile,
  },
};
</script>

<template>
  <div>
    <BannerImage></BannerImage>
    <MainContent></MainContent>
    <ArticleProfile></ArticleProfile>
    <Footer></Footer>
  </div>
</template>
<style>
.container {
  padding: 0;
}
</style>
