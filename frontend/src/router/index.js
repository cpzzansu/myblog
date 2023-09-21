// router/index.js
import {createRouter, createWebHistory} from 'vue-router';
import Home from '@/views/main/Home.vue';
import Login from '@/views/login/Login.vue';

const routes = [
  {
    path: '/',
    name: 'HomePage',
    component: Home,
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: Login,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
