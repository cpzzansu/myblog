<script>
export default {
  name: 'NavigationMenu',
  props: {
    menu: String,
    linkTo: String,
  },
};
</script>
<template>
  <div class="navigationMenu">
    <RouterLink :to="linkTo" class="menu-link"
      ><div class="menu">{{ menu }}</div></RouterLink
    >
  </div>
</template>
<style scoped>
.navigationMenu {
  height: 33px;
  display: flex;
  align-items: center;
}
.menu {
  color: white;
  font-size: 16px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 800;
  word-wrap: break-word;
}
.menu-link {
  text-decoration: none;
}
</style>
