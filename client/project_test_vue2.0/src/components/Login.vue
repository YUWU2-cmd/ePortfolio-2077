<template>
    <div class="login_container">
      <div class="all">
        <div class="topbar-wrapper">
            <div class="topbar">
                    <div class="title">
                        ePortfolio 2077
                    </div>
            </div>
        </div>
        <div class="login_box">
            <!-- 头像区域 -->
            <div class="avatar_box">
                <img src="../assets/logo1.png" alt="">
            </div>
            <div class="title">
                Login
            </div>
            <!-- 登录表单区域, 这里使用了vbind的：号，绑定了elform的model属性 -->
            <!-- rules和prop属性都是校验相关的。
             ref是引用属性，下面js部分使用这个的会得到该属性的标签的对象 -->
             <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="0px" class="login_form">
                <!-- 用户名 -->
                <span>Username</span> 
                <el-form-item prop="username">
                <el-input v-model="loginForm.username" placeholder="Fill in your username" prefix-icon="iconfont icon-bussiness-man-fill"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <span>Password</span> 
                <el-form-item prop="password">
                <el-input v-model="loginForm.password" placeholder="Fill in your password" prefix-icon="iconfont icon-password" type="password"></el-input>
                </el-form-item>
                <div class="forget">
                        <router-link to="/forget">Forget your password?</router-link>
                </div>
                <!-- 按钮区域 -->
                <div class="btn">
                    <button @click="login" type="submit">Login</button>
                </div>
            </el-form>
        </div>
          <div class="footer">
            <span>Don't have an account? <router-link to="/register">Create one here!</router-link></span>
        </div>
        </div>
      </div>
</template>

<script>
export default {
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      // 这是表单的验证规则对象
      loginFormRules: {
        // 验证用户名是否合法，trigger是触发方法，blur是表示键入标离开就触发
        username: [
          { required: true, message: 'Please enter username', trigger: 'blur' },
          { min: 3, max: 20, message: 'Username need 3 ~ 20 characters', trigger: 'blur' }
        ],
        // 验证密码是否合法
        password: [
          { required: true, message: 'Please enter password', trigger: 'blur' },
          { min: 6, max: 15, message: 'Password need 6 ~ 15 characters', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 这个是予验证，检查当前内容格式是否符合验证规则
    login () {
      this.$refs.loginFormRef.validate(async valid => {
        if (!valid) return
        const { data: res } = await this.$http.post('login', this.loginForm)
        if (res.meta.status !== 200) return this.$message.error('login fail！')
        this.$message.success('login success!')
        // 1. 将登录成功之后的 token，保存到客户端的 sessionStorage 中
        //   1.1 项目中出了登录之外的其他API接口，必须在登录之后才能访问
        //   1.2 token 只应在当前网站打开期间生效，所以将 token 保存在 sessionStorage 中
        window.sessionStorage.setItem('token', res.data.token)
        // 2. 通过编程式导航跳转到后台主页，路由地址是 /home
        this.$router.push('/home')
      })
    }
  }
}
</script>

<style lang="less" scoped>
.login_container {
    background-color: #f0f4f7;
    font-family: fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
    height: 100%;
}
.all{
  height: 90%
}
.topbar{
    position: absolute;
    height: 42px;
    left: 50%;
    top: 24px;
    text-decoration: none;
     transform: translate(-50%,0);
}
.topbar-wrapper{
    position: relative;
    height: 90px;
    background-color: #fff;
}
.topbar .title{
    float: left;
    margin: 0 20px;
    color: rgb(65, 65, 65);
    line-height: 42px;
    font-size: 28px;
    font-weight: bold;
    
}
.topbar .title:hover{
    color: #3899ec;
}

.login_box{
    position: relative;
    margin: 85px auto;
    width: 440px;
    height: 530px;
    background-color: #fff;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,0.025);
    border: 2px rgb(212, 212, 212, .5) solid;
    border-radius: .25rem;
    top: 10%;


     .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px gray;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }
}

.login_box .title{
    position: absolute;
    font-size: 35px;
    font-weight: bold;
    color: rgb(65, 65, 65);
    height: 40px;
    line-height: 40px;
    padding: 40px 170px;
    top: 10%;
}
.login_form span{
    font-size: 20px;
    font-weight: bold;
    height: 20px;
    line-height: 20px;
    box-sizing: border-box;
    padding: 20px 0;
    color: #515a62;
    top:1;
}
.login_form {
  position: absolute;
  bottom: 10%;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}
/deep/ .el-input__inner{
  height: 60px;
}
.forget{
    display: block;
    text-decoration: none;
    color: #228be6;
    width: 185px;
    height: 18px;
    line-height: 18px;
    margin: 20px 0;
    font-size: 14px;
}
.btn button{
    width: 100%;
    height: 76px;
    color: rgb(235, 238, 238);
    font-size: 17px;
    font-weight: 600;
    background-color: #228be6;
    border-radius: .25rem;
    border: solid rgba(0,0,0,0.2) 1px;
    box-shadow: inset 0 1px 0 rgba(255,255,255,0.0125),0 1px 1px rgba(0,0,0,0.05);
    top: 70%;
}
.btn button:hover{
    background-color: #2280d1;
}
.btn button:active{
    border-top-width: calc(.2rem + .0625rem);
    border-bottom-width: .0625rem;
}
 .footer{
   position: relative;
    width: 350px;
    height: 50px;
    bottom: 0;
    left: 50%;
    top: 5%;
    transform: translate(-50%, -50%);
    text-align: center;
    font-size: 15px;
    color: #495057;
}


</style>
