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
            <!-- title -->
            <div class="title">
                Change your password
            </div>
            <div class="subtitle">
                Last step of resetting the password
            </div>
            <div class="description">
                Fill out your email address and new password. You'll reset your password. 
            </div>
             <el-form ref="resetFormRef" :model="resetForm" :rules="resetFormRules" label-width="0px" class="verify_form">
                <!-- email address -->
                <span>Email Address</span> <br/>
                <div style="margin: 30px 0px 10px 0px">{{resetForm.email}}</div><br/>
                <!-- new password -->
                <span>New Password</span> 
                <el-form-item prop="password">
                <el-input class="input" v-model="resetForm.password" placeholder="Fill in your Password" prefix-icon="iconfont icon-password"></el-input>
                </el-form-item>
                <!-- button -->
                
            </el-form>
                <div class="btn">
                    <button @click="verify" type="submit">Reset</button>
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
      resetForm: {
        email: '',
        password: ''
      },
       // prevalidate rules
      resetFormRules: {
        // validate the input is legal or not
        password: [
          { required: true, message: 'Please enter password', trigger: 'blur' },
          { min: 6, max: 15, message: 'Password need 6 ~ 15 characters', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
        this.getEmail()
  },
  methods: {
    //get email which was entered in the previous page
    getEmail(){
      this.resetForm.email = window.localStorage.getItem("email")
    },
    // prevalidate first. If the input follow the prevalidate rules, the method will send request
    verify () {
      this.$refs.resetFormRef.validate(async valid => {
        if (!valid) return
        var data = this.$qs.stringify(this.resetForm)
        const { status: res } = await this.$http.post('/api/user/change/password', data, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
        if (res != 200) return this.$message.error('reset fail！')
        this.$message.success('reset success')

        //after reset, go to the login in page
        this.$router.push('/Login')
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
