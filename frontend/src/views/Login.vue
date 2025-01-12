<!-- commu_manage_sys/frontend/src/views/Login.vue -->
<template>
    <div class="login-container">
        <h2>登录</h2>
        <form @submit.prevent="handleLogin">
            <!-- 用户类型选择 -->
            <div class="form-group">
                <label>
                    <input type="radio" value="student" v-model="userType" />
                    学生
                </label>
                <label>
                    <input type="radio" value="admin" v-model="userType" />
                    管理员
                </label>
            </div>

            <!-- 用户名输入 -->
            <div class="form-group">
                <label for="username">用户名：</label>
                <input
                        type="text"
                        id="username"
                        v-model="username"
                        placeholder="请输入用户名"
                        required
                />
            </div>

            <!-- 密码输入 -->
            <div class="form-group">
                <label for="password">密码：</label>
                <input
                        type="password"
                        id="password"
                        v-model="password"
                        placeholder="请输入密码"
                        required
                />
            </div>

            <!-- 登录按钮 -->
            <div class="form-group">
                <button type="submit">登录</button>
            </div>

            <!-- 找回密码链接 -->
            <div class="form-group">
                <router-link to="/find_back_pwd">找回密码</router-link>
            </div>
        </form>
    </div>
</template>

<script>
import { ref } from 'vue';

export default {
    name: 'Login',
    setup() {
        const userType = ref('student'); // 默认选择学生
        const username = ref('');
        const password = ref('');

        const handleLogin = () => {
            // 这里可以添加登录逻辑，例如调用 API 进行验证
            // 目前只是打印输入的值
            console.log('用户类型:', userType.value);
            console.log('用户名:', username.value);
            console.log('密码:', password.value);

            // 示例：根据用户类型导航到不同的主页
            if (userType.value === 'student') {
                // 假设有学生主页
                // router.push({ name: 'StudentHome' });
                alert('学生登录成功！');
            } else if (userType.value === 'admin') {
                // 假设有管理员主页
                // router.push({ name: 'AdminHome' });
                alert('管理员登录成功！');
            }
        };

        return {
            userType,
            username,
            password,
            handleLogin
        };
    }
};
</script>

<style scoped>
.login-container {
    max-width: 400px;
    margin: 0 auto;
    padding: 40px;
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    color: #42b983;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 15px;
    display: flex;
    flex-direction: column;
}

.form-group label {
    margin-bottom: 5px;
    font-weight: bold;
}

.form-group input[type="text"],
.form-group input[type="password"] {
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.form-group button {
    padding: 10px;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.form-group button:hover {
    background-color: #369870;
}

.form-group a {
    color: #42b983;
    text-decoration: none;
    text-align: center;
}

.form-group a:hover {
    text-decoration: underline;
}

.form-group > label > input[type="radio"] {
    margin-right: 5px;
}
</style>
