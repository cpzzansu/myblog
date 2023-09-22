<script>
import LoginFormLogo from '@/components/login_form/LoginFormLogo.vue';
import LoginFormTitle from '@/components/login_form/LoginFormTitle.vue';
import LoginForm from '@/components/login_form/LoginForm.vue';
import LoginFormButton from '@/components/login_form/LoginFormButton.vue';
import LoginFormAddButton from '@/components/login_form/LoginFormAddButton.vue';

export default {
  name: 'LoginPage',
  components: {
    LoginFormAddButton,
    LoginFormButton,
    LoginFormLogo,
    LoginFormTitle,
    LoginForm,
  },
};
</script>
<template>
  <div class="login-div">
    <div class="login-form">
      <LoginFormLogo></LoginFormLogo>
      <LoginFormTitle></LoginFormTitle>
      <LoginForm></LoginForm>
      <LoginFormButton></LoginFormButton>
      <LoginFormAddButton></LoginFormAddButton>
    </div>
  </div>
</template>
<style>
.login-div {
  width: 1140px;
  margin-left: 15px;
  margin-right: 15px;
  height: 800px;
  display: flex;
  justify-content: center;
  align-items: start;
}
.login-form {
  width: 475px;
  height: 600px;
}
</style>
