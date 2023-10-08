<script>
import {defineComponent} from 'vue';
import BlogWriteTitle from '@/components/blog_write/BlogWriteTitle.vue';
import BlogAddForm2 from '@/components/blog_write/BlogAddForm2.vue';

export default defineComponent({
  components: {BlogWriteTitle, BlogAddForm2},
});
</script>
<template>
  <div class="d-flex justify-content-center">
    <div class="col-md-11">
      <BlogWriteTitle></BlogWriteTitle>
      <BlogAddForm2></BlogAddForm2>
    </div>
  </div>
</template>
<style></style>
