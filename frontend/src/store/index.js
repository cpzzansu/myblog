import {createStore} from 'vuex';

export default createStore({
  state: {
    // 로그인 상태 확인
    isLoggedIn: false,
    profilePicture: null,
    memberProfilePicture: null,
    memberName: null,
    memberEmail: null,
    memberPhone: null,
    memberCompanyName: null,
    memberDuty: null,
    memberBiography: null,
  },
  mutations: {
    setLoginState(state, status) {
      state.isLoggedIn = status;
    },
    setProfilePicture(state, payload) {
      state.profilePicture = payload;
    },
    setMemberName(state, payload) {
      state.memberName = payload;
    },
    setMemberEmail(state, payload) {
      state.memberEmail = payload;
    },
    setMemberPhone(state, payload) {
      state.memberPhone = payload;
    },
    setMemberCompanyName(state, payload) {
      state.memberCompanyName = payload;
    },
    setMemberDuty(state, payload) {
      state.memberDuty = payload;
    },
    setMemberBiography(state, payload) {
      state.memberBiography = payload;
    },
    setMemberProfilePicture(state, payload) {
      state.memberProfilePicture = payload;
    },
  },
  actions: {},
  getters: {},
});
