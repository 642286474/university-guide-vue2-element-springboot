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
        <div v-for="item in this.$store.state.infor" :key="item.id">
          <!-- 教学楼信息 -->
          <div class="name_button" :style="item.left + ';' + item.top" slot="reference" @click="showInfor(item.id, item.name)">
            <!-- <img src="" alt="" icon="el-icon-location-outline" /> -->
            <i class="img el-icon-location-outline"></i>
            <span>{{ item.name }}</span>
          </div>
        </div>
        <!-- <img src="@/assets/map.png" alt="" /> -->
      </div>
    </div>
  </div>
</template>

<script>
import Infor from './Information.vue'
import Alter from '@/components/common/Alter.vue'
import store from '@/store'
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
      infor: [],
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
    showInfor(id, name) {
      //当前选择建筑的id和名字
      this.$store.commit('setAtArchitectureID', id)
      this.$store.commit('setAtArchitectureName', name)
      // 展示信息框
      this.$store.commit('showInformation')
    },
  },
  //创建时拿建筑位置数据
  created() {
    //当前选中大学的id
    this.$store.commit('setAtUniversityID', '001')
    this.$axios
      .post('universities', { university: '001' })
      .then((res) => {
        this.$store.commit('setInfor', res.data.datas)
        console.log(this.$store.state.infor)
      })
      .catch((err) => {
        console.error(err)
      })
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
