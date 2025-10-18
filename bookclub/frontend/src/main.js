import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import "flyonui/flyonui"
import router from './rotuer/router.js'

createApp(App)
    .use(router)
    .mount('#app')
