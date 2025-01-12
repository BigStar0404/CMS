<!-- commu_manage_sys/frontend/src/views/FindBackPwd.vue -->
<template>
    <div class="find-back-pwd-container">
        <h2>找回密码</h2>
        <form @submit.prevent="handleFindBackPwd">
            <!-- 用户名输入 -->
            <div class="form-group">
                <label for="username">用户名：</label>
                <input
                        type="text"
                        id="username"
                        v-model="username"
                        placeholder="请输入您的用户名"
                        required
                />
            </div>

            <!-- 邮箱输入 -->
            <div class="form-group">
                <label for="email">邮箱：</label>
                <input
                        type="email"
                        id="email"
                        v-model="email"
                        placeholder="请输入您的邮箱"
                        required
                />
            </div>

            <!-- 找回密码按钮 -->
            <div class="form-group">
                <button type="submit">找回密码</button>
            </div>
        </form>
    </div>
</template>

<script>
import { ref } from 'vue';

export default {
    name: 'FindBackPwd',
    setup() {
        const username = ref('');
        const email = ref('');

        const handleFindBackPwd = () => {
            // 这里可以添加找回密码逻辑，例如调用 API 发送重置密码邮件
            console.log('用户名:', username.value);
            console.log('邮箱:', email.value);

            alert('找回密码请求已发送到您的邮箱。');
            // 重置表单
            username.value = '';
            email.value = '';
        };

        return {
            username,
            email,
            handleFindBackPwd
        };
    }
};
</script>

<style scoped>
.find-back-pwd-container {
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
.form-group input[type="email"] {
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
</style>
