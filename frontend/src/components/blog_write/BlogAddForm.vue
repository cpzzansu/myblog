<script>
import {ref, onMounted} from 'vue';
import SimpleMDE from 'simplemde';
import 'simplemde/dist/simplemde.min.css';
import BlogAddButton from '@/components/blog_write/BlogAddButton.vue';

export default {
  name: 'MarkdownEditor',
  components: {BlogAddButton},
  setup() {
    let textArea = ref(null);
    let simplemde = ref(null); // Declare a reference for the SimpleMDE instance

    const inputBlog = () => {
      console.log(simplemde.value.value());
    };

    onMounted(() => {
      simplemde.value = new SimpleMDE({
        element: textArea.value,
        autofocus: false,
        autosave: {
          enabled: true,
          uniqueId: 'BlogWriteContent',
          delay: 10000,
        },
        forceSync: true,
        lineWrapping: true,
        placeholder: '블로그 본문, 마크다운 형식으로 작성해주세요.',
        spellChecker: false,
        styleSelectedText: false,
        tabSize: 2,
        toolbar: false,
        toolbarTips: false,
      });
      simplemde.value.codemirror.on('change', inputBlog);
    });

    return {
      textArea,
      simplemde, // Return the instance so that it can be referenced if needed
      inputBlog,
    };
  },
};
</script>

<template>
  <form>
    <div class="form-group col-md-7">
      <textarea
        class="blog-main-title form-control"
        rows="2"
        placeholder="제목을 입력하세요."
      ></textarea>
      <textarea ref="textArea" @input="inputBlog"></textarea>
      <BlogAddButton></BlogAddButton>
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
</style>
