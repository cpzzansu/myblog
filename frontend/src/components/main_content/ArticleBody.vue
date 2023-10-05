<script setup>
import {nextTick, onMounted, ref} from 'vue';
import {useStore} from 'vuex';
import 'prismjs/themes/prism-tomorrow.min.css'; // 원하는 테마 선택
import Prism from 'prismjs';
import 'prismjs/components/prism-java'; // 예를 들어 Java 구성 요소

const store = useStore();

//블로그 본문 변수
const blogContent = ref('');

//store에서 블로그 본문 변수 가져오기
onMounted(async () => {
  blogContent.value = store.state.blogDetail.blogContent;
  await nextTick();
  Prism.highlightAll();
});
</script>
<template>
  <body>
    <article v-html="blogContent" class="col-12"></article>
  </body>
</template>
<style scoped>
body {
  color: #d4d4dc;
  text-align: left;
  font-family: Pretendard-Regular, 'Apple SD Gothic Neo';
  font-weight: 400;
  letter-spacing: -0.02px;
  font-style: normal;
  margin-left: 5px;
  margin-right: 5px;
}
strong {
  font-weight: 900;
}
p {
  font-size: 18px;
  line-height: 160%;
  word-break: break-all;
}
h2 {
  font-size: 2rem;
}
h2,
h3,
h4,
h5 {
  line-height: 150%;
  margin-bottom: 0.5rem;
  font-weight: 500;
}
pre {
  max-width: 100% !important;
  overflow: auto !important;
}
</style>
