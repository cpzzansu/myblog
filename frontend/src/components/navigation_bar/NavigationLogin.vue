<script>
export default {
  name: 'NavigationMenu',
  props: ['menu'],
};
</script>
<template>
  <div class="navigationLogin">
    <router-link class="login-link" to="login"
      ><div class="loginBtn">로그인</div></router-link
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
  font-family: Pretendard;
  font-weight: 400;
  word-wrap: break-word;
}
.login-link {
  text-decoration: none;
}
</style>
