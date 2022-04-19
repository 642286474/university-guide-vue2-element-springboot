<template>
  <div class="shadow">
    <div class="login-frame-box">
      <!-- 登录 -->
      <Register v-if="getFrame === 1"></Register>
      <!-- 注册 -->
      <LoginFrame v-else-if="getFrame === 2"></LoginFrame>
      <!-- 重置密码 -->
      <ResetPasswd v-else-if="getFrame === 3"></ResetPasswd>

      <div class="agreement">登录注册即代表同意<a href="javascript:;" @click="goUserAgreement">《用户协议》</a>和<a href="javascript:;" @click="goPrivacyAgreement">《隐私协议》</a></div>
    </div>
  </div>
</template>

<script>
// 注册组件
import LoginFrame from './LoginFrame.vue'
// 登录组件
import Register from './Register.vue'
//重置密码组件
import ResetPasswd from './ResetPasswd.vue'
export default {
  components: {
    Register,
    LoginFrame,
    ResetPasswd,
  },
  computed: {
    //选择不同的框（登录、注册、重置密码）
    getFrame() {
      console.log(this.$store.state.frame)
      return this.$store.state.frame
    },
  },
  methods: {
    //用户协议
    goUserAgreement() {
      this.$router.push('/useragreement')
    },
    //隐私协议
    goPrivacyAgreement() {
      this.$router.push('/privacyagreement')
    },
  },
}
</script>

<style lang="less" scoped>
//阴影
.shadow {
  border-width: 0px;
  position: absolute;
  left: 0px;
  top: 0px;
  width: 100%;
  height: 100%;
  background: inherit;
  background-color: rgba(69, 69, 69, 0.5);
  border: none;
  border-radius: 0px;
  box-shadow: none;
}
//登录框
.login-frame-box {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  border-width: 0px;
  width: 318px;
  padding-top: 34px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 20px;
  -moz-box-shadow: 0px 0px 5px rgba(112, 133, 166, 0.349019607843137);
  -webkit-box-shadow: 0px 0px 5px rgb(112 133 166 / 35%);
  box-shadow: 0px 0px 5px rgb(112 133 166 / 35%);
  //协议
  .agreement {
    margin: 0 auto;
    margin-top: -4px;
    margin-bottom: 23px;
    border-width: 0px;
    width: 286px;
    height: 14px;
    line-height: 14px;
    font-family: '等线', sans-serif;
    font-weight: 400;
    font-style: normal;
    font-size: 13px;
    color: #afafaf;
    a {
      text-decoration: none;
      color: #afafaf;
    }
  }
}
//协议
.agreement {
  margin: 0 auto;
  margin-top: -4px;
  margin-bottom: 23px;
  border-width: 0px;
  width: 286px;
  height: 14px;
  line-height: 14px;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 13px;
  color: #afafaf;
  a {
    text-decoration: none;
    color: #afafaf;
  }
}
</style>
