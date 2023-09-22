<script>
import ArticleProfileName from '@/components/article_profile/ArticleProfileName.vue';
import ArticleProfileButton from '@/components/article_profile/AricleProfileButton.vue';
import ArticleProfileNewsFeed from '@/components/article_profile/AticleProfileNewsFeed.vue';

export default {
  components: {
    ArticleProfileName,
    ArticleProfileButton,
    ArticleProfileNewsFeed,
  },
  data() {
    return {
      follow: '팔로우',
      coffeeChat: '☕ 커피챗',
    };
  },
};
</script>
<template>
  <div class="container d-flex justify-content-center">
    <div class="article-profile-div">
      <ArticleProfileName></ArticleProfileName>
      <div class="coffee-chat-btn d-flex justify-content-between">
        <ArticleProfileButton :button-name="follow"></ArticleProfileButton>
        <ArticleProfileButton :button-name="coffeeChat"></ArticleProfileButton>
      </div>
      <div class="NewsFeedDiv">
        <ArticleProfileNewsFeed></ArticleProfileNewsFeed>
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
  background: #00000000;
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
    background: #00000000;
    border-radius: 11px;
  }
}
.coffee-chat-btn {
  margin-top: 30px;
}
.NewsFeedDiv {
  margin-top: 15px;
}
</style>
