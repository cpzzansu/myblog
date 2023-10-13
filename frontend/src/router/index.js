// router/index.js
import {createRouter, createWebHistory} from 'vue-router';
import Login from '@/views/common/Login.vue';
import AddMember from '@/views/common/AddMember.vue';
import axios from 'axios';
import store from '@/store';
import ProfileMain from '@/views/profile/ProfileMain.vue';
import ProfileAddForm from '@/components/profile/profile_add_form/ProfileAddForm.vue';
import BlogWrite from '@/views/common/BlogWrite.vue';
import BlogListMain from '@/views/main/BlogListMain.vue';
import BlogContentMain from '@/views/main/BlogContentMain.vue';
import MyBlog from '@/components/profile/profile_myblog/MyBlog.vue';

const routes = [
  {
    path: '/',
    name: 'blogList',
    component: BlogListMain,
    beforeEnter: async (to, from, next) => {
      try {
        await store.dispatch('fetchData');
        next();
      } catch (error) {
        console.error('Error fetching data:', error);
        next(false);
      }
    },
    meta: {isHome: true},
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
    children: [
      {
        path: 'addForm',
        name: 'ProfileAddForm',
        component: ProfileAddForm,
        meta: {requiresAuth: true},
      },
      {
        path: '',
        name: 'myBlog',
        component: MyBlog,
        meta: {requiresAuth: true},
      },
    ],
  },
  {
    path: '/blogWrite',
    name: 'BlogWrite',
    component: BlogWrite,
    meta: {requiresAuth: true},
  },
  {
    path: '/blog/:id',
    name: 'blog',
    component: BlogContentMain,
    beforeEnter: async (to, from, next) => {
      try {
        const currentId = to.params.id;
        await store.dispatch('blogDetail', currentId);
        next();
      } catch (error) {
        console.error('Error fetching data:', error);
        next(false);
      }
    },
    meta: {requiresAuth: true},
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

async function verifyToken(token) {
  try {
    await axios.get('http://localhost:90/private/resource', {
      headers: {
        Authorization: 'Bearer ' + token,
      },
    });
    store.commit('setLoginState', true);
    return true;
  } catch (error) {
    if (error.response && error.response.status === 401) {
      return false; // 401 에러의 경우 false 반환
    }
    throw error; // 다른 에러는 던져서 상위에서 처리
  }
}

async function refreshToken() {
  const refreshToken = localStorage.getItem('refreshToken');
  try {
    const response = await axios.post(
      'http://localhost:90/token',
      refreshToken,
    );
    const data = response.data;
    const accessToken = data.accessToken;
    console.log('토큰 새로 발급받음');
    localStorage.setItem('accessToken', accessToken);
    return true;
  } catch (error) {
    if (error.response && error.response.status === 401) {
      localStorage.removeItem('accessToken');
      localStorage.removeItem('refreshToken');
    }
    return false;
  }
}
// 여기에 beforeEach 전역 가드 추가
router.beforeEach(async (to, from, next) => {
  const token = localStorage.getItem('accessToken');

  if (!token) {
    store.commit('setLoginState', false);
    return next();
  }

  const isTokenValid = await verifyToken(token);

  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (isTokenValid) return next();

    const isRefreshSuccess = await refreshToken();
    return isRefreshSuccess ? next() : next('/login');
  } else if (to.matched.some((record) => record.meta.notLoggedIn)) {
    if (isTokenValid) return next('/');
    const isRefreshSuccess = await refreshToken();
    return isRefreshSuccess ? next('/') : next('/login');
  } else if (to.matched.some((record) => record.meta.isHome)) {
    if (isTokenValid) return next();
    const isRefreshSuccess = await refreshToken();
    return isRefreshSuccess ? next('/') : next('/login');
  }
  next();
});

export default router;
