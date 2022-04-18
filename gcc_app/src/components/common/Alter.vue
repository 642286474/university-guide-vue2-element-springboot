//修改用户信息
<template>
  <div class="information">
    <div class="el-icon-close close" @click="closeAlter"></div>
    <div>
      <h3>用户名：</h3>
      <el-input v-model="user_name" :placeholder="this.$store.state.user_name"></el-input>
      <el-button type="primary" @click="setUserName" round style="margin-top: 15px">修改</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user_name: '',
    }
  },
  methods: {
    //隐藏信息显示框
    closeAlter() {
      this.$store.commit('closeAlter')
    },
    //修改用户名
    setUserName() {
      if (this.user_name === '') {
        this.$message.error('修改失败，新用户名为空！')
      } else if (this.$store.state.user_name === this.user_name) {
        this.$message.error('修改失败，新用户名与原用户名一致！')
      } else {
        this.$store.commit('setUserName', this.user_name)
        if (this.$store.state.user_name === this.user_name) {
          this.$message.success('修改成功!')
          this.closeAlter()
        } else {
          this.$message.error('修改失败!')
        }
      }
    },
  },
}
</script>

<style lang="less" scoped>
.information {
  position: absolute;

  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 200px;
  padding: 50px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 20px;
  z-index: 2;
  -moz-box-shadow: 0px 0px 5px rgba(112, 133, 166, 0.349019607843137);
  -webkit-box-shadow: 0px 0px 5px rgb(112 133 166 / 35%);
  box-shadow: 0px 0px 5px rgb(112 133 166 / 35%);
  //关闭按钮
  .close {
    position: absolute;
    top: 10px;
    right: 20px;
    cursor: pointer;
  }
  /deep/ el-input {
    width: 50px;
  }
}
</style>
