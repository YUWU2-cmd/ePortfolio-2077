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
            <!-- logo -->
            <div class="avatar_box">
                <img src="../assets/logo1.png" alt="">
            </div>
            <div class="title">
                Login
            </div>
             <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="0px" class="login_form">
                <!-- email address -->
                <span>Email Address</span> 
                <el-form-item prop="email">
                <el-input v-model="loginForm.email" placeholder="Fill in your email" prefix-icon="iconfont icon-email1"></el-input>
                </el-form-item>
                <!-- password -->
                <span>Password</span> 
                <el-form-item prop="password">
                <el-input v-model="loginForm.password" @keydown.enter.native="login" placeholder="Fill in your password"  prefix-icon="iconfont icon-password" type="password"></el-input>
                </el-form-item>
                
            </el-form>
            <div class="forget">
                        <el-button type="text" @click="goFind">Forget your password?</el-button>
                </div>
                <!-- button -->
                <div class="btn">
                    <button @click="login" type="submit">Login</button>
                </div>
        </div>
          <div class="footer">
            <span>Don't have an account? <el-button type="text" @click="goRegister">Create one here!</el-button></span>
        </div>
        </div>
      </div>
</template>

<script>
export default {
  data () {
    return {
      loginForm: {
        email: '',
        password: ''
      },
      // prevalidate rules
      loginFormRules: {
        // validate the input is legal or not
        email: [
          { required: true, message: 'Please enter email', trigger: 'blur' },
          { min: 3, max: 40, message: 'email need 3 ~ 40 characters', trigger: 'blur' }
        ],
        password: [
          { required: true, message: 'Please enter password', trigger: 'blur' },
          { min: 6, max: 15, message: 'Password need 6 ~ 15 characters', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    goRegister () {
      this.$router.push('/register')
    },
    goFind () {
      this.$router.push('/forget')
    },
    
    // prevalidate first. If the input follow the prevalidate rules, the method will send request
    login () {
      this.$refs.loginFormRef.validate(async valid => {
        if (!valid) return
        const { status: res } = await this.$http.post('/api/user/login', this.loginForm)
        if (res != 200) return this.$message.error('login fail！')
        this.$message.success('login success!')
        //route to dashboard        
        this.$router.push('/dashboard')
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
      background-color: rgb(255, 255, 255);
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
  width: 100%;
  padding: 0 20px;
  margin-top: 37%;
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
    padding: 0 20px;
    margin: 20px 0;
    font-size: 14px;
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
