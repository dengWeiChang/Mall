<template>
    <div class="wrapper">
        <app-header></app-header>
        <div style="display: flex;">
          <div class="left-container">
            <sider-list></sider-list>
          </div>
          <div class="main-container">
              <router-view></router-view>
          </div>
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
    height: 1000px;
    width: 100%;
    /*overflow-x:hidden;*/
    /*background-color: red;*/
}
.left-container{
  width: 10%;
  /*height: 100%;*/
  background-color: #545c64;
  bottom: 0px;
  min-height: 1000px;
}
.main-container {
  width: 90%;
  height: 100%;
  margin-top: 1%;
  margin-left: 1%;
  margin-right: 1%;
}
</style>
