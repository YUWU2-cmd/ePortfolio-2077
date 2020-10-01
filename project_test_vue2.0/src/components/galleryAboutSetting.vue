<template>
    <div id="about-body">
        <div class="body-wrapper">
            <el-upload
                action="/api/home/upload/img"
                list-type="picture-card"
                :on-preview="handlePictureCardPreview"
                :on-remove="handleRemove"
                :data="{siteId: 13}">
                <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
                <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
            <div class="title">About me</div>
            <p class="content">
                    <el-input
                    type="textarea"
                    :autosize="{ minRows: 4, maxRows: 7}"
                    placeholder="Please write something about yourself"
                    v-model="aboutme">
                    </el-input>
            </p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return{
            aboutme: '1',
            dialogImageUrl: '',
            dialogVisible: false
        }
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = false;
      }
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

</style>