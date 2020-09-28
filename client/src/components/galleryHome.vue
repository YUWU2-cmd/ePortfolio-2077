<template>
    <div id="home-body">
       <div class="body-wrapper">
        <div class="content-wrapper">
            <div class="left-content">
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g1.jpeg" id="img1">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g3.jpg" id="img3">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g5.jpg" id="img5">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g7.jpg" id="img7">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g9.jpg" id="img9">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
            </div>

            <div class="right-content">
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g2.jpg" id="img2">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g4.jpg" id="img4">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g6.jpg" id="img6">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g8.jpg" id="img8">
                        <div class="img-title">I'm an image title.</div>
                    </div>
                </a>
                <a href="javascript:;" class="description">
                    <div class="img-wrapper">
                        <img src="../assets/g10.jpg" id="img10">
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
export default {}
</script>

<style lang="less" scoped>
#home-body .body-wrapper{
    position: relative;
}



#home-body .content-wrapper{
    width: 70%;
    padding-top: 20px;
    margin-left: 15%;
    height: 3100px;
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
    position: absolute;
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