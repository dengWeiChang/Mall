<template>
    <div class="header">
        <div class="collapse-btn" @click="handleHome">
            <i class="el-icon-menu"></i>
        </div>
        <div class="logo">运营后台管理系统</div>
        <div class="header-right">
            <div class="header-user-icon">
                <div class="user-avator">
                    <img src="@/assets/img.png" alt="">
                </div>
                <el-dropdown trigger="click" @command="handleCommand">
                    <span class="el-dropdown-link">
                        {{username}}
                      <i class="el-icon-arrow-down el-icon--right"/>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>
                            <a>个人信息</a>
                            </el-dropdown-item>
                        <el-dropdown-item>
                            <a href="https://github.com/MrZHLF" target="_blank">github</a>
                        </el-dropdown-item>
                        <el-dropdown-item command="loginout">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      name: "默认用户"
    }
  },
  computed:{
      username() {
        let username = localStorage.getItem('ms_username');
        return username ? username : this.name;
    }
  },
  methods:{
    handleHome() {
      this.$router.push({ path: '/dashboard' })
    },
    handleCommand(command) {
        if(command == 'loginout') {
            this.$router.push('/login')
        }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header {
    position: relative;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #fff;
    background-color: #242f42;
    z-index: 0;
}
.collapse-btn{
    float: left;
    padding: 0 21px;
    cursor: pointer;
    line-height: 70px;
}
.logo {
    float: left;
    width: 250px;
    line-height: 70px;
}
.header-right {
    float: right;
    padding-right: 50px;
}
.header-user-icon{
    display: flex;
    height: 70px;
    align-items: center;
}
.btn-fullscreen{
    transform: rotate(45deg);
    margin-right: 5px;
    font-size: 24px;
}
.user-avator{
    margin-left: 10px;
}
.user-avator img{
    display: block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    z-index: 999;
		padding-right: 10px;
}
.el-dropdown-link{
    color: white;
    cursor: pointer;
}
a{
    text-decoration: none;
    color: black;
}
</style>
