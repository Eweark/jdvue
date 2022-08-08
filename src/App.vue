<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  body{
    margin:0;
    padding:0;
    border:0
  }
  .build {
  	background-image: url(./assets/back.jpg);
  	background-size: cover;
  	background-repeat: no-repeat;
  	width: 100%;
  	height: 100%;
  	position: fixed;
  	background-size: 100% 100%;
  }

</style>
