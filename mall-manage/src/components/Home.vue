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
  name: 'Home',
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
    width: auto;
    margin-top: 1%;
    margin-left: 11%;
    margin-right: 1%;
}
</style>
