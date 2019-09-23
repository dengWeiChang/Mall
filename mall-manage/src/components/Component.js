/**
 * 组件全局配置
 */

const component = {};

component.install = function (Vue) {
  Vue.component("mBreadcrumb", () => import('./Breadcrumb'));
  Vue.component("mCategoryTree", () => import('./CategoryTree.vue'));
}

export default component;
