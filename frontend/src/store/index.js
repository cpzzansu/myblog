import {createStore} from 'vuex';

export default createStore({
  state: {
    // 로그인 상태 확인
    isLoggedIn: false,
    profilePicture: null,
  },
  mutations: {
    setLoginState(state, status) {
      state.isLoggedIn = status;
    },
    setProfilePicture(state, payload) {
      state.profilePicture = payload;
    },
  },
  actions: {},
  getters: {},
});
