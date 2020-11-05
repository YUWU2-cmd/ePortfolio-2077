<!-- contact page for classic template -->
<template>
    <div id="contact-body">
        <div class="body-wrapper" >
        <div class="title-wrapper">
            <div class="content-wrapper">
                <div class="blue-dot"></div>
                <div class="title">Let's Talk!</div>
            </div>
        </div>
        <!-- email content -->
        <div class="contact-form">
            <div class="form">
                <div class="sender">
                    <div class="name">
                        <div class="label">Name</div>
                        <input v-model="contactForm.name" type="text" maxlength="30">
                    </div>
                    <div class="email">
                        <div class="label">Email</div>
                        <input v-model="contactForm.viewerEmail" type="text" maxlength="40">
                    </div>
                </div>
                
                <div class="message">
                    <div class="label">Message</div>
                    <textarea v-model="contactForm.content" id="message-input" maxlength="400"></textarea>
                </div>
                <div class="send-btn">
                    <button id="send" style="cursor: pointer;" @click="send">SEND</button>
                </div>
            </div>
        </div>
        <!-- contact info -->
        <div class="footer">
            <div class="email">
                <div class="title">Email <i class="iconfont icon-22"></i></div>
                <div class="content">{{email}}</div>
            </div>
            <div class="call">
                <div class="title">Call <i class="iconfont icon-dianhua"></i></div>
                <div class="content">{{phoneNumber}}</div>
            </div>
            <div v-show="!isViewerMode" class="views">Views: {{views}}</div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            contactForm: {
                viewerEmail: '',
                ownerEmail: '',
                name: '',
                phone: '',
                content: ''
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
        },
        async send(){
            this.contactForm.ownerEmail = this.email
            const { data: res } = await this.$http.post('/api/user/contact',this.contactForm)
            if (res.message != "Success!") return this.$message.error('upload fail！')
            this.$message.success('upload success！')
        },
     }
}
</script>

<style lang="less" scoped>

#contact-body .body-wrapper{
    position: relative;
    height: 933px;
    width: 100%;
    background-color:#e6dace;
}
#contact-body .title-wrapper{
    height: 200px;
    width: 100%;
    overflow: hidden;
}
#contact-body .title-wrapper .content-wrapper{
    width: 200px;
    height: 50px;
    margin: 80px auto;
}
#contact-body .title-wrapper .content-wrapper .blue-dot{
    float: left;
    width: 20px;
    height: 20px;
    background-color: rgba(0, 80, 255, 1);
    margin-top: 15px;
}
#contact-body .title-wrapper .content-wrapper .title{
    float: left;
    font-size: 35px;
    font-weight: bold;
    line-height: 1.33em;
    margin-left: 8px;
}
#contact-body .contact-form{
    width: 680px;
    height: 550px;
    background-color: #fff;
    box-shadow: -5px 5px 17px 0px rgba(138,131,124,0.23);
    margin: 0 auto;
    box-sizing: border-box;
    padding: 60px 0;
}
#contact-body .footer{
    position: fixed;
    background-color: #fff;
    height: 80px;
    width: 100%;
    bottom: 0;
    box-shadow: 0 0 10px 0px rgba(209, 205, 201, 0.774);
}
#contact-body .footer .email,
#contact-body .footer .call{
    float: right;
    width: 250px;
    height: 100%;
    margin-right: 40px;
    text-align: center;
    font-size: 14px;
    box-sizing: border-box;
    padding: 20px 10px;
    overflow: visible;
}
#contact-body .footer .views{
    float: left;
    width: 250px;
    height: 100%;
    margin-right: 80px;
    text-align: center;
    font-size: 18px;
    font-weight: bold;
    box-sizing: border-box;
    padding: 20px 10px;
    overflow: visible;
}
#contact-body .footer .title{
    font-weight: bold;
}
#contact-body .footer .content{
    width: 100%;
    margin-top: 10px;
}
#contact-body .contact-form .form{
    position: relative;
    width: 550px;
    height: 430px;
    margin: 0 auto;
}
#contact-body .contact-form .form .sender{
    width: 100%;
    height: 66px;
}
#contact-body .contact-form .form .sender .name{
    float: left;
    width: 250px;
    height: 100%;
}
#contact-body .contact-form .form .sender .email{
    float: left;
    margin-left: 50px;
    width: 250px;
    height: 100%;
}
#contact-body .contact-form .form .label{
    font-size: 17px;
    line-height: 17px;
    height: 17px;
    color: #000000a8;
    font-weight: bold;
}
#contact-body .contact-form .form .sender input{
    width: 240px;
    height: 40px;
    margin-top: 10px;
    border: 0;
    outline: 0;
    background: transparent;
    border-bottom: 2px solid #000000a8;
    box-sizing: border-box;
    padding-left: 15px;
    font-size: 17px;
}
#contact-body .contact-form .form .subject,
#contact-body .contact-form .form .message{
    width: 100%;
    height: 66px;
    margin-top: 60px;
}
#contact-body .contact-form .form .subject input{
    width: 540px;
    height: 40px;
    margin-top: 10px;
    border: 0;
    outline: 0;
    background: transparent;
    border-bottom: 2px solid #000000a8;
    box-sizing: border-box;
    padding-left: 15px;
    font-size: 17px;
}
#contact-body .contact-form .form .message #message-input{
    width: 540px;
    height: 100px;
    margin-top: 10px;
    border: 0;
    outline: 0;
    background: transparent;
    border-bottom: 2px solid #000000a8;
    box-sizing: border-box;
    padding: 15px;
    font-size: 17px;
    resize: none;
}

#contact-body .contact-form .form input:hover,
#contact-body .contact-form .form input:focus,
#contact-body .contact-form .form .message #message-input:hover,
#contact-body .contact-form .form .message #message-input:focus{
    border-bottom: 2px solid#0050FF;
}

#contact-body .contact-form .form .send-btn #send{
    position: absolute;
    width: 115px;
    height: 35px;
    bottom: 5px;
    right: 10px;
    border-radius: 100px;
    background-color: #0050ff;
    border: 2px solid #0050ff;
    color: #fff;
    font-weight: bold;
    font-size: 14px;
    transition: border-color 0.4s ease 0s, background-color 0.4s ease 0s;
}
#contact-body .contact-form .form .send-btn #send:hover{
    color: black;
    background-color: #fff;
}
</style>