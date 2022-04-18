// Vuex状态管理
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
var store = new Vuex.Store({
    state: {
        // 用于选择不同的框（登录->1、注册->2、重置密码->3）
        frame: 1,
        // 用户名
        user_name: '水木淋',
        //用户头像
        user_img: '',
        //地图图片
        map_url: '',
        //信息显示框
        information: false,
        //修改信息框
        alter: false,
        //静态邮箱账号
        email: '12345678@123.com',
        //静态密码
        pass: '123456ABcd',
        //静态图片验证码
        code: 'btma',
        //静态邮箱验证码
        emailCode: '1234',
        //静态页面的相关信息弹框
        tips: true,
    },
    // 类似于过滤器，数据输出前可操作的数据
    getters: {
        getFrame(frame) {
            return frame
        },
    },
    // 对绑定事件（用户操作）进行处理
    mutations: {
        //切换至登录页
        registerFrame(frame) {
            this.state.frame = 1
        },
        //切换至注册页
        loginFrame(frame) {
            this.state.frame = 2
        },
        //切换至忘记密码页
        resetPasswdFrame(frame) {
            this.state.frame = 3
        },
        //显示信息显示框
        showInformation(information) {
            this.state.information = true
        },
        //隐藏信息显示框
        closeInformation(information) {
            this.state.information = false
        },
        //修改用户名
        setUserName(user_name, usName) {
            this.state.user_name = usName
        },
        //修改用户头像
        setUserImg(user_img, usImg) {
            this.state.user_img = usImg
        },
        //显示修改信息框
        showAlter(alter) {
            this.state.alter = true
            console.log(this.state.alter)
        },
        //隐藏修改信息框
        closeAlter(alter) {
            this.state.alter = false
        },
    },
})

export default store