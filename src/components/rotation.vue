<template>
	<div id="rotation">
		<el-row>
		  <el-col :span="4"><div class="grid-content bg-purple">
		  <ul class="b_nav">
		      <li class="bnavli"><a href="#">手机 电话卡</a></li>
		      <li class="bnavli"><a href="#">电视 盒子</a></li>
		      <li class="bnavli"><a href="#">笔记本 平板</a></li>
		      <li class="bnavli"><a href="#">出行 穿戴</a></li>
		      <li class="bnavli"><a href="#">智能 路由器</a></li>
		      <li class="bnavli"><a href="#">健康 儿童</a></li>
		      <li class="bnavli"><a href="#">耳机 音响</a></li>
		      <li class="bnavli"><a href="#">智能 路由器</a></li>
		      <li class="bnavli"><a href="#">健康 儿童</a></li>
		      <li class="bnavli"><a href="#">耳机 音响</a></li>
		  </ul>
		  </div>
		  </el-col>
		  <el-col :span="20"><div class="grid-content bg-purple-light">
		  <el-carousel :interval="5000" arrow="always" height="400px">
		      <el-carousel-item v-for="ca in carouseData" :key="ca.id">
		        <img :src="ca.url" style="width: 100%;height: 400px;"/>
		      </el-carousel-item>
		    </el-carousel>
		  </div></el-col>
		</el-row>
		
	</div>
</template>

<script>
	export default {
		name: 'rotation',
		data() {
			return {
				carouseData: [
					{id:'1',url :require('../assets/img/001.png')},
					{id:'2',url :require('../assets/img/002.png')},
					{id:'3',url :require('../assets/img/003.png')},
					{id:'4',url :require('../assets/img/004.png')},
				]
			}
		}
	}
</script>

<style>
	  .b_nav{
		  background-color: rgba(105,101,101,.6);
		  margin-top: 0px;
		  height: 400px;
		  padding: 0px;
	  }
	  .bnavli{
		  height: 38px;
		  list-style: none;
		  border-bottom: 1px solid black;
		  line-height: 38px;
		  text-align: center;
		  
	  }
	  .bnavli>a{
		  color: #fff;
		  text-decoration:none;
	  }
	  .b_nav>li:hover{
		  background-color: #ff6700;
	  }
</style>
