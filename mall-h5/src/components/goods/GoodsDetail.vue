<template>
  <div>
    <Search></Search>
    <!-- 店铺头-->
    <ShopHeader></ShopHeader>

    <GoodsDetailNav></GoodsDetailNav>
    <!-- 商品面包屑-->
    <div class="shop-item-path">
      <div class="shop-nav-container">
        <Breadcrumb>
          <BreadcrumbItem to="/">首页</BreadcrumbItem>
          <BreadcrumbItem to="/goodsList">手机壳</BreadcrumbItem>
          <BreadcrumbItem>手机保护套</BreadcrumbItem>
        </Breadcrumb>
      </div>
    </div>
    <!-- 商品Sku信息展示 -->
    <GoodsSku></GoodsSku>
    <!-- 商品Intro详细展示 -->
    <GoodsSpec></GoodsSpec>
    <Spin size="large" fix v-if="isLoading"></Spin>
  </div>
</template>

<script>
import Search from '@/components/search/Search';
import GoodsDetailNav from '@/components/goods/GoodsDetailNav';
import ShopHeader from '@/components/shop/ShopHeader';
import GoodsSku from '@/components/goods/GoodsSku';
import GoodsSpec from '@/components/goods/GoodsSpec';
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';
export default {
  name: 'GoodsDetail',
  beforeRouteEnter (to, from, next) {
    window.scrollTo(0, 0);
    next();
  },
  created () {
    this.loadGoodsInfo();
  },
  data () {
    return {
      tagsColor: [ 'blue', 'green', 'red', 'yellow' ]
    };
  },
  methods: {
    ...mapActions(['loadGoodsInfo'])
  },
  computed: {
    ...mapState(['goodsInfo', 'isLoading'])
  },
  components: {
    Search,
    ShopHeader,
    GoodsDetailNav,
    GoodsSku,
    GoodsSpec
  },
  store
};
</script>

<style scoped>
.shop-item-path {
  height: 38px;
  background-color: rgb(236, 235, 235);
  line-height: 38px;
  color: #2c2c2c;
}
.shop-nav-container {
  margin-left: 15%;
  width: 80%;
}
</style>
