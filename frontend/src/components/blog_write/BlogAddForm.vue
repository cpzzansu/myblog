<script>
import {ref, onMounted} from 'vue';
import SimpleMDE from 'simplemde';
import 'simplemde/dist/simplemde.min.css';

export default {
  name: 'MarkdownEditor',
  setup() {
    let textArea = ref(null);
    let simplemde = ref(null); // Declare a reference for the SimpleMDE instance

    onMounted(() => {
      simplemde.value = new SimpleMDE({
        element: textArea.value,
        autofocus: true,
        autosave: {
          enabled: true,
          uniqueId: 'MyUniqueID',
          delay: 1000,
        },
        blockStyles: {
          bold: '__',
          italic: '_',
        },
        forceSync: true,
        hideIcons: ['guide', 'heading'],
        indentWithTabs: false,
        initialValue: 'Hello world!',
        insertTexts: {
          horizontalRule: ['', '\n\n-----\n\n'],
          image: ['![](http://', ')'],
          link: ['[', '](http://)'],
          table: [
            '',
            '\n\n| Column 1 | Column 2 | Column 3 |\n| -------- | -------- | -------- |\n| Text     | Text      | Text     |\n\n',
          ],
        },
        lineWrapping: true,
        parsingConfig: {
          allowAtxHeaderWithoutSpace: true,
          strikethrough: false,
          underscoresBreakWords: true,
        },
        placeholder: 'Type here...',
        promptURLs: true,
        renderingConfig: {
          singleLineBreaks: false,
          codeSyntaxHighlighting: true,
        },
        shortcuts: {
          drawTable: 'Cmd-Alt-T',
        },
        showIcons: ['code', 'table'],
        spellChecker: false,
        styleSelectedText: false,
        tabSize: 2,
        toolbar: false,
        toolbarTips: false,
      });
    });

    return {
      textArea,
      simplemde, // Return the instance so that it can be referenced if needed
    };
  },
};
</script>

<template>
  <form>
    <div class="form-group col-md-7">
      <textarea ref="textArea"></textarea>
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
</style>
