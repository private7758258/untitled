import Vue from 'vue'
import VueRouter from 'vue-router'
import UserIndex from '../views/UserIndex.vue'
import UserLogin from '../views/UserLogin'
import MainIndex from '../views/MainIndex'
import Register from '../views/Register'
import WebSocket from '../views/WebSocket'
import MagicBox from '../views/MagicBox'
import LogRecord from '../views/LogRecord'
Vue.use(VueRouter)

const routes = [
  //用户首页展示
  {
    path: '/',
    name: 'UserIndex',
    component: UserIndex
  },
  //登录进来的主页面
  {
    path: '/userIndex',
    name: 'UserIndex',
    component: UserIndex
  },
  //用户登录界面
  {
    path: '/userLogin',
    name: 'UserLogin',
    component: UserLogin
  },
  //左导航栏  
  {
    path:'/mainIndex',
    name:'MainIndex',
    component:MainIndex,
    children:[
          //用户聊天界面
          {
            path:"/webSocket",
            name:'WebSocket',
            component:WebSocket
          },
          //百宝箱
          {
            path:"/magicBox",
            name:"MagicBox",
            component:MagicBox,
          },
          //日志记录
          {
            path:"/logRecord",
            name:"LogRecord",
            component:LogRecord
          }
    ]
  },
  //用户注册
  {
    path:'/register',
    name:'Register',
    component:Register
  },
  {
    path: '/',
    name: 'App',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/MainIndex.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
