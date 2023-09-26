<script>
import {defineComponent} from 'vue';
import AddFormTitle from '@/components/add_form/AddFormTitle.vue';
import AddFormInformation from '@/components/add_form/AddFormInformation.vue';
import AddForm from '@/components/add_form/AddForm.vue';
import AddFormButton from '@/components/add_form/AddFormButton.vue';
import axios from 'axios';

export default defineComponent({
  components: {AddFormButton, AddFormInformation, AddFormTitle, AddForm},
  data() {
    return {member: {}};
  },
  methods: {
    async save() {
      await axios
        .post('/api/member', this.member, {
          headers: {
            Authorization: 'Bearer ' + localStorage.getItem('accessToken'),
          },
        })
        .then(() => {
          this.$router.push('/login');
        })
        .catch((error) => {
          if (error.response && error.response.status === 401) {
            alert('회원가입에 실패했습니다.');
            this.$router.push('/addMember');
          }
        });
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
      <AddFormButton @click="save"></AddFormButton>
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
