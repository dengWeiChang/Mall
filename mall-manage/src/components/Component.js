/**
 * 组件全局配置
 */

const component = {};

component.install = function (Vue) {
  Vue.component("mTree", () => import('./Tree'));
  Vue.component("mBreadcrumb", () => import('./Breadcrumb'));
}

export default component;
