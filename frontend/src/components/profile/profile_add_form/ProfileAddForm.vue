<script>
import {defineComponent} from 'vue';
import ProfilePicture from '@/components/profile/profile_add_form/ProfilePicture.vue';
import ProfileAddInput from '@/components/profile/profile_add_form/ProfileAddInput.vue';
import ProfileLongInput from '@/components/profile/profile_add_form/ProfileLongInput.vue';
import ProfileFormButton from '@/components/profile/profile_add_form/ProfileFormButton.vue';

export default defineComponent({
  components: {
    ProfileAddInput,
    ProfilePicture,
    ProfileLongInput,
    ProfileFormButton,
  },
});
</script>
<template>
  <form
    class="container d-flex row justify-content-center"
    action="/profile"
    method="post"
  >
    <div class="form-row profile-title">멤버 프로필</div>
    <div class="d-flex justify-content-center">
      <ProfilePicture></ProfilePicture>
    </div>
    <div class="form-input-div d-flex input-div row">
      <ProfileAddInput
        class="col-md-6 col-xs-12"
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
    <div class="form-input-div d-flex input-div row">
      <ProfileAddInput
        input-id="memberName"
        input-label-text="전화번호"
        input-type="text"
        @input-value="inputName"
        :isRequired="false"
      ></ProfileAddInput>
    </div>

    <div class="form-row profile-sub-title">자기 소개</div>

    <div class="form-input-div d-flex input-div row top-margin">
      <ProfileAddInput
        class="col-md-6 col-xs-12"
        input-id="memberCompanyName"
        input-label-text="회사이름"
        input-type="text"
        @input-value="inputCompanyName"
        :isRequired="false"
      ></ProfileAddInput>
      <ProfileAddInput
        input-id="memberDuty"
        input-label-text="직업"
        input-type="text"
        @input-value="inputDuty"
        :isRequired="false"
      ></ProfileAddInput>
    </div>

    <div class="form-input-div d-flex input-div row">
      <ProfileLongInput
        input-id="memberBiography"
        input-label-text="짧은 소개"
        input-type="text"
        @input-value="inputBiography"
        :isRequired="false"
      ></ProfileLongInput>
    </div>
    <div class="col-md-6">
      <ProfileFormButton></ProfileFormButton>
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
.form-input-div {
  width: 100%;
}
.profile-sub-title {
  color: #efefef;
  font-family: Pretendard;
  font-size: 20px;
  font-weight: 900;
  margin-top: 50px;
}
.top-margin {
  margin-top: 20px;
}
</style>
