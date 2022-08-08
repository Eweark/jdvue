<template>
  <div id="userList">
    <h1>用户列表</h1>

    <el-button @click="addUser(-1)">添加</el-button>
    <el-table
      :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase())).slice((currentPage-1)*pageSize,currentPage*pageSize)"
      style="width: 100%" :row-class-name="tableRowClassName">
      <el-table-column label="编号" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.staffId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账号" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.acc }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名" width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>编号: {{ scope.row.staffId }}</p>
            <p>账号: {{ scope.row.acc}}</p>
            <p>姓名: {{ scope.row.name }}</p>
            <p>住址: {{ scope.row.address }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
      </el-table-column>
    </el-table>


    <div class="">
      <el-pagination background layout="prev, pager, next,sizes,jumper" :total="total" :page-size="pageSize"
        :page-sizes="[2, 3, 4, 5]" :current-page="currentPage" @current-change="currentChange"
        @size-change="rowsChange">
      </el-pagination>
    </div>



    <!-- <el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button> -->

    <el-dialog :title="title" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="编号" :label-width="formLabelWidth">
          <el-input v-model="form.staffId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="账号" :label-width="formLabelWidth">
          <el-input v-model="form.acc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addPage()">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        pages: [2, 3, 4, 5],
        pageSize: 5,
        currentPage: 1,
        tableData: [],
        search: '',
        total: 10,
        dialogTableVisible: false,
        dialogFormVisible: false,
        title: '修改',
        formInline: {
          user: '',
          region: ''
        },
        form: {
          name: '',
          address: '',
          acc: '',
          staffId: '',
          userList: [],
          delivery: false,
          type: [],
          resource: '',
          desc: '',
          flag: '',
          totle: ''
        },
        formLabelWidth: '120px'
      }
    },
    methods: {
      rowsChange(val) {
        this.$data.pageSize = val
      },
      tableRowClassName({
        row,
        rowIndex
      }) {
        if (rowIndex % 2 == 0) {
          return 'warning-row';
        } else {
          return '';
        }
        return '';
      },
      handleEdit(index, row) {
        this.$data.title = "修改用户"
        this.dialogFormVisible = true
        this.form.name = row.name
        this.form.address = row.address
        this.form.staffId = row.staffId
        this.form.acc = row.acc
        this.$data.form.flag = index
        console.log(index, row);
      },
      handleDelete(index, row) {
        this.$axios({
          url: '/user/delUser',
          method: 'post',
          headers: {
            "Content-Type": "multipart/form-data"
          },
          data: {
            id: row.staffId
          } //传值
        }).then(res => {
          if (res.data == '1') {
            this.$message({
              message: '删除成功!',
              type: 'success'
            });
            this.selAllUser()
          } else {
            this.$message.error('删除失败');
          }
          console.log('数据接收');
          console.log(res.data);
        });

      },
      currentChange(val) {
        console.log(val)
        this.$data.currentPage = val
      },
      addUser(val) {
        this.$data.title = "添加用户"
        this.dialogFormVisible = true
        this.$data.form.staffId = "",
          this.$data.form.acc = ""
        this.$data.form.name = ""
        this.$data.form.address = ""
        this.$data.form.flag = val

      },
      selAllUser() {
        var slef = this;

        slef.$axios.post('/user/userList', {
            contentType: "application/x-www-form-urlencoded; charset=utf-8"
          }, {
            responseType: "utf-8"
          })
          .then(response => {
            console.log('数据接收');
            console.log(response.data.staffList);
            console.log(response.data.record);
            slef.total = response.data.record;
            slef.tableData = response.data.staffList;
          })

        // this.$axios.post('/user/userList')
        //   .then(response => {
        //     console.log(response.data)
        //     // self.tableData = response.data.staffList
        //     var list = response.data.staffList;

        //     // self.tableData=JSON.stringify(list)
        //     self.tableData=list
        //     // this.$data.tableData = response.data.staffList
        //     slef.total = response.data.record
        //     console.log(JSON.stringify(list) + "--------455")
        //   })
        //   console.log(this.$data.tableData.length + "--------4848")


      },

      addPage() {
        if (this.$data.form.flag == '-1') {

          const da = {
            acc: this.$data.form.acc,
            name: this.$data.form.name,
            address: this.$data.form.address
          }

          // this.$axios({
          //   url: '/user/insUser',
          //   method: 'post',
          //   headers: {
          //     "Content-Type": "multipart/form-data"
          //   },
          //   data: {
          //     this.$qs.stringify(da)
          //     // acc: this.$data.form.acc,
          //     // name: this.$data.form.name,
          //     // address: this.$data.form.address
          //   } //传值
          // }).then(res => {
          //   if (res.data == '1') {
          //     this.$message({
          //       message: '添加成功!',
          //       type: 'success'
          //     });
          //     this.selAllUser()
          //   } else {
          //     this.$message.error('添加失败');
          //   }
          //   console.log('数据接收');
          //   console.log(res.data);
          // });

          // this.$data.tableData.push(da)
          // this.$message({
          //   type: 'success',
          //   message: '添加成功!'
          // });

          this.$axios.post('/user/insUser',this.$qs.stringify(da)).then(res => {
            if (res.data == '1') {
              this.$message({
                message: '添加成功!',
                type: 'success'
              });
              this.selAllUser()
            } else {
              this.$message.error('添加失败');
            }
            console.log('数据接收');
            console.log(res.data);
          });
          this.dialogFormVisible = false
          // console.log(this.$data.form.name)
        } else {

          const da = {
            staffId:this.$data.form.staffId,
            acc: this.$data.form.acc,
            name: this.$data.form.name,
            address: this.$data.form.address
          }
          // this.$axios({
          //   url: '/user/updUser',
          //   method: 'post',
          //   headers: {
          //     "Content-Type": "multipart/form-data"
          //   },
          //   data: {
          //     staffId: this.$data.form.staffId,
          //     acc: this.$data.form.acc,
          //     name: this.$data.form.name,
          //     address: this.$data.form.address
          //   } //传值
          // }).then(res => {
          //   if (res.data == '1') {
          //     this.$message({
          //       message: '修改成功!',
          //       type: 'success'
          //     });
          //     this.selAllUser()
          //   } else {
          //     this.$message.error('修改失败');
          //   }
          // });
          // vm.set(this.$data.tableData,this.$data.form.flag,da)
          // this.$data.tableData.splice(this.$data.form.flag, 1, da)
          // this.$message({
          //   type: 'success',
          //   message: '修改成功!'
          // });

          this.$axios.post('/user/updUser',this.$qs.stringify(da)).then(res => {
            if (res.data == '1') {
              this.$message({
                message: '修改成功!',
                type: 'success'
              });
              this.selAllUser()
            } else {
              this.$message.error('修改失败!');
            }
            console.log('数据接收');
            console.log(res.data);
          });

          this.dialogFormVisible = false
        }

      }

    },

    mounted: function() {
      this.selAllUser()
    },
    watch: {
      search: {
        handler() {
          console.log("-----")
          this.$data.currentPage = 1
          this.$data.total = this.$data.tableData.filter(data => !this.$data.search || data.name.toLowerCase().includes(
            this.$data.search.toLowerCase())).length
          // this.$data.total =  = this.$data.tableData.length
          console.log(this.$data.total)
        }


      }
    },

  }
</script>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }

  .page {
    margin-left: 250px;
  }
</style>
