<script>
import {computed, ref} from 'vue';
import {useStore} from 'vuex';

export default {
  setup() {
    const fileInput = ref(null);
    const store = useStore();

    const profilePictureStyle = computed(() => ({
      backgroundImage: `url(${store.state.profilePicture})`,
    }));

    const uploadPicture = () => {
      if (fileInput.value) {
        fileInput.value.click();
      }
    };

    const onFileChange = (event) => {
      const file = event.target.files[0];
      if (file) {
        store.commit('setMemberProfilePicture', file);
        const reader = new FileReader();
        reader.onload = (e) => {
          store.commit('setProfilePicture', e.target.result);
        };
        reader.readAsDataURL(file);
      }
    };

    return {
      profilePictureStyle,
      fileInput,
      uploadPicture,
      onFileChange,
    };
  },
};
</script>
<template>
  <div
    :style="profilePictureStyle"
    class="profile-picture d-flex justify-content-center align-items-center"
    @click="uploadPicture"
  >
    <div
      class="camera-picture d-flex justify-content-center align-items-center"
    >
      <img src="../../../assets/profile-camera.svg" width="25" height="25" />
    </div>
    <input
      ref="fileInput"
      type="file"
      style="display: none"
      @change="onFileChange"
    />
  </div>
</template>
<style scoped>
.profile-picture {
  width: 135px;
  height: 135px;
  padding: 10px;
  border-radius: 100px;
  margin-top: 50px;
  position: relative;
  background-image: url('../../../assets/person.png');
  background-size: cover;
  margin-bottom: 50px;
  cursor: pointer;
}
.camera-picture {
  position: absolute;
  top: 95px;
  left: 95px;
  width: 42px;
  height: 42px;
  background-color: #cccccc;
  color: #676767;
  border-radius: 100px;
}
</style>
