import Vue from 'vue'
import App from './App.vue'
// 导入Element组件的使用文件
import '@/InportElement'
// 导入axios
// import axios from 'axios'
// 导入Vuex的自定义store仓库文件
import store from './store'
//导入路由文件
import router from './router'
Vue.config.productionTip = false
    // axios配置请求根路径
    // axios.defaults.baseURL = 'http://127.0.0.1:5000/'
    // axios绑定到原型链
    // Vue.prototype.$axios = axios

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app')