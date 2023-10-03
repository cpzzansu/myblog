<script>
import {defineComponent} from 'vue';
import BlogWriteTitle from '@/components/blog_write/BlogWriteTitle.vue';
import BlogAddForm from '@/components/blog_write/BlogAddForm.vue';

export default defineComponent({
  components: {BlogWriteTitle, BlogAddForm},
});
</script>
<template>
  <div class="d-flex justify-content-center">
    <div class="col-md-11">
      <BlogWriteTitle></BlogWriteTitle>
      <BlogAddForm></BlogAddForm>
    </div>
  </div>
</template>
<style></style>
