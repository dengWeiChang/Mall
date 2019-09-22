<template>
    <div class="sidebar">
        <el-menu
            router
            class="sidebar-el-menu"
            background-color="#545c64"
            text-color="#fff"
            :collapse="collapse"
            active-text-color="#ffd04b">
            <el-menu-item index="dashboard">
                <i class="el-icon-setting"></i>
                <span slot="title">首页</span>
            </el-menu-item>

            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-date"></i>
                <span slot="title">商品管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="category">类目管理</el-menu-item>
                <el-menu-item index="brand">品牌管理</el-menu-item>
                <el-menu-item index="specification">规格管理</el-menu-item>
                <el-menu-item index="goods">商品管理</el-menu-item>
                <el-menu-item index="goodsedit">商品编辑</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

						<el-submenu index="4">
								<template slot="title">
										<i class="el-icon-document"></i>
										<span slot="title">订单管理</span>
								</template>
										<el-menu-item-group>
										<el-menu-item index="order">订单列表</el-menu-item>
								</el-menu-item-group>
						</el-submenu>
        </el-menu>
    </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      collapse:false
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.sidebar{
    display: block;
    position: absolute;
    top: 70px;
    left: 0;
    bottom: 0;
    height: 100%;
		background-color: rgb(50, 65, 87);
}
.sidebar-el-menu{
    /*width: 25%;*/
}
.sidebar>ul{
    height: 100%;
}
</style>
