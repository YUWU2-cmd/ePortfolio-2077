<template>
    <div class="business-container">
        <!-- topbar for eportfolio2077 website -->
        <div class="topbar-wrapper" id="topbar">
            <div class="topbar">
            
                <div class="topbar-main">
                    <div v-show="!isViewerMode" class="title" style="cursor: pointer" @click="goDashboard">
                        ePortfolio 2077
                    </div>
                </div>

                <el-dropdown v-show="!isViewerMode" placement="bottom-start" class="topbar-side">
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
        <div class="user-tab">
        <!-- navigation links to each section of the template -->
        <div class="nav">
            <a @click="jumpTo('#intro-page')"><div id="about">About</div></a>
            <a @click="jumpTo('#experience-page')"><div id="experience">Education&Experience</div></a>
            <a @click="jumpTo('#skills-page')"><div id="skills">Skills&Languages</div></a>
            <a @click="jumpTo('#awards-page')"><div id="awards">Awards&Interests</div></a>
            <el-button v-show="!isViewerMode" type="text" @click="dialogVisible = true" class="share-link">Share Link</el-button>
        </div>
                <!-- share link -->
                <el-dialog
                title="Share Link"
                :visible.sync="dialogVisible"
                width="30%"
                >
                <span>https://eportfolio2077.herokuapp.com/#/business/{{experienceForm.siteId}}</span>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="dialogVisible = false">Close</el-button>
                </span>
                </el-dialog>
        
    </div>
    <div id="aboutme-page">
        <div class="left-content">
            <div class="title-wrapper">
                <div class="hello">HELLO, I'M</div>
                <h1 class="name">{{firstName}} {{lastName}}.</h1>
                <div class="subtitle">{{aboutedForm.education.degree}} Student</div>
            </div>
        </div>
        <div class="right-content">
            <i v-show="!isViewerMode" class="iconfont icon-setting" style="margin-left:90%; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <div class="profile-img"><img :src="profilePic"></div>
            <div class="name">{{firstName}} {{lastName}}.</div>
            <div class="subtitle">{{aboutedForm.education.degree}}. {{aboutedForm.education.schoolName}}</div>
            <div class="email">john@student.unimelb.edu.au</div>
            <div class="phone">0123-456-789</div>
            <div class="socialmedia">
                <a href="https://www.facebook.com/" target="_blank"><i class="iconfont icon-facebook1"></i></a>
                <a href="https://twitter.com/" target="_blank"><i class="iconfont icon-twitter"></i></a>
                <a href="https://www.instagram.com" target="_blank"><i class="iconfont icon-instagram"></i></a>
                <a href="https://www.linkedin.com/" target="_blank"><i class="iconfont icon-linkedin last-icon"></i></a>
            </div>
        </div>
    </div>
    <div id="intro-page">
        <div class="content-wrapper">
            <div class="title">About</div>
            <div class="subtitle">MY BACKGROUND</div>
            <p class="content">{{aboutedForm.education.description}}</p>
        </div>
    </div>
    <div id="experience-page">
        <div class="left-content">
            <div class="content-wrapper">
                <div class="title">Education</div>
                <div class="subtitle">WHAT I'VE LEARNED</div>
                <div v-for="item in educationForm.educations" class="exp">
                    <div class="duration">{{item.duration}}</div>
                    <p class="school">{{item.schoolName}}</p>
                    <p class="degree">{{item.degree}}</p>
                </div>
                
            </div>
            
        </div>
        <div class="right-content">
            <div class="content-wrapper">
                <div class="title">Experience</div>
                <div class="subtitle">WHERE I'VE WORKED</div>
                <div v-for="item in experienceForm.experiences" class="exp">
                    <div class="duration">{{item.duration}}</div>
                    <p class="company">{{item.companyName}}</p>
                </div>
                
            </div>
            
        </div>
    </div>
    <div id="skills-page">
        <div class="content-wrapper">
            <div class="title">Skills & Languages</div>
            <div class="subtitle">WHAT I BRING TO THE TABLE</div>
            <div v-for="(item,index) in skillForm.skillList" class="content">
                <div class="text">{{item}}</div>
                <div class="level">
                <div :class='"sublevel"+skillForm.skillScore[index]'></div>
            </div>
            </div>
            
            <div class="dividing-line"></div>

            <div v-for="(item,index) in skillForm.languageList" class="content">
                <div class="text">{{item}}</div>
                <div class="level">
                    <div :class='"sublevel"+skillForm.languageScore[index]'></div>
                </div>
            </div>
            
        </div>
    </div>
    <div id="awards-page">
        <div class="left-content">
            <div class="content-wrapper">
               <div class="title">Awards</div>
                <div class="subtitle">WHERE I SHINE</div>
                <p v-for="item in skillForm.awardList" class="content">{{item}}</p>
            </div>
            
        </div>
        <div class="right-content">
            <div class="content-wrapper">
                <div class="title">Interests</div>
                <div class="subtitle">OUT OF OFFICE</div>
                 <p v-for="item in skillForm.interestList" class="content">{{item}}</p>
            </div>
        </div>
    </div>
    <div id="contact-page">
        <div class="left-content">
            <div class="title">I'd love to hear from you.</div>
            <div class="socialmedia">
                <a :href="facebookLink" target="_blank"><i class="iconfont icon-facebook1"></i></a>
                <a :href="twitterLink" target="_blank"><i class="iconfont icon-twitter"></i></a>
                <a :href="instagramLink" target="_blank"><i class="iconfont icon-instagram"></i></a>
                <a :href="linkedinLink" target="_blank"><i class="iconfont icon-linkedin last-icon"></i></a>
            </div>
        </div>
        <div class="right-content">
            <div class="email">{{email}}</div>
            <div class="phone">{{phoneNumber}}</div>
            <a @click="backtop()" class="btn">
                <div>Back to Top</div>
            </a>
        </div>
        <div v-show="!isViewerMode" class="views">Views: {{views}}</div>
    </div>

    </div>
