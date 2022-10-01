import axios from 'axios'
import { createApp } from 'vue'
import App from './App.vue'

axios.defaults.baseURL = process.env.PORT || 3000;

createApp(App).mount('#app')
