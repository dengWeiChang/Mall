<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item
        v-for="(item,index) in breadList"
        :key="index"
        :to="{ path: item.path }"
      >{{item.meta.title}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  name: "Breadcrumb",
  data() {
    return {
      breadList: [{
        name: "首页",
        path: "/home"
      }, {
        name: "系统设置",
        path: "/setting"
      }, {
        name: "用户管理",
        path: "/setting/usermanage"
      }]
    }
  },
  methods: {
    isHome(route) {
      return route.name !=null && route.name === "home";
    },
    getBreadcrumb() {
      let matched = this.$route.matched;
      if (!this.isHome(matched[0])) {
        matched = [{ path: "/home", meta: { title: "首页" } }].concat(matched);
      }
      this.breadList = matched;
    }
  },
  created() {
    this.getBreadcrumb();
  }
}
</script>

<style scoped>

</style>
