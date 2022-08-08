<template>
	<div id="main">
		<div id="header">
			<Header></Header>
		</div>
		<div class="back">
			<el-row>
				<el-col :span="2">
					<div class="grid-content bg-purple"></div>
				</el-col>
				<el-col :span="20">
					<div class="grid-content bg-purple-light">
						<div id="img">
							<rotation></rotation>
						</div>
						<div id="Pagebody">
							<pageBody></pageBody>
			
						</div>
			
					</div>
				</el-col>
				<el-col :span="2">
					<div class="grid-content bg-purple"></div>
				</el-col>
			</el-row>
		</div>
		
		<div id="bottom">
			<Bottom></Bottom>
		</div>


	</div>
</template>

<script>
	import Header from './head.vue'
	import pageBody from './pageBody.vue'
	import rotation from './rotation.vue'
	import Bottom from './bottom.vue'
	export default {
		name: 'page',
		components: {
			Header,
			pageBody,
			rotation,
			Bottom
		},
		data() {
			return {

			}
		}
	}
</script>

<style>
.back{
	background-color: #f5f5f5;
}

</style>
