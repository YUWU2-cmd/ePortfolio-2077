<template>
    <div id="home-body">
       <div class="body-wrapper">
        <div class="content-wrapper">
            <el-upload
                    style="margin-left: 30%; padding-right: 30%"
                    action="/api/home/upload/img"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :data="{siteId: 13}"
                    list-type="picture">
                    <el-button style="margin-left: 50px" size="small" type="primary">Upload</el-button>
                    <div slot="tip" class="el-upload__tip">jpg/png only，500kb limit</div>
                  </el-upload>
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
    methods: {
        handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      }
    }
}
</script>

<style lang="less" scoped>
#home-body .body-wrapper{
   width: 100%;
   height: 3130px;
}

#home-body .content-wrapper{
    width: 70%;
    padding-top: 20px;
    margin-left: 15%;
    height: 3130px;
}
#home-body .footer{

    width: 100%;
    height: 150px;
    top: 100%;
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