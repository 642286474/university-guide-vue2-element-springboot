// 注册组件
<template>
  <div class="login-box">
    <!-- 标题 -->
    <div class="title-box">注册账号</div>
    <!-- 表单 -->
    <el-form :model="ruleForm" :rules="loginRules" ref="loginFormRef" label-width="100px" class="demo-ruleForm form-box">
      <el-form-item prop="email">
        <el-input v-model="ruleForm.email" placeholder="输入邮箱"></el-input>
      </el-form-item>
      <el-form-item prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="输入密码"></el-input>
      </el-form-item>
      <el-form-item prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="确认密码"></el-input>
      </el-form-item>
      <el-form-item prop="text" class="input-text-box">
        <el-input class="input-text" type="text" v-model.number="ruleForm.code" autocomplete="off" placeholder="输入邮箱验证码"></el-input>
        <el-button type="button" @click="sendEmailCode">发送验证邮件</el-button>
      </el-form-item>
      <el-form-item class="submit-box">
        <el-button type="primary" @click="submitLoginForm">注册</el-button>
      </el-form-item>
      <el-form-item class="return-box">
        <el-button type="button" @click="goRegister">返回登录</el-button>
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
      // 正则表达式：包含数字、大写字母和小写字母
      let reg = /^.*(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/
      if ((this.ruleForm.pass.length < 6) | (this.ruleForm.pass.length > 16)) {
        //密码长度不在指定范围
        callback(new Error('请输入6-16位密码'))
      } else if (!reg.test(this.ruleForm.pass)) {
        //不包含数字、大写字母和小写字母
        callback(new Error('密码至少包含数字、大写字母和小写字母'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          // 修改密码后，再次调用确认密码，是否一致
          this.$refs.loginFormRef.validateField('checkPass')
        }
        callback()
      }
    }
    //确认密码验证
    var validatePass2 = (rule, value, callback) => {
      if (this.ruleForm.checkPass !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    //验证码位数验证
    var validateCode = (rule, value, callback) => {
      if (String(this.ruleForm.code).length !== 6) {
        callback(new Error('请输入6位验证码'))
      } else {
        callback()
      }
    }

    return {
      ruleForm: {
        email: '',
        pass: '',
        checkPass: '',
        code: '',
      },
      // 验证规则
      loginRules: {
        // 验证邮箱
        email: [{ validator: validateEmail, trigger: 'blur' }],
        // 验证密码
        pass: [{ validator: validatePass, trigger: 'blur' }],
        //验证确认密码
        checkPass: [{ validator: validatePass2, trigger: 'blur' }],
        //验证码位数验证
        text: [{ validator: validateCode, trigger: 'blur' }],
      },
    }
  },
  methods: {
    //返回登录按钮
    goRegister() {
      this.$store.commit('registerFrame')
    },
    //发送邮件验证码按钮
    sendEmailCode() {
      /// 提交前预验证（邮箱格式是否正确）
      let reg = /^([a-zA-Z\d])(\w|\-)+@[a-zA-Z\d]+\.[a-zA-Z]{2,4}$/
      if (reg.test(this.ruleForm.email)) {
        console.log('邮箱格式正确')
        this.$axios.post('users/sendemail', { email: this.ruleForm.email })
      } else {
        // 表单验证错误
        return false
      }
    },
    //注册按钮
    submitLoginForm() {
      // 表单提交前预验证
      console.log('点击注册按钮')
      this.$refs.loginFormRef.validate((valid) => {
        console.log(111)
        if (valid) {
          // console.log('submit!!')
          // alert('submit!')
          this.$axios
            .post('users/login', this.ruleForm)
            .then((res) => {
              console.log(res)
              if (res.data.token) {
                //token不为空
                this.$message.success('注册成功')
                // 将注册成功的token值保存到客户端sessionStorage中
                window.sessionStorage.setItem('token', res.data.token)
                this.$store.commit('setUserName', res.data.user_name)
                this.$store.commit('setUserImg', res.data.user_img)
                console.log(this.$store.state.user_name, this.$store.state.user_img)
                //注册成功后进行页面跳转
                this.$router.push('universitymap')
              } else {
                //token为空
                this.$message.success('注册失败，此邮箱已注册！')
              }
            })
            .catch((err) => {
              console.error(err)
            })
        } else {
          // 表单验证错误
          // console.log('error submit!!')
          return false
        }
      })
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
}
//发送验证邮件按钮
/deep/ .input-text-box .el-button {
  float: right;
  border-width: 0px;
  width: 137px;
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
  color: #ffffff;
}
//注册按钮
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

//返回登录按钮
/deep/.return-box .el-button {
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
