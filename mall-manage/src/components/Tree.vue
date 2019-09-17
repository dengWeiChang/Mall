<template>
  <div>
    <el-tree
      class="tree"
      :props="props"
      :load="loadNode"
      lazy
      show-checkbox
      @check-change="handleCheckChange">
    </el-tree>
  </div>
</template>

<script>
  import {getAllCategoryTree as getCategoryTree} from '@/api/category';

  export default {
      name: "mTree",
      data() {
        return {
          props: {
            label: 'name',
            children: 'children'
          },
          count: 1,

        };
      },
      methods: {
        handleCheckChange(data, checked, indeterminate) {
          console.log(data, checked, indeterminate);
        },
        handleNodeClick(data) {
          console.log(data);
        },
        loadNode(node, resolve) {

        }
      }
    }
</script>

<style scoped>
  .tree {
    margin: 0px;
    padding: 5px;
    width: 200px;
    height: 400px;
  }
</style>
