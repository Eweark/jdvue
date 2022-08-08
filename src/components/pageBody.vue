<template>
	<!-- 	<el-table :data="commodityData"> -->
	<div id="pageBody">
		<el-row :gutter="20">
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<div class="img">
						<img src="../assets/commodity/a.png" width="300px" height="180px" />
					</div>
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<div class="img">
						<img src="../assets/commodity/b.png" width="300px" height="180px" />
					</div>
				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<div class="img">
						<img src="../assets/commodity/c.png" width="300px" height="180px">
					</div>

				</div>
			</el-col>
			<el-col :span="6">
				<div class="grid-content bg-purple">
					<div class="img">
						<img src="../assets/commodity/b.png" width="300px" height="180px" />
					</div>
				</div>
			</el-col>
		</el-row>
		<img src="../assets/img/im.png" width="1270px" />
		<div id="com">
			<h2>手机</h2>
			<el-row>
				<el-col :span="4">
					<div class="grid-content bg-purple">
						<img src="../assets/commodity/u.png" height="580px" />
					</div>
				</el-col>
				<el-col :span="20" style="margin-top: -15px;">
					<div class="grid-content bg-purple-light">
						<ul>
							<el-row>
								<el-col :span="5" v-for="comm in commodityData" :key="comm.id"
									style="margin-left: 20px;margin-top: 10px;">
									<el-card :body-style="{ padding: '0px' }" shadow="hover">
										<img :src="comm.img" class="image">
										<div style="padding: 14px;">
											<span>{{comm.sname}}</span><br />
											<span style="color: #ff6700;">{{comm.sprice}}</span>
										</div>
									</el-card>
								</el-col>
							</el-row>

						</ul>
					</div>
				</el-col>
			</el-row>




		</div>

	</div>
	<!-- 	</el-table> -->
</template>

<script>
	export default {
		name: 'pageBody',
		data() {
			return {
				// id:'',
				// //商品名
				// sname:'',
				// //商品价格
				// sprice:'',
				commodityData: [
					// {id,url :require('../assets/commodity/xiaomi12.png')},
					// {id,url :require('../assets/commodity/xiaomi12s.png')},
					// {id,url :require('../assets/commodity/xiaomi12su.png')},
					// {id,url :require('../assets/commodity/1.png')},
					// {id,url :require('../assets/commodity/note11t.png')},
					// {id,url :require('../assets/commodity/note11pt.png')},
					// {id,url :require('../assets/commodity/red.png')},
					//    {id,url :require('../assets/commodity/civi9.png')}
				],



			}
		},
		mounted(){
			this.getselectdata();
		},

		methods: {
			getselectdata() {
				this.$axios.get('/goods/selAllGoods', {
					//传参
					params: {

					}
				}).then(response => {
					console.log(response.data.list);
					// alert(response.data.list);
					if (response.data != null) {
						// 接收后台发来的map集合table是表数据，total是总数
						
						// this.commodityData = response.data.list
						const list = response.data.list
						console.log(list)
						var abc = []
						for (var i = 0; i < list.length; i++) {
							
							const a = {
								id:list[i].id,
								img :require('../assets/commodity/xiaomi12.png'),
								sname:list[i].snane,
								sprice:list[i].sprice
								// url :require(list[i].img)
								
							}
							abc.push(a)
						}
						this.commodityData = abc
					}
				}).catch(err => {
					alert(err)
				})
			}
		}
	}
</script>

<style>
	.img {
		margin-left: ;
	}

	.el-row {
		margin-bottom: 20px;

		&:last-child {
			margin-bottom: 0;
		}
	}

	/* {
		background-color: #f5f5f5;
	} */

	.el-col {
		border-radius: 4px;
	}

	.bg-purple-dark {
		/* background: #99a9bf; */
	}

	.bg-purple {
		/* background: #d3dce6; */
	}

	.bg-purple-light {
		/* background: #e5e9f2; */
	}

	.grid-content {
		border-radius: 4px;
		min-height: 36px;
	}

	.row-bg {
		padding: 10px 0;
		/* background-color: #f9fafc; */
	}

	.time {
		font-size: 13px;
		color: #999;
	}

	.bottom {
		margin-top: 13px;
		line-height: 12px;
	}

	.button {
		padding: 0;
		float: right;
	}

	.image {
		width: 100%;
		display: block;
	}

	.clearfix:before,
	.clearfix:after {
		display: table;
		content: "";
	}

	.clearfix:after {
		clear: both
	}
</style>
