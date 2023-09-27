<script></script>
<template>
  <div class="profile-picture d-flex justify-content-center align-items-center">
    <div
      class="camera-picture d-flex justify-content-center align-items-center"
    >
      <img src="../../../assets/profile-camera.svg" width="25" height="25" />
    </div>
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
