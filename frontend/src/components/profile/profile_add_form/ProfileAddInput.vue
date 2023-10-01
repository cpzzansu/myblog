<script>
export default {
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
    isRequired: {
      type: Boolean,
      required: true,
    },
    isDisable: {
      type: Boolean,
      required: true,
    },
    value: {
      type: String,
      required: false,
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
  <div class="input-box form-group col-xs-12 col-md-6">
    <label :for="inputId" class="login-input-label">
      {{ inputLabelText }}<span v-if="isRequired"> *</span>
    </label>
    <input
      :id="inputId"
      :name="inputId"
      :type="inputType"
      :value="value"
      :disabled="isDisable"
      class="form-control profile-add-input"
      @input="emitInputValue"
    />
  </div>
</template>
<style scoped>
.input-box {
  padding-left: 10px;
  padding-right: 10px;
}
.profile-add-input {
  height: 50px;
  background: #363636;
  color: #f8f8f8;
  font-family: Pretendard, 'Apple SD Gothic Neo';
  font-size: 18px;
  border-radius: 10px;
  width: 100%;
}
.input-box > :first-child {
  margin-right: 10px;
}

input:focus {
  background-color: #363636;
  color: #f8f8f8;
  box-shadow: none;
}
span {
  color: #5dd9ff;
}
</style>
