<!-- home page for gallery template -->
<template>
    <div class="gallery-container">
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
            <div class="user-tab" id="user-tab">
                <div class="user-name">{{firstName}} {{lastName}}</div>
                <div class="nav-wrapper">
                    <div class="nav">
                        <router-link :to='"/gallery/galleryHome/"+siteId' class="nava"><div id="contact">Home</div></router-link>
                        <router-link :to='"/gallery/galleryAbout/"+siteId' class="nava"><div id="projects">About</div></router-link>
                        <router-link :to='"/gallery/galleryContact/"+siteId' class="nava"><div id="more">Contact</div></router-link>

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
            firstName: '',
            lastName: '',
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
.gallery-container{
    font-family: fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 16px;
    line-height: 1.5;
    background-color: #f9fafa;
    color: #414141;

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
    height: 180px;
    text-align: center;
    box-sizing: border-box;
    padding: 1px;
    z-index: 9;
}
.user-tab .user-name{
    height: 52px;
    line-height: 1.2em;
    font-family: CoquetteW00-Light, sans-serif;
    font-size: 42px;
    margin-top: 50px;
}
.user-tab .nav{
    width: 246px;
    height: 32px;
    margin-left: 50%;
    transform: translate(-46%,0);
    margin-top: 20px;
}
.user-tab .nav .nava{
    float: left;
    text-decoration: none;
    width: 62px;
    height: 32px;
    margin-right: 20px;
    color: #414141;
}
.user-tab .nav .nava:hover{
    color: #0051ffad;
}
.user-tab .nav .router-link-active{
    color: #0051ffad;
}

</style>
