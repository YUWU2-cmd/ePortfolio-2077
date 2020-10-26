<template>
    <div class="forget_container">
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
        <div class="forget_box">
            <div class="inner-body">
            <!-- 标题区域 -->
            <div class="title">
                Forget your password?
            </div>
            <div class="subtitle">
                Don't worry!
            </div>
            <div class="description">
                Fill out your email address, and we’ll send you instructions to reset your password. 
            </div>
            <!-- 登录表单区域, 这里使用了vbind的：号，绑定了elform的model属性 -->
            <!-- rules和prop属性都是校验相关的。
             ref是引用属性，下面js部分使用这个的会得到该属性的标签的对象 -->
             <el-form ref="forgetFormRef" :model="forgetForm" :rules="forgetFormRules" label-width="0px" class="forget_form">
                <!-- 用户名 -->
                <span>Email Address</span> 
                <el-form-item prop="emailAdd">
                <el-input class="input" v-model="forgetForm.emailAdd" placeholder="Fill in your Unimelb email" prefix-icon="iconfont icon-email-fill"></el-input>
                </el-form-item>
              </el-form>
                <!-- 按钮区域 -->
                <div class="btn">
                    <button @click="sendEmail" type="submit">Email me some help</button>
                </div>
            
            <div class="note">
                Heads up! You may need to check your spam folder for our email.
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
      forgetForm: {
        emailAdd: ''
      },
      // 这是表单的验证规则对象
      forgetFormRules: {
        emailAdd: [
          { required: true, message: 'Please enter email address', trigger: 'blur' },
          { min: 6, max: 30, message: 'Please enter vaild email address', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 这个是予验证，检查当前内容格式是否符合验证规则
    sendEmail () {
      this.$refs.forgetFormRef.validate(async valid => {
        if (!valid) return
        var temp = {email: this.forgetForm.emailAdd}
        var data = this.$qs.stringify(temp)
        const { status: re } = await this.$http.post('/api/user/send', data, {headers:{'Content-Type':'application/x-www-form-urlencoded' }})
        if (re != 200) return this.$message.error('send code fail！')
        this.$router.push('/verifyForget')
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
.forget_form span{
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
    font-size: 18px;
    line-height: 1.5;
    text-align: center;
    margin: 10px auto;
}

.forget_container {
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

.forget_box{
    position: relative;
    margin: 85px auto;
    width: 512px;
    height: 520px;
    background-color: #fff;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,0.025);
    border: 2px rgb(212, 212, 212, .5) solid;
    border-radius: .25rem;
}

.forget_form {
   margin: 20px 0px 0px 0px;
   height: 220px;
}
.input {
   margin: 20px 0px 0px 0px;
}
/deep/ .el-input__inner{
  height: 70px;
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
