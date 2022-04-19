// 大学选项
<template>
  <div class="university">
    <el-dropdown @command="handleCommand">
      <el-button type="primary">&nbsp;{{ pitchOnUniversity }}<i class="el-icon-arrow-down el-icon--right"></i> </el-button>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="广州商学院">广州商学院</el-dropdown-item>
        <el-dropdown-item command="广州大学">广州大学</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pitchOnUniversity: '广州商学院',
      click: true,
    }
  },
  methods: {
    // 选择下拉菜单选项时触发
    handleCommand(command) {
      //显示的选项
      this.pitchOnUniversity = command
      // 发送请求
      this.$axios
        .post('university', { university: this.pitchOnUniversity })
        .then((res) => {
          console.log(res)
        })
        .catch((err) => {
          console.error(err)
        })
    },
  },
}
</script>

<style lang="less" scoped>
/deep/ .el-button {
  border-width: 0px;

  width: 200px;
  height: 40px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 9px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 16px;
  //按钮中的文字
  span {
    text-align: center;
    width: 181px;
    height: 38px;
    font-family: '等线', sans-serif;
    font-weight: 400;
    color: #333333;
    font-style: normal;
    font-size: 16px;
    //三角
    i {
      float: right;
    }
  }
}

//学校选项ul
.el-dropdown-menu {
  width: 190px;
  background-color: rgba(255, 255, 255, 1);
  border-radius: 9px;
  padding: 6px 5px;
}
//学校选项li
/deep/ .el-dropdown-menu__item {
  border-width: 0px;
  width: 148px;
  height: 33px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 7px;
  box-shadow: none;
  font-family: '等线', sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 16px;
  color: #38579d;
}
</style>
