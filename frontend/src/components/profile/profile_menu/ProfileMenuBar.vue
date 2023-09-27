<script>
import ProfileMenu from '@/components/profile/profile_menu/ProfileMenu.vue';

export default {
  components: {
    ProfileMenu,
  },
};
</script>
<template>
  <div class="container">
    <div class="d-flex menuBar">
      <RouterLink to="/profile/addForm" v-slot="{isActive}">
        <ProfileMenu
          menuTitle="프로필"
          :class="{'active-link': isActive}"
        ></ProfileMenu>
      </RouterLink>
      <RouterLink to="/profile" v-slot="{isActive}">
        <ProfileMenu
          menuTitle="커피챗"
          :class="{'active-link': isActive}"
        ></ProfileMenu>
      </RouterLink>
      <RouterLink to="/profile" v-slot="{isActive}">
        <ProfileMenu
          menuTitle="내 글"
          :class="{'active-link': isActive}"
        ></ProfileMenu>
      </RouterLink>
      <RouterLink to="/profile" v-slot="{isActive}">
        <ProfileMenu
          menuTitle="내 댓글"
          :class="{'active-link': isActive}"
        ></ProfileMenu>
      </RouterLink>
    </div>
  </div>
</template>
<style>
.menuBar > *:first-child {
  margin-right: 10px;
}
.menuBar > *:last-child {
  margin-left: 10px;
}
.menuBar > *:not(:first-child):not(:last-child) {
  margin-right: 10px;
  margin-left: 10px;
}
.menuBar > a {
  text-decoration: none;
  color: #858484;
}
.menuBar {
  height: 70px;
}

.active-link {
  color: white;
}
</style>
