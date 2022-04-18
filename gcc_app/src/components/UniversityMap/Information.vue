// 显示信息
<template>
  <div class="information">
    <div>
      <div class="el-icon-close close" @click="closeInfor"></div>
      <div>
        <h2>xxxx院</h2>
        <div class="img">
          <a
            href="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.51yuansu.com%2Fbackgd%2Fcover%2F00%2F39%2F10%2F5be38f6f2685e.jpg%21%2Ffw%2F780%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue&refer=http%3A%2F%2Fpic.51yuansu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652891529&t=1f7735d36f46c72aac51bc81852e739b"
            target="_blank"
            ><img
              src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.51yuansu.com%2Fbackgd%2Fcover%2F00%2F39%2F10%2F5be38f6f2685e.jpg%21%2Ffw%2F780%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue&refer=http%3A%2F%2Fpic.51yuansu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652891529&t=1f7735d36f46c72aac51bc81852e739b"
              alt=""
          /></a>
        </div>
        <h4>xxxx院</h4>
        <h4>Guangzhou College of Commerce</h4>
        <p class="content">xxxx院（Guangzhou College of Commerce），位于xx省xx市xxx，是经教育部批准设立的一所民办全日制普通本科院校，为xx省硕士学位授予立项建设单位、xx省自然科学基金项目依托单位、xx省第六批博士后创新实践基地单位。</p>
        <p class="content">
          学校前身是创办于xxxx年x月的xxxx大学xx学院。xxxx年x月，教育部确认xxxx大学xx学院为独立学院。xxxx年x月，学院获得学士学位授予权。xxxx年x月，经教育部批准转设为独立设置的民办普通高校，更名xxxx院。学校顺利通过xxxx年教育部本科教学工作合格评估。xxxx年，学校获批为xx博士工作站及硕士学位授予立项建设单位。
        </p>
        <p class="content">截至xxxx年x月，学校校园占地面积xxxx多亩，总建筑面积xx万余平方米，学校图书馆馆藏纸质图书xxx万册，电子图书xxx万册，教学科研仪器设备总值xxxx万元；设有xx院x部，全日制在校生数为xxxxx人。</p>
        <span class="content left-box">创办时间：xxxx年</span>
        <span class="content right-box">学校官网：<a href="http://www.baidu.com" target="_blank">http://www.baidu.com</a></span>
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
