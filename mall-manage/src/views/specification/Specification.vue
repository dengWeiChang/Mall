<template>
    <div>
      <mBreadcrumb />
      <div class="container">
        <div class="left">
          <el-card class="left-box-card">
            <el-tree style="background-color: rgb(240,240,240)"
                     class="tree"
                     :props="props"
                     :load="loadNode"
                     lazy
                     @check-change="handleCheckChange"
                     @node-click="handleNodeClick">
            </el-tree>
          </el-card>
        </div>
        <div class="right">
          <el-card class="right-box-card">
            <h3 v-if="this.selectedcategory.name != ''">规格设置-{{this.selectedcategory.name}}</h3>
            <h3 v-else>请选择一个具体分类</h3>
            <div v-for="item in items" :key="item">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>{{item.name}}</span>
                  <el-button style="float: right; padding: 3px 0" type="text">编辑操作</el-button>
                </div>
                <div v-for="itdl in item.specs" :key="itdl" style="font-size: 5px">
                  <!--<el-row><el-col :span="12">{{ itdl.name  }}</el-col><el-col :span="12">{{itdl.value}}</el-col></el-row>-->
                  <el-collapse accordion>
                    <el-collapse-item>
                      <template slot="title">
                        {{ itdl.name  }}<i class="header-icon el-icon-info"></i>
                      </template>
                      <div>
                        <!--<div v-for="itdlv in itdl.value" :key="itdlv">-->
                          <!--<el-tag type="success">{{itdlv}}</el-tag>-->
                        <!--</div>-->
                        <el-tag type="success">{{itdl.value}}</el-tag>
                      </div>
                    </el-collapse-item>
                  </el-collapse>
                </div>
              </el-card>
            </div>
          </el-card>
        </div>
      </div>
    </div>
</template>

<script>
  import {getAllCategoryTree as getCategoryTree} from '@/api/category';
  import {getSpecGroupByCatId as getSpecGroup} from '@/api/specification.js';
  export default {
    name: "Specification",
    data() {
      return {
        selectcategory:"手机",
        items:[
        //   {
        //   groupname:"主体",
        //   details:[{
        //     name:"入网型号",
        //     value:["A2217"]
        //   },{
        //     name:"产品名称",
        //     value:["iPhone 11 Pro"]
        //   },{
        //     name:"上市年份",
        //     value:["2018","2019年"]
        //   }]
        // },{
        //   groupname:"操作系统",
        //   details:[{
        //     name:"操作系统",
        //     value:["Android","iOS(Apple)"]
        //   }]
        // },{
        //   groupname:"基本信息",
        //   details:[{
        //     name:"机身颜色",
        //     value:["深空灰色","白色","土豪金"]
        //   },{
        //     name:"机身长度（mm）",
        //     value:["144"]
        //   },{
        //     name:"双卡机类型",
        //     value:["单卡单待","双卡双待"]
        //   }]
        // }
        ],
        props: {
          label: 'name',
          children: 'children'
        },
        categoryList:[
        ],
        selectedcategory: {
          id:'',
          name:'',
        },
      };
    },
    methods: {
      handleCheckChange(data, checked, indeterminate) {
        // console.log(data, checked, indeterminate);
        console.log(111);
      },
      handleNodeClick(data) {
        this.selectedcategory.name = data.name
        this.selectedcategory.id = data.id
        getSpecGroup(
          this.selectedcategory.id
        ).then(response => {
          this.items = response
          console.log(this.items)
        })
      },
      loadNode(node, resolve) {
        // // 每次点击都是一个node
        if (node.level === 0) {
          getCategoryTree({
            parentId: 0
          }).then(response=>{
            return resolve(response)
          });
        } else {
          getCategoryTree({
            parentId:node.data.id
          }).then(response=>{
            return resolve(response)
          });
        }
      }
    }

    ,
    mounted () {

    }
  }
</script>

<style scoped>
  .container{
    height: 100%;
  }
  .left{
    width: 20%;
    height: 900px;
    float: left;
    font-size: 40px;
    color: #fff;
  }
  .right{
    width: 80%;
    height: 900px;
    font-size: 40px;
    float: left;
    color: #fff;
  }

  .left-box-card {
    width: 90%;
    height: 900px;
  }
  .right-box-card {
    width: 100%;
    height: 900px;
  }
</style>
