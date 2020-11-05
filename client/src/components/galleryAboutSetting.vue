<template>
    <div id="about-body">
        <div class="body-wrapper">
            <el-upload
                class="avatar-uploader"
                action="/api/home/update/gallery/aboutpic"
                :data="{siteId: aboutMeForm.siteId}">
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <div class="title">About me</div>
            <p class="content">
                    <el-input
                    type="textarea"
                    maxlength="500"
                    :autosize="{ minRows: 4, maxRows: 7}"
                    placeholder="Please write something about yourself"
                    v-model="aboutMeForm.aboutme"
                    show-word-limit>
                    </el-input>
            </p>
             <el-button type="primary"  plain @click="handleUpload">upload</el-button>
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
        }
    },
     created() {
            this.getAboutData()
    },
    methods: {
      handleUpload(){
          this.upload()
      },
      //get some basic information of the site owner
      async getAboutData() {
            this.aboutMeForm.siteId = window.localStorage.getItem("nowSiteId")
            var tem = {siteId: this.aboutMeForm.siteId}
            var data1 = this.$qs.stringify(tem)
            const { data: r } = await this.$http.post('/api/dashboard/fetch',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (r.message != "Success!") return this.$message.error('get about fail！')
            this.aboutMeForm.aboutme = r.obj.aboutMe
            this.aboutMeForm.bio = r.obj.bio
        },
        async upload(){
            var data0 = this.$qs.stringify(this.aboutMeForm)
            const { data: res } = await this.$http.post('/api/home/update/classic/aboutme',data0, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (res.message != "Success!") return this.$message.error('upload fail！')
            this.$message.success('upload success！')
        },
    }
}
</script>

<style lang="less" scoped>
#about-body .body-wrapper{
    width: 100%;
    height: 800px;
    text-align: center;
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
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

</style>