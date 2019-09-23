<template>
  <div>
    <mBreadcrumb />
    <di class="container">
      <div>
        <el-steps :active="step" finish-status="success" align-center>
          <el-step title="提交订单" ></el-step>
          <el-step title="支付订单"></el-step>
          <el-step title="平台发货" ></el-step>
          <el-step title="确认收货" ></el-step>
          <el-step title="完成评价" ></el-step>
        </el-steps>
      </div>
      <el-card shadow="never" style="margin-top: 15px">
        <div class="operate-container">
          <i class="el-icon-warning color-danger" style="margin-left: 20px"></i>
          <span class="color-danger">当前订单状态：
            <span v-if="status == 0" style="color:#F00">新订单，带支付</span>
            <span v-else-if="status == 1" style="color:#F00">新订单，待支付</span>
            <span v-else-if="status == 2" style="color:#F00">已支付，待发货</span>
            <span v-else-if="status == 3" style="color:#F00">已发货，待收货</span>
            <span v-else-if="status == 4" style="color:#F00">已收货，待评价</span>
          </span>
          <div class="operate-button-container" >
            <el-button size="mini" >修改收货人信息</el-button>
            <el-button size="mini">修改商品信息</el-button>
            <el-button size="mini" >修改费用信息</el-button>
            <el-button size="mini" >发送站内信</el-button>
            <el-button size="mini" >关闭订单</el-button>
            <el-button size="mini" >备注订单</el-button>
          </div>
        </div>
        <div style="margin-top: 20px">
          <svg-icon icon-class="marker" style="color: #606266"></svg-icon>
          <span class="font-small">基本信息</span>
        </div>
        <div class="table-layout">
          <el-row>
            <el-col :span="4" class="table-cell-title">订单编号</el-col>
            <el-col :span="4" class="table-cell-title">发货单流水号</el-col>
            <el-col :span="4" class="table-cell-title">用户账号</el-col>
            <el-col :span="4" class="table-cell-title">支付方式</el-col>
            <el-col :span="4" class="table-cell-title">订单来源</el-col>
            <el-col :span="4" class="table-cell-title">订单类型</el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="table-cell">1</el-col>
            <el-col :span="4" class="table-cell">暂无</el-col>
            <el-col :span="4" class="table-cell">11</el-col>
            <el-col :span="4" class="table-cell">11</el-col>
            <el-col :span="4" class="table-cell">11</el-col>
            <el-col :span="4" class="table-cell">1</el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="table-cell-title">配送方式</el-col>
            <el-col :span="4" class="table-cell-title">物流单号</el-col>
            <el-col :span="4" class="table-cell-title">自动确认收货时间</el-col>
            <el-col :span="4" class="table-cell-title">订单可得优币</el-col>
            <el-col :span="4" class="table-cell-title">订单可得成长值</el-col>
            <el-col :span="4" class="table-cell-title">活动信息</el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="table-cell">1</el-col>
            <el-col :span="4" class="table-cell">1</el-col>
            <el-col :span="4" class="table-cell">1</el-col>
            <el-col :span="4" class="table-cell">1</el-col>
            <el-col :span="4" class="table-cell">1</el-col>
          </el-row>
        </div>
      </el-card>
    </di>
  </div>
</template>

<script>
export default {
    name: "Order",
    data() {
      return {
        searchdata: {},
        step:0,
        status:3
      };
    },
  methods: {
  }
}
</script>

<style scoped>
  .container {
    padding: 20px 20px 20px 20px;
    margin: 20px auto;
  }
  .operate-button-container {
    float: right;
    margin-right: 20px
  }
  .operate-container {
    background: #F2F6FC;
    height: 80px;
    margin: -20px -20px 0;
    line-height: 80px;
  }
</style>