</template>

<script>
export default {
     data() {
        return{
            firstName: '',
            lastName: '',
            profilePic: '',
            bio: '',
            aboutMe: '',
            views: '',
            aboutedForm: {
                education:{schoolName: "",
                            business: "True",
                            degree: "",
                            schoolLocation: "",
                            description: ""
                },
	            siteId: ''
            },
            experienceForm: {
                experiences:[
                    {
                        duration:'',
                        position:'',
                        companyName:'',
                        companyLocation:'',
                        description:''
                    },
                    {
                        duration:'',
                        position:'',
                        companyName:'',
                        companyLocation:'',
                        description:''
                    },
                    {
                        duration:'',
                        position:'',
                        companyName:'',
                        companyLocation:'',
                        description:''
                    }
                ],
                siteId:''
                 
            },
           educationForm: {
               educations:[
                    {
                        duration:'',
                        schoolName:'',
                        degree:'',
                        schoolLocation:'',
                        description:''
                    },
                    {
                        duration:'',
                        schoolName:'',
                        degree:'',
                        schoolLocation:'',
                        description:''
                    },
                    {
                        duration:'',
                        schoolName:'',
                        degree:'',
                        schoolLocation:'',
                        description:''
                    }
               ],
               siteId:''
           },
           skillForm : {
               skillList:[],
                skillScore:[0,0,0,0,0,0,0],
                languageList:[],
                languageScore:[0,0,0],
                awardList:[],
                interestList:[],
                siteId: '',
           },
           isViewerMode : false,
           dialogVisible : false,
           phoneNumber: '',
           email: '',
           linkedinLink: "",
           facebookLink: "",
            twitterLink: "",
            instagramLink: "",
           siteId: ''
        }
        
    },
    created() {
        this.verifyViewerMode()
        this.getUserData()
        this.getAboutData()
        this.getExperienceData()
        this.getEducationData()
        this.getSkillData()
    },
    methods: {
        verifyViewerMode(){
            if(typeof(this.$route.params.id) != "undefined"){ 
                this.isViewerMode = true 
                this.countVisited()
            }
        },
        goSetting(){
            this.$router.push('/businessSetting')
        },
        //The implementation of scroll effect
        jumpTo(selector){
            // this.$el.querySelector(selector).scrollIntoView(true)
             let anchor = this.$el.querySelector(selector);
             //document.documentElement.scrollTop = anchor.offsetTop;
             let total = anchor.offsetTop;

             // scroll evenly, cost 500ms，every 10ms jump once，50 jumps in total
             // get the distance between the scroll bar and the page top
             let distance = document.documentElement.scrollTop || document.body.scrollTop
             // count every jumps' distance
             let step = total/50;
             (function smoothDown () {
                 if (distance < total) {
                     distance += step
                 　　// move a litte bit
                     document.body.scrollTop = distance
                     document.documentElement.scrollTop = distance
                 　　// every 10ms jump once
                     setTimeout(smoothDown, 10)
                 } else {
                 　　// restrict stop distance
                     document.body.scrollTop = total
                     document.documentElement.scrollTop = total
                 }
             })()
        },
         backtop(){
          var timer = setInterval(function(){
            let osTop = document.documentElement.scrollTop || document.body.scrollTop;
            let ispeed = Math.floor(-osTop / 5); 
            document.documentElement.scrollTop = document.body.scrollTop = osTop + ispeed;
            this.isTop = true;
            if(osTop === 0){
              clearInterval(timer);
            }
          },30)
      },
        //get experience part's data
         async getExperienceData() {
            if(this.isViewerMode == true){
                this.experienceForm.siteId = this.$route.params.id
            }else{this.experienceForm.siteId = window.localStorage.getItem("nowSiteId")}
            var extem = {siteId: this.experienceForm.siteId}
            var data1 = this.$qs.stringify(extem)
            
            const { data: aa } = await this.$http.post('/api/home/get/classic/experience',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (aa.message != "Success!") return this.$message.error('get about fail！')
            if(aa.obj.experiences.length != 0){
                this.experienceForm = aa.obj
            }
        },
        //get education part's data
        async getEducationData() {
            if(this.isViewerMode == true){
                this.educationForm.siteId = this.$route.params.id
            }else{this.educationForm.siteId = window.localStorage.getItem("nowSiteId")}
            var edtem = {siteId: this.educationForm.siteId}
            var data2 = this.$qs.stringify(edtem)
            
            const { data: bb } = await this.$http.post('/api/home/get/classic/education',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (bb.message != "Success!") return this.$message.error('get about fail！')
            if (bb.obj.educations.length != 0){
                this.educationForm = bb.obj
            }
        },
        //get about part's data
      async getAboutData() {
            if(this.isViewerMode == true){
                this.aboutedForm.siteId = this.$route.params.id
            }else{this.aboutedForm.siteId = window.localStorage.getItem("nowSiteId")}
            var tem = {siteId: this.aboutedForm.siteId}
            var data3 = this.$qs.stringify(tem)
            const { data: r } = await this.$http.post('/api/home/get/business/aboutedu',data3, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('get about fail！')
            if(r.obj.education != null){
                this.aboutedForm.education.schoolName = r.obj.education.schoolName
                this.aboutedForm.education.degree = r.obj.education.degree
                this.aboutedForm.education.description = r.obj.education.description
            }
            
        },
        //get skill part's data
        async getSkillData() {
            if(this.isViewerMode == true){
                this.skillForm.siteId = this.$route.params.id
            }else{this.skillForm.siteId = window.localStorage.getItem("nowSiteId")}
            var skilltem = {siteId: this.skillForm.siteId}
            var data4 = this.$qs.stringify(skilltem)
            const { data: cc } = await this.$http.post('/api/home/get/business/skill',data4, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (cc.message != "Success!") return this.$message.error('get skill fail！')

            //store returned data and prevent unexpect data be stored
            var tempArray1 = []
            var tempArray2 = []
            if(cc.obj.skillList.length != 0){
                for(var i = 0; i<cc.obj.skillList.length; i++){
                    tempArray1.push(cc.obj.skillList[i].skillName)
                    tempArray2.push(cc.obj.skillList[i].score)
                }
                this.skillForm.skillList = tempArray1
                this.skillForm.skillScore = tempArray2
            }
            tempArray1 = []
            tempArray2 = []
            if(cc.obj.languageList.length != 0){
                for(var j = 0; j<cc.obj.languageList.length; j++){
                    tempArray1.push(cc.obj.languageList[j].skillName)
                    tempArray2.push(cc.obj.languageList[j].score)
                }
                this.skillForm.languageList = tempArray1
                this.skillForm.languageScore = tempArray2
            }
            tempArray1 = []
            tempArray2 = []
            if(cc.obj.awardList.length != 0){
                for(var k = 0; k<cc.obj.awardList.length; k++){
                    tempArray1.push(cc.obj.awardList[k].skillName)
                }
                this.skillForm.awardList = tempArray1
            }
            tempArray1 = []
            if(cc.obj.interestList.length != 0){
                for(var n = 0; n<cc.obj.interestList.length; n++){
                    tempArray1.push(cc.obj.interestList[n].skillName)
                }
                this.skillForm.interestList = tempArray1
            }
            tempArray1 = []
        },
        //get some basic information of the site owner
      async getUserData() {
            if(this.isViewerMode){
                var temp = {siteId: this.$route.params.id}
                var data = this.$qs.stringify(temp)
                const { data: re } = await this.$http.post('/api/dashboard/fetch',data, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.profilePic = re.obj.user.profilePicture
                this.firstName = re.obj.user.firstName
                this.lastName = re.obj.user.lastName
                this.phoneNumber = re.obj.user.phoneNumber
                this.email = re.obj.user.email
                this.linkedinLink = re.obj.user.linkedinLink
                this.facebookLink = re.obj.user.facebookLink
                this.twitterLink = re.obj.user.twitterLink
                this.instagramLink = re.obj.user.instagramLink
            }else{
                const { data: re } = await this.$http.get('/api/user/logged')
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.profilePic = re.obj.profilePic
                this.firstName = re.obj.firstName
                this.lastName = re.obj.lastName

                var tempid = {siteId: window.localStorage.getItem("nowSiteId")}
                var data5 = this.$qs.stringify(tempid)
                const { data: rere } = await this.$http.post('/api/dashboard/fetch',data5, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (rere.message != "Success!") return this.$message.error('get logged fail！')
                this.views = rere.obj.visit
                this.phoneNumber = rere.obj.user.phoneNumber
                this.email = rere.obj.user.email
                this.linkedinLink = rere.obj.user.linkedinLink
                this.facebookLink = rere.obj.user.facebookLink
                this.twitterLink = rere.obj.user.twitterLink
                this.instagramLink = rere.obj.user.instagramLink
            }
        },
        //when the site is visted once, this method will be called and let server add the visit times number
        async countVisited() {
                var temvis = {siteId: this.$route.params.id}
                var data4 = this.$qs.stringify(temvis)
                const { data: vis } = await this.$http.post('/api/home/view/visited',data4, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (vis.message != "Success!") return this.$message.error('count visited fail！')
        },
        goDashboard() {
            this.$router.push('/dashboard')
        },

    }
}
</script>

<style lang="less" scoped>
.business-container{
    font-family: fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 16px;
    line-height: 1.5;
    background-color: #f9fafa;
    color: #414141;
    word-wrap: break-word;
}
.selected{
    color: #0051ffad!important;
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

.topbar .title{
    float: left;
    top: 10px;
    margin: 10px 20px;
    color: rgb(65, 65, 65);
    line-height: 42px;
    font-size: 28px;
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

.user-tab{
    width: 100%;
    height: 72px;
    background-color: #5569dc;
    box-sizing: border-box;
    padding: 1px;
}
.user-tab .nav{
    width: 980px;
    height: 20px;
    margin: 25px auto;
    position: relative;
}
.nav a{
    float: left;
    text-decoration: none;
    color: #fff;
    margin-right: 30px;
    line-height: 20px;
    font: italic normal normal 18px 'playfair display',serif;
    transition: opacity 0.4s ease 0s;
    cursor: pointer;
}
.nav a:hover{
    opacity: 0.5;
}
.nav .share-link{
    position: absolute;
    top: -10px;
    right: 20px;
    color: #fff;
    line-height: 20px;
    transition: opacity 0.4s ease 0s;
}
.share-link:hover{
    opacity: 0.5;
}
#aboutme-page{
    width: 100%;
    height: 650px;
    background-color: #5569dc;
}
#aboutme-page .left-content{
    float: left;
    position: relative;
    width: 75%;
    height: 100%;
    box-sizing: border-box;
    padding: 1px;
    overflow: hidden;
}
#aboutme-page .left-content::before{
    content: ' ';
    display: block;
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    z-index: 1;
    opacity: 0.5;
    background-image: url(../assets/bg2.jpg);
    background-size: cover;
}
#aboutme-page .left-content .title-wrapper{
    position: relative;
    z-index: 2;
    width: 710px;
    height: 100%;
    margin: 0 auto;
    color: #fff;
    margin-top: 350px;
}
.title-wrapper .hello{
    width: 100%;
    height: 31px;
    font: normal normal normal 26px/1.4em FuturaLTW01-LightOblique,sans-serif;
    letter-spacing: 0.35em;
    margin-left: 10px;
}
.title-wrapper h1{
    font: normal normal bold 88px/1.4em playfairdisplay-bold,'playfair display',serif;
    margin: 0;
}
.title-wrapper .subtitle{
    font: italic normal normal 23px/1.4em 'playfair display',serif;

}

#aboutme-page .right-content{
    position: relative;
    float: left;
    width: 25%;
    height: 100%;
    color: #fff;
}
#aboutme-page .right-content .profile-img img{
    display: block;
    height: 140px;
    width: 140px;
    border-radius: 50%;
    margin: 20px auto;
}
#aboutme-page .right-content .name{
    font: normal normal bold 32px/1.4em playfairdisplay-bold,'playfair display',serif;
    height: 43px;
    width: 100%;
    text-align: center;
    margin-top: 30px;
}
#aboutme-page .right-content .subtitle{
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    width: 50%;
    text-align: center;
    line-height: 1.6em;

    margin: 50px auto;
    margin-bottom: 0px;
}
#aboutme-page .right-content .email{
    font: normal normal normal 16px/1.4em FuturaLTW01-LightOblique,sans-serif;
    height: 21px;
    width: 100%;
    text-align: center;
    line-height: 1.6em;
    margin-top: 90px;
}
#aboutme-page .right-content .phone{
    font: normal normal normal 16px/1.4em FuturaLTW01-LightOblique,sans-serif;
    height: 21px;
    text-align: center;
    line-height: 1.6em;
    margin-top: 10px;
}
#aboutme-page .right-content .socialmedia{
    width: 144px;
    height: 24px;
    margin: 40px auto;
}
#aboutme-page .right-content .socialmedia a i{
    display: inline-block;
    text-decoration: none;
    color: #fff;
    width: 24px;
    height: 24px;
    font-size: 20px;
    text-align: center;
    line-height: 24px;
    margin-right: 10px;
}
#aboutme-page .right-content .socialmedia a .last-icon{
    margin-right: 0;
}

