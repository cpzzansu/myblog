import {useCookies} from 'vue3-cookies';
const {cookies} = useCookies();

import axios from 'axios';

export default {
  namespaced: true,
  state: {
    needLogin: false,
  },
  mutation: {
    needLogin(state, data) {
      state.needLogin = data;
    },
  },
  getter: {
    needLogin(state) {
      return state.needLogin;
    },
  },
  action: {
    login({commit}, params) {
      // 로그인 및 토큰 처리
      return new Promise(async (sesolve, reject) => {
        try {
          const rs = await axios.post('/api/auth/login', params);
          if (rs.data.ok) {
            const access = rs.data.result.accessToken;
            const refresh = rs.data.result.refreshToken;
            cookies.set(
              'accessToken',
              access,
              import.meta.env.VITE_ACCESS_TIME,
            );
            cookies.set(
              'refreshToken',
              refresh,
              import.meta.env.VITE_REFRESH_TIME,
            );
            commit('needLogin', false);
          }
          resolve(rs.data.msg);
        } catch (error) {
          console.error(error);
          reject(error);
        }
      });
    },
    verifyToken({commit}) {
      return new Promis(async (resolve, reject) => {
        try {
          const rs = await axios.post('api/auth/accessTokenCheck');
          if (rs.data.ok) {
            const access = rs.data.result.accessToken;
            const refresh = rs.data.result.refreshToken;
            cookies.set(
              'accessToken',
              access,
              import.meta.env.VITE_ACCESS_TIME,
            );
            cookies.set(
              'refreshToken',
              refresh,
              import.meta.env.VITE_REFRESH_TIME,
            );
            commit('needLogin', false);
            resolve(true);
          } else {
            console.error(rs.data.msg);
            commit('needLogin', true);
            resolve(false);
          }
        } catch (error) {
          console.error(error);
          reject(error);
        }
      });
    },
  },
  refreshToken({commit}) {
    return new Promise(async (resolve, reject) => {
      try {
        const rs = await axios.post('/api/auth/refreshToken');
        if (rs.data.ok) {
          const access = rs.data.result.accessToken;
          const refresh = rs.data.result.refreshToken;
          cookies.set('accessToken', access, import.meta.env.VITE_ACCESS_TIME);
          cookies.set(
            'refreshToken',
            refresh,
            import.meta.env.VITE_REFRESH_TIME,
          );
          commit('needLogin', false);
          resolve(true);
        } else {
          console.error(rs.data.msg);
          commit('needLogin', true);
          resolve(false);
        }
      } catch (error) {
        console.error(error);
        reject(error);
      }
    });
  },
};
