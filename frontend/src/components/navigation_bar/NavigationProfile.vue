<script>
export default {
  computed: {
    isLoggedIn() {
      return this.$store.state.isLoggedIn;
    },
  },
  methods: {
    logout() {
      this.$store.commit('setLoginState', false);
      localStorage.removeItem('accessToken');
      localStorage.removeItem('refreshToken');
    },
  },
  name: 'NavigationMenu',
  props: ['menu'],
};
</script>
<template>
  <div class="navigationLogin">
    <div v-if="!isLoggedIn" display="none">로그인</div>

    <router-link v-if="isLoggedIn" class="login-link" to="profile"
      ><div class="loginBtn">프로필</div></router-link
    >
  </div>
</template>
<style scoped>
.navigationLogin {
  height: 33px;
  display: flex;
  align-items: center;
  margin-left: auto;
}
.loginBtn {
  color: white;
  font-size: 16px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 400;
  word-wrap: break-word;
}
.login-link {
  text-decoration: none;
}
</style>