#intro-page{
    width: 100%;
    height: 483px;
    background-color: #eef0fb;
}
#intro-page .content-wrapper{
    width: 60%;
    height: 100%;
    margin: 0 auto;
    margin-left: 26%;
    overflow: hidden;
}
#intro-page .content-wrapper .title{
    color: #5569DC;
    font: italic normal normal 34px/1.4em 'playfair display',serif;
    margin-top: 80px;
}
#intro-page .content-wrapper .subtitle{
    color: #5569DC;
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    letter-spacing: 0.15em;
    margin-top: 10px;
}
#intro-page .content-wrapper .content{
    font: normal normal normal 21px/1.4em FuturaLTW01-LightOblique,sans-serif;
    width: 85%;
    height: 50%;
    margin-top: 50px;
    line-height: 2em;
    overflow-y: scroll;
    scrollbar-width: none;
}
#intro-page .content-wrapper .content::-webkit-scrollbar{
    display: none;
}

#experience-page{
    width: 100%;
    height: 690px;

}
#experience-page .left-content{
    width: 50%;
    height: 100%;
    float: left;
    box-sizing: border-box;
    padding-left: 26%;
}
#experience-page .left-content .content-wrapper{
    width: 50%;
    height: 100%;
    float: left;
    box-sizing: border-box;
    padding-top: 100px;
    overflow-y: scroll;
    scrollbar-width: none;
}
#experience-page .right-content{
    width: 50%;
    height: 100%;
    float: left;
}
#experience-page .right-content .content-wrapper{
    width: 40%;
    height: 100%;
    float: left;
    box-sizing: border-box;
    padding-top: 100px;
    overflow-y: scroll;
    scrollbar-width: none;
}
#experience-page .right-content .content-wrapper::-webkit-scrollbar,
#experience-page .left-content .content-wrapper::-webkit-scrollbar{
    display: none;
    
}
#experience-page .title{
    font: italic normal normal 34px/1.4em 'playfair display',serif;
    color: #5569DC;
}
#experience-page .subtitle{
    font: normal normal normal 16px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #5569DC;
    line-height: 1em;
    letter-spacing: 0.15em;
    margin-top: 15px;
    margin-bottom: 60px;
}
#experience-page .exp .duration{
    font: normal normal bold 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #1C2349;
    margin-bottom: 15px;
}
#experience-page .exp .school{
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #1C2349;
    margin-bottom: 5px;
}
#experience-page .exp .degree{
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #1C2349;
    margin-bottom: 40px;
}
#experience-page .exp .company{
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #1C2349;
    margin-bottom: 63.8px;
}

