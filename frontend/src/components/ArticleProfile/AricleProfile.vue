<script>
import ArticleProfileName from '@/components/ArticleProfile/ArticleProfileName.vue';
import ArticleProfileButton from '@/components/ArticleProfile/AricleProfileButton.vue';
export default {
  components: {
    ArticleProfileName,
    ArticleProfileButton,
  },
};
</script>
<template>
  <div class="container d-flex justify-content-center">
    <div class="article-profile-div">
      <ArticleProfileName></ArticleProfileName>
      <div class="coffee-chat-btn d-flex justify-content-between">
        <ArticleProfileButton></ArticleProfileButton>
        <ArticleProfileButton></ArticleProfileButton>
      </div>
    </div>
  </div>
</template>
<style scoped>
.article-profile-div {
  position: fixed;
  margin-left: 800px;
  top: 300px;
  width: 330px;
  height: 390px;
  background: #1c1c20;
  border-radius: 11px;
}
@media (max-width: 1200px) {
  .article-profile-div {
    position: inherit;
    margin-left: auto;
    margin-right: auto;
    margin-top: 50px;
    top: 300px;
    width: 330px;
    height: 390px;
    background: #1c1c20;
    border-radius: 11px;
  }
}
.coffee-chat-btn {
  margin-top: 30px;
}
</style>
