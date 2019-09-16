<template>
  <div>
    <mTree class="tree"
           :props="props"
           :load="loadNode"
           lazy
           show-checkbox
           @check-change="handleCheckChange"></mTree>
  </div>
</template>

<script>
  import {getAllCategoryTree as getCategoryTree} from '@/api/category';

  export default {
    data() {
      return {
        props: {
          label: 'name',
          children: 'children'
        },
        count: 2
      };
    },
    name: "category",
    methods: {
      handleCheckChange(data, checked, indeterminate) {
        console.log(data, checked, indeterminate);
      },
      handleNodeClick(data) {
        console.log(data);
      },
      loadNode(node, resolve) {
        // console.log("CHILDREN")
        // getCategoryTree(null).then(response=>{
        //   resolve(response)
        //   console.log("333333")
        // });
        console.log("222222222")
        if (node.level === 0) {
          return resolve([{ name: 'region3' }, { name: 'region4' }]);
        }
        if (node.level > 3) return resolve([]);

        var hasChild;
        if (node.data.name === 'region3') {
          hasChild = true;
        } else if (node.data.name === 'region2') {
          hasChild = false;
        } else {
          hasChild = Math.random() > 0.5;
        }

        setTimeout(() => {
          var data;
          if (hasChild) {
            data = [{
              name: 'zone' + this.count++
            }, {
              name: 'zone' + this.count++
            }];
          } else {
            data = [];
          }

          resolve(data);
        }, 500);
      }
    }
  }
</script>

<style scoped>

</style>
