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
          count: 1
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
          // // 每次点击都是一个node
          if (node.level === 0) {
            getCategoryTree(null).then(response=>{
              return resolve(response)
            });
          } else {
            console.log(node.data.isParent)
            console.log(node.data.id)
            params = {
              id:node.data.id
            }
            getCategoryTree(params).then(response=>{
              return resolve(response)
            });
          }
        }
      }
    }
</script>

<style scoped>
  .tree {
    margin: 0px;
    padding: 5px;
    width: 150px;
    height: 400px;
  }
</style>
