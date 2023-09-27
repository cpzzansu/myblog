<script>
import ProfileMenuBar from '@/components/profile/profile_menu/ProfileMenuBar.vue';

export default {
  components: {ProfileMenuBar},
};
</script>
<template>
  <div class="profile-div container">
    <div class="profie-main-div col-xs-12 col-12">
      <ProfileMenuBar></ProfileMenuBar>
      <RouterView />
    </div>
  </div>
</template>
<style scoped>
.profile-div {
  margin-left: 15px;
  margin-right: 15px;
  height: 800px;
  width: 1170px;
  display: flex;
  justify-content: center;
  align-items: start;
}
</style>
