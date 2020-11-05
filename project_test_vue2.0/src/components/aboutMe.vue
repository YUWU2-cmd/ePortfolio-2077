<template>
        <div class="body-wrapper" id="aboutme-body">
            <div class="left-body"><i v-show="!isViewerMode" class="iconfont icon-setting" style="margin-left:240%; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i></div>
            
            <div class="content-wrapper">
                <div class="banner">
                    <div class="main">
                        <div class="profile">
                            <img :src="profilePic" alt=""/>
                        </div>
                        <div class="title">{{firstName}} {{lastName}}</div>
                        <div class="deco-line"></div>
                        <div class="subtitle">{{aboutMeForm.bio}}</div> 
                    </div>
                    <el-button v-show="!isViewerMode" type="text" @click="dialogVisible = true" class="share-link">Share Link</el-button>
                    <div class="footer">
                        <div class="content">
                            <a :href="facebookLink" target="_blank"><i class="iconfont icon-facebook1"></i></a>
                            <a :href="twitterLink" target="_blank"><i class="iconfont icon-twitter"></i></a>
                            <a :href="instagramLink" target="_blank"><i class="iconfont icon-instagram"></i></a>
                            <a :href="linkedinLink" target="_blank"><i class="iconfont icon-linkedin last-icon"></i></a>
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

                <el-dialog
                title="Share Link"
                :visible.sync="dialogVisible"
                width="30%"
                >
                <span>https://eportfolio2077.herokuapp.com/#/classic/{{aboutMeForm.siteId}}</span>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="dialogVisible = false">Close</el-button>
                </span>
                </el-dialog>
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
            firstName: '',
            lastName: '',
            linkedinLink: "",
            facebookLink: "",
            twitterLink: "",
            instagramLink: "",
            dialogVisible : false,
            isViewerMode : false
        }
    },
    created() {
            this.verifyViewerMode()
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
        verifyViewerMode(){
            if(typeof(this.$route.params.id) != "undefined"){ 
                this.isViewerMode = true 
            }
        },
        async getUserData() {
            if(this.isViewerMode){
                 var temp = {siteId: this.aboutMeForm.siteId}
                var data2 = this.$qs.stringify(temp)
                const { data: re } = await this.$http.post('/api/dashboard/fetch',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.profilePic = re.obj.user.profilePicture
                this.firstName = re.obj.user.firstName
                this.lastName = re.obj.user.lastName
            }else{
                const { data: re } = await this.$http.get('/api/user/logged')
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.profilePic = re.obj.profilePic
                this.firstName = re.obj.firstName
                this.lastName = re.obj.lastName
            }
            
        },
        async getAboutData() {
            if(this.isViewerMode == true){
                this.aboutMeForm.siteId = this.$route.params.id
            }else{this.aboutMeForm.siteId = window.localStorage.getItem("nowSiteId")}
            
            var tem = {siteId: this.aboutMeForm.siteId}
            var data1 = this.$qs.stringify(tem)
            console.log(data1)
            const { data: r } = await this.$http.post('/api/dashboard/fetch',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('get about fail！')
            this.aboutMeForm.aboutme = r.obj.aboutMe
            this.aboutMeForm.bio = r.obj.bio
            this.linkedinLink = r.obj.user.linkedinLink
            this.facebookLink = r.obj.user.facebookLink
            this.twitterLink = r.obj.user.twitterLink
            this.instagramLink = r.obj.user.instagramLink
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
    word-wrap:break-word;
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
.share-link{
    color: #588dff;
    line-height: 20px;
    transition: opacity 0.4s ease 0s;
    margin-left: 155px;
}
.share-link:hover{
    opacity: 0.5;
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