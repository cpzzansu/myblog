<script>
import DescriptionTitle from '@/components/main_content/DescriptionTitle.vue';
import BlogTitle from '@/components/main_content/BlogTitle.vue';
import BlogRegistDate from '@/components/main_content/BlogRegistDate.vue';
import ArticleBody from '@/components/main_content/ArticleBody.vue';

export default {
  components: {
    DescriptionTitle,
    BlogTitle,
    BlogRegistDate,
    ArticleBody,
  },
};
</script>
<template>
  <div class="container">
    <div class="main-content col-12 col-md-12 col-lg-10 col-xl-8">
      <DescriptionTitle></DescriptionTitle>
      <BlogTitle></BlogTitle>
      <BlogRegistDate></BlogRegistDate>
      <ArticleBody></ArticleBody>
    </div>
  </div>
</template>
<style>
.main-content {
  width: 690px;
  padding-top: 30px;
}
</style>
