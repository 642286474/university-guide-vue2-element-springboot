// 登录组件
<template>
  <div class="register-box">
    <!-- 标题 -->
    <div class="title-box">登录账号</div>
    <!-- 表单 -->
    <el-form :model="ruleForm" :rules="registerRules" ref="ruleFormRef" label-width="100px" class="demo-ruleForm form-box">
      <!-- 邮箱 -->
      <el-form-item prop="email">
        <el-input type="email" v-model="ruleForm.email" placeholder="输入邮箱"></el-input>
      </el-form-item>
      <!-- 密码 -->
      <el-form-item prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="输入密码"></el-input>
      </el-form-item>
      <el-form-item prop="text" class="input-text-box">
        <el-input class="input-text" type="text" v-model.number="ruleForm.code" autocomplete="off" placeholder="输入验证码"></el-input>
        <img src="@/assets/static_code.png" alt="" />
      </el-form-item>
      <el-form-item class="submit-box">
        <el-button type="primary" @click="submitForm">登录</el-button>
      </el-form-item>

      <el-form-item class="return-box">
        <el-button type="button" @click="goLoginFrame">注册</el-button>
        <div class="forget"><a href="javascript:;" @click="goResetPasswd">忘记密码</a></div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    //邮箱验证,使用正则表达式进行匹配
    var validateEmail = (rule, value, callback) => {
      let reg = /^([a-zA-Z\d])(\w|\-)+@[a-zA-Z\d]+\.[a-zA-Z]{2,4}$/
      if (!reg.test(this.ruleForm.email)) {
        callback(new Error('请输入正确的邮箱地址'))
      } else {
        callback()
      }
    }
    //密码验证
    var validatePass = (rule, value, callback) => {
      if ((this.ruleForm.pass.length < 6) | (this.ruleForm.pass.length > 16)) {
        callback(new Error('请输入6-16位密码'))
      } else {
        callback()
      }
    }
    //验证码位数验证
    var validateCode = (rule, value, callback) => {
      if (String(this.ruleForm.code).length !== 4) {
        callback(new Error('请输入4位验证码'))
      } else {
        callback()
      }
    }

    return {
      ruleForm: {
        email: '',
        pass: '',
        code: '',
      },
      // 验证规则
      registerRules: {
        // 验证邮箱
        email: [{ validator: validateEmail, trigger: 'blur' }],
        // 验证密码
        pass: [{ validator: validatePass, trigger: 'blur' }],
        //验证码位数验证
        text: [{ validator: validateCode, trigger: 'blur' }],
      },

      //图片验证码
      img_src: {},
    }
  },
  methods: {
    // 登录按钮
    submitForm() {
      if (this.ruleForm.email === this.$store.state.email && this.ruleForm.pass === this.$store.state.pass && this.ruleForm.code === this.$store.state.code) {
        this.$message.success('登录成功！')
        // 将登录成功的token值保存到客户端sessionStorage中
        window.sessionStorage.setItem('token', '13579abcde24680')
        //通过编程式导航跳转页面
        this.$router.push('universitymap')
      } else {
        this.$message.error('登录失败，输入信息错误！')
      }
    },
    //注册按钮
    goLoginFrame() {
      this.$store.commit('loginFrame')
    },
    //忘记密码链接
    goResetPasswd() {
      this.$store.commit('resetPasswdFrame')
    },
  },
}
</script>

<style lang="less" scoped>
// 标题
.title-box {
  margin: 0 auto;
  padding-bottom: 10px;
  border-width: 0px;
  width: 68px;
  height: 19px;
  display: flex;
  font-family: '黑体', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 17px;
  color: #000000;
  border-bottom: rgba(56, 87, 157, 1) solid 4px;
}
//表单
.form-box {
  margin-top: 40px;
}
//邮箱验证码框和发送邮箱验证按钮的爷div
/deep/ .input-text-box {
  margin-left: 11px;
}
//邮箱验证码框和发送邮箱验证按钮的父div
/deep/ .input-text-box .el-form-item__content {
  width: 286px;
}
//输入邮箱验证码框
/deep/ .input-text-box .el-input__inner {
  width: 137px;
}
/deep/ .input-text-box .el-input {
  display: inline-block;
  width: 137px;
  float: left;
  margin-left: 6px;
}
//图片验证码
/deep/ .input-text-box img {
  float: right;
  width: 137px;
  height: 38px;
  margin-right: -5px;
  cursor: pointer;
}
//登录按钮
/deep/.submit-box .el-button {
  order-width: 0px;
  width: 286px;
  height: 38px;
  background: inherit;
  background-color: rgba(56, 87, 157, 1);
  border: none;
  border-radius: 44px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 16px;
  color: #fcfbfb;
}

//注册按钮
/deep/.return-box .el-button {
  float: left;
  margin-left: 18px;
  border-width: 0px;
  width: 85px;
  height: 25px;
  padding: 0;
  background: inherit;
  background-color: rgba(255, 255, 255, 0);
  box-sizing: border-box;
  border-width: 1px;
  border-style: solid;
  border-color: rgba(56, 87, 157, 1);
  border-radius: 148px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  color: #38579d;
}

//忘记密码
/deep/.return-box .forget {
  float: right;
  margin-right: 19px;
  border-width: 0px;
  width: 60px;
  height: 25px;
  display: flex;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 15px;
  color: #38579d;
  a {
    line-height: 25px;
    text-decoration: none;
  }
}

// 修改Element内部样式
/deep/ .el-input__inner {
  border-radius: 26px;
  width: 286px;
  height: 38px;
  padding: 2px 10px 2px 13px;
  font-family: '等线 Regular', '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 15px;
  vertical-align: none;
  text-align: center;
  text-transform: none;
}
/deep/ .el-form-item__content {
  margin-left: 0px !important;
}
/deep/ .el-form-item {
  margin-bottom: 20px;
}
</style>
