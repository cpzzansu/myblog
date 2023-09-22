<script>
import {defineComponent} from 'vue';
import AddFormTitle from '@/components/add_form/AddFormTitle.vue';
import AddFormInformation from '@/components/add_form/AddFormInformation.vue';
import AddForm from '@/components/add_form/AddForm.vue';
import AddFormButton from '@/components/add_form/AddFormButton.vue';

export default defineComponent({
  components: {AddFormButton, AddFormInformation, AddFormTitle, AddForm},
  data() {
    return {member: {}};
  },
  methods: {
    consoleOut() {
      console.log(this.member);
    },
    updateMember(value) {
      this.member = value;
    },
  },
});
</script>
<template>
  <div class="addMemberDiv">
    <div class="addForm">
      <AddFormTitle></AddFormTitle>
      <AddFormInformation></AddFormInformation>
      <AddForm @input-value="updateMember"></AddForm>
      <AddFormButton @click="consoleOut"></AddFormButton>
    </div>
  </div>
</template>
<style scoped>
.addMemberDiv {
  width: 1140px;
  margin-left: 15px;
  margin-right: 15px;
  height: 800px;
  display: flex;
  justify-content: center;
  align-items: start;
}
.addForm {
  width: 475px;
}
</style>
