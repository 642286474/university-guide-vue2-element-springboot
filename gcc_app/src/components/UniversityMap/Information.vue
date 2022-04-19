// 显示信息
<template>
  <div class="information">
    <div>
      <div class="el-icon-close close" @click="closeInfor"></div>
      <div>
        <h2>广州商学院</h2>
        <div class="img">
          <a href="http://www.gzcc.cn" target="_blank"><img src="@/assets/infor.jpg" alt="" /></a>
        </div>
        <h4>广州商学院</h4>
        <h4>Guangzhou College of Commerce</h4>
        <p class="content">广州商学院（Guangzhou College of Commerce），位于广东省广州市中新广州知识城，是经教育部批准设立的一所民办全日制普通本科院校，为广东省硕士学位授予立项建设单位、广东省自然科学基金项目依托单位、广东省第六批博士后创新实践基地单位。</p>
        <p class="content">
          学校前身是创办于1997年9月的华南师范大学增城学院。2004年1月，教育部确认华南师范大学增城学院为独立学院。2012年1月，学院获得学士学位授予权。2014年5月，经教育部批准转设为独立设置的民办普通高校，更名广州商学院。学校顺利通过2020年教育部本科教学工作合格评估。2021年，学校获批为广东博士工作站及硕士学位授予立项建设单位。
        </p>
        <p class="content">截至2022年1月，学校校园占地面积1000多亩，总建筑面积36万余平方米，学校图书馆馆藏纸质图书197.3万册，电子图书108.1万册，教学科研仪器设备总值9014.03万元；设有11院1部，全日制在校生数为19583人。</p>
        <span class="content left-box">创办时间：1997年</span>
        <span class="content right-box">学校官网：<a href="http://www.gzcc.cn" target="_blank">http://www.gzcc.cn</a></span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    //隐藏信息显示框
    closeInfor() {
      this.$store.commit('closeInformation')
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
  width: 700px;
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
  .img {
    float: left;
    width: 350px;
    height: 200px;
    margin-right: 20px;
    overflow: hidden;
    img {
      width: 100%;
      cursor: pointer;
    }
  }
  .content {
    text-align: left;
    line-height: 23px;
    text-indent: 2em;
    font-size: 13px;
  }
  .left-box {
    float: left;
  }
  .right-box {
    float: right;
    a {
      color: #555;
      text-decoration: none;
    }
    a:hover {
      color: #66f;
    }
  }
}
</style>
