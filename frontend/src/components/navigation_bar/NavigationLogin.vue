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
    <router-link v-if="!isLoggedIn" class="login-link" to="/login"
      ><div class="loginBtn">로그인</div></router-link
    >
    <router-link
      v-if="isLoggedIn"
      class="login-link"
      to="/login"
      @click="logout"
      ><div class="loginBtn">로그아웃</div></router-link
    >
  </div>
</template>
<style scoped>
.navigationLogin {
  height: 33px;
  display: flex;
  align-items: center;
}
.loginBtn {
  color: white;
  font-size: 16px;
  font-family: Pretendard;
  font-weight: 400;
  word-wrap: break-word;
}
.login-link {
  text-decoration: none;
}
</style>