#skills-page{
    width: 100%;
    height: 674px;
}
#skills-page .content-wrapper{
    height: 100%;
    box-sizing: border-box;
    padding-left: 26%;
    overflow-y: scroll;
    scrollbar-width: none;
}
#skills-page .content-wrapper::-webkit-scrollbar{
    display: none;
}
#skills-page .content-wrapper .sub-wrapper{
    float: right;
}

#skills-page .title{
    font: italic normal normal 34px/1.4em 'playfair display',serif;
    color: #5569DC;
}
#skills-page .subtitle{
    font: normal normal normal 16px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #5569DC;
    line-height: 1em;
    letter-spacing: 0.15em;
    margin-top: 15px;
    margin-bottom: 60px;
}
#skills-page .content{
    margin-bottom: 20px;
}
#skills-page .content .text{
    display: inline-block;
    width: 310px;
    height: 21px;
    font: normal normal bold 16px/1.4em FuturaLTW01-LightOblique,sans-serif;
}
#skills-page .content .level{
    display: inline-block;
    width: 50%;
    height: 3px;
    background-color: rgba(202, 212, 232, 1);

}
#skills-page .content .sublevel0{
    width: 0%;
    height: 3px;
    background-color:rgba(85, 105, 220, 1);
}
#skills-page .content .sublevel1{
    width: 20%;
    height: 3px;
    background-color:rgba(85, 105, 220, 1);
}
#skills-page .content .sublevel2{
    width: 40%;
    height: 3px;
    background-color:rgba(85, 105, 220, 1);
}
#skills-page .content .sublevel3{
    width: 60%;
    height: 3px;
    background-color:rgba(85, 105, 220, 1);
}
#skills-page .content .sublevel4{
    width: 80%;
    height: 3px;
    background-color:rgba(85, 105, 220, 1);
}
#skills-page .content .sublevel5{
    width: 100%;
    height: 3px;
    background-color:rgba(85, 105, 220, 1);
}
#skills-page .dividing-line{
    width: 30px;
    height: 5px;
    border-top: 1px solid rgba(202, 212, 232, 1);
    margin: 40px 0;
}

