// router/index.js
import {createRouter, createWebHistory} from 'vue-router';
import Home from '@/views/main/Home.vue';
import Login from '@/views/common/Login.vue';
import AddMember from '@/views/common/AddMember.vue';
import axios from 'axios';
import store from '@/store';
import ProfileMain from '@/views/common/ProfileMain.vue';

const routes = [
  {
    path: '/',
    name: 'HomePage',
    component: Home,
    meta: {requiresAuth: true},
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: Login,
    meta: {notLoggedIn: true},
  },
  {
    path: '/addMember',
    name: 'AddMemberPage',
    component: AddMember,
    meta: {notLoggedIn: true},
  },
  {
    path: '/profile',
    name: 'ProfileMainPage',
    component: ProfileMain,
    meta: {requiresAuth: true},
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 여기에 beforeEach 전역 가드 추가
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('accessToken');
  if (token) {
    let response = axios.get('/api/private/resource', {
      headers: {
        Authorization: 'Bearer ' + token,
      },
    });
    if (to.matched.some((record) => record.meta.requiresAuth)) {
      response
        .then(() => {
          store.commit('setLoginState', true);
          next(); // 유효한 토큰이므로 네비게이션 계속
        })
        .catch((error) => {
          if (error.response && error.response.status === 401) {
            next('/login'); // 토큰이 유효하지 않으므로 로그인 페이지로 리다이렉트
          } else {
            next(); // 다른 에러가 발생했지만 일단 네비게이션 계속
          }
        });
    } else if (to.matched.some((record) => record.meta.notLoggedIn)) {
      response
        .then(() => {
          store.commit('setLoginState', true);
          next('/');
        })
        .catch((error) => {
          if (error.response && error.response.status === 401) {
            next('/login'); // 토큰이 유효하지 않으므로 로그인 페이지로 리다이렉트
          } else {
            next(); // 다른 에러가 발생했지만 일단 네비게이션 계속
          }
        });
    } else {
      next(); // 로그인이 필요하지 않은 페이지로 이동
    }
  } else {
    store.commit('setLoginState', false);
    next();
  }
});

export default router;
