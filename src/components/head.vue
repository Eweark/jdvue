<template>
	<div id="header">
		<div id="hl">
			<el-row>
				<el-col :span="24">
					<div class="grid-content bg-purple-dark">
						<div class="btn">
							<el-button type="primary">
								<router-link to="/login">登录</router-link>
							</el-button>
							<el-button type="info">
								<router-link to="/register">注册</router-link>
							</el-button>
						</div>
					</div>
				</el-col>
			</el-row>
		</div>
		<el-row>
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<img src="../assets/img/hh.gif" width="80px" height="80px"
						style="margin-left: 200px; margin-top: -20px;" />
				</div>
			</el-col>
			<el-col :span="10">
				<div class="grid-content bg-purple-light">
					<ul class="bb">
						<li><a href="#">首页</a></li>
						<li><a href="#">手机</a></li>
						<li><a href="#">耳机</a></li>
						<li><a href="#">家电</a></li>
						<li><a href="#">拍卖</a></li>
						<li><a href="#">会员</a></li>
						<li><a href="#">路由器</a></li>
						<li><a href="#">服务中心</a></li>
					</ul>
				</div>
			</el-col>
			<el-col :span="4">
				<div class="grid-content bg-purple">
					<div class="seach">
						<el-input placeholder="请输入搜索内容" v-model="search">
							<el-button slot="append" icon="el-icon-search" ></el-button>
						</el-input>
					</div>
				</div>
			</el-col>
		</el-row>
	</div>

</template>

<script>
	export default {
		name: 'Header',
		data() {
			return {
				search:'',
			}
		}
	}
</script>

<style>
	#hl {
		background-color: #333;
	}

	.bb>li {
		float: left;
		width: 70px;
		list-style: none;

	}

	.bb>li>a {
		color: black;
		text-decoration: none;
	}

	.bb>li>a:hover {
		color: red;
	}

	.btn {
		margin-left: 1200px;
	}

	.seach{
		margin-top: 10px;
	}

	.el-row {
		margin-bottom: 20px;

		&:last-child {
			margin-bottom: 0;
		}
	}

	.el-col {
		border-radius: 4px;
	}


	.grid-content {
		border-radius: 4px;
		min-height: 36px;
	}

	.row-bg {
		padding: 10px 0;
	}
</style>
