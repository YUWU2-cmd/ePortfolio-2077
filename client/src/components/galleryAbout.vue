<template>
    <div id="about-body">
        <div class="body-wrapper">
            <i class="iconfont icon-setting" style="margin-left:98%; margin-bottom:30px; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <img src="../assets/profile-img2.jpg" class="profile-img">
            <div class="title">About me</div>
            <p class="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec rutrum neque, sit amet consectetur nisi. Cras vel arcu dui. Vestibulum purus sem, facilisis at volutpat sit amet, viverra vitae tortor. Sed scelerisque dui sed cursus facilisis. Vestibulum et sodales est. Sed hendrerit non felis at auctor. Nunc maximus posuere lorem, non molestie neque lobortis in. Cras sem ante, gravida quis fermentum nec, consequat at augue. </p>
        </div>
    </div>
</template>

<script>
export default {
    methods: {
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