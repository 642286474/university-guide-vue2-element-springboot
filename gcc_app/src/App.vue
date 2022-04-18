<template>
  <div id="app">
    <!-- 要有router-view -->
    <router-view></router-view>
  </div>
</template>

<script>
import Home from '@/components/Views/Home.vue'
export default {
  name: 'App',
  components: {
    Home,
  },
}
</script>

<style lang="less">
html,
body {
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
  background-color: rgba(242, 246, 254, 1);
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
