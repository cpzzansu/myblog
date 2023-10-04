<script>
import {defineComponent, onMounted, ref} from 'vue';
import BlogListProfile from '@/components/blog_list/BlogListProfile.vue';
import axios from 'axios';

export default defineComponent({
  components: {BlogListProfile},
  setup() {
    const token = localStorage.getItem('accessToken');
    const blogs = ref([]);
    onMounted(() => {
      const response = axios.get('/api/private/blog', {
        headers: {
          Authorization: 'Bearer ' + token,
        },
      });

      response.then((res) => {
        blogs.value = res.data;
        console.log(blogs);
      });

      response.catch((error) => {
        console.log(error);
      });
    });

    return {
      blogs,
    };
  },
});
</script>
<template>
  <div class="d-flex justify-content-center">
    <div class="col-md-9">
      <div class="d-flex align-items-center total-div">
        <div class="total-font">전체</div>
        <div class="total-number">4000</div>
      </div>
      <div v-for="blog in blogs" :key="blog.id">
        <div class="blog-list-main">
          <div class="d-flex">
            <div class="description-title">#자바스크립트</div>
            <div class="description-title">#자바스크립트</div>
          </div>
          <div class="list-title">
            {{ blog.blogTitle }}
          </div>
          <div class="list-content">
            {{ blog.blogContent }}
          </div>
          <BlogListProfile
            :memberProfileDto="blog.memberProfileDto"
          ></BlogListProfile>
        </div>
      </div>
    </div>
  </div>
</template>
<style>
.blog-list-main {
  background-color: #333333;
  border-radius: 20px;
  margin-top: 20px;
}
.total-font {
  color: #fbfbfc;
  font-weight: 800;
  font-size: 26px;
}
.total-number {
  color: #9b9b9b;
  margin-left: 10px;
  font-weight: 700;
  font-size: 26px;
}
.total-div {
  margin-bottom: 20px;
}
.description-title {
  font-family: Pretendard-Regular;
  color: #97989c;
  font-size: 16px;
  display: flex;
  font-weight: 800;
  padding-top: 20px;
  margin-left: 12px;
}
.list-title {
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-size: 25px;
  font-weight: 900;
  color: #fbfbfc;
  text-align: left;
  margin-left: 12px;
  padding: 10px 0px;
}
.list-content {
  color: #d4d4dc;
  text-align: left;
  font-family: Pretendard-Regular, 'Apple SD Gothic Neo';
  font-weight: 400;
  letter-spacing: -0.02px;
  font-style: normal;
  margin-left: 12px;
  margin-right: 12px;
}
</style>
