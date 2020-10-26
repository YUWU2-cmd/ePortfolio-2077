<template>
    <div class="verify_container">
      <div class="all">
        <div class="topbar-wrapper">
            <div class="topbar">
                     <img class="logo" src="../assets/logo1.png">
                     </img>
                    <div class="title">
                        ePortfolio 2077
                    </div>
            </div>
        </div>
        <div class="verify_box">
            <div class="inner-body">
            <!-- 标题区域 -->
            <div class="title">
                verify your email
            </div>
            <div class="subtitle">
                Before go to reset the password
            </div>
            <div class="description">
                Fill out your email address and verify code from sended email. You'll access to reset your password. 
            </div>
            <!-- 登录表单区域, 这里使用了vbind的：号，绑定了elform的model属性 -->
            <!-- rules和prop属性都是校验相关的。
             ref是引用属性，下面js部分使用这个的会得到该属性的标签的对象 -->
             <el-form ref="verifyFormRef" :model="verifyForm" :rules="verifyFormRules" label-width="0px" class="verify_form">
                <!-- 用户名 -->
                <span>Email Address</span> 
                <el-form-item prop="email">
                <el-input class="input" v-model="verifyForm.email" placeholder="Fill in your Unimelb email" prefix-icon="iconfont icon-email-fill"></el-input>
                </el-form-item>
                 
                <span>Verify Code</span> 
                <el-form-item prop="code">
                <el-input class="input" v-model="verifyForm.code" placeholder="Fill in your verifyCode"></el-input>
                </el-form-item>
                <!-- 按钮区域 -->
                
            </el-form>
            <div class="btn">
                    <button @click="verify" type="submit">Verify</button>
                </div>
        </div>
        </div>

        </div>
      </div>
</template>

<script>
export default {
  data () {
    return {
      verifyForm: {
        email: '',
        code: ''
      },
      // 这是表单的验证规则对象
      verifyFormRules: {
        email: [
          { required: true, message: 'Please enter email address', trigger: 'blur' },
          { min: 6, max: 40, message: 'Please enter vaild email address', trigger: 'blur' }
        ],
        code: [
          { required: true, message: 'Please enter verifyCode', trigger: 'blur' },
          { min: 1, max: 15, message: 'Please enter vaild verifyCode', trigger: 'blur' }
        ]
      }
    }
  },
  
  methods: {
    // 这个是予验证，检查当前内容格式是否符合验证规则
    verify () {
      this.$refs.verifyFormRef.validate(async valid => {
        if (!valid) return
        var data = this.$qs.stringify(this.verifyForm)
        const { status: res } = await this.$http.post('/api/user/verify', data, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
        if (res != 200) return this.$message.error('fail verify！')
        this.$message.success('verify success')
        // 1. 将登录成功之后的 token，保存到客户端的 sessionStorage 中
        //   1.1 项目中出了登录之外的其他API接口，必须在登录之后才能访问
        //   1.2 token 只应在当前网站打开期间生效，所以将 token 保存在 sessionStorage 中
        // 2. 通过编程式导航跳转到后台主页，路由地址是 /home
        this.$router.push('/reset')
      })
    }
  }
}
</script>

<style lang="less" scoped>
.topbar .logo{
    float: left;
    width: 42px;
    height: 42px;
    background-size: 42px 42px;
}
.verify_form span{
    font-size: 20px;
    font-weight: bold;
    height: 20px;
    line-height: 20px;
    box-sizing: border-box;
    padding: 5px 0px;
    color: #515a62;
    transform: translate(0%, -10%);
}
.inner-body{
    width: 444px;
    height: 460px;
    margin: 30px auto;
    display: flex;
    flex-direction: column;
}
.inner-body .title{
    font-size: 35px;
    font-weight: bold;
    color: rgb(65, 65, 65);
    height: 40px;
    line-height: 40px;
    margin: 0 25px;
    text-align: center;
}
.inner-body .subtitle{
    height: 25px;
    color: #1864ab;
    font-weight: bold;
    font-size: 20px;
    line-height: 25px;
    margin: 10px auto;
}
.inner-body .description{
    height: 60px;
    color: #495057;
    font-size: 16px;
    line-height: 1.5;
    text-align: center;
    margin: 10px auto;
}

.verify_container {
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

.verify_box{
    position: relative;
    margin: 85px auto;
    width: 512px;
    height: 600px;
    background-color: #fff;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,0.025);
    border: 2px rgb(212, 212, 212, .5) solid;
    border-radius: .25rem;
}

.verify_form {
   margin: 20px 0px 0px 0px;
   height: 220px;
}
.input {
   margin: 20px 0px 0px 0px;
}
/deep/ .el-input__inner{
  height: 70px;
}
.btn {
    margin-top: 50px;
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
    transform: translate(0%, 10%);
}
.btn button:hover{
    background-color: #2280d1;
}
.btn button:active{
    border-top-width: calc(.2rem + .0625rem);
    border-bottom-width: .0625rem;
}
.inner-body .note{
    height: 60px;
    color: #495057;
    font-size: 12px;
    text-align: center;
    margin: 30px auto;
}
</style>
