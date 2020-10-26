<template>
    <div id="about-body">
        <div class="body-wrapper">
            <i v-show="!isViewerMode" class="iconfont icon-setting" style="margin-left:98%; margin-bottom:30px; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <img :src="imgPath" class="profile-img">
            <div class="title">About me</div>
            <p class="content">{{aboutMeForm.aboutme}}</p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return{
            aboutMeForm: {
                bio:'',
                aboutme:'',
                siteId:''
            },
            imgPath : '',
            isViewerMode : false
        }
    },
     created() {
            this.verifyViewerMode()
            this.getAboutData()
            this.getAboutImg()
    },
    methods: {
        verifyViewerMode(){
            if(typeof(this.$route.params.id) != "undefined"){ 
                this.isViewerMode = true 
            }
        },
        async getAboutData() {
            if(this.isViewerMode == true){
                this.aboutMeForm.siteId = this.$route.params.id
            }else{this.aboutMeForm.siteId = window.localStorage.getItem("nowSiteId")}
            var tem = {siteId: this.aboutMeForm.siteId}
            var data1 = this.$qs.stringify(tem)
            const { data: r } = await this.$http.post('/api/dashboard/fetch',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('get about fail！')
            this.aboutMeForm.aboutme = r.obj.aboutMe
            this.aboutMeForm.bio = r.obj.bio
        },
        async getAboutImg() {
            if(this.isViewerMode == true){
                this.aboutMeForm.siteId = this.$route.params.id
            }else{this.aboutMeForm.siteId = window.localStorage.getItem("nowSiteId")}
            var temp = {siteId: this.aboutMeForm.siteId}
            var data2 = this.$qs.stringify(temp)
            const { data: re } = await this.$http.post('/api/home/get/gallery/aboutpic',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (re.message != "Success!") return this.$message.error('get aboutImg fail！')
            this.imgPath = re.obj
            
        },
        goSetting(){
            this.$router.push('/gallery/galleryAboutSetting')
        }
    }
}
</script>

<style lang="less" scoped>
#about-body .body-wrapper{
    width: 100%;
    height: 800px;
    text-align: center;
    word-wrap: break-word;
}
#about-body .profile-img{
    display: block;
    width: 500px;
    margin: 50px auto;
}
#about-body .title{
    font-size: 30px;
    height: 40px;
    line-height: 40px;
}
#about-body .content{
    width: 470px;
    font-size: 14px;
    margin: 40px auto;
}

</style>