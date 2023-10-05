<script>
import {defineComponent, onMounted, ref} from 'vue';
import BlogListProfile from '@/components/blog_list/BlogListProfile.vue';
import BannerImage from '@/components/banner/BannerImage.vue';
import {useStore} from 'vuex';

export default defineComponent({
  components: {BannerImage, BlogListProfile},
  setup() {
    const blogs = ref([]);
    const store = useStore();

    onMounted(() => {
      blogs.value = store.state.blogs;
    });

    return {
      blogs,
    };
  },
});
</script>
<template>
  <div class="d-flex justify-content-center row">
    <BannerImage class="col-12"></BannerImage>
    <div class="col-md-9">
      <div class="d-flex align-items-center total-div">
        <div class="total-font">전체</div>
        <div class="total-number">{{ blogs.length }}</div>
      </div>
      <div v-for="blog in blogs" :key="blog.id">
        <div class="blog-list-main">
          <router-link
            :to="{name: 'blog', params: {id: blog.id}}"
            class="blog-div"
          >
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
          </router-link>
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
  margin-top: 100px;
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
.blog-div {
  text-decoration: none;
}
</style>
