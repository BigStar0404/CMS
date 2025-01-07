// commu_manage_sys/frontend/src/services/api.js
import axios from 'axios';

const api = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api', // 后端 API 基地址
});

// 添加请求拦截器（可选，用于添加认证信息）
api.interceptors.request.use(config => {
    const token = localStorage.getItem('token'); // 假设您使用 localStorage 存储 JWT Token
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, error => {
    return Promise.reject(error);
});

export default api;
