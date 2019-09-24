<template>
  <div>
  <mBreadcrumb />
    <el-card class="box-card">
      <el-steps :active="step" finish-status="success">
        <el-step title="基本信息" />
        <el-step title="规格属性SPU" />
        <el-step title="销售信息SKU" />
        <el-step title="商品描述图片" />
      </el-steps>

      <el-form  ref="form" :model="form" >
        <el-form-item v-show="0 === step" label="商品分类：" :rules="{ required: true, message: '请选择活动资源', trigger: 'change' }">
          <el-cascader
            v-model="value"
            :options="options"
            @change="handleChange"></el-cascader>
        </el-form-item>

        <el-form-item v-show="0 === step" label="商品名称：" :rules="{ required: true, message: '请输入商品名称', trigger: 'blur'}">
          <el-input style="width: 50%" v-model="form.name"></el-input>
        </el-form-item>

        <el-form-item v-show="0 === step" label="副标题：" :rules="{ required: true, message: '请输入商品副标题', trigger: 'blur'}">
          <el-input style="width: 50%" v-model="form.subtitle"></el-input>
        </el-form-item>

        <el-form-item v-show="0 === step" label="商品品牌：" :rules="{ required: true, message: '请选择商品品牌', trigger: 'blur'}">
          <el-select v-model="value" placeholder="请选择">
            <el-option
              v-for="item in form.options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item v-show="0 === step"  label="商品介绍：">
          <el-input style="width: 50%" type="textarea" v-model="form.desc"></el-input>
        </el-form-item>

        <el-form-item v-show="0 === step" label="包装清单：">
          <el-input style="width: 50%" v-model="form.name"></el-input>
        </el-form-item>

        <el-form-item v-show="0 === step" label="售后服务：">
          <el-input style="width: 50%" v-model="form.name"></el-input>
        </el-form-item>


        <el-form-item v-show="1 === step" label="商品参数：">
          <el-card style="margin-left: auto">
            屏幕尺寸:<br/>
            网络:<br/>
            系统:<br/>
            电池容量:<br/>
          </el-card>
        </el-form-item>

        <el-form-item v-show="2 === step" label="商品规格：" :rules="{ required: true, message: '请输入商品名称', trigger: 'blur'}">
          <el-card style="margin-left: auto">
            <div slot="header">
              颜色：
              <br/>
              容量：
              <el-checkbox-group v-model="form.checkList.value">
                <div v-for="item in form.checkList.name">
                  <el-checkbox >{{item}}</el-checkbox>
                </div>
              </el-checkbox-group>
            </div>
            <div>
              <el-table
                :data="tableData"
                style="width: 100%"
                max-height="250">
                <el-table-column
                  fixed
                  prop="color"
                  label="颜色"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="memory"
                  label="容量"
                  width="120">
                </el-table-column>
                <el-table-column
                  label="售价/元"
                  width="130">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.price"  type='number' maxLength="9"></el-input>
                    <!--<span style="margin-left: 10px">{{  }}</span>-->
                  </template>
                </el-table-column>
                <el-table-column
                  label="库存"
                  width="120">
                  <template slot-scope="scope">
                      <el-input v-model="scope.row.stock"  type='number' maxLength="9"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  fixed="right"
                  label="操作"
                  width="120">
                  <template slot-scope="scope">
                    <el-button
                      @click.native.prevent="deleteRow(scope.$index, tableData)"
                      type="text"
                      size="small">
                      移除
                    </el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-card>
        </el-form-item>

        <el-form-item v-show="3 === step" label="规格图片：">
          <el-card style="height: 500px;">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-remove="handleRemove">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-card>
        </el-form-item>
        <el-form-item v-show="3 === step" label="详情大图：">
          <div>
            <editor-bar v-model="editor.info" :isClear="isClear"></editor-bar>
          </div>
        </el-form-item>
      </el-form>


      <div style="display: flex; justify-content: center;">
        <div v-if="0 !== step">
          <el-button @click="pre" style="margin-top: 12px;">上步</el-button>
        </div>
        <div v-if="3 !== step">
          <el-button type="primary" style="margin-top: 12px;margin-left: 10px" @click="next">下步</el-button>
        </div>
        <div v-if="3 === step">
          <el-button type="primary" style="margin-top: 12px;margin-left: 10px" @click="submit">提交</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
  import EditorBar from '@/components/WangEditor/index'
export default {
  name: "goodsedit",
  data() {
    return {
      ptype: null,
      spuId: '',
      step: 0,
      form:{
        checkList:{
          name:["16G", "128G"],
          value:[]
        },
        options: [{
          value: '选项1',
          label: '小米'
        }, {
          value: '选项2',
          label: '华为'
        }, {
          value: '选项3',
          label: '苹果'
        }, {
          value: '选项4',
          label: '一加'
        }, {
          value: '选项5',
          label: '360'
        }]
      },
      rules: {
        name: [
          { required: true, message: '请输入活动名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        region: [
          { required: true, message: '请选择活动区域', trigger: 'change' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        date2: [
          { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
        ],
        type: [
          { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
        ],
        resource: [
          { required: true, message: '请选择活动资源', trigger: 'change' }
        ],
        desc: [
          { required: true, message: '请填写活动形式', trigger: 'blur' }
        ]
      },

      value: [],
      options: [{
        value: 'zhinan',
        label: '指南',
        children: [{
          value: 'shejiyuanze',
          label: '设计原则',
          children: [{
            value: 'yizhi',
            label: '一致'
          }, {
            value: 'fankui',
            label: '反馈'
          }, {
            value: 'xiaolv',
            label: '效率'
          }, {
            value: 'kekong',
            label: '可控'
          }]
        }, {
          value: 'daohang',
          label: '导航',
          children: [{
            value: 'cexiangdaohang',
            label: '侧向导航'
          }, {
            value: 'dingbudaohang',
            label: '顶部导航'
          }]
        }]
      }],


      dialogImageUrl: '',
      dialogVisible: false,

      editor: {
        info: ''
      },
      isClear: false,

      tableData: [{
        color: '玫瑰金',
        memory: '16G',
        price: 10000,
        stock: 100
      }]
    };
  },
  components: {
    EditorBar
  },
  methods: {
    handleChange() {

    },
    pre() {
      if (this.step-- < 1) this.step = 0;
    },
    next() {
      if (this.step++ > 2) this.step = 3;
    },
    submit() {

    },
    deleteRow(index, rows) {
      rows.splice(index, 1);
    },
    handleRemove() {

    }
  },
  created () {
    this.ptype = this.$route.query.ptype
    this.spuId = this.$route.query.spuId
    // 0 为修改、1为新增
    if (1 === this.ptype) {
      //
      // this.form = {}
    }
  }
}
</script>

<style scoped>
  body > .el-container {
    margin-bottom: 40px;
  }
  .box-card {
    margin-top: 1%;
    min-height: 800px;
  }
  .box-card {
  }
  .box-card-main {
  }
</style>
