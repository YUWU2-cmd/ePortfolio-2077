<template>
    <div id="home-body">
       <div class="body-wrapper">
        <div class="content-wrapper">
            <el-button v-show="!isViewerMode" type="text" @click="dialogVisible = true">Share Link</el-button>

                <el-dialog
                title="Share Link"
                :visible.sync="dialogVisible"
                width="30%"
                >
                <span>https://eportfolio2077.herokuapp.com/#/gallery/{{id.siteId}}</span>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="dialogVisible = false">Close</el-button>
                </span>
                </el-dialog>
            <i v-show="!isViewerMode" class="iconfont icon-setting" style="margin-left:98%; margin-bottom:30px; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <div class="left-content">
                
                <a v-for="item in imageList1" class="description">
                    <div class="img-wrapper">
                        <i v-show="!isViewerMode" class="el-icon-close" style="color: gray; font-size: 20px; transform: translate(2350%, 150%); cursor: pointer; " @click="handleDelete(item.imageId)"></i>
                        <img :src="item.imagePath" id="img3">
                        
                        
                    </div>
                </a>
                
            </div>

            <div class="right-content">
                <a v-for="item in imageList2" class="description">
                    <div class="img-wrapper">
                        <i v-show="!isViewerMode" class="el-icon-close" style="color: gray; font-size: 20px; transform: translate(2350%, 150%); cursor: pointer; " @click="handleDelete(item.imageId)"></i>
                        <img :src="item.imagePath" id="img2">
                    </div>
                </a>
                
            </div>
        </div>
        <div class="footer">
            <div class="text">© All illustrations credit to Jean Jullien</div>
            <div class="icons">
                <a :href="facebookLink" target="_blank"><i class="iconfont icon-facebook1"></i></a>
                <a :href="instagramLink" target="_blank"><i class="iconfont icon-instagram"></i></a>
                <a :href="linkedinLink" target="_blank"><i class="iconfont icon-linkedin last-icon"></i></a>
                <a :href="twitterLink" target="_blank"><i class="iconfont icon-twitter"></i></a>
            </div>
            
        </div>
    </div>
    </div>
</template>

<script>
export default {
    data(){
        return {
            imageList1 : [],
            imageList2 : [],
            id: {siteId : ''},
            linkedinLink: "",
            facebookLink: "",
            twitterLink: "",
            instagramLink: "",
            isViewerMode : false,
            dialogVisible : false
        }
    },
    created() {
            this.verifyViewerMode()
            this.loadImage()
            this.getUserData()
    },
      methods:{
         goSetting(){
            this.$router.push('/gallery/galleryHomeSetting')
        },
        verifyViewerMode(){
            if(typeof(this.$route.params.id) != "undefined"){ 
                this.isViewerMode = true 
            }
        },
        async loadImage(){
            if(this.isViewerMode == true){
                this.id.siteId = this.$route.params.id
            }else{this.id.siteId = window.localStorage.getItem("nowSiteId")}
            var sendData = this.$qs.stringify(this.id)
            const { data: res } = await this.$http.post('/api/home/get/img', sendData, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (res.message != "Success!") return this.$message.error('get load fail！')
            var tempList1 = []
            var tempList2 = []
            for(var i=0;i<res.obj.length;i= i+2){
                tempList1.push(res.obj[i])
            }
            for(var j=1;j<res.obj.length;j= j+2){
                tempList2.push(res.obj[j])
            }
            this.imageList1 = tempList1
            this.imageList2 = tempList2
        },
        async handleDelete(id){
            var temp1 = {siteId: this.id.siteId, imageId: id}
            var data1 = this.$qs.stringify(temp1)
            const { data: r } = await this.$http.post('/api/home/delete/img',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('delete fail！')
            this.$message.success('delete success！')
            this.loadImage()
        },
        async getUserData() {
            if(this.isViewerMode == true){
                this.siteId = this.$route.params.id
            }else{this.siteId = window.localStorage.getItem("nowSiteId")}
            var temp = {siteId: this.siteId}
            var data2 = this.$qs.stringify(temp)
            const { data: re } = await this.$http.post('/api/dashboard/fetch',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (re.message != "Success!") return this.$message.error('get logged fail！')
            this.linkedinLink = re.obj.user.linkedinLink
            this.facebookLink = re.obj.user.facebookLink
            this.twitterLink = re.obj.user.twitterLink
            this.instagramLink = re.obj.user.instagramLink
        }
      }
}
</script>

<style lang="less" scoped>
body,html{
    min-width: 1050px;
}
#home-body .body-wrapper{
    width: 100%;
    height: 100%;
    margin: 0;
    display: table;
}

#home-body .content-wrapper{
    width: 1050px;
    padding-top: 20px;
    margin: 0 auto;
    height: 100%;
}
#home-body .content-wrapper .left-content{
    float: left;
    width: 500px;
    display: flex;
    flex-direction: column;
}
#home-body .content-wrapper .right-content{
    float: left;
    width: 500px;
    margin-left: 50px;
    display: flex;
    flex-direction: column;
}
#home-body .content-wrapper img{
    width: 500px;
    margin-bottom: 40px;
}
#home-body .content-wrapper .img-wrapper{
    position: relative;
}
#home-body .content-wrapper .img-wrapper .img-title{
    position: absolute;
    font-size: 27px;
    top: 10%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: none;
}
#home-body .content-wrapper .img-wrapper img{
}

#home-body .content-wrapper .img-wrapper:hover .img-title{
    display: block;
    color: #414141;
}
.des-window{
    position: fixed;
    width: 100%;
    height: 80%;
    top: 10%;
    background-color: #fff;
    z-index: 99;
    display: none;
}
.des-window a{
    text-decoration: none;
}
.des-window .quit{
    position: absolute;
    width: 38px;
    height: 38px;
    font-size: 30px;
    right: 10px;
    top: 10px;
    color: #414141;
}
.des-window .img-container img{
    height: 700px;
    /* width: 500px; */
    float: left;
    background-color: pink;
    margin-left: 200px;
    overflow: hidden;
}
.des-window .description{
    font-size: 20px;
    float: left;
    margin-left: 150px;
    margin-top: 50px;
    width: 400px;
}
#home-body .footer{
    display: table-row;
    width: 70%;
    height: 150px;
    text-align: center;
}
#home-body .footer .text{
    height: 16px;
    line-height: 16px;
    margin-top: 40px;
    font-size: 12px;
}
#home-body .footer .icons{
    margin-top: 15px;
    height: 18px;
    line-height: 18px;
}
#home-body .footer .icons a{
    text-decoration: none;
    color: black;
    margin-right: 10px;
}
#home-body .footer .icons a i{
    font-size: 18px;
}
</style>