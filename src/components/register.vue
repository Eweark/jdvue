<template>
	<div class="build">
		<div id="register">
			<div id="reform">
				<router-view></router-view>
				<h1>注册页面</h1>
				<el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
					<el-form-item label="账号" prop="acc">
						<el-input v-model.number="ruleForm.acc"></el-input>
					</el-form-item>
					<el-form-item label="密码" prop="pass">
						<el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="确认密码" prop="checkPass">
						<el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="真实姓名" prop="trueName">
						<el-input v-model.number="ruleForm.trueName"></el-input>
					</el-form-item>
					<el-form-item label="地址" prop="address">
						<el-input v-model.number="ruleForm.address"></el-input>
					</el-form-item>
					<el-form-item label="头像" prop="headImg">
					<el-upload action="#" list-type="picture-card" :auto-upload="false">
						
						<i slot="default" class="el-icon-plus"></i>
						<div slot="file" slot-scope="{file}">
							<img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
							<span class="el-upload-list__item-actions">
								<span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
									<i class="el-icon-zoom-in"></i>
								</span>
								<span v-if="!disabled" class="el-upload-list__item-delete" @click="handleDownload(file)">
									<i class="el-icon-download"></i>
								</span>
								<span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)">
									<i class="el-icon-delete"></i>
								</span>
							</span>
						</div>
					</el-upload>
					<el-dialog :visible.sync="dialogVisible">
						<img width="100%" :src="dialogImageUrl" alt="">
					</el-dialog>
					</el-form-item>
					<br>
					<div class="b2">
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</div>
				</el-form>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'register',
		data() {
			var checkAge = (rule, value, callback) => {
				if (!value) {
					return callback(new Error('账号不能为空'));
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
			var validatePass2 = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('请再次输入密码'));
				} else if (value !== this.ruleForm.pass) {
					callback(new Error('两次输入密码不一致!'));
				} else {
					callback();
				}
			};
			return {
				ruleForm: {
					pass: '',
					checkPass: '',
					acc: ''
				},
				rules: {
					pass: [{
						validator: validatePass,
						trigger: 'blur'
					}],
					checkPass: [{
						validator: validatePass2,
						trigger: 'blur'
					}],
					acc: [{
						validator: checkAge,
						trigger: 'blur'
					}]
				},
				dialogImageUrl: '',
				        dialogVisible: false,
				        disabled: false
			};
		},
		methods: {
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if (valid) {
						alert('submit!');
					} else {
						console.log('error submit!!');
						return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},
			handleRemove(file) {
				console.log(file);
			},
			handlePictureCardPreview(file) {
				this.dialogImageUrl = file.url;
				this.dialogVisible = true;
			},
			handleDownload(file) {
				console.log(file);
			}
		}
	}
	
</script>

<style>
	.b2{
		margin-left: 150px;
	}
	h1{
		text-align: center;
	}
	#register{
		width: 800px;
		height: 650px;
		margin-left: 25vw;
		margin-top: 50px;
		border: 1px solid #ee9e97;
		/* line-height: 100px; */
		background-color: #1a83b3;
		border-radius: 40px;
	}
	#reform{
		margin-left: 50px;
		width: 600px;
	}
</style>
