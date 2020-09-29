import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import home from '../components/home.vue'
import register from '../components/register.vue'
import forget from '../components/forget.vue'
import homeSetting from '../components/homeSetting.vue'
import personalDetail from '../components/personalDetail.vue'
import moreAboutMe from '../components/moreAboutMe.vue'
import homeDetail from '../components/homeDetail.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    // 从根页面直接跳到login子页面
    { path: '/', redirect: '/login' },
    { path: '/login', component: Login },
    { path: '/home', component: home, children: [
      { path: '/home', redirect: '/home/homeDetail' },
      { path: '/home/homeDetail',  component: homeDetail},
      { path: '/home/moreAboutMe', component: moreAboutMe},
      { path: '/home/homeSetting',  component: homeSetting}
    ]},
    { path: '/register', component: register },
    { path: '/homeSetting', component: homeSetting },
    { path: '/forget', component: forget },
    { path: '/personalDetail', component: personalDetail }
  ]
})

/*router.beforeEach((to, from, next) => {
  // to 将要访问的路径
  // from 代表从哪个路径跳转而来
  // next 是一个函数，表示放行
  //     next()  放行    next('/login')  强制跳转

  if (to.path === '/login'||to.path === '/register'||to.path === '/forget') return next()
  // 获取token
  const tokenStr = window.sessionStorage.getItem('token')
  if (!tokenStr) return next('/login')
  next()
})*/

export default router