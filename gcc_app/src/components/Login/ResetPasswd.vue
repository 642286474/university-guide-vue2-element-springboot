// 重置密码组件
<template>
  <div class="reset-box">
    <!-- 标题 -->
    <div class="title-box">重设密码</div>
    <!-- 表单 -->
    <el-form :model="ruleForm" :rules="resetPasswdRules" ref="ruleForm" label-width="100px" class="demo-ruleForm form-box">
      <el-form-item>
        <div class="hint">请输入您的账号的电子邮箱，我们将会往你的邮箱发送重设密码的邮件，请注意查收。</div>
      </el-form-item>
      <el-form-item prop="email">
        <el-input v-model="ruleForm.email" placeholder="输入邮箱"></el-input>
      </el-form-item>
      <el-form-item class="submit-box">
        <el-button type="primary" @click="sendEmailCode">重设密码</el-button>
      </el-form-item>
      <el-form-item class="return-box">
        <el-button type="button" @click="goRegister">返回</el-button>
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
    return {
      ruleForm: {
        email: '',
      },
      // 验证规则
      resetPasswdRules: {
        // 验证邮箱
        email: [{ validator: validateEmail, trigger: 'blur' }],
      },
    }
  },
  methods: {
    //重设密码按钮
    sendEmailCode() {
      // 提交前预验证（邮箱是否填写）
      if (this.ruleForm.email === this.$store.state.email) {
        this.$message.success('修改密码成功，密码为：654321DCba！')
        //修改信息
        this.$store.state.pass = '654321DCba'
      } else {
        this.$message.error('邮箱不存在，请输入正确的邮箱！')
      }
    },
    //返回按钮
    goRegister() {
      this.$store.commit('registerFrame')
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
//提示

.hint {
  margin: 0 auto;
  margin-top: -12px;
  text-align: left;
  border-width: 0px;
  width: 277px;
  height: 66px;
  display: flex;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 16px;
  line-height: 22px;
}

//重设密码按钮
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

//返回按钮
/deep/.return-box .el-button {
  border-width: 0px;
  width: 85px;
  height: 25px;
  margin-bottom: 28px;
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
