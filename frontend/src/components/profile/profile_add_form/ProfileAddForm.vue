<script>
import {defineComponent} from 'vue';
import {useStore} from 'vuex';
import ProfilePicture from '@/components/profile/profile_add_form/ProfilePicture.vue';
import ProfileAddInput from '@/components/profile/profile_add_form/ProfileAddInput.vue';
import ProfileLongInput from '@/components/profile/profile_add_form/ProfileLongInput.vue';
import ProfileFormButton from '@/components/profile/profile_add_form/ProfileFormButton.vue';
import axios from 'axios';

export default defineComponent({
  components: {
    ProfileAddInput,
    ProfilePicture,
    ProfileLongInput,
    ProfileFormButton,
  },
  setup() {
    const store = useStore();
    const inputName = (value) => {
      store.commit('setMemberName', value);
    };
    const inputEmail = (value) => {
      store.commit('setMemberEmail', value);
    };
    const inputPhone = (value) => {
      store.commit('setMemberPhone', value);
    };
    const inputCompanyName = (value) => {
      store.commit('setMemberCompanyName', value);
    };
    const inputDuty = (value) => {
      store.commit('setMemberDuty', value);
    };
    const inputBiography = (value) => {
      store.commit('setMemberBiography', value);
    };
    const submitProfile = () => {
      const memberEmail = store.state.memberEmail;
      const memberName = store.state.memberName;
      const memberCompanyName = store.state.memberCompanyName;
      const memberDuty = store.state.memberDuty;
      const memberBiography = store.state.memberBiography;
      const profilePicture = store.state.profilePicture;

      const memberProfileDto = {
        memberEmail: memberEmail,
        memberName: memberName,
        memberCompanyName: memberCompanyName,
        memberDuty: memberDuty,
        memberBiography: memberBiography,
        profilePicture: profilePicture,
      };

      const token = localStorage.getItem('accessToken');

      axios
        .post('/api/private/profile', memberProfileDto, {
          headers: {
            Authorization: 'Bearer ' + token,
          },
        })
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    // 폼 전송에 사용될 store 변수 초기화
    store.commit('setMemberName', null);
    store.commit('setMemberEmail', null);
    store.commit('setMemberPhone', null);
    store.commit('setMemberCompanyName', null);
    store.commit('setMemberDuty', null);
    store.commit('setMemberBiography', null);

    return {
      inputName,
      inputEmail,
      inputPhone,
      inputCompanyName,
      inputDuty,
      inputBiography,
      submitProfile,
    };
  },
});
</script>
<template>
  <form
    class="container d-flex row justify-content-center"
    action="/api/profile"
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
        @input-value="inputPhone"
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
      <ProfileFormButton @click="submitProfile"></ProfileFormButton>
    </div>
  </form>
</template>
<style scoped>
.profile-title {
  color: #efefef;
  font-family: Pretendard, 'Apple SD Gothic Neo';
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
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-size: 20px;
  font-weight: 900;
  margin-top: 50px;
}
.top-margin {
  margin-top: 20px;
}
</style>
