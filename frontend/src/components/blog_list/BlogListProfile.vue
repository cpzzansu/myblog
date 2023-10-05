<script>
import {computed, ref} from 'vue';
import {useStore} from 'vuex';

export default {
  props: {
    memberProfileDto: {
      type: Object,
      required: true,
    },
  },
  setup(props) {
    const store = useStore();

    const memberName = ref('');
    const memberCompanyName = ref('');
    const memberDuty = ref('');
    const imageSourcePath = ref('');
    const profilePictureStyle = computed(() => ({
      backgroundImage: `url(${store.state.profilePicture})`,
    }));

    memberName.value = props.memberProfileDto.memberName;
    memberCompanyName.value = props.memberProfileDto.memberCompanyName;
    memberDuty.value = props.memberProfileDto.memberDuty;
    imageSourcePath.value = props.memberProfileDto.imageSourcePath;
    if (imageSourcePath.value !== '' && imageSourcePath.value !== null) {
      let imageSource = '/api' + imageSourcePath.value;
      store.commit('setProfilePicture', imageSource);
    }

    return {
      memberName,
      memberCompanyName,
      memberDuty,
      profilePictureStyle,
      memberProfile: props.memberProfileDto,
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
    </div>
  </div>
</template>
<style scoped>
.profile-name-div {
  height: 80px;
  width: 100%;
  padding-top: 15px;
  padding-bottom: 20px;
  background: #00000000;
  justify-content: flex-start;
  align-items: center;
  gap: 5px;
  display: flex;
  border-radius: 12px;
  margin-left: 12px;
}
.member-name {
  color: white;
  font-size: 15px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 800;
  word-wrap: break-word;
  margin-left: 10px;
}
.member-job {
  color: #cccccc;
  margin-left: 5px;
  font-size: 10px;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-weight: 400;
  word-wrap: break-word;
}
.profile-picture {
  width: 35px;
  height: 35px;
  background-size: cover;
  border-radius: 9999px;
}
</style>
