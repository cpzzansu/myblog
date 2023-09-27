import {createStore} from 'vuex';

export default createStore({
  state: {
    // 로그인 상태 확인
    isLoggedIn: false,
  },
  mutations: {
    setLoginState(state, status) {
      state.isLoggedIn = status;
    },
  },
  actions: {},
  getters: {},
});
