<template>
  <div class="home">
    <!-- 地图 -->
    <university-map></university-map>
    <!-- 登录 -->
    <login v-if="login"></login>
  </div>
</template>

<script>
//地图组件
import UniversityMap from '@/components/UniversityMap/TestDrag'
//登录组件
import Login from '@/components/Login'
export default {
  name: 'Home',
  data() {
    return {
      login: true,
    }
  },
  components: {
    UniversityMap,
    Login,
  },
}
</script>

<style lang="less" scoped>
html,
body {
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
}
</style>
