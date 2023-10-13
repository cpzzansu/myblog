<script>
import {defineComponent, onMounted, ref} from 'vue';
import {useStore} from 'vuex';
import ProfilePicture from '@/components/profile/profile_add_form/ProfilePicture.vue';
import ProfileAddInput from '@/components/profile/profile_add_form/ProfileAddInput.vue';
import ProfileLongInput from '@/components/profile/profile_add_form/ProfileLongInput.vue';
import ProfileFormButton from '@/components/profile/profile_add_form/ProfileFormButton.vue';
import axios from 'axios';
import person from '@/assets/person.png';

export default defineComponent({
  components: {
    ProfileAddInput,
    ProfilePicture,
    ProfileLongInput,
    ProfileFormButton,
  },
  setup() {
    const store = useStore();

    const memberEmail = ref('');
    const memberName = ref('');
    const memberPhone = ref('');
    const memberCompanyName = ref('');
    const memberDuty = ref('');
    const memberBiography = ref('');
    const imageSourcePath = ref('');

    const inputEmail = (value) => {
      store.commit('setMemberEmail', value);
    };
    const inputName = (value) => {
      store.commit('setMemberName', value);
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
      const memberPhone = store.state.memberPhone;
      const memberBiography = store.state.memberBiography;
      const memberProfilePicture = store.state.memberProfilePicture;

      const formData = new FormData();
      formData.append('memberEmail', memberEmail);
      formData.append('memberName', memberName);
      formData.append('memberCompanyName', memberCompanyName);
      formData.append('memberDuty', memberDuty);
      formData.append('memberPhone', memberPhone);
      formData.append('memberBiography', memberBiography);

      // profilePicture가 File 객체 또는 Blob 객체인 경우
      if (memberProfilePicture) {
        formData.append('memberProfilePicture', memberProfilePicture);
      }
      const token = localStorage.getItem('accessToken');
      axios
        .post('http://localhost:90/private/profile', formData, {
          headers: {
            Authorization: 'Bearer ' + token,
            'Content-Type': 'multipart/form-data',
          },
        })
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    onMounted(async () => {
      try {
        const token = localStorage.getItem('accessToken');
        const response = await axios.get(
          'http://localhost:90/private/profile',
          {
            headers: {
              Authorization: 'Bearer ' + token,
            },
          },
        );
        const data = response.data;

        memberEmail.value = data.memberEmail;
        store.commit('setMemberEmail', data.memberEmail);
        memberName.value = data.memberName;
        store.commit('setMemberName', data.memberName);
        memberPhone.value = data.memberPhone;
        store.commit('setMemberPhone', data.memberPhone);
        memberCompanyName.value = data.memberCompanyName;
        store.commit('setMemberCompanyName', data.memberCompanyName);
        memberDuty.value = data.memberDuty;
        store.commit('setMemberDuty', data.memberDuty);
        memberBiography.value = data.memberBiography;
        store.commit('setMemberBiography', data.memberBiography);
        imageSourcePath.value = data.imageSourcePath;

        if (imageSourcePath.value !== '' && imageSourcePath.value !== null) {
          let imageSource = 'http://localhost:90' + imageSourcePath.value;
          store.commit('setProfilePicture', imageSource);
        } else {
          const imagePath = ref(person);
          store.commit('setProfilePicture', imagePath.value);
        }
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    });

    return {
      memberEmail,
      memberName,
      memberPhone,
      memberCompanyName,
      memberDuty,
      memberBiography,
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
    action="http://localhost:90/profile"
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
        :is-disable="false"
        :value="memberName"
        @input-value="inputName"
        :isRequired="true"
      ></ProfileAddInput>
      <ProfileAddInput
        input-id="memberEmail"
        input-label-text="이메일"
        input-type="text"
        :is-disable="true"
        :value="memberEmail"
        @input-value="inputEmail"
        :isRequired="true"
      ></ProfileAddInput>
    </div>
    <div class="form-input-div d-flex input-div row">
      <ProfileAddInput
        input-id="memberName"
        input-label-text="전화번호"
        input-type="text"
        :value="memberPhone"
        :is-disable="false"
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
        :is-disable="false"
        :value="memberCompanyName"
        @input-value="inputCompanyName"
        :isRequired="false"
      ></ProfileAddInput>
      <ProfileAddInput
        input-id="memberDuty"
        input-label-text="직업"
        input-type="text"
        :is-disable="false"
        :value="memberDuty"
        @input-value="inputDuty"
        :isRequired="false"
      ></ProfileAddInput>
    </div>

    <div class="form-input-div d-flex input-div row">
      <ProfileLongInput
        input-id="memberBiography"
        input-label-text="짧은 소개"
        input-type="text"
        :is-disable="false"
        :value="memberBiography"
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
