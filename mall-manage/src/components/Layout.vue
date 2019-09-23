<template>
    <div class="wrapper">
        <app-header></app-header>
        <sider-list></sider-list>
        <div class="content">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
import Header from './Header'
import Sidebar from './Sidebar'
export default {
  name: 'Layout',
  data () {
    return {
      collapse:false
    }
  },
  created() {

  },
  components: {
      "app-header":Header,
      "sider-list":Sidebar
  }
}
</script>

<style>
.wrapper{
    height: 100%;
    width: 100%;
    overflow: hidden;
}
.content {
  margin-top: 6%;
  margin-left: 13%;
  margin-right: 1%;
  overflow:scroll
}
</style>
