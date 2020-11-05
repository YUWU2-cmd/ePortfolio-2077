<template>
    <div class="personal-detail-container">
        <div class="topbar-wrapper">
            <div class="topbar">
            
            <div class="topbar-main">
                <div class="title" style="cursor: pointer" @click="goDashboard">
                    ePortfolio 2077
                </div>
            </div>

        <el-dropdown placement="bottom-start" class="topbar-side">
                    <span class="el-dropdown-link">
                      <div class="user-avatar">
                        <img :src="profilePic" alt=""/>
                        <!-- display user avatar which can be uploaded -->
                      </div>
                    </span>
                    <el-dropdown-menu  slot="dropdown" class="dropdown-menu">
                      <el-dropdown-item><router-link to="/personalDetail">Personal details</router-link></el-dropdown-item>
                      <el-dropdown-item><router-link to="/dashboard">go dashboard</router-link></el-dropdown-item>
                      <el-dropdown-item><router-link to="/login">Logout</router-link></el-dropdown-item>
                    </el-dropdown-menu>
        </el-dropdown>
        </div>
    </div>
    <div class="body-wrapper">
        <h1>Personal Detail</h1>
        <div class="subtitle">View and update your account details, profile and more.</div>
        <div class="basic-info">
            <div class="title">Basic Info</div>
            <div class="content">
                <div class="info">
                    <div class="acc">
                        <span class="text">First Name</span>
                        <span class="acc-input"><el-input v-model="detailForm.firstName" placeholder="Enter your first name" maxlength="30" suffix-icon="el-icon-user-solid"></el-input></span>
                    </div>
                    <div class="acc">
                        <span class="text">Last Name</span>
                        <span class="acc-input"><el-input v-model="detailForm.lastName" placeholder="Enter your last name" maxlength="30" suffix-icon="el-icon-user"></el-input></span>
                    </div>
                    <div class="acc">
                        <span class="text">Email</span>
                        <span class="acc-input">{{resetForm.email}}</span>
                    </div>
                </div>
                <div class="profile-img">
                    <el-upload
                    style="margin-top: 15px;height: 180px"
                        action="/api/user/change/profile"
                        list-type="picture-card"
                        :on-success="handleSuccess"
                        :show-file-list="false">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <div>Profile Image</div>
                </div>
            </div>
        </div>
        <div class="more-info">
            <div class="title">More Info</div>
            <div class="content">
                    <div class="acc">
                        <span class="text">Phone Number</span>
                        <span class="acc-input"><el-input v-model="detailForm.phoneNumber" placeholder="Enter your phone number" maxlength="20" suffix-icon="el-icon-phone"></el-input></span>
                    </div>
                    <div class="acc">
                        <span class="text">Password</span>
                        <span class="acc-input"><el-input v-model="resetForm.password" placeholder="Enter your new Password" minlength="6" maxlength="15" show-password suffix-icon="el-icon-lock"></el-input></span>
                        <span class="btn"><el-button type="primary" plain round @click="resetPassword">Edit Password</el-button></span>
                    </div>
            </div>
        </div>
        <div class="socialmedia-info">
            <div class="title">Social Media</div>
            <div class="content">
                    <div class="acc">
                        <span class="iconfont icon-linkedin"></span>
                        <span class="text">Linkedin</span>
                        <span class="acc-input"><el-input v-model="detailForm.linkedinLink" placeholder="Enter your Linkedin address" suffix-icon="el-icon-location-outline"></el-input></span>
                    </div>
                    <div class="acc">
                        <span class="iconfont icon-facebook1"></span>
                        <span class="text">Facebook</span>
                        <span class="acc-input"><el-input v-model="detailForm.facebookLink" placeholder="Enter your Facebook address" suffix-icon="el-icon-location-outline"></el-input></span>
                    </div>
                    <div class="acc">
                        <span class="iconfont icon-twitter"></span>
                        <span class="text">Twitter</span>
                        <span class="acc-input"><el-input v-model="detailForm.twitterLink" placeholder="Enter your Twitter address" suffix-icon="el-icon-location-outline"></el-input></span>
                    </div>
                    <div class="acc">
                        <span class="iconfont icon-instagram"></span>
                        <span class="text">Instagram</span>
                        <span class="acc-input"><el-input v-model="detailForm.instagramLink" placeholder="Enter your Instagram address" suffix-icon="el-icon-location-outline"></el-input></span>
                    </div>
            </div>
        </div>
        <el-button type="primary" style="margin-left: 40%; margin-top: 80px" plain @click="uploadDetail">upload</el-button>
    </div>
        

    </div>
    
