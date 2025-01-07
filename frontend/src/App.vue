<!-- commu_manage_sys/frontend/src/App.vue -->
<template>
    <div id="app">
        <header>
            <h1>大学生社团管理系统</h1>
            <TestComponent />
        </header>
    </div>
</template>

<script>
import TestComponent from './components/TestComponent.vue';

export default {
    name: 'App',
    components: {
        TestComponent
    }
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
</style>
