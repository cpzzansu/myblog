<script>
import LoginFormInput from '@/components/login_form/LoginFormInput.vue';

export default {
  data() {
    return {
      member: {
        memberEmail: '',
        memberPw: '',
      },
    };
  },
  components: {LoginFormInput},
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
};
</script>
<template>
  <form class="row d-flex justify-content-center">
    <LoginFormInput
      :inputId="'memberEmail'"
      :inputLabelText="'이메일'"
      :inputType="'text'"
      @input-value="memberEmail"
    ></LoginFormInput>
    <LoginFormInput
      :inputId="'memberPw'"
      :inputLabelText="'비밀번호'"
      :inputType="'password'"
      @input-value="memberPw"
    ></LoginFormInput>
  </form>
</template>
<style></style>
