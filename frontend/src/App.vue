<!-- commu_manage_sys/frontend/src/App.vue -->
<template>
    <div id="app">
        <header>
            <h1>大学生社团管理系统</h1>
            <nav>
                <router-link to="/">首页</router-link> |
                <router-link to="/about">关于我们</router-link> |
                <router-link to="/login">登录</router-link> |
                <router-link to="/find_back_pwd">找回密码</router-link>
            </nav>
        </header>
        <main>
            <router-view></router-view>
        </main>
    </div>
</template>

<script>
export default {
    name: 'App'
};
</script>

<style>
#app {
    text-align: center;
    margin-top: 50px;
}

header {
    background-color: #42b983;
    padding: 20px;
    border-radius: 8px;
}

h1 {
    color: white;
}

nav a {
    color: white;
    text-decoration: none;
    margin: 0 10px;
}

nav a.router-link-exact-active {
    font-weight: bold;
}

main {
    padding: 20px;
}
</style>
