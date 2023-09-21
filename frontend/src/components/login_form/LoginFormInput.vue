<script>
export default {
  data() {
    return {};
  },
  props: {
    inputLabelText: {
      type: String,
      require: true,
    },
    inputType: {
      type: String,
      require: true,
    },
    inputId: {
      type: String,
      required: true,
    },
  },
};
</script>
<template>
  <div class="input-box">
    <label :for="inputId" class="login-input-label">
      {{ inputLabelText }}
    </label>
    <input
      :id="inputId"
      :name="inputId"
      :type="inputType"
      class="form-control login-input"
    />
  </div>
</template>
<style>
.login-input-label {
  color: #d1d1d1;
  margin: 10px 10px;
  font-weight: 600;
}
.input-box {
  margin-bottom: 20px;
}
</style>
