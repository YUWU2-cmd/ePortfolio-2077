<template>
    <div class="classic-container">
        <!-- topbar for eportfolio2077 website -->
         <div class="topbar-wrapper">
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
            <div class="user-intro-wrapper">
                <div class="user-intro">
                    <div class="blue-dot"></div>
                    <div class="title">{{username}}</div>
                </div>
            </div>
            <div class="nav-wrapper">
                <!-- navigation tabs for each section of this template -->
                <div class="nav">
                    <router-link :to='"/classic/contact/"+siteId' class="nava"><div id="contact">CONTACT</div></router-link>
                    <router-link :to='"/classic/projects/"+siteId' class="nava"><div id="projects">PROJECTS</div></router-link>
                    <router-link :to='"/classic/more/"+siteId' class="nava"><div id="more">MORE</div></router-link>
                    <router-link :to='"/classic/aboutMe/"+siteId' class="nava"><div id="aboutme">ABOUT ME</div></router-link>
                </div>
            </div>
        </div>

        <router-view />

    </div>
</template>

<script>
export default {
     data() {
        return{
            username: '',
            profilePic: '',
            isViewerMode : false,
            siteId: ''
        }
        
    },
    created() {
        this.verifyViewerMode()
        this.getUserData()
    },
     methods:{
         verifyViewerMode(){
            if(typeof(this.$route.params.id) != "undefined"){ 
                console.log(123)
                this.isViewerMode = true
                this.siteId = this.$route.params.id 
                this.countVisited()
            }
        },
        //get some basic information of the site owner
        async getUserData() {
            if(this.isViewerMode){
                 var temp = {siteId: this.$route.params.id}
                 //convert aboutMeForm to form type
                var data2 = this.$qs.stringify(temp)
                const { data: re } = await this.$http.post('/api/dashboard/fetch',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.profilePic = re.obj.user.profilePicture
                this.username = re.obj.user.username
            }else{
                const { data: re } = await this.$http.get('/api/user/logged')
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.profilePic = re.obj.profilePic
                this.username = re.obj.username
            }
        },
        //when the site is visted once, this method will be called and let server add the visit times number
        async countVisited() {
                var tem = {siteId: this.$route.params.id}
                var data3 = this.$qs.stringify(tem)
                const { data: res } = await this.$http.post('/api/home/view/visited',data3, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (res.message != "Success!") return this.$message.error('count visited fail！')
        },
        goDashboard() {
            this.$router.push('/dashboard')
        }
     }
}
</script>

<style lang="less" scoped>

.classic-container {
  height: 100%;
  font-family: fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
}
.user-tab{
    width: 100%;
    height: 130px;
}
.user-tab .user-intro-wrapper,
.user-tab .nav-wrapper{
    float: left;
    height: 100%;
    width: 50%;
    box-sizing: border-box;
    padding: 47.5px 3.5%;
}
.user-intro-wrapper .user-intro,
.nav-wrapper .nav{
    height: 35px;
    width: 100%;
    background-color: #fff;
}
.user-intro .blue-dot{
    float: left;
    width: 16px;
    height: 16px;
    margin-top: 10px;
    background-color: #0050ff;
}
.user-intro .title{
    float: left;
    height: 35px;
    font-weight: bold;
    font-size: 25px;
    line-height: 35px;
    margin-left: 10px;
}

.nav .nava{
    display: block;
    text-decoration: none;
    float: right;
    font-size: 14px;
    line-height: 35px;
    margin-left: 20px;
    color: black;
}
.nav .nava:hover{
    color: #0050FF;
}
.nav .router-link-active{
    color: #0050FF;
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


</style>