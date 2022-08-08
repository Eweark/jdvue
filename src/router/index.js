import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import register from '../components/register.vue'
import Main from '../components/main.vue'
import login from '../components/login.vue'
// import back from '../components/page.vue'
import back from '../components/adminback/backMain.vue'
import hello from '../components/adminback/HelloWorld.vue'
import userList from '../components/adminback/userList.vue'
import roleList from '../components/adminback/roleList.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component: Main
    },
    {path:'/register',component: register},
    {path:'/main',component: Main},
    {path:'/login',component:login},
    {path:'/back',component:back,
    	children:[
    		{path:'/hello/:id',component: hello,props:true},
    		{path:'/userList',component: userList},
    		{path:'/role',component: roleList}
    	]
    }
  ]
})
