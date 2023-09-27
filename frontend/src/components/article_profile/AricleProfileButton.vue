<script>
export default {
  props: ['buttonName'],
};
</script>
<template>
  <div class="profile-btn">
    <div class="profile-btn-font">{{ buttonName }}</div>
  </div>
</template>
<style scoped>
.profile-btn {
  width: 160px;
  height: 31px;
  padding-top: 7px;
  padding-bottom: 7px;
  background: #6eb8ed;
  border-radius: 12px;
  overflow: hidden;
  justify-content: center;
  align-items: center;
  display: flex;
}
.profile-btn-font {
  color: black;
  font-size: 14px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 700;
  word-wrap: break-word;
}
</style>
