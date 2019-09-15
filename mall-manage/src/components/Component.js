const component = {};

component.install = function (Vue) {
  Vue.component("mTree", () => import('./Tree'));
}

export default component;
