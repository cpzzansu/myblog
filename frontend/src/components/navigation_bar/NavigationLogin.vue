<script>
export default {
  name: "NavigationMenu",
  props: ["menu"],
};
</script>
<template>
  <div class="navigationLogin">
    <div class="loginBtn">로그인</div>
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
</style>
