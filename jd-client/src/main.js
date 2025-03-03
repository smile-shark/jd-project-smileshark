import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import elementIcon from '@/plugins/icon'
import ApiPlugin from './utils/axios/axios'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app=createApp(App)
app.use(store)
app.use(router)
app.use(ElementPlus)
app.use(elementIcon)
app.use(ApiPlugin)
for(const [key,component] of Object.entries(ElementPlusIconsVue)){
    app.component(key,component)
}
app.mount('#app')