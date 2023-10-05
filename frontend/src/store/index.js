import {createStore} from 'vuex';
import axios from 'axios';

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
    blogs: null,
    blogDetail: null,
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
    setBlogs(state, payload) {
      state.blogs = payload;
    },
    setBlogDetail(state, payload) {
      state.blogDetail = payload;
    },
  },
  actions: {
    async fetchData({commit}) {
      const token = localStorage.getItem('accessToken');

      function stripHTMLTagsTruncatedText(input) {
        let text = input.replace(/<\/?[^>]+(>|$)/g, '');
        return text.length > 100 ? text.substring(0, 100) + '...' : text;
      }

      const response = await axios.get('/api/private/blog', {
        headers: {
          Authorization: 'Bearer ' + token,
        },
      });

      response.data = response.data.map((item) => ({
        ...item,
        blogContent: stripHTMLTagsTruncatedText(item.blogContent),
      }));

      commit('setBlogs', response.data);
    },

    async blogDetail({commit}, blogId) {
      const token = localStorage.getItem('accessToken');

      const response = await axios.get(`/api/private/blog/${blogId}`, {
        headers: {
          Authorization: 'Bearer ' + token,
        },
      });

      commit('setBlogDetail', response.data);
    },
  },
  getters: {},
});
