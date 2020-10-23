<template>
        <div class="body-wrapper" id="aboutme-body">
            <div class="left-body"><i class="iconfont icon-setting" style="margin-left:240%; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i></div>
            
            <div class="content-wrapper">
                <div class="banner">
                    <div class="main">
                        <div class="profile">
                            <img :src="profilePic" alt=""/>
                        </div>
                        <div class="title">{{username}}</div>
                        <div class="deco-line"></div>
                        <div class="subtitle">{{aboutMeForm.bio}}</div> 
                    </div>
                    <div class="footer">
                        <div class="content">
                            <a href="https://www.facebook.com/" target="_blank"><i class="iconfont icon-facebook1"></i></a>
                            <a href="https://twitter.com/" target="_blank"><i class="iconfont icon-twitter"></i></a>
                            <a href="https://www.instagram.com" target="_blank"><i class="iconfont icon-instagram"></i></a>
                            <a href="https://www.linkedin.com/" target="_blank"><i class="iconfont icon-linkedin last-icon"></i></a>
                        </div>
                    </div>
                </div>
                <div class="bio">
                    <div class="title">Hello</div>
                    <div class="subtitle">Here's who I am & what I do</div>
                    <p class="content">
                        {{aboutMeForm.aboutme}}
                    </p>
                </div> 
                
            </div>
        </div>
</template>

<script>
export default {
    data(){
        return {
            aboutMeForm: {
                bio:'',
                aboutme:'',
                siteId:''
            },
            profilePic: '',
            username: ''
        }
    },
    created() {
            this.getAboutData()
            this.getUserData()
    },
    methods:{
        handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
         goSetting(){
            this.$router.push('/classic/aboutMeSetting')
        },
        async getUserData() {
            const { data: re } = await this.$http.get('/api/user/logged')
            if (re.message != "Success!") return this.$message.error('get logged fail！')
            this.profilePic = re.obj.profilePic
            this.username = re.obj.username
        },
        async getAboutData() {
            this.aboutMeForm.siteId = window.localStorage.getItem("nowSiteId")
            var tem = {siteId: this.aboutMeForm.siteId}
            var data1 = this.$qs.stringify(tem)
            console.log(data1)
            const { data: r } = await this.$http.post('/api/dashboard/fetch',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('get about fail！')
            this.aboutMeForm.aboutme = r.obj.aboutMe
            this.aboutMeForm.bio = r.obj.bio
        }
    }
}

</script>

<style lang="less" scoped>

#aboutme-body{
    position: relative;
    width: 100%;
    height: 800px;
    background-color: #fff;
    display: block;
}
#aboutme-body .left-body{
    height: 100%;
    width: 39%;
    background-color: #e6dace;
}
#aboutme-body .content-wrapper{
    position: absolute;
    width: 100%;
    height: 520px;
    box-sizing: border-box;
    padding-left:25%;
    top: 10%;
    left: 0;
    border: 0px solid #fff;
}
#aboutme-body .banner{
    float: left;
    width: 375px;
    height: 520px;
    background-color: #f4ece6;
    box-shadow: -11px 11px 17px 0px rgba(138,131,124,0.23);
}
#aboutme-body .bio{
    float: left;
    margin-left: 35px;
    width: 369px;
    height: 100%;
    background-color: white;
    

}
.bio .title{
    font-size: 100px;
    font-weight: bold;
    height: 150px;
    line-height: 150px;
}
.bio .subtitle{
    font-size: 25px;
    height: 30px;
    line-height: 30px;
    margin-bottom: 15px;
}
.bio .content{
    font-size: 17px;
    line-height: 1.5em;
    color: #000000a6;
}
.banner .main{
    height: 467px;
    width: 100%;
}
.banner .footer{
    box-sizing: border-box;
    padding: 14px 110.5px;
    height: 53px;
    width: 100%;
    background-color: #fff;
}
.footer .content{
    width: 154px;
    height: 25px;
}
.footer .content a{
    text-decoration: none;
    color: #000000;
}

.footer .content a i{
    font-size: 25px;
    margin-right: 12px;
}
.last-icon{
    margin-right: 0!important;
}

.banner .main .profile{
    width: 100%;
    height: 250px;
    overflow: hidden;
}
.banner .main .profile img{
    width: 205px;
    height: 205px;
    border-radius: 100%;
    margin: 22.5px 85px;
    background-size: 205px 205px;
}
.banner .main .title{
    margin: 0 auto;
    height: 100px;
    font-size: 27px;
    font-weight: bold;
    line-height: 120px;
    text-align: center;
}
.deco-line{
    height: 30px;
    width: 70px;
    border-top: 2px solid rgba(0, 80, 255, 1);
    margin: 0 auto;
}
.banner .main .subtitle{
    font-size: 17px;
    line-height: 1.2em;
    text-align: center;
    letter-spacing: 0.25em;
    color: #000000b9;
}

</style>