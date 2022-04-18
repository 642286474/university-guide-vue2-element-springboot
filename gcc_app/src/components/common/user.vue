<template>
  <div class="user-box">
    <div class="uesr-name">
      {{ this.$store.state.user_name }}
      <div></div>
    </div>
    <div class="user-img-father" @click="showAlter">
      <!-- :src="this.$store.state.user_img"  -->
      <div class="user-img-son"><img src="@/assets/user_img.jpg" alt="" /></div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    // 显示信息显示框
    showAlter() {
      this.$store.commit('showAlter')
    },
  },
}
</script>

<style lang="less" scoped>
.user-box {
  position: relative;
  height: 1px;
  width: 300px;
}
.uesr-name {
  position: absolute;
  top: 12px;
  right: 16px;
  border-width: 0px;
  height: 40px;
  line-height: 40px;
  padding-left: 20px;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  border: none;
  border-radius: 86px;
  box-shadow: none;
  border-width: 0px;
  font-family: '等线 Bold', '等线', sans-serif;
  font-weight: 700;
  font-style: normal;
  font-size: 15px;
  div {
    display: inline-block;
    width: 50px;
    height: 10px;
  }
}
.user-img-father {
  position: absolute;
  right: 0;
  border-width: 0px;
  width: 60px;
  height: 60px;
  border-radius: 50%;
  background-color: #fff;
  border: 1px solid #aaa;
  cursor: pointer;
  .user-img-son {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    border-width: 0px;
    overflow: hidden;
    width: 56px;
    height: 56px;
    border-radius: 50%;
    img {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
