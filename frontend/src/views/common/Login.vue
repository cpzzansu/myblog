<script>
import {ref, computed} from 'vue';
import {useStore} from 'vuex';
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
  setup() {
    const memberEmail = ref('test');
    const memberPw = ref('asdf');
    const store = useStore();

    // 로그인의 필요성 확인
    const needLogin = computed(() => {
      return store.getters['auth/needLogin'];
    });

    // 로그인 처리
    const login = async () => {
      try {
        const rs = await store.dispatch('auth/login', {
          memberEmail: memberEmail.value,
          memberPw: memberPw.value,
        });
        alert(rs);
      } catch (error) {
        alert(error);
      }
    };

    return {
      needLogin,
      memberEmail,
      memberPw,
      login,
    };
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
<style scoped>
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
