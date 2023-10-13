<script>
import {computed, onMounted, ref} from 'vue';
import {useStore} from 'vuex';
import axios from 'axios';

export default {
  setup() {
    const store = useStore();

    const memberName = ref('');
    const memberCompanyName = ref('');
    const memberDuty = ref('');
    const memberBiography = ref('');
    const imageSourcePath = ref('');

    const profilePictureStyle = computed(() => ({
      backgroundImage: `url(${store.state.profilePicture})`,
    }));

    onMounted(async () => {
      const token = localStorage.getItem('accessToken');
      await axios
        .get('/api/private/profile', {
          headers: {
            Authorization: 'Bearer ' + token,
          },
        })
        .then((response) => {
          const data = response.data;
          memberName.value = data.memberName;
          memberCompanyName.value = data.memberCompanyName;
          memberDuty.value = data.memberDuty;
          memberBiography.value = data.memberBiography;
          imageSourcePath.value = data.imageSourcePath;
          if (imageSourcePath.value !== '' && imageSourcePath.value !== null) {
            let imageSource = '/api' + imageSourcePath.value;
            store.commit('setProfilePicture', imageSource);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    });
    return {
      memberName,
      memberCompanyName,
      memberDuty,
      memberBiography,
      profilePictureStyle,
    };
  },
};
</script>
<template>
  <div class="profile-name-div">
    <div class="profile-picture" :style="profilePictureStyle"></div>
    <div>
      <div class="d-flex align-items-center">
        <div class="member-name">{{ memberName }}</div>
        <div class="member-job">{{ memberCompanyName }}</div>
        <div class="member-job">{{ memberDuty }}</div>
      </div>
      <div>
        <div class="profile-massage">
          <div class="massage-font">{{ memberBiography }}</div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
.profile-name-div {
  height: 80px;
  width: 100%;
  padding-top: 2px;
  padding-bottom: 2px;
  background: #00000000;
  justify-content: flex-start;
  align-items: center;
  gap: 5px;
  display: flex;
  border-radius: 12px;
}
.member-name {
  color: white;
  font-size: 19px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 800;
  word-wrap: break-word;
  margin-left: 10px;
}
.member-job {
  color: #cccccc;
  margin-left: 5px;
  font-size: 12px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 400;
  word-wrap: break-word;
}
.profile-picture {
  width: 80px;
  height: 80px;
  background-size: cover;
  border-radius: 9999px;
}
.profile-massage {
  height: 51px;
  margin-left: 10px;
  background: #00000000;
  justify-content: flex-start;

  display: inline-flex;
}
.massage-font {
  width: 200px;
  color: #cccccc;
  font-size: 15px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 400;
  word-wrap: break-word;
}
</style>
