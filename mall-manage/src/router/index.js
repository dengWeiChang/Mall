import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: resolve => require(['../views/Login.vue'], resolve),
    },
    {
      path: '/',
      component: resolve => require(['../components/Home.vue'], resolve),
      meta: { title: '自述文件' },
      children:[
        {
          path: '/dashboard',
          component: resolve => require(['@/views/Dashboard.vue'], resolve),
          meta: { title: '首页' },
        },
        {
          path: '/category',
          component: resolve => require(['@/views/Category'], resolve),
          meta: { title: '类目' },
        },
        {
          path: '/brand',
          component: resolve => require(['@/views/brand/Brand'], resolve),
          meta: { title: '类目' },
        },
        {
          path: '/tabs',
          component: resolve => require(['@/views/Tabs.vue'], resolve),
          meta: { title: 'tab选项卡' },
        },
        {
          path: '/foodlist',
          component: resolve => require(['@/views/FoodList.vue'], resolve),
          meta: { title: '食品列表' },
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