#awards-page{
    width: 100%;
    height: 447px;
}
#awards-page .left-content{
    float: left;
    width: 52%;
    height: 100%;
}
#awards-page .right-content{
    float: left;
    width: 48%;
    height: 100%;
}
#awards-page .title{
    font: italic normal normal 34px/1.4em 'playfair display',serif;
    color: #5569DC;
}
#awards-page .subtitle{
    font: normal normal normal 16px/1.4em FuturaLTW01-LightOblique,sans-serif;
    color: #5569DC;
    line-height: 1em;
    letter-spacing: 0.15em;
    margin-top: 15px;
    margin-bottom: 60px;
}
#awards-page .left-content .content-wrapper{
    width: 50%;
    height: 100%;
    float: right;
    box-sizing: border-box;
    padding-top: 100px;
    overflow-y: scroll;
    scrollbar-width: none;
}
#awards-page .right-content .content-wrapper{
    width: 50%;
    height: 100%;
    float: left;
    box-sizing: border-box;
    padding-top: 100px;
    margin-left: 18%;
    overflow-y: scroll;
    scrollbar-width: none;
}
#awards-page .right-content .content-wrapper::-webkit-scrollbar,
#awards-page .left-content .content-wrapper::-webkit-scrollbar{
    display: none;
}
#awards-page .content{
    line-height: 1.8em;
    color: #1C2349;
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    margin: 10px 0;
}

