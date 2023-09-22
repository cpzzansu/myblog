<script>
import AddFormInput from '@/components/add_form/AddFormInput.vue';

export default {
  data() {
    return {
      member: {
        memberEmail: '',
        memberPw: '',
      },
    };
  },
  methods: {
    memberEmail(value) {
      this.member.memberEmail = value;
      this.$emit('input-value', this.member);
    },
    memberPw(value) {
      this.member.memberPw = value;
      this.$emit('input-value', this.member);
    },
  },
  components: {AddFormInput},
};
</script>
<template>
  <form class="row d-flex justify-content-center">
    <AddFormInput
      :inputId="'memberEmail'"
      :inputLabelText="'이메일 주소'"
      :inputType="'text'"
      :placeholder="'이메일 주소를 입력해 주세요'"
      @input-value="memberEmail"
    ></AddFormInput>
    <AddFormInput
      :inputId="'memberPw'"
      :inputLabelText="'비밀번호'"
      :inputType="'password'"
      :placeholder="'비밀번호를 입력해 주세요'"
      @input-value="memberPw"
    ></AddFormInput>
  </form>
</template>
<style></style>
