import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import register from '../components/register.vue'
import forget from '../components/forget.vue'
import verify from '../components/verify.vue'
import personalDetail from '../components/personalDetail.vue'
import dashboard from '../components/dashboard.vue'
import classic from '../components/ClassicTemplates/classic.vue'
import aboutMe from '../components/ClassicTemplates/aboutMe.vue'
import more from '../components/ClassicTemplates/more.vue'
import projects from '../components/ClassicTemplates/projects.vue'
import contact from '../components/ClassicTemplates/contact.vue'
import aboutMeSetting from '../components/ClassicTemplates/aboutMeSetting'
import gallery from '../components/GalleryTemplates/gallery.vue'
import galleryHome from '../components/GalleryTemplates/galleryHome.vue'
import galleryAbout from '../components/GalleryTemplates/galleryAbout.vue'
import galleryContact from '../components/GalleryTemplates/galleryContact.vue'
import business from '../components/BusinessTemplates/business.vue'


Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    // 从根页面直接跳到login子页面
    { path: '/', redirect: '/login' },
    { path: '/login', component: Login },
    { path: '/dashboard', component: dashboard },
    { path: '/business', component: business },
    { path: '/classic', component: classic, children: [
      { path: '/classic', redirect: '/classic/aboutMe' },
      { path: '/classic/aboutMe',  component: aboutMe},
      { path: '/classic/aboutMeSetting',  component: aboutMeSetting},
      { path: '/classic/more',  component: more},
      { path: '/classic/projects',  component: projects},
      { path: '/classic/contact',  component: contact}
    ]},
    { path: '/gallery', component: gallery, children: [
      { path: '/gallery', redirect: '/gallery/galleryHome' },
      { path: '/gallery/galleryHome',  component: galleryHome},
      { path: '/gallery/galleryAbout',  component: galleryAbout},
      { path: '/gallery/galleryContact',  component: galleryContact}
    ]},
    { path: '/register', component: register },
    { path: '/forget', component: forget },
    { path: '/verify', component: verify },
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