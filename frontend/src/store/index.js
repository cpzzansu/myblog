import {createStore} from 'vuex';

export default createStore({
  state: {
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
