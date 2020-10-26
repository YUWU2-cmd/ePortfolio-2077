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
                <span>localhost:8081/?#/gallery/{{id.siteId}}</span>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="dialogVisible = false">Close</el-button>
                </span>
                </el-dialog>
            <i v-show="!isViewerMode" class="iconfont icon-setting" style="margin-left:98%; margin-bottom:30px; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <div class="left-content">
                
                <a v-for="item in imageList1"  href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img :src="item.imagePath" id="img3">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                
            </div>

            <div class="right-content">
                <a v-for="item in imageList2" href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img :src="item.imagePath" id="img2">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                
            </div>
        </div>
        <div class="footer">
            <div class="text">© All illustrations credit to Jean Jullien</div>
            <div class="icons">
                <a href="https://www.facebook.com/" target="_blank"><i class="iconfont icon-facebook1"></i></a>
                <a href="https://www.instagram.com" target="_blank"><i class="iconfont icon-instagram"></i></a>
                <a href="https://www.pinterest.com/" target="_blank"><i class="iconfont icon-pinterest"></i></a>
                <a href="https://twitter.com" target="_blank"><i class="iconfont icon-twitter"></i></a>
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
            isViewerMode : false,
            dialogVisible : false
        }
    },
    created() {
            this.verifyViewerMode()
            this.loadImage()
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
            for(var i=0;i<res.obj.length;i= i+2){
                this.imageList1.push(res.obj[i])
            }
            for(var j=1;j<res.obj.length;j= j+2){
                this.imageList2.push(res.obj[j])
            }
            console.log(this.imageList1)
        },
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
#home-body .content-wrapper .img-wrapper img:hover{
    opacity: 0.2;
    transition: opacity .4s ease;
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