<script>
import BannerImage from '@/components/banner/BannerImage.vue';
import MainContent from '@/components/main_content/MainContent.vue';
import Footer from '@/components/footer/Footer.vue';
import ArticleProfile from '@/components/article_profile/AricleProfile.vue';
import axios from 'axios';

export default {
  name: 'HomePage',
  components: {
    BannerImage,
    MainContent,
    // eslint-disable-next-line
    Footer,
    ArticleProfile,
  },
  created() {
    const token = localStorage.getItem('token'); // 예를 들어 token이 로컬 스토리지에 저장되어 있다고 가정
    // prettier-ignore
    axios
      .get('/api/private/resource', {
        headers: {
          'Authorization': 'Bearer ' + token,
        },
      })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 401) {
          this.$router.push('/login');
        }
      });
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
