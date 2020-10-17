<template>
    <div class="register_container">
      <div class="all">
        <div class="topbar-wrapper">
            <div class="topbar">
                    <div class="title">
                        ePortfolio 2077
                    </div>
            </div>
        </div>
        <div class="register_box">
            <!-- 头像区域 -->
            <div class="avatar_box">
                <img src="../assets/logo1.png" alt="">
            </div>
            <div class="title">
                Register
            </div>
            <!-- 登录表单区域, 这里使用了vbind的：号，绑定了elform的model属性 -->
            <!-- rules和prop属性都是校验相关的。
             ref是引用属性，下面js部分使用这个的会得到该属性的标签的对象 -->
             <el-form ref="registerFormRef" :model="registerForm" :rules="registerFormRules" label-width="0px" class="register_form">
                <!-- 用户名 -->
                <span>Email Address</span> 
                <el-form-item prop="email">
                <el-input v-model="registerForm.email" placeholder="Fill in your Unimelb email" prefix-icon="iconfont icon-email1"></el-input>
                </el-form-item>
                <span>Username</span> 
                <el-form-item prop="username">
                <el-input v-model="registerForm.username" placeholder="Fill in your username" prefix-icon="iconfont icon-bussiness-man-fill"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <span>Password</span> 
                <el-form-item prop="password">
                <el-input v-model="registerForm.password" placeholder="Fill in your password" prefix-icon="iconfont icon-password" type="password"></el-input>
                </el-form-item>
            </el-form>
            <!-- 按钮区域 -->
                <div class="btn">
                    <button @click="register" type="submit">Register</button>
                </div>
        </div>
        <div class="footer">
            <el-button type="text" @click="goLogin">go back login Page</el-button>
        </div>
        </div>
      </div>
</template>

<script>
export default {
  data () {
    return {
      registerForm: {
        username: '',
        password: '',
        email : ''
      },
      // 这是表单的验证规则对象
      registerFormRules: {
        // 验证用户名是否合法，trigger是触发方法，blur是表示键入标离开就触发
        username: [
          { required: true, message: 'Please enter username', trigger: 'blur' },
          { min: 3, max: 20, message: 'Please enter vaild username', trigger: 'blur' }
        ],
        // 验证密码是否合法
        password: [
          { required: true, message: 'Please enter password', trigger: 'blur' },
          { min: 6, max: 15, message: 'Password need 6 ~ 15 characters', trigger: 'blur' }
        ],
        email: [
          { required: true, message: 'Please enter email address', trigger: 'blur' },
          { min: 6, max: 40, message: 'Please enter vaild email address', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    goLogin () {
      this.$router.replace('/login')
    },
    // 这个是予验证，检查当前内容格式是否符合验证规则
    register () {
      this.$refs.registerFormRef.validate(async valid => {
        if (!valid) return
        const { status: res } = await this.$http.post('/api/user/signup', this.registerForm)
        if (res != 200) return this.$message.error('sign up fail！')
        this.$message.success('sign up success')
        var temp = {email: this.registerForm.email}
        var data = this.$qs.stringify(temp)
        const { status: re } = await this.$http.post('/api/user/send', data, {headers:{'Content-Type':'application/x-www-form-urlencoded' }})
        if (re != 200) return this.$message.error('send code fail！')
        this.$router.push('/verify')
        // 1. 将登录成功之后的 token，保存到客户端的 sessionStorage 中
        //   1.1 项目中出了登录之外的其他API接口，必须在登录之后才能访问
        //   1.2 token 只应在当前网站打开期间生效，所以将 token 保存在 sessionStorage 中
        // 2. 通过编程式导航跳转到后台主页，路由地址是 /home
        
      })
    }
  }
}
</script>

<style lang="less" scoped>
.register_container {
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

.register_box{
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

.register_box .title{
    position: absolute;
    font-size: 35px;
    font-weight: bold;
    color: rgb(65, 65, 65);
    height: 40px;
    line-height: 40px;
    padding: 40px 155px;
    top: 10%;
}
.register_form span{
    font-size: 20px;
    font-weight: bold;
    height: 20px;
    line-height: 20px;
    box-sizing: border-box;
    padding: 20px 0;
    color: #515a62;
    top:1;
}
.register_form {
  width: 100%;
  height: 1;
  padding: 0 20px;
  margin-top: 35%; 
  box-sizing: border-box;
}
/deep/ .el-input__inner{
  height: 50px;
}
.btn{
  margin: 0 3%;
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
