import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "@/views/main/Home.vue";

Vue.use(VueRouter)

const routes = [
    { path: '/', component: Home },
]

const router = new VueRouter({
    routes // ES6의 단축 구문으로 routes: routes와 동일합니다.
})

export default router
