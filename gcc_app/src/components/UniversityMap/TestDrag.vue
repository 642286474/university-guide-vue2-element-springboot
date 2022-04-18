<template>
  <div class="drag-box">
    <infor v-if="this.$store.state.information"></infor>
    <alter v-if="this.$store.state.alter"></alter>
    <!-- @mousedown.prevent="down":拖拽，且防止默认拉取行为 -->
    <div ref="father" class="father" @mousedown.prevent="down">
      <!-- 绑定鼠标按下事件 -->
      <!-- :style="{ backgroundImage: 'url(' + this.$store.state.map_url + ')' }" -->
      <div ref="son" class="son">
        <!-- 按钮 -->
        <div v-for="item in infor" :key="item.id">
          <el-popover placement="top" width="160" v-model="visible">
            <!-- 显示的信息 -->
            <p>这是一段内容这是一段内容确定删除吗？</p>
            <!-- 隐藏显示的信息 -->
            <div style="text-align: center; margin: 0">
              <el-button type="primary" size="mini" @click="visible = false">确定</el-button>
            </div>
            <!-- 教学楼信息 -->
            <div class="name_button" :style="item.left + ';' + item.top" slot="reference" @click="showInfor">
              <!-- <img src="" alt="" icon="el-icon-location-outline" /> -->
              <i class="img el-icon-location-outline"></i>
              <span>{{ item.name }}</span>
            </div>
          </el-popover>
        </div>
        <!-- <img src="@/assets/map.png" alt="" /> -->
      </div>
    </div>
  </div>
</template>

