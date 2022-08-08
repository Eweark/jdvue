// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import axios from 'axios'
//引用qs
import qs from 'qs'     
Vue.prototype.$qs = qs

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$axios = axios //定义全局
axios.defaults.baseURL = '/api'
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
