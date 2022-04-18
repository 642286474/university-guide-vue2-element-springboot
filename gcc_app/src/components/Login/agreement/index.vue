<template>
  <div class="agreement">
    <!-- 头部 -->
    <header class="header-box">
      <component class="logo" :is="Logo"></component>
    </header>
    <!-- 条款区域（躯体） -->
    <slot></slot>
  </div>
</template>

<script>
import Logo from '@/components/common/Logo'
export default {
  components: {
    Logo,
  },
  data() {
    return {
      Logo: 'Logo',
    }
  },
}
</script>

<style lang="less" scoped>
html,
body {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.agreement {
  position: relative;
  width: 100%;
  height: auto;
  background-color: #f4f4f4;
  margin: 0;
  margin-top: -60px;
  padding: 0;
  // 头部区域
  .header-box {
    position: relative;
    width: 100%;
    height: 80px;
    background-color: #fff;
    .logo {
      position: absolute;
      left: 18px;
      top: 50%;
      transform: translate(0px, -50%);
    }
  }
}
</style>
