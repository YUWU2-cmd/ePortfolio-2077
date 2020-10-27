<template>
    <div id="contact-body">
        <div class="body-wrapper" >
            <div class="icon-title"><i class="iconfont icon-zhifeiji1"></i></div>
            <div class="title">Contact</div>
            <div class="info">{{email}} | Tel: {{phoneNumber}}</div>
            <div class="content-wrapper">
                <div class="label">Enter Your Name *</div>
                <div class="text-input">
                    <input v-model="contactForm.name" type="text">
                </div>
                <div class="label">Enter Your Email *</div>
                <div class="text-input">
                    <input v-model="contactForm.email" type="text">
                </div>
                <div class="label">Enter Your Phone</div>
                <div class="text-input">
                    <input v-model="contactForm.phone" type="text">
                </div>
                <div class="label">Enter Your Message Here *</div>
                <div class="message-input">
                    <textarea v-model="contactForm.message" id="message"></textarea>
                </div>
                <div class="submit-btn">
                    <button>Submit</button>
                </div>
            </div>
        </div>
        <div v-show="!isViewerMode" class="views">Views: {{views}}</div>
    </div>
</template>

<script>
export default {
     data () {
        return {
            contactForm: {
                name: '',
                email: '',
                subject: '',
                message: ''
            },
            phoneNumber: '',
            email: '',
            isViewerMode : false,
            views: '',
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
            }
        },
        async getUserData() {
                if(this.isViewerMode == true){
                    this.siteId = this.$route.params.id
                }else{this.siteId = window.localStorage.getItem("nowSiteId")}
                var temp = {siteId: this.siteId}
                var data2 = this.$qs.stringify(temp)
                const { data: re } = await this.$http.post('/api/dashboard/fetch',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
                if (re.message != "Success!") return this.$message.error('get logged fail！')
                this.views = re.obj.visit
                this.phoneNumber = re.obj.user.phoneNumber
                this.email = re.obj.user.email
            }
    }
     
}
</script>

<style lang="less" scoped>
#contact-body .body-wrapper{
    height: 900px;
    width: 100%;
}
#contact-body .icon-title{
    width: 230px;
    height: 140px;
    line-height: 126px;
    margin: 10px auto;
    text-align: center;
}
#contact-body .icon-title i{
    font-size: 125px;
}
#contact-body .title{
    width: 460px;
    height: 40px;
    font-size: 30px;
    line-height: 40px;
    margin: 20px auto;
    text-align: center;
}
#contact-body .info{
    width: 460px;
    height: 20px;
    font-size: 15px;
    margin: 20px auto;
    text-align: center;
}
#contact-body .content-wrapper{
    width: 480px;
    height: 490px;
    margin: 40px auto;
    box-sizing: border-box;
    /* background-color: pink; */
}
#contact-body .content-wrapper .label{
    width: 100%;
    height: 15px;
    font-size: 15px;
    line-height: 15px;
    margin-bottom: 15px;
}
#contact-body .content-wrapper .text-input input{
    width: 460px;
    height: 38px;
    margin-bottom: 15px;
    font-size: 13px;
    box-sizing: border-box;
    padding-left: 13px;
    background-color: #f4f3f2;
    border: 1px solid rgba(255, 255, 255, 1);
}
#contact-body .content-wrapper .text-input input:hover,
#contact-body .content-wrapper .text-input input:focus,
#contact-body .content-wrapper .message-input textarea:hover,
#contact-body .content-wrapper .message-input textarea:focus{
    background-color: rgba(255, 255, 255, 1);
    border: 1px solid rgba(182, 182, 182, 0.507);
}
#contact-body .content-wrapper .message-input textarea{
    width: 460px;
    height: 130px;
    box-sizing: border-box;
    padding: 13px;
    resize: none;
    background-color: #f4f3f2;
    border: 1px solid #f4f3f2;
}

#contact-body .content-wrapper .submit-btn button{
    width: 460px;
    height: 40px;
    margin-top: 20px;
    cursor: pointer;
    background-color: rgba(65, 65, 65, 1);
    color: #fff;
    border: solid transparent 0px;
    font-size: 14px;
}
#contact-body .content-wrapper .submit-btn button:hover{
    background-color: rgba(244, 243, 242, 1);
    border-color: rgba(65, 65, 65, 1);
    color: #414141;
    transition: border-color 0.4s ease 0s, background-color 0.4s ease 0s;
}
#contact-body .views{
    text-align: center;
    font-size: 18px;
    font-weight: bold;
    padding-bottom: 50px;
}
</style>