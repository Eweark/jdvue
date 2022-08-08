<template>
  <div id="roleList">
    <h1>角色列表</h1>
    <el-button @click="addRole()">添加</el-button>
    <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
      style="width: 100%">

      <el-table-column label="角色编号" prop="roleId">
      </el-table-column>
      <el-table-column label="角色名称" prop="roleName">
      </el-table-column>
      <el-table-column label="角色描述" prop="roleDesc">
      </el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          <el-button size="mini" type="primary" @click="handlePower(scope.$index, scope.row)">授权</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="page">
      <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize" :page-sizes="pages"
        :current-page="currentPage" @current-change="currentChange">
      </el-pagination>
    </div>
    <el-dialog :title="title" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <input type="hidden" id="" value="" />
        <el-form-item label="角色名称" :label-width="formLabelWidth">
          <el-input v-model="form.roleName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色描述" :label-width="formLabelWidth">
          <el-input v-model="form.roleDesc" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addOrUpd()">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="授权" :visible.sync="dialogpower">
      <tree-transfer :to_data="toData" :from_data="powerDate" :defaultProps="{label:'label'}" @addBtn='add'
        @removeBtn='remove' :mode='mode' height='540px' filter openAll></tree-transfer>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogpower = false">取 消</el-button>
        <el-button type="primary" @click="">保存</el-button>
      </div>
    </el-dialog>

  </div>

</template>

<script>
  import treeTransfer from 'el-tree-transfer' // 引入
  export default {
    data() {
      return {
        mode: "transfer",
        pages: [2, 3, 4, 5],
        pageSize: 5,
        currentPage: 1,
        tableData: [],
        powerDate: [{
          key: 1,
          label: '超级管理员',
          desc: '无敌'
        }, {
          key: 2,
          label: '房源发布员',
          desc: '发布房子的'
        }, {
          key: 3,
          label: '资格审核员',
          desc: '审核资格的'
        }, {
          key: 4,
          label: '系统管理员',
          desc: '关小黑屋的'
        }],
        search: '',
        total: 12,
        dialogTableVisible: false,
        dialogFormVisible: false,
        dialogpower: false,
        title: '修改',
        form: {
          roleId: -1,
          roleName: '',
          address: '',
          flag: '',
          delivery: false,
          type: [],
          resource: '',
          roleDesc: '',
          flag: ''
        },
        formLabelWidth: '120px',
        toData: []
      }
    },
    methods: {
      selRole(curr, size) {
        this.$axios.post('/role/roleList', this.$qs.stringify({
          pageCurr: curr,
          pageSize: size
        })).then(res => {
          console.log(res.data)
          this.$data.tableData = res.data.roleList
          this.$data.total = res.data.recordCount
        })
      },
      handleEdit(index, row) {
        this.$data.form.flag = 1
        this.dialogFormVisible = true
        this.$data.form.roleId = row.roleId
        this.$data.form.roleName = row.roleName
        this.$data.form.roleDesc = row.roleDesc
        // const f = this.$data.form
        // const res = await saveSubject(f)
        console.log(JSON.stringify(this.$data.form) + "-----")
        console.log(index, row);
      },
      handlePower(index, row) {
        this.$data.form.roleId = row.roleId
        this.$axios.post('/role/allPower', this.$qs.stringify({
          roleId: row.roleId
        })).then(res => {
          var list = res.data.powerList
          var has = res.data.rolePower
          var power = []
          for (var i = 0; i < list.length; i++) {
            if (list[i].parentId == '-1') {
              const p = {
                id: list[i].powerId,
                pid: list[i].parentId,
                label: list[i].powerName,
                children: this.selChild(list[i].powerId, list)
              }
              power.push(p)
            }
          }
          var has = res.data.rolePower
          var val = []
          for (var i = 0; i < has.length; i++) {
            if (has[i].parentId == '-1') {
              const da = {
                id: has[i].powerId,
                pid: has[i].parentId,
                label: has[i].powerName,
                children: this.selChild(has[i].powerId, has)
              }
              val.push(da)
            }
          }
          console.log(JSON.stringify(power.concat(val)) + "-----ooo")
          console.log(JSON.stringify(power) + "power")
          console.log(JSON.stringify(val) + "val")
          this.$data.powerDate = power
          this.$data.toData = val
          console.log(this.$data.value)

        })

        this.dialogpower = true
        console.log(index, row);
      },
      selChild(pid, list) {
        var child = []
        for (var i = 0; i < list.length; i++) {
          if (list[i].parentId == pid) {
            const ch = {
              id: list[i].powerId,
              pid: list[i].parentId,
              label: list[i].powerName
            }
            child.push(ch)
          }
        }
        return child;
      },
      addRole() {
        this.$data.form.flag = -1
        this.$data.form.roleId = -1
        this.$data.form.roleName = ""
        this.$data.form.roleDesc = ""
        this.dialogFormVisible = true
        console.log(JSON.stringify(this.$data.form) + "-----")

      },
      handleDelete(index, row) {
        console.log(index, row);
        this.$confirm('此操作将删除该角色, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.post('/role/delRole', this.$qs.stringify({
            roleId: row.roleId
          })).then(res => {
            console.log(res)
            if (res.data == 1) {
              this.$message({
                message: '删除成功!',
                type: 'success'
              });
              this.selRole(this.$data.currentPage, this.$data.pageSize);
            } else {
              this.$message.error('删除失败');
            }
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        })

      },
      currentChange(val) {
        console.log(val)
        this.$data.currentPage = val
        this.selRole(val, this.$data.pageSize)
      },
      addOrUpd() {
        var url = ''
        var msg = ''
        if (this.$data.form.flag == '-1') {
          url = '/role/addRole'
          msg = '添加'
        } else {
          url = '/role/updRole'
          msg = '修改'
        }
        this.$axios.post(url, this.$qs.stringify(this.$data.form)).then(req => {
          if (req.data == 1) {
            this.$message({
              message: msg + '成功!',
              type: 'success'
            });
            this.selRole(this.$data.currentPage, this.$data.pageSize);
            this.dialogFormVisible = false
          } else {
            this.$message.error(msg + '失败!');
          }
        })
      },
      // 切换模式 现有树形穿梭框模式transfer 和通讯录模式addressList
      changeMode() {
        if (this.mode == "transfer") {
          this.mode = "addressList";
        } else {
          this.mode = "transfer";
        }
      },
      // 监听穿梭框组件添加
      add(fromData, toData, obj) {
        // 树形穿梭框模式transfer时，返回参数为左侧树移动后数据、右侧树移动后数据、移动的        {keys,nodes,halfKeys,halfNodes}对象
        // 通讯录模式addressList时，返回参数为右侧收件人列表、右侧抄送人列表、右侧密送人列表
        console.log("fromData:", fromData);
        console.log("toData:", toData);
        console.log("obj:", obj);
        this.obj = toData

      },
      // 监听穿梭框组件移除
      remove(fromData, toData, obj) {
        // 树形穿梭框模式transfer时，返回参数为左侧树移动后数据、右侧树移动后数据、移动的{keys,nodes,halfKeys,halfNodes}对象
        // 通讯录模式addressList时，返回参数为右侧收件人列表、右侧抄送人列表、右侧密送人列表
        console.log("fromData:", fromData);
        console.log("toData:", toData);
        console.log("obj:", obj);
        this.obj = toData
      }

    },
    components: {
      treeTransfer
    },
    mounted: function() {
      this.selRole(1, this.$data.pageSize)
    }

  }
</script>

<style>
</style>
