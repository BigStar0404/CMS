<!-- commu_manage_sys/frontend/src/components/TestComponent.vue -->
<template>
    <div>
        <h2>测试前后端连接</h2>
        <p>后端响应: {{ message }}</p>
    </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import api from '../services/api';

export default {
    name: 'TestComponent',
    setup() {
        const message = ref('');

        const fetchTestMessage = async () => {
            try {
                const response = await api.get('/test');
                message.value = response.data;
            } catch (error) {
                console.error('Error fetching test message:', error);
                message.value = '无法获取后端响应';
            }
        };

        onMounted(() => {
            fetchTestMessage();
        });

        return { message };
    }
};
</script>

<style scoped>
h2 {
    color: #42b983;
}
</style>
