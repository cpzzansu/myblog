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
    placeholder: {
      type: String,
      required: true,
    },
  },
  methods: {
    emitInputValue(event) {
      this.$emit('input-value', event.target.value);
    },
  },
};
</script>
<template>
  <div class="input-box">
    <label :for="inputId" class="login-input-label">
      {{ inputLabelText }}<span>*</span>
    </label>
    <input
      :id="inputId"
      :name="inputId"
      :type="inputType"
      :placeholder="placeholder"
      class="form-control login-input"
      @input="emitInputValue"
    />
  </div>
</template>
<style scoped>
.login-input-label {
  color: #d1d1d1;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  margin: 10px 10px;
  font-weight: 300;
  font-size: 14px;
}
.input-box {
  margin-bottom: 10px;
}
span {
  color: #5dd9ff;
}
.login-input {
  font-family: Pretendard, 'Apple SD Gothic Neo';
}
</style>
