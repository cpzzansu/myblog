<script>
import DescriptionTitle from "@/components/main_content/DescriptionTitle.vue";
import BlogTitle from "@/components/main_content/BlogTitle.vue";
import BlogRegistDate from "@/components/main_content/BlogRegistDate.vue";
import ArticleBody from "@/components/main_content/ArticleBody.vue";

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
  <div class="main-content">
    <DescriptionTitle></DescriptionTitle>
    <BlogTitle></BlogTitle>
    <BlogRegistDate></BlogRegistDate>
    <ArticleBody></ArticleBody>
  </div>
</template>
<style>
.main-content {
  width: 690px;
  padding-top: 30px;
}
</style>
