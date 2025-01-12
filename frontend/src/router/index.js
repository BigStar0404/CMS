// commu_manage_sys/frontend/src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';
import Login from '../views/Login.vue'; // 新增
import FindBackPwd from '../views/FindBackPwd.vue'; // 新增

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/about',
        name: 'About',
        component: About
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/find_back_pwd',
        name: 'FindBackPwd',
        component: FindBackPwd
    },
    // 未来可以添加更多路由
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