#contact-page{
    width: 100%;
    min-height: 351px;
    background-color:#eef0fc;
}
#contact-page .left-content{
    display: inline-block;
    width: 40%;
    height: 100%;
    overflow: hidden;
    box-sizing: border-box;
    padding-right: 3%;
}
#contact-page .right-content{
    display: inline-block;
    width: 50%;
    height: 100%;
    box-sizing: border-box;
    padding-left: 5%;
}
#contact-page .left-content .title{
    font: italic normal normal 200%/1.4em 'playfair display',serif;
    height: 86px;
    width: 234px;
    margin-left: 70%;
    margin-top: 70px;
    color: #1C2349;
    
}
#contact-page .left-content .socialmedia{
    width: 234px;
    height: 24px;
    margin-left: 69%;
    margin-top: 70px;
}
#contact-page .left-content .socialmedia a i{
    display: inline-block;
    text-decoration: none;
    color: #1C2349;
    width: 24px;
    height: 24px;
    font-size: 20px;
    text-align: center;
    line-height: 24px;
    margin-right: 10px;
}
#contact-page .right-content .email{
    line-height: 1.8em;
    color: #1C2349;
    font: normal normal normal 100%/1.4em FuturaLTW01-LightOblique,sans-serif;
    margin-left: 35%;
    margin-top: 80px;
}
#contact-page .right-content .phone{
    line-height: 1.8em;
    color: #1C2349;
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    margin-left: 35%;
    margin-top: 10px;
    
}
#contact-page .right-content .btn{
    text-decoration: none;
    display: block;
    width: 160px;
    height: 52px;
    margin-left: 35%;
    margin-top: 80px;
    background-color: rgba(85, 105, 220, 1);
    border-color: rgba(0, 0, 0, 1);
    transition: background-color 0.4s ease 0s;
    cursor: pointer;
}
#contact-page .right-content .btn div{
    color: #fff;
    font: normal normal normal 17px/1.4em FuturaLTW01-LightOblique,sans-serif;
    text-align: center;
    line-height: 52px;
}
#contact-page .right-content .btn:hover{
    background-color: rgba(85, 105, 220, 0.5);
}
#contact-page .views{
    display: inline-block;
    width: 10%;
    height: 100%;
    // font-size: 18px;
    font-weight: bold;
    box-sizing: border-box;
    font: normal normal bold 120%/18px FuturaLTW01-LightOblique,sans-serif;

}

@font-face {font-family: "FuturaLTW01-LightOblique"; src: url("//db.onlinewebfonts.com/t/9a7e574c3eda05d71d03345d3f9e268e.eot"); src: url("//db.onlinewebfonts.com/t/9a7e574c3eda05d71d03345d3f9e268e.eot?#iefix") format("embedded-opentype"), url("//db.onlinewebfonts.com/t/9a7e574c3eda05d71d03345d3f9e268e.woff2") format("woff2"), url("//db.onlinewebfonts.com/t/9a7e574c3eda05d71d03345d3f9e268e.woff") format("woff"), url("//db.onlinewebfonts.com/t/9a7e574c3eda05d71d03345d3f9e268e.ttf") format("truetype"), url("//db.onlinewebfonts.com/t/9a7e574c3eda05d71d03345d3f9e268e.svg#FuturaLTW01-LightOblique") format("svg"); } 

</style>
