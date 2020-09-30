import Vue from 'vue'
import App from './App.vue'
import router from './router/index.js'
// 导入字体图标
import './assets/fonts/iconfont.css'
// 导入全局样式表
import './assets/css/global.css'


// 手动配置 element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './plugins/element.js'

import axios from 'axios'
import Qs from 'qs'

// 配置请求的跟路径
axios.defaults.baseURL = '/api'
axios.defaults.withCredentials = true


Vue.prototype.$http = axios
Vue.prototype.$qs = Qs

Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