</template>

<script>
export default {
    data(){
        return {
            resetForm: {
                email: '',
                password: ''
            },                        
            username: '',
            profilePic: '',
            detailForm: {
                firstName: "",
                lastName: "",
                phoneNumber: '',
                linkedinLink: "",
                facebookLink: "",
                twitterLink: "",
                instagramLink: "",
                userId: 3
            }
            

        }
    },
    created() {
        this.getUserData()
    },
     methods: {

      handleSuccess(response, file, fileList) {
            this.$message.success('upload profile image success！')
        },
        goDashboard() {
            this.$router.push('/dashboard')
        },
        async uploadDetail(){
            const { data: re } = await this.$http.post('/api/user/update/details',this.detailForm)
            if (re.message != "Success!") return this.$message.error('upload detail fail！')
            this.$message.success('upload detail success！')
        },
      async getUserData() {
            const { data: res } = await this.$http.get('/api/user/logged')
            if (res.message != "Success!") return this.$message.error('get logged fail！')
            this.profilePic = res.obj.profilePic
            this.username = res.obj.username
            this.detailForm.firstName = res.obj.firstName
            this.detailForm.lastName = res.obj.lastName
            this.detailForm.phoneNumber = res.obj.phoneNumber
            this.detailForm.linkedinLink = res.obj.linkedinLink
            this.detailForm.facebookLink = res.obj.facebookLink
            this.detailForm.twitterLink = res.obj.twitterLink
            this.detailForm.instagramLink = res.obj.instagramLink
            this.detailForm.userId = res.obj.userId
            this.resetForm.email = res.obj.email
        },
        async resetPassword(){
            var data = this.$qs.stringify(this.resetForm)
            const { status: r } = await this.$http.post('/api/user/change/password', data, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r != 200) return this.$message.error('reset fail！')
            this.$message.success('reset success')
        }
    }
    
}
</script>

