<template>
  <div>
    <mBreadcrumb />
    <!-- 查询面板 -->
    <el-row>
      <el-card class="box-card"  v-show="!showdetail">
        <el-form style="display: flex; " ref="searchdata" :model="searchdata" label-width="100px">
          <el-form-item label="商品货号：">
            <el-input v-model="searchdata.name" style="width: 100%"></el-input>
          </el-form-item>
          <el-form-item label="商品状态：">
            <el-select v-model="searchdata.region" placeholder="请选择商品状态">
              <el-option label="已上架" value="shanghai"></el-option>
              <el-option label="已下架" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="商品分类：">
            <el-select v-model="searchdata.region" placeholder="请选择商品分类">
              <el-option label="手机" value="shanghai"></el-option>
              <el-option label="服饰" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="商品品牌：">
            <el-select v-model="searchdata.region" placeholder="请选择商品品牌">
              <el-option label="小米" value="shanghai"></el-option>
              <el-option label="华为" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="">立即查询</el-button>
            <el-button icon="el-icon-magic-stick">重置</el-button>
            <el-button type="success" icon="el-icon-plus" @click="">添加新商品</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-row>

    <el-row>
      <!-- 商品列表面板 -->
      <el-card class="box-card-main" v-show="!showdetail">
        <el-table
          :data="tableDataList"
          border
          style="width: 100%">
          <el-table-column
            prop="spuId"
            label="编号"
            width="180">
          </el-table-column>
          <el-table-column
            prop="spuTitle"
            label="商品标题"
            width="180">
          </el-table-column>
          <el-table-column
            label="商品图片">
            <template slot-scope="scope">
              <img :src="scope.row.image" alt="" style="width: 100px;height:150px">
            </template>
          </el-table-column>
          <el-table-column
            prop="price"
            label="价格">
          </el-table-column>
          <el-table-column
            prop="status"
            label="商品状态">
            <template slot-scope="scope">
              <div v-if="1 === scope.row.saleable"> <el-button type="success">已上架</el-button></div>
              <div v-else-if="0 === scope.row.saleable"> <el-button type="info">已下架</el-button></div>
              <div v-else-if="2 === scope.row.saleable"> <el-button type="warning">在审核</el-button></div>
            </template>
          </el-table-column>
          <el-table-column
            prop="letter"
            label="库存管理">
            <template slot-scope="scope">
              <el-button type="primary" icon="el-icon-edit" circle></el-button>
            </template>
          </el-table-column>
          <el-table-column
            prop="createTime"
            label="添加时间">
          </el-table-column>
          <el-table-column
            prop="updateTime"
            label="修改时间">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" icon="el-icon-edit-outline" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :page-sizes="[10, 20, 50]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
          </el-pagination>
        </div>
      </el-card>
    </el-row>

    <!-- 明细面板 -->
    <el-row>
      <el-card class="box-card" v-show="showdetail">
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
            <el-card >
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
                <el-table :data="tableDataDetail">
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
            <el-card >
              <el-upload
                action="https://jsonplaceholder.typicode.com/posts/"
                list-type="picture-card"
                :on-preview="handlePictureCardPreview"
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

    </el-row>
  </div>
</template>

<script>
  import {getAllGoods as getAllSpus} from '@/api/spu';
  import EditorBar from '@/components/WangEditor/index'

  export default {
  name: "goods",
  data() {
    return {
      showdetail:false,
      total: 0,
      currentPage: 1,
      pageNum: 1,
      pageSize: 10,
      tableDataList: [],
      searchdata:{},

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
      editor: {
        info: ''
      },
      isClear: false,

      tableDataDetail: [{
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
    pre() {
      if (this.step-- < 1) this.step = 0;
    },
    next() {
      if (this.step++ > 2) this.step = 3;
    },
    submit() {

    },
    handleEdit() {
      this.showdetail = !this.showdetail
    },
    deleteRow(index, rows) {
      rows.splice(index, 1);
    },
    handleSizeChange(size) {
      this.pageSize = size
      this.handlePageChange()
    },
    handleCurrentChange(currentPage) {
      this.pageNum = currentPage
      this.handlePageChange()
    },
    handlePageChange: function () {
      // 分页查询SPU
      getAllSpus({
        pageSize: this.pageSize,
        pageNum: this.pageNum
      }).then(response => {
        console.log(response.records)
        this.total = response.total
        this.tableDataList = response.records
      });
    }
  },
  mounted () {
    this.handlePageChange()
  }
}
</script>

<style scoped>
  body > .el-container {
    margin-bottom: 40px;
  }

  .box-card {
    margin-top: 5px;
  }

  .box-card-main {
  }
</style>
