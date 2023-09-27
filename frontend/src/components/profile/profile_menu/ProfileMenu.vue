<script>
export default {
  props: ['menuTitle'],
};
</script>
<template>
  <div class="menu-font">{{ menuTitle }}</div>
</template>
<style scoped>
.menu-font {
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-size: 18px;
  font-weight: 900;
}
</style>
