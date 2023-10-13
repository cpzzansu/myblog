<template>
  <div ref="editorElement"></div>
</template>

<script>
import Editor from '@toast-ui/editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/theme/toastui-editor-dark.css';
import axios from 'axios';

export default {
  name: 'ToastEditor',
  props: {
    initialContent: {
      type: String,
      default: '',
    },
  },
  data() {
    return {
      editor: null,
    };
  },
  mounted() {
    this.editor = new Editor({
      el: this.$refs.editorElement,
      previewStyle: 'vertical',
      initialEditType: 'wysiwyg',
      height: '600px',
      initialValue: this.initialContent,
      theme: 'dark',
      hooks: {
        addImageBlobHook: async (blob, callback) => {
          const formData = new FormData();
          formData.append('image', blob);
          console.log(formData.get('image'));
          try {
            const response = await axios.post(
              'http://localhost:90/private/blog/image',
              formData,
            );

            // 서버에서 반환된 이미지 URL을 에디터에 추가합니다.
            callback(response.data.imageUrl, 'alt text');
          } catch (error) {
            console.error('Image upload failed:', error);
          }

          return false; // 기본 동작을 방지하기 위해 false를 반환합니다.
        },
      },
    });
  },
  beforeUnmount() {
    this.editor.destroy();
  },
};
</script>
