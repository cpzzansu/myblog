<script>
import LoginFormInput from '@/components/login_form/LoginFormInput.vue';

export default {
  data() {
    return {};
  },
  components: {LoginFormInput},
};
</script>
<template>
  <form class="row d-flex justify-content-center">
    <LoginFormInput
      :inputId="'memberEmail'"
      :inputLabelText="'이메일'"
      :inputType="'text'"
    ></LoginFormInput>
    <LoginFormInput
      :inputId="'memberPw'"
      :inputLabelText="'비밀번호'"
      :inputType="'password'"
    ></LoginFormInput>
  </form>
</template>
<style></style>
