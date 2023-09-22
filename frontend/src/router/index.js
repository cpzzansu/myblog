// router/index.js
import {createRouter, createWebHistory} from 'vue-router';
import Home from '@/views/main/Home.vue';
import Login from '@/views/common/Login.vue';
import AddMember from '@/views/common/AddMember.vue';

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
  {
    path: '/addMember',
    name: 'AddMemberPage',
    component: AddMember,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
