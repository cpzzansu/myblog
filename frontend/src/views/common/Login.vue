<script>
import LoginFormLogo from '@/components/login_form/LoginFormLogo.vue';
import LoginFormTitle from '@/components/login_form/LoginFormTitle.vue';
import LoginForm from '@/components/login_form/LoginForm.vue';
import LoginFormButton from '@/components/login_form/LoginFormButton.vue';
import LoginFormAddButton from '@/components/login_form/LoginFormAddButton.vue';
import axios from 'axios';

export default {
  name: 'LoginPage',
  data() {
    return {
      member: {},
    };
  },
  components: {
    LoginFormAddButton,
    LoginFormButton,
    LoginFormLogo,
    LoginFormTitle,
    LoginForm,
  },
  methods: {
    async login() {
      await axios
        .post('/api/login', this.member, {
          headers: {
            Authorization: 'Bearer ' + localStorage.getItem('accessToken'),
          },
        })
        .then((response) => {
          const accessToken = response.headers['accesstoken'];
          const refreshToken = response.headers['refreshtoken'];

          localStorage.setItem('accessToken', accessToken);
          localStorage.setItem('refreshToken', refreshToken);
        })
        .catch((error) => {
          if (error.response && error.response.status === 401) {
            console.error('Login error: ', error);
            this.$router.push('/login');
          }
        });
      this.$store.commit('setLoginState', true);
      this.$router.push('/');
    },
    loginMember(value) {
      this.member = value;
      console.log(this.member);
    },
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.isLoggedIn;
    },
  },
};
</script>
<template>
  <div class="login-div">
    <div class="login-form">
      <LoginFormLogo></LoginFormLogo>
      <LoginFormTitle></LoginFormTitle>
      <LoginForm @input-value="loginMember"></LoginForm>
      <LoginFormButton @click="login"></LoginFormButton>
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
