// 功能选项
<template>
  <div>
    <div class="FunctionOptions">
      <div class="option">
        <div class="icon">
          <div class="smallIcon" style="">
            <div class="img-box map-box"></div>
          </div>
        </div>
        <div class="iconName">地图</div>
      </div>
      <div class="option">
        <div class="icon" @click="aboutUS = true">
          <div class="smallIcon" style=""><span>i</span></div>
        </div>
        <div class="iconName">关于我们</div>
      </div>
    </div>
    <!-- 关于我们的弹框 -->
    <el-dialog title="关于我们" :modal-append-to-body="false" :visible.sync="aboutUS" width="600px" :before-close="handleClose" center>
      <!-- 关于我们的信息 -->
      <about></about>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="aboutUS = false">确 定</el-button>
        <el-button @click="aboutUS = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import About from '@/components/common/AboutUS'
export default {
  components: {
    About,
  },
  data() {
    return {
      // 展示关于我们
      aboutUS: false,
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then((_) => {
          done()
        })
        .catch((_) => {})
    },
  },
}
</script>

<style lang="less" scoped>
.FunctionOptions {
  border-width: 0px;
  box-sizing: border-box;
  padding-top: 16px;
  padding-left: 30px;
  padding-right: 20px;
  height: 106px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 138px;
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
  z-index: 2;
  .option {
    display: inline-block;
    width: 80px;
    // 图标外界
    .icon {
      margin: 0 auto;
      position: relative;
      width: 50px;
      height: 50px;
      background-color: rgba(236, 236, 236, 1);
      border-radius: 50%;
      overflow: hidden;
      // 图标
      .smallIcon {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        width: 24px;
        height: 24px;
        overflow: hidden;
        .img-box {
          width: 100%;
          height: 100%;
        }
        .map-box {
          background-image: url('../../assets/map_logo2.png');
          background-size: 100%;
        }
        span {
          width: 50px;
          height: 50px;
          font-family: 'Times New Roman Normal', 'Times New Roman', sans-serif;
          font-style: normal;
          font-size: 23px;
          color: #38579d;
          -moz-user-select: none;
          -webkit-user-select: none;
          -ms-user-select: none;
          -khtml-user-select: none;
          user-select: none;
        }
      }
    }
    //图标hover操作
    .icon:hover {
      background-color: #38579d;
      span {
        color: #fff;
      }
      .map-box {
        background-image: url('../../assets/map_logo.png');
        background-size: 100%;
      }
    }
    //图标名称
    .iconName {
      margin: 0 auto;
      margin-top: 10px;
      border-width: 0px;
      width: 100%;
      height: 15px;
      font-family: '等线 Bold', '等线', sans-serif;
      font-weight: 700;
      font-style: normal;
      font-size: 15px;
      color: #38579d;
    }
  }
}
</style>
