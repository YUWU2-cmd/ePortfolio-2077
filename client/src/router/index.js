import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import register from '../components/register.vue'
import forget from '../components/forget.vue'
import verify from '../components/verify.vue'
import verifyForget from '../components/verifyForget.vue'
import reset from '../components/reset.vue'
import personalDetail from '../components/personalDetail.vue'
import dashboard from '../components/dashboard.vue'
import classic from '../components/classic.vue'
import aboutMe from '../components/aboutMe.vue'
import more from '../components/more.vue'
import projects from '../components/projects.vue'
import contact from '../components/contact.vue'
import gallery from '../components/gallery.vue'
import galleryHome from '../components/galleryHome.vue'
import galleryAbout from '../components/galleryAbout.vue'
import galleryContact from '../components/galleryContact.vue'
import business from '../components/business.vue'
import aboutMeSetting from '../components/aboutMeSetting'
import moreSetting from '../components/moreSetting'
import projectSetting from '../components/projectSetting'
import galleryHomeSetting from '../components/galleryHomeSetting'
import galleryAboutSetting from '../components/galleryAboutSetting'
import businessSetting from '../components/businessSetting'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    // 从根页面直接跳到login子页面
    { path: '/', redirect: '/login' },
    { path: '/login', component: Login },
    { path: '/dashboard', component: dashboard },
    { path: '/business', component: business },
    { path: '/business/:id', component: business },
    { path: '/businessSetting', component: businessSetting },
    { path: '/classic', component: classic, children: [
      { path: '/classic', redirect: '/classic/aboutMe' },
      { path: '/classic/aboutMe',  component: aboutMe},
      { path: '/classic/aboutMeSetting',  component: aboutMeSetting},
      { path: '/classic/moreSetting',  component: moreSetting},
      { path: '/classic/projectSetting',  component: projectSetting},
      { path: '/classic/more',  component: more},
      { path: '/classic/projects',  component: projects},
      { path: '/classic/contact',  component: contact}
    ]},
    { path: '/classic/:id', component: classic, children: [
      { path: '/classic/:id', redirect: '/classic/aboutMe/:id' },
      { path: '/classic/aboutMe/:id',  component: aboutMe},
      { path: '/classic/aboutMeSetting/:id',  component: aboutMeSetting},
      { path: '/classic/moreSetting/:id',  component: moreSetting},
      { path: '/classic/projectSetting/:id',  component: projectSetting},
      { path: '/classic/more/:id',  component: more},
      { path: '/classic/projects/:id',  component: projects},
      { path: '/classic/contact/:id',  component: contact}
    ]},
    
    { path: '/gallery', component: gallery, children: [
      { path: '/gallery', redirect: '/gallery/galleryHome' },
      { path: '/gallery/galleryHome',  component: galleryHome},
      { path: '/gallery/galleryHomeSetting',  component: galleryHomeSetting},
      { path: '/gallery/galleryAbout',  component: galleryAbout},
      { path: '/gallery/galleryAboutSetting',  component: galleryAboutSetting},
      { path: '/gallery/galleryContact',  component: galleryContact}
    ]},
    { path: '/gallery/:id', component: gallery, children: [
      { path: '/gallery/:id', redirect: '/gallery/galleryHome/:id' },
      { path: '/gallery/galleryHome/:id',  component: galleryHome},
      { path: '/gallery/galleryHomeSetting/:id',  component: galleryHomeSetting},
      { path: '/gallery/galleryAbout/:id',  component: galleryAbout},
      { path: '/gallery/galleryAboutSetting/:id',  component: galleryAboutSetting},
      { path: '/gallery/galleryContact/:id',  component: galleryContact}
    ]},
    { path: '/register', component: register },
    { path: '/forget', component: forget },
    { path: '/verify', component: verify },
    { path: '/verifyForget', component: verifyForget },
    { path: '/reset', component: reset },
    { path: '/personalDetail', component: personalDetail }
  ]
})

//router guard
router.beforeEach((to, from, next) => {

  //make sure nobody can access reset password page without the verify
  if (to.path !== '/reset'){
    if(window.localStorage.getItem("isVerified") != null){
      window.localStorage.removeItem("isVerified")
    }
    return next()
  } 
  if (to.path === '/reset' && window.localStorage.getItem("isVerified")) {
    return next()
  }
 else{return next('/login')}
})

export default router