<script>
import Infor from './Information.vue'
import Alter from '@/components/common/Alter.vue'
export default {
  components: {
    Infor,
    Alter,
  },
  data() {
    return {
      //地图缩放大小
      background_size: 150,
      visible: false,

      //测试数据
      infor: [
        { id: '1', left: 'left:' + '66%', top: 'top:' + '55%', name: '教学楼' },
        { id: '2', left: 'left:' + '68%', top: 'top:' + '57%', name: '教学楼' },
        { id: '3', left: 'left:' + '64%', top: 'top:' + '52%', name: '教学楼' },
        { id: '4', left: 'left:' + '71%', top: 'top:' + '52%', name: '教学楼' },
        { id: '5', left: 'left:' + '46%', top: 'top:' + '62%', name: '教学楼' },
        { id: '6', left: 'left:' + '40%', top: 'top:' + '60%', name: '教学楼' },
        { id: '7', left: 'left:' + '39%', top: 'top:' + '57%', name: '教学楼' },
        { id: '8', left: 'left:' + '38%', top: 'top:' + '54%', name: '教学楼' },
        { id: '9', left: 'left:' + '39%', top: 'top:' + '46%', name: '教学楼' },
        { id: '0', left: 'left:' + '42%', top: 'top:' + '52%', name: '实训楼' },
        { id: '11', left: 'left:' + '22%', top: 'top:' + '57%', name: '实训楼' },
        { id: '12', left: 'left:' + '24%', top: 'top:' + '60%', name: '教学楼' },
        { id: '13', left: 'left:' + '50%', top: 'top:' + '44%', name: '教师食堂' },
        { id: '14', left: 'left:' + '71%', top: 'top:' + '57%', name: '第一饭堂' },
        { id: '15', left: 'left:' + '51%', top: 'top:' + '62%', name: '第二饭堂' },
        { id: '16', left: 'left:' + '56%', top: 'top:' + '49%', name: '第三饭堂' },
        { id: '17', left: 'left:' + '49%', top: 'top:' + '54%', name: '第四饭堂' },
        { id: '18', left: 'left:' + '35%', top: 'top:' + '51%', name: '第五饭堂' },
        { id: '19', left: 'left:' + '20%', top: 'top:' + '47%', name: '第六饭堂' },
        { id: '20', left: 'left:' + '72%', top: 'top:' + '68%', name: '1号公寓' },
        { id: '21', left: 'left:' + '71%', top: 'top:' + '59%', name: '2号公寓' },
        { id: '22', left: 'left:' + '60%', top: 'top:' + '60%', name: '3号公寓' },
        { id: '23', left: 'left:' + '59%', top: 'top:' + '53%', name: '4号公寓' },
        { id: '24', left: 'left:' + '57%', top: 'top:' + '55%', name: '5号公寓' },
        { id: '25', left: 'left:' + '57%', top: 'top:' + '52%', name: '6号公寓' },
        { id: '26', left: 'left:' + '56%', top: 'top:' + '59%', name: '7号公寓' },
        { id: '27', left: 'left:' + '57%', top: 'top:' + '62%', name: '8号公寓' },
        { id: '28', left: 'left:' + '57%', top: 'top:' + '66%', name: '9号公寓' },
        { id: '29', left: 'left:' + '56%', top: 'top:' + '68%', name: '10号公寓' },
        { id: '30', left: 'left:' + '55%', top: 'top:' + '66%', name: '11号公寓' },
        { id: '31', left: 'left:' + '54%', top: 'top:' + '68%', name: '12号公寓' },
        { id: '32', left: 'left:' + '52%', top: 'top:' + '65%', name: '13号公寓' },
        { id: '33', left: 'left:' + '51%', top: 'top:' + '65%', name: '14号公寓' },
        { id: '34', left: 'left:' + '51%', top: 'top:' + '68%', name: '15号公寓' },
        { id: '35', left: 'left:' + '51%', top: 'top:' + '60%', name: '16号公寓' },
        { id: '36', left: 'left:' + '48%', top: 'top:' + '59%', name: '18号公寓' },
        { id: '37', left: 'left:' + '47%', top: 'top:' + '58%', name: '19号公寓' },
        { id: '38', left: 'left:' + '45%', top: 'top:' + '60%', name: '20号公寓' },
        { id: '39', left: 'left:' + '36%', top: 'top:' + '49%', name: '22号公寓' },
        { id: '40', left: 'left:' + '21%', top: 'top:' + '54%', name: '23号公寓' },
        { id: '41', left: 'left:' + '19%', top: 'top:' + '56%', name: '24号公寓' },
        { id: '42', left: 'left:' + '19%', top: 'top:' + '53%', name: '25号公寓' },
        { id: '43', left: 'left:' + '17%', top: 'top:' + '54%', name: '26号公寓' },
        { id: '44', left: 'left:' + '15%', top: 'top:' + '45%', name: '27号公寓' },
        { id: '45', left: 'left:' + '14%', top: 'top:' + '47%', name: '28号公寓' },
        { id: '46', left: 'left:' + '20%', top: 'top:' + '40%', name: '29号公寓' },
        { id: '47', left: 'left:' + '18%', top: 'top:' + '41%', name: '30号公寓' },
        { id: '48', left: 'left:' + '17%', top: 'top:' + '39%', name: '31号公寓' },
        { id: '49', left: 'left:' + '15%', top: 'top:' + '40%', name: '32号公寓' },
        { id: '50', left: 'left:' + '30%', top: 'top:' + '60%', name: '38号公寓' },
        { id: '51', left: 'left:' + '16%', top: 'top:' + '50%', name: '宿舍' },
        { id: '52', left: 'left:' + '15%', top: 'top:' + '54%', name: '宿舍' },
        { id: '53', left: 'left:' + '67%', top: 'top:' + '67%', name: '图书馆' },
        { id: '54', left: 'left:' + '44%', top: 'top:' + '58%', name: '创客空间' },
        { id: '55', left: 'left:' + '70%', top: 'top:' + '63%', name: '羽毛球场' },
        { id: '56', left: 'left:' + '67%', top: 'top:' + '46%', name: '足球场' },
        { id: '57', left: 'left:' + '33%', top: 'top:' + '55%', name: '体育馆' },
        { id: '58', left: 'left:' + '37%', top: 'top:' + '62%', name: '篮球场' },
        { id: '59', left: 'left:' + '33%', top: 'top:' + '62%', name: '网球场' },
        { id: '60', left: 'left:' + '48%', top: 'top:' + '66%', name: '行政楼' },
        { id: '61', left: 'left:' + '58%', top: 'top:' + '49%', name: '行政楼' },
        { id: '62', left: 'left:' + '51%', top: 'top:' + '56%', name: '行政楼' },
        { id: '63', left: 'left:' + '54%', top: 'top:' + '50%', name: '专家楼' },
        { id: '64', left: 'left:' + '53%', top: 'top:' + '44%', name: '湖' },
        { id: '65', left: 'left:' + '42%', top: 'top:' + '54%', name: '服务中心' },
        { id: '66', left: 'left:' + '35%', top: 'top:' + '66%', name: '驿站' },
        { id: '67', left: 'left:' + '18%', top: 'top:' + '50%', name: '驿站' },
        { id: '68', left: 'left:' + '27%', top: 'top:' + '63%', name: '校门' },
        { id: '69', left: 'left:' + '27%', top: 'top:' + '56%', name: '校门' },
        { id: '70', left: 'left:' + '39%', top: 'top:' + '67%', name: '北门' },
        { id: '71', left: 'left:' + '47%', top: 'top:' + '68%', name: '中门' },
        { id: '72', left: 'left:' + '61%', top: 'top:' + '73%', name: '校门' },
      ],
    }
  },

  methods: {
    // 鼠标按下
    down(e) {
      // 鼠标位置
      let MouseX = e.pageX
      let MouseY = e.pageY

      // 获取子元素的绝对位置
      let SonLeft = this.$refs.son.offsetLeft
      let SonTop = this.$refs.son.offsetTop
      //鼠标按下并移动
      document.onmousemove = (e) => {
        // 得到鼠标移动的相对位置
        let MouseMoveX = e.pageX - MouseX
        let MouseMoveY = e.pageY - MouseY
        //计算父框右下角位置
        console.log(this.$refs.son.getBoundingClientRect().right, this.$refs.father.offsetLeft * 9 + 100)
        if (this.$refs.son.offsetLeft >= -100 && MouseMoveX >= 0) {
          console.log('左边越界')
        } else if (this.$refs.son.getBoundingClientRect().right <= this.$refs.father.offsetLeft * 70 && MouseMoveX <= 0) {
          console.log('右边越界')
        } else if (this.$refs.son.offsetTop >= -100 && MouseMoveY >= 0) {
          console.log('上边越界')
        } else if (this.$refs.son.getBoundingClientRect().bottom <= this.$refs.father.offsetTop * 14 && MouseMoveY <= 0) {
          console.log('下边越界')
        } else {
          //移动元素：子元素绝对位置 + 鼠标移动相对位置 + 'px'
          this.$refs.son.style.left = SonLeft + MouseMoveX + 'px'
          this.$refs.son.style.top = SonTop + MouseMoveY + 'px'
        }
      }
      // 鼠标弹起
      document.onmouseup = (e) => {
        document.onmousemove = null
        document.onmouseup = null
      }
    },
    // 显示信息显示框
    showInfor() {
      this.$store.commit('showInformation')
    },
  },
}
</script>

<style lang="less" scoped>
// 按钮图片字体大小
@nameButtonSize: 14px;
html,
body,
.drag-box {
  margin: 0;
  padding: 0;
}
.father {
  position: relative;
  left: 2%;
  top: 0px;
  width: 96%;
  height: 800px;
  border-radius: 40px;
  // 超出隐藏
  overflow: hidden;
  border: 1px solid black;
  margin: 0;
  padding: 0;
  .son {
    position: absolute;
    left: -100px;
    top: 0px;
    width: 250%;
    height: 250%;
    background-size: 100% 100%;
    //地图
    background-image: url('@/assets/map.png');
    .name_button {
      position: absolute;
      cursor: pointer;
      .img {
        vertical-align: middle;
        width: @nameButtonSize;
        height: @nameButtonSize;
        margin-right: 6px;
      }
      span {
        color: #666;
        font-weight: 700;
        font-size: @nameButtonSize;
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
        -khtml-user-select: none;
        user-select: none;
      }
    }
  }
  .son:hover {
    cursor: move;
  }
}
</style>
