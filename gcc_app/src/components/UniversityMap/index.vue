<template>
  <div class="map-box">
    <div class="UniversityOption">
      <UniversityOption></UniversityOption>
    </div>

    <div class="user">
      <User></User>
    </div>
    <Map> </Map>
    <div class="FunctionOptions">
      <FunctionOptions></FunctionOptions>
    </div>
  </div>
</template>

<script>
//地图
import Map from './TestDrag'
//大学选项
import UniversityOption from './UniversityOption'
//用户
import User from '@/components/common/user'
//功能选项
import FunctionOptions from '@/components/common/FunctionOptions'
export default {
  components: {
    Map,
    UniversityOption,
    User,
    FunctionOptions,
  },
}
</script>

<style lang="less" scoped>
.map-box {
  //大学选项
  .UniversityOption {
    position: absolute;
    top: 40px;
    left: 6%;
    z-index: 2;
  }
  // 用户
  .user {
    position: absolute;
    top: 27px;
    right: 6%;
    z-index: 2;
  }
  .FunctionOptions {
    position: relative;
    float: right;
    margin-top: -3%;
    margin-right: -1%;
    z-index: 2;
  }
}
</style>
