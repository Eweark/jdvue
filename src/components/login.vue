<template>
  <div class="build">
    <div id="login">
      <div id="loginForm">
        <h1 style="margin-left: 50px;">登录</h1>
        <el-form v-model="myform" status-icon ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="账号" prop="acc">
            <el-input v-model="myform.uname"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input type="password" v-model="myform.password" autocomplete="off"></el-input>
          </el-form-item>
          <div class="b1">
            <el-form-item>
              <el-button type="primary" @click="onSubmit">提交</el-button>
              <el-button>
                <router-link to="/register" active-class="action">去注册</router-link>
              </el-button>
              <router-link to="/main">首页</router-link>
              <router-link to="/back">后台</router-link>
              <!-- <router-view></router-view> -->
            </el-form-item>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        setTimeout(() => {
          callback();
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      return {
        myform: {
          uname: 'admin',
          password: '123'
        }
      };
    },
    methods: {
      onSubmit: function() {
         // this.$axios.post('userManage/loginM',{
         //   params:{
         //      acc:this.$data.myform.uname,
         //      pwd:this.$data.myform.password
         //    }
         // }).then(function(responce){
         //   console.log(responce)
         // })
        this.$axios({
          url: 'userManage/loginM',
          method: 'post',
          headers: {
            "Content-Type": "multipart/form-data"
          },
          data: {
            acc: this.$data.myform.uname,
            pwd: this.$data.myform.password
          } //传值
        }).then(res => {
          if(res.data == '1'){
            this.$message({
            	          message: '登录成功!',
            	          type: 'success'
            	        });
            	this.$router.push('/back')
          }else{
             this.$message.error('登录失败！请检查账号或密码');
          }
          console.log('数据接收');
          console.log(res.data);
        });



        // if(this.$data.myform.uname == 'admin' && this.$data.myform.password == '123'){
        // 	// alert('登录成功！')
        // 	this.$message({
        // 	          message: '登录成功!',
        // 	          type: 'success'
        // 	        });
        // 	// this.$router.push('/main')

        // 	this.$router.replace('/main')
        // 	//push :跳到某一个路径下
        // 	//重定向：replace

        // }else{
        // 	alert('登录失败！')
        // }
        // console.log(this.$data.myform.uname)

      }


      // submitForm(formName) {
      // 	this.$refs[formName].validate((valid) => {
      // 		if (valid) {
      // 			alert('登陆了!');
      // 		} else {
      // 			console.log('error submit!!');
      // 			return false;
      // 		}
      // 	});
      // },
      // resetForm(formName) {
      // 	// this.$refs[formName].resetFields();
      // }
    }
  }
</script>

<style>
  .b1 {
    margin-left: 67px;
  }

  #login {
    width: 500px;
    height: 400px;
    margin-left: 32vw;
    margin-top: 20vh;
    border: 1px solid #ee9e97;
    line-height: 100px;
    background-color: #1a83b3;
    border-radius: 40px;

  }

  #loginForm {
    width: 450px;
  }
</style>
