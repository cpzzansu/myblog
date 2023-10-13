<script>
import {ref, onMounted} from 'vue';
import 'simplemde/dist/simplemde.min.css';
import BlogAddButton from '@/components/blog_write/BlogAddButton.vue';
import axios from 'axios';
import ToastEditor from '@/components/blog_write/ToastEditor.vue';

export default {
  name: 'MarkdownEditor',
  components: {BlogAddButton, ToastEditor},
  setup() {
    const blogTitle = ref(null);

    const addBlog = () => {
      let bt = blogTitle.value.value;

      const data = {
        blogTitle: bt,
      };

      const token = localStorage.getItem('accessToken');

      axios
        .post('http://localhost:90/private/blog', data, {
          headers: {
            Authorization: 'Bearer ' + token,
          },
        })
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log('에러발생', error);
        });
    };

    onMounted(() => {});

    return {
      blogTitle,
      addBlog,
    };
  },
};
</script>

<template>
  <form>
    <div class="form-group col-md-12">
      <textarea
        ref="blogTitle"
        class="blog-main-title form-control"
        rows="2"
        placeholder="제목을 입력하세요."
      ></textarea>
      <ToastEditor :initialContent="''"></ToastEditor>
      <BlogAddButton @click="addBlog"></BlogAddButton>
    </div>
  </form>
</template>
<style>
.CodeMirror {
  background-color: #333333;
  color: white;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-size: 16px;
  font-weight: 600;
  border: none;
  border-radius: 15px;
}
.CodeMirror-cursor {
  border-left: 1px solid white !important;
  z-index: 1;
}
.CodeMirror pre {
  white-space: pre-wrap;
  word-wrap: break-word;
}
.blog-main-title.form-control {
  border: none;
  background-color: #333333;
  color: #fbfbfc;
  font-size: 30px;
  font-weight: 900;
  border-radius: 15px;
  margin-top: 60px;
  margin-bottom: 30px;
}
.blog-main-title.form-control:focus {
  border: none;
  background-color: #333333;
  color: #fbfbfc;
}
.blog-main-title.form-control::placeholder {
  color: #c4c4c4;
}
.toastui-editor-defaultUI {
  border-radius: 15px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
}
.toastui-editor-defaultUI-toolbar {
  border-radius: 15px 15px 0 0;
}
.toastui-editor-mode-switch {
  border-radius: 0 0 15px 15px;
}
.toastui-editor-dark .toastui-editor-md-container,
.toastui-editor-dark .toastui-editor-ww-container {
  background-color: #333333;
}
.toastui-editor-contents {
  font-family: Pretendard-Regular, 'Apple SD Gothic Neo';
  font-size: 17px;
  font-width: 300;
}
.ProseMirror {
  font-family: Pretendard-Regular, 'Apple SD Gothic Neo';
  font-size: 17px;
  font-width: 300;
}
</style>
