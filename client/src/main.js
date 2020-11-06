import Vue from 'vue'
import App from './App.vue'
import router from './router/index.js'
// import icon
import './assets/fonts/iconfont.css'
// import global css
import './assets/css/global.css'


// config element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './plugins/element.js'

import axios from 'axios'
import Qs from 'qs'
// request root path
axios.defaults.baseURL = '/'
axios.interceptors.request.use(config => {
  config.headers.Authorization = window.sessionStorage.getItem('token')
  return config
})

Vue.prototype.$http = axios
Vue.prototype.$qs = Qs


Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
