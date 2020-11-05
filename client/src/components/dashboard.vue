<!-- dashboard page for user to manage his sites -->
<template>
    <div class="dashboard-container">
        <!-- topbar for eportfolio2077 website -->
        <div class="topbar-wrapper">
            <div class="topbar">
            
                <div class="topbar-main">
                    <div class="title" style="cursor: pointer">
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
                      <el-dropdown-item><router-link to="/login">Logout</router-link></el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                
        </div>
    </div>
    <div class="user-tab">
        <div class="title-wrapper">
            <div class="title">{{username}}'s ePortfolios</div>
            <div class="subtitle">Select a site to edit, view and open its dashboard.</div>
        </div>
        <!-- button to create sites -->
        <el-dropdown class="create-wrapper" placement="bottom" @command="handleCommand">
            <span >
                <div id="create-new" class="button">+ Create new</div>
            </span>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="a">classic</el-dropdown-item>
                <el-dropdown-item command="b">gallery</el-dropdown-item>
                <el-dropdown-item command="c">business</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
    </div>
    <div class="body-wrapper">
        <div class="header">
            <div>All ePortfolios</div>
        </div>
        <div class="sites" id="site-list">
            <!-- area where all the sites are displayed -->
            <a v-bind:key=index v-for="(item,index) in portfolioList" >
                <div class="site" @click="goTemp(item.template,item.siteId)">
                    
                       <i class="iconfont icon-21file" style=" margin: 5px 0px; cursor: pointer;bottom: 55px; left: 20%" @click.stop="handleRenameButton(index)"></i>
                       <span @click.stop="">
                            <el-input v-if="inputFlagList[index]" v-model="name" class="site-name"  maxlength="16" @blur.stop="handle_blur(index,item.siteId)"></el-input>
                        </span>
                        <span v-if="!inputFlagList[index] && item.siteName!=null">{{item.siteName}}</span>
                        <span v-if="!inputFlagList[index] && item.siteName==null">{{item.template}} {{item.siteId}}</span>
                        <i class="el-icon-close" style="color: gray; font-size: 20px; margin: 5px 0px; cursor: pointer; float: right;" @click.stop="handleDelete(item.siteId)"></i>
                </div>
                 
                
            </a>
        </div>
    </div>
</div>
</template>

<script>
export default {

    data () {
        return {
        name : '',
        portfolioList : [],
        inputFlagList : [],
        profilePic: '',
        username: ''
        }
    },
    created() {
            this.loadIform()
            this.getUserData()
    },
    methods: {
        //use input variables to decide to goto which site
        goTemp(template,id){
            //store the selected site's id 
            window.localStorage["nowSiteId"]=id
            if (template=="classic"){
                this.$router.push('/classic')
            }
            if (template=="gallery"){
                this.$router.push('/gallery')
            }
            if (template=="business"){
                this.$router.push('/business')
            }
        },
        //decide to create which type of site
        handleCommand(command) {
            if (command=="a"){
            this.create("classic")
            }
            if (command=="b"){
                this.create("gallery")
            }
            if (command=="c"){
                this.create("business")
            }
        },
        //open the name input box for particular site
        handleRenameButton(i){
            var statu = !this.inputFlagList[i]
            //vue's vshow if can't monitor list's change，so we use this let vue to know the change of list 
            this.$set(this.inputFlagList,i,statu);
            
        },
        //when user click on the input box's outside, it will update the site name
        handle_blur(index,id){
            this.handleRenameButton(index)
            this.rename(id)
        },
        //update site name
        async rename(id){
            var temp2 = {siteId: id, name: this.name}
            var data2 = this.$qs.stringify(temp2)
            const { data: r } = await this.$http.post('/api/dashboard/rename',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('rename fail！')
            this.$message.success('rename success！')
            this.loadIform()
        },
        //delete site
        async handleDelete(id){
            var temp1 = {siteId: id}
            var data1 = this.$qs.stringify(temp1)
            const { data: re } = await this.$http.post('/api/dashboard/delete',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (re.message != "Success!") return this.$message.error('delete fail！')
            this.$message.success('delete success！')
            this.loadIform()
        },
        //create new site
        async create(temType){
            var temp = {template: temType}
            var data = this.$qs.stringify(temp)
            const { data: res } = await this.$http.post('/api/dashboard/create',data, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (res.message != "Success!") return this.$message.error('create fail！')
            this.$message.success('create success！')
            this.loadIform()
            
        },
        //get all sites the user have
        async loadIform(){
            const { data: re } = await this.$http.get('/api/dashboard/load')
            if (re.message != "Success!") return this.$message.error('get load fail！')
            this.portfolioList = re.obj
            if(this.inputFlagList.length != this.portfolioList.length){
                this.inputFlagList.length = []
                for(var i=0; i<re.obj.length; i++){
                    this.inputFlagList.push(false)
                }
            }
            
        },
        //get some basic information of the site owner
         async getUserData() {
            const { data: r } = await this.$http.get('/api/user/logged')
            if (r.message != "Success!") return this.$message.error('get logged fail！')
            this.profilePic = r.obj.profilePic
            this.username = r.obj.username
        }

    }
  }

</script>

<style lang="less" scoped>
.site-name{
    width: 155px;
}

.dashboard-container{
    height: 800px;
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





.user-tab{
    box-sizing: border-box;
    background-color: #fff;
    height: 144px;
    padding: 35px 8.5%;
}
.title-wrapper{
    float: left;
    height: 74px;
}
.title-wrapper .title{
    font-size: 32px;
    line-height: 42px;
    font-weight: bold;
    color: #162D3D;
}
.title-wrapper .subtitle{
    font-size: 16px;
    line-height: 24px;
    font-weight: 100;
    color: #475761;
}
.create-wrapper{
    float: right;
    width: 190px;
    padding: 8px 0;
}
#create-new{
    display: block;
    width: 185px;
    height: 36px;
    line-height: 36px;
    background-color:#4EB7F5;
    color: #fff;
    text-align: center;
    border: 1px solid #4EB7F5;
    border-radius: 18px;
    text-decoration: none;
    cursor: default;
}
#create-new:hover{
    background-color:#4eb8f5c4;
    border-color:#4eb8f5c4;
}

.body-wrapper{
    width: 83%;
    height: 50%;
    margin: 0 auto;
}
.body-wrapper .header{
    box-sizing: border-box;
    width: 100%;
    height: 108px;
    padding: 39px 0;
}
.header div{
    width: 100px;
    height: 30px;
    line-height: 30px;
    font-size: 15px;
    text-align: center;
    color: #577083;
}
.body-wrapper .sites{
    width: 100%;
    height: 100%;
    /* background-color: #fff; */
    display: flex;
    flex-flow: row wrap;
    align-items: center;
}
.sites a{
    position: relative;
    text-decoration: none;
    top:0px;
}
.site{
    box-sizing: border-box;
    width: 250px;
    height: 84px;
    line-height: 84px;
    box-shadow: 0 4px 25px 0 rgba(0,0,0,.08);
    border-radius: 4px;
    padding: 0 20px;
    background-color: #fff;
    margin-right: 25px;
    cursor: pointer;
}
.sites i{
    font-size: 35px;
    margin-right: 20px;
    color: #4EB7F5;
}
.site span{
    color: #475761;
    font-size: 16px;
}
.site:hover{
    box-shadow: 0 4px 25px 0 rgba(0,0,0,.16);
    cursor: default;
}
</style>