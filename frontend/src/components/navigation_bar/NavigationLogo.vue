<template>
  <div class="logo">
    <RouterLink :to="linkTo" class="logo-link"
      ><img class="logo-image" src="../../assets/logo.png"
    /></RouterLink>
  </div>
</template>
<script>
export default {
  props: ['linkTo'],
};
</script>
<style scoped>
.logo {
  width: 163px;
  height: 30px;
  justify-content: center;
  align-items: center;
  display: inline-block;
  float: left;
}
.logo-image {
  width: 162px;
  height: 30px;
}
.logo-link {
  text-decoration: none;
}
</style>
