import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
import VueVideoPlayer from 'vue-video-player'
import 'video.js/dist/video-js.css'
axios.defaults.baseURL="http://localhost:8888"
//绑定到vue的原型，方便全局引用
Vue.prototype.$axios = axios;
Vue.use(VueVideoPlayer)
Vue.use(ElementUI);
Vue.config.productionTip = false
axios.interceptors.request.use(
  config => {
  // 判断是否存在token，如果存在的话，则每个http header都加上token
    let token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJXZWQgQXVnIDA0IDE1OjU4OjAwIEdNVCswODowMCAyMDIxIiwic3ViIjoidXNlciIsImlzcyI6InVzZXIiLCJpYXQiOjE2MjgwNjM4ODAsImV4cCI6MTYyODA2NzQ4MH0.gv_cr26maV8oC_q4-fsyIOctAep4Gaf4x7MZkliiBKw"
    if (!config.headers.hasOwnProperty('token') && token) {
      config.headers.Authorization = token;
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  });
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