<style lang="less" scoped>
    .personal-detail-container{
        height: 1600px;
        background-color: #f0f4f7;
        font-family: fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
    }
    .el-dropdown-link {
        cursor: pointer;
        color: #409EFF;

    }
    .topbar-wrapper{
        position: relative;
        height: 90px;
        background-color: #fff;
        box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,.025);
        z-index: 99;
    }
    .topbar .topbar-main{
        position: absolute;
        height: 60px;
        left: 50%;
        top: 13px;
        text-decoration: none;
        transform: translate(-50%,0);
        
    }
    .topbar .logo{
        float: left;
        width: 42px;
        height: 42px;
        border: 1px  #eee;
        border-radius: 50%;
        padding: 10px;
        box-shadow: 0 0 1px gray;
        img {
        width: 100%;
        height: 100%;
        }
        
    }
    .topbar .title{
        float: left;
        top: 10px;
        margin: 10px 20px;
        color: rgb(65, 65, 65);
        line-height: 42px;
        font-size: 25px;
        font-weight: bold;
        
    }
    .topbar .title:hover{
        color: #3899ec;
    }
    .topbar .user-avatar{
        text-decoration: none;
        background-size: 38px 38px;
        width: 38px;
        height: 38px;
        border-radius: 100%;

        border: 2px solid rgba(0,0,0,.1);
        img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
        }
    }
    .topbar .block{
        position: absolute;
        height: 50px;
        width: 38px;
        left: 95%;
        top: 23px;

    }
    .topbar-side{
    position: absolute;
        left: 95%;
        transform: translate(-50%,0);
        top:28px;
    }
    .topbar-side .dropdown-menu{
        display: none;
        box-sizing: border-box;
        width: 170px;
        height: 140px;
        border: 1px rgba(212, 212, 212, .6) solid;
        border-radius: .2em;
        background-color: #fff;
    }
    .dropdown-menu a{
        display: block;
        height: 50px;
        width: 169px;
        text-decoration: none;
        color: rgb(65, 65, 65);
        text-align: center;
        line-height: 50px;
    }
    html,body{
        min-width: 1100px;
    }
    .body-wrapper{
        width: 1100px;
        height: 1510px;
        margin: 0 auto;
        box-sizing: border-box;
        overflow: hidden;
    }
    .body-wrapper h1{
        font-size: 36px;
        line-height: 48px;
        height: 48px;
        color: #162D3D;
    }
    .body-wrapper .subtitle{
        font-size: 16px;
        line-height: 24px;
        color: #32536A;
        font-weight: 400;
    }
    .body-wrapper .basic-info{
        width: 100%;
        height: 338px;
        background-color: #fff;
        border-radius: 8px;
        box-sizing: border-box;
        margin-top: 20px;
    }
    .body-wrapper .more-info{
        width: 100%;
        height: 230px;
        background-color: #fff;
        border-radius: 8px;
        box-sizing: border-box;
        margin-top: 40px;
    }
    .body-wrapper .socialmedia-info{
        width: 100%;
        height: 450px;
        background-color: #fff;
        border-radius: 8px;
        box-sizing: border-box;
        margin-top: 40px;
    }
    .basic-info .title{
        width: 100%;
        height: 77px;
        padding: 27px 30px 26px;
        box-sizing: border-box;
        font-size: 20px;
        line-height: 24px;
        font-weight: 400;
        color: #162D3D;
        border-bottom: 1px solid #ddebf6;
    }
    .more-info .title{
        width: 100%;
        height: 50px;
        padding: 15px 25px;
        box-sizing: border-box;
        font-size: 20px;
        line-height: 24px;
        font-weight: 400;
        color: #162D3D;
        border-bottom: 1px solid #ddebf6;
    }
    .socialmedia-info .title{
        width: 100%;
        height: 77px;
        padding: 27px 30px 26px;
        box-sizing: border-box;
        font-size: 20px;
        line-height: 24px;
        font-weight: 400;
        color: #162D3D;
        border-bottom: 1px solid #ddebf6;
    }
    .basic-info .content{
        width: 100%;
        height: 260px;
    }
    .more-info .content{
        box-sizing: border-box;
        padding: 30px;
        width: 100%;
        height: 180px;
    }
    .socialmedia-info .content{
        box-sizing: border-box;
        padding: 30px;
        width: 100%;
        height: 373px;
    }
    .basic-info .content .info{
        float: left;
        width: 80%;
        height: 100%;
        box-sizing: border-box;
        padding: 30px;
    }
    .basic-info .content .profile-img{
        float: left;
        width: 20%;
        height: 100%;
        overflow: hidden;
        text-align: center;
    }
    .basic-info .content .profile-img div{
        font-size: 16px;
        line-height: 24px;
        height: 24px;
        color: #32536A;
    }
    .basic-info .content .profile-img img{
        width: 150px;
        height: 150px;
        border-radius: 50%;
        margin: 35px 20px;
        margin-bottom: 0;
    }
    .basic-info .content .info .acc{
        height: 33%;
        width: 100%;
        font-size: 16px;
        line-height: 24px;
        color: #32536A;
    }
    .basic-info .content .info .acc .text{
        display: inline-block;
        width: 30%;
        height: 100%;
    }
    .basic-info .content .info .acc .acc-input{
        display: inline-block;
        width: 70%;
        height: 100%;
    }
    .more-info .content .acc{
        height: 50%;
        width: 100%;
        font-size: 16px;
        line-height: 24px;
        color: #32536A;
    }
    .more-info .content .acc .text{
        display: inline-block;
        width: 30%;
        height: 100%;
    }
    .more-info .content .acc .acc-input{
        display: inline-block;
        width: 40%;
        height: 100%;
    }
    .more-info .content .acc .btn{
        display: inline-block;
        width: 10%;
        height: 100%;
        margin-left: 15%;
    }
    .socialmedia-info .content .acc{
        height: 25%;
        width: 100%;
        font-size: 16px;
        line-height: 24px;
        color: #32536A;
        overflow: hidden;
    }
    .socialmedia-info .content .acc .iconfont{
        margin-left: 40px;
        display: inline-block;
        font-size: 40px;
        height: 40px;
        line-height: 40px;
    }
    .socialmedia-info .content .acc .text{
        display: inline-block;
        width: 30%;
        height: 40px;
        margin-left: 20px;
    }
    .socialmedia-info .content .acc .acc-input{
        display: inline-block;
        width: 40%;
        height: 100%;
        margin-left: 20px;
    }

</style>
