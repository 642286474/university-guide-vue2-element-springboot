// 路由
import Vue from 'vue'
import VueRouter from 'vue-router'
//导入组件
import Home from '@/components/Views/Home' //登录注册组件
import UserAgreement from '@/components/Login/agreement/UserAgreement' //用户协议组件
import PrivacyAgreement from '@/components/Login/agreement/PrivacyAgreement' //隐私协议组件
import UniversityMap from '@/components/UniversityMap'
Vue.use(VueRouter)

// 配置路由
const routes = [
    { path: '/', component: Home },
    { path: '/useragreement', component: UserAgreement },
    { path: '/privacyagreement', component: PrivacyAgreement },
    { path: '/universitymap', component: UniversityMap },
]

const router = new VueRouter({
    routes,
})

//路由白名单
const white_list = ['/useragreement', '/privacyagreement']
    //全局路由守卫
router.beforeEach((to, from, next) => {
    if (white_list.includes(to.fullPath)) {
        //要去的路由在白名单中
        console.log(111)
        next()
    } else if (to.fullPath === '/' && !window.sessionStorage.getItem('token')) {
        //去登录界面且为未登录状态，放行
        console.log(window.sessionStorage.getItem('token'))
        console.log(222)
        next()
    } else if (to.fullPath === '/' && window.sessionStorage.getItem('token')) {
        //去登录路由且为登录状态，强制跳转到主页
        console.log(window.sessionStorage.getItem('token'))
        console.log(222)
        next('/universitymap')
    } else if (window.sessionStorage.getItem('token')) {
        //登录状态去其他路由，放行
        next()
    }
})
export default router