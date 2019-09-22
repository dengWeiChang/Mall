import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: resolve => require(['../views/Login.vue'], resolve),
    },
    {
      path: '/',
      component: resolve => require(['../components/Home.vue'], resolve),
      meta: { title: '引导页' },
      children:[
        {
          path: '/dashboard',
          component: resolve => require(['@/views/home/Dashboard.vue'], resolve),
          meta: { title: '首页' },
        },
        {
          path: '/category',
          component: resolve => require(['@/views/category/Category'], resolve),
          meta: { title: '类目' },
        },
        {
          path: '/brand',
          component: resolve => require(['@/views/brand/Brand'], resolve),
          meta: { title: '品牌' },
        },
        {
          path: '/specification',
          component: resolve => require(['@/views/specification/Specification'], resolve),
          meta: { title: '规格' },
        },
        {
          path: '/goods',
          component: resolve => require(['@/views/goods/Goods'], resolve),
          meta: { title: '商品' },
        },
        {
          path: '/goodsedit',
          component: resolve => require(['@/views/goods/GoodsEdit'], resolve),
          meta: { title: '商品编辑' },
        },
        {
          path: '/order',
          component: resolve => require(['@/views/order/Order'], resolve),
          meta: { title: '订单列表' },
        },
        {
          path: '/orderDetail',
          component: resolve => require(['@/views/order/OrderDetail'], resolve),
          meta: { title: '订单详情' },
        }
      ]
    },
    {
      path: '/404',
      component: resolve => require(['@/views/404.vue'], resolve)
    }
  ],
  model:history
})
