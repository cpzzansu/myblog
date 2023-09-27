<script>
import {defineComponent} from 'vue';
import ProfilePicture from '@/components/profile/profile_add_form/ProfilePicture.vue';
import ProfileAddInput from '@/components/profile/profile_add_form/ProfileAddInput.vue';

export default defineComponent({
  components: {ProfileAddInput, ProfilePicture},
});
</script>
<template>
  <form class="container d-flex row" action="/profile" method="post">
    <div class="form-row profile-title">멤버 프로필</div>
    <div class="d-flex justify-content-center">
      <ProfilePicture></ProfilePicture>
    </div>
    <div class="container d-flex input-div">
      <ProfileAddInput
        input-id="memberName"
        input-label-text="이름"
        input-type="text"
        @input-value="inputName"
        :isRequired="true"
      ></ProfileAddInput>
      <ProfileAddInput
        input-id="memberEmail"
        input-label-text="이메일"
        input-type="text"
        @input-value="inputEmail"
        :isRequired="true"
      ></ProfileAddInput>
    </div>
    <div class="d-flex input-div">
      <ProfileAddInput
        input-id="memberName"
        input-label-text="전화번호"
        input-type="text"
        @input-value="inputName"
        :isRequired="false"
      ></ProfileAddInput>
    </div>
  </form>
</template>
<style scoped>
.profile-title {
  color: #efefef;
  font-family: Pretendard;
  font-size: 20px;
}
.input-div > :first-child {
  margin-right: auto;
}
.form-row {
  display: flex;
  flex-wrap: wrap;
}
</style>
