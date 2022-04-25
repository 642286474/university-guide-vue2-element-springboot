// 显示信息
<template>
  <div class="information">
    <div class="el-icon-close close" @click="closeInfor"></div>
    <!-- 数据内容 -->
    <div class="datas">
      <!-- 渲染信息 -->
      <!-- 建筑名称 -->
      <h2>{{ this.$store.state.atArchitectureName }}</h2>
      <!-- 教学楼、运动场地、宿舍的数据 -->
      <div v-if="datas.class === 'TeachingBuilding' || datas.class === 'SportsField' || datas.class === 'DormitoryBuilding'">
        <div class="content-box" v-for="item in datas.datas" :key="datas.class === 'TeachingBuilding' ? item.class_floorid : datas.class === 'SportsField' ? item.sports_field_name : item.dormitory_building_name">
          <i class="content">{{ datas.class === 'TeachingBuilding' ? '教室号：' + item.class_floorid : datas.class === 'SportsField' ? '运动场名称：' + item.sports_field_name : '公寓号：' + item.dormitory_building_name }}</i>
          <i class="content">
            {{ datas.class === 'TeachingBuilding' ? '楼层：' + item.class_floor : datas.class === 'SportsField' ? '所在楼层：' + item.sports_field_floor : '楼层：' + item.dormitory_building_height }}
          </i>
          <i class="content">
            {{ datas.class === 'TeachingBuilding' ? '教室类型：' + item.class_name : datas.class === 'SportsField' ? '用户类型：' + item.sports_field_usertype : '公寓类型：' + item.dormitory_building_type }}
          </i>
        </div>
      </div>
      <!-- 饭堂的数据 -->
      <div v-else-if="datas.class === 'Canteen'">
        <p class="content">{{ datas.datas }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //数据
      datas: {},
      //测试
      //饭堂数据
      // datas:{
      //   class: "Canteen",
      //   datas: "鲜果缘水果捞、家家味焗饭、柳州螺蛳粉、客家风味小炒、SITTER茶空间、新一鸡排.汉堡.小串、阿妈靓食原味汤粉、一炖天香、星辰潮记风味、眷村阿嬷粢饭團、肠粉猪杂汤饭、粤肠玖肠粉、张率麻辣烫麻辣香锅",
      // }
    }
  },
  methods: {
    //隐藏信息显示框
    closeInfor() {
      this.$store.commit('closeInformation')
    },
  },
  created() {
    console.log(this.$store.state.atUniversityID, this.$store.state.atArchitectureID)
    this.$axios
      .post('universities/architecture', { atUniversityID: this.$store.state.atUniversityID, atArchitectureID: this.$store.state.atArchitectureID })
      .then((res) => {
        this.datas = res.data
        console.log(res.data)
      })
      .catch((err) => {
        console.error(err)
      })
  },
}
</script>

<style lang="less" scoped>
i {
  font-style: normal;
}
.father-box {
  overflow: hidden;
}
.information {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 700px;
  max-height: 400px;
  overflow-y: auto;
  //overscroll-: ;
  padding: 50px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 20px;
  z-index: 2;
  -moz-box-shadow: 0px 0px 5px rgba(112, 133, 166, 0.144);
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
  .content-box {
    text-align: left;
    .content {
      display: inline-block;
      text-align: left;
      padding-right: 10px;
      line-height: 23px;
      text-indent: 2em;
      font-size: 13px;
    }
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
.information::-webkit-scrollbar {
  display: none;
}
</style>
