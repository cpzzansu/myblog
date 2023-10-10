<script>
import ProfileMenuBar from '@/components/profile/profile_menu/ProfileMenuBar.vue';

export default {
  components: {ProfileMenuBar},
};
</script>
<template>
  <div class="profile-div container">
    <div class="profile-main-div col-xs-12 col-lg-8">
      <ProfileMenuBar></ProfileMenuBar>
      <RouterView />
    </div>
  </div>
</template>
<style>
.profile-div {
  margin-left: 15px;
  margin-right: 15px;
  display: flex;
  justify-content: center;
  align-items: start;
}
</style>
