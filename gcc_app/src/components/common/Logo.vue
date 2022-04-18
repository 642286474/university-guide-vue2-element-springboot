<template>
  <div>
    <h1 class="logo" @click="goHome">大学漫游指南</h1>
  </div>
</template>

<script>
export default {
  name: 'Logo',
  methods: {
    goHome() {
      this.$router.push('/')
    },
  },
}
</script>

<style lang="less" scoped>
.logo {
  cursor: pointer;
  color: #88f;
}
</style>
