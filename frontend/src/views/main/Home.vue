<script>
import BannerImage from '@/components/banner/BannerImage.vue';
import MainContent from '@/components/main_content/MainContent.vue';
import Footer from '@/components/footer/Footer.vue';
import ArticleProfile from '@/components/article_profile/AricleProfile.vue';

export default {
  name: 'HomePage',
  components: {
    BannerImage,
    MainContent,
    // eslint-disable-next-line
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
  </div>
</template>
<style>
.container {
  padding: 0;
}
</style>
