<template>
  <div>
  <el-breadcrumb separator="/">
    <el-breadcrumb-item :to="{ path: '/dashboard' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>商品管理</el-breadcrumb-item>
    <el-breadcrumb-item>类目管理</el-breadcrumb-item>
  </el-breadcrumb>
  <br/>
  </div>
</template>

<script>
    export default {
        name: "Breadcrumb"
    }
</script>

<style scoped>

</style>
