<script>
export default {
  name: 'NavigationMenu',
  props: ['menu']
}
</script>
<template>
  <div class="navigationMenu">
    <div class="menu">{{ menu }}</div>
  </div>
</template>
<style scoped>
.navigationMenu{
  height: 33px;
  display: flex;
  align-items: center;
}
.menu{
  color: white;
  font-size: 16px;
  font-family: Pretendard;
  font-weight: 800;
  word-wrap: break-word
}
</style>