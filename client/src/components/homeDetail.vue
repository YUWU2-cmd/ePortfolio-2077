<template>
    <div>
                <div class="main-block">
            <div class="aboutme">
                &nbsp;About Me
                <i class="iconfont icon-about" style="font-weight: normal; font-size: 18px; color: #3899ec;"></i>
            </div>
            <div id="aboutme-content">{{aboutme}}</div>
            <div class="myexpertise">&nbsp;My Expertise
                <i class="iconfont icon-_gexingtechang" style="font-weight: normal; font-size: 22px; color:#3899ec;"></i>
            </div>
            <div id="myexpertise-content">
                <div class="left-expertise">
                    <div class="expertises">
                        <i class="iconfont icon-zhuanye2" style="font-weight: normal; font-size: 20px; color:#3899ec;"></i>
                        <div id="expertise1">{{expertise1}}</div>
                    </div>
                    <div class="expertises">
                        <i class="iconfont icon-zhuanyequanwei" style="font-weight: normal; font-size: 20px; color:#3899ec;"></i>
                        <div id="expertise1">{{expertise2}}</div>
                    </div>
                </div>
                <div class="right-expertise">
                    <div class="expertises">
                        <i class="iconfont icon-zhuanyegaoxiao" style="font-weight: normal; font-size: 20px; color:#3899ec;"></i>
                        <div id="expertise1">{{expertise3}}</div>
                    </div>
                    <div class="expertises">
                        <i class="iconfont icon-zhuanye1" style="font-weight: normal; font-size: 20px; color:#3899ec;"></i>
                        <div id="expertise1">{{expertise4}}</div>
                    </div>
                </div>
                
            </div>
        </div>
        <div class="side-block">
            <div class="side-top">
              <div class="image">
                 &nbsp;Images
                 <i class="iconfont icon-picture" style="font-weight: normal; font-size: 20px; color:#3899ec;"></i>
              </div>
                <div id="img-wrapper">
                  <div class="block">
                      <el-carousel height="400px">
                        <el-carousel-item v-for="item in 4" :key="item">
                         <el-image
                          style="width: 100%; height: 100%"
                          src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
                          fit="cover"></el-image>
                        </el-carousel-item>
                      </el-carousel>
                  </div>
                  {{img_info}}
                </div>
              
            </div>
            <div class="side-bottom">
                <div class="contacts">
                    &nbsp;Contacts
                    <i class="iconfont icon-contacts" style="font-weight: normal; font-size: 20px; color:#3899ec;"></i>
                </div>
                <div id="contacts-content">
                  <h5>Email:</h5>
                    </br>
                  <h5>Address:</h5>
                   </br>
                {{contacts}}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
    return {
      username:"default",
      sign:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum id arcu enim. Cras vel orci. ",
      aboutme:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum sodales quam vel ullamcorper. Donec tortor lacus, auctor ultrices odio sed, posuere posuere massa. Sed id eleifend nunc. Sed placerat luctus urna ut malesuada. Donec dui elit, auctor id venenatis eu, consequat eget ante. Morbi in diam justo. Nam ac semper dui, quis commodo mi. Phasellus eleifend lorem sit amet metus pretium, vel laoreet mauris lacinia. Quisque eleifend commodo imperdiet. Ut vestibulum semper nisl eget gravida. Nam cursus quis nulla id varius. Curabitur euismod iaculis diam non consectetur. Etiam quis elit mattis, egestas lorem nec, finibus mauris. Ut quis augue sem. Aenean viverra ligula ut ex consectetur semper. Fusce euismod orci maximus, tincidunt magna a, euismod ligula. ",
      expertise1:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum sodales quam vel ullamcorper. Donec tortor lacus, auctor ultrices odio sed, posuere posuere massa. Sed id eleifend nunc. Sed placerat luctus urna ut malesuada. Donec dui elit, auctor id venenatis eu, consequat eget ante. Morbi in diam justo. Nam ac semper dui, quis commodo mi. Phasellus eleifend lorem sit amet metus pretium, vel laoreet mauris lacinia. Quisque eleifend commodo imperdiet. Ut vestibulum semper nisl eget gravida. Nam cursus quis nulla id varius. Curabitur euismod iaculis diam non consectetur. Etiam quis elit mattis, egestas lorem nec, finibus mauris. Ut quis augue sem. Aenean viverra ligula ut ex consectetur semper. Fusce euismod orci maximus, tincidunt magna a, euismod ligula. ",
      expertise2:"",
      expertise3:"",
      expertise4:"",
      img_url:"",
      img_info:"image description",
      contacts:""
    }
  }

}
</script>

<style lang="less" scoped>
.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;

  }
.topbar-wrapper{
    position: relative;
    height: 90px;
    background-color: #fff;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,.025);
    z-index: 99;
}

.topbar .topbar-main{
    position: absolute;
    height: 60px;
    left: 50%;
    top: 13px;
    text-decoration: none;
    transform: translate(-50%,0);
     
}
.topbar .logo{
    float: left;
    width: 42px;
    height: 42px;
    border: 1px  #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 1px gray;
    img {
      width: 100%;
      height: 100%;
    }
    
}
.topbar .title{
    float: left;
    top: 10px;
    margin: 10px 20px;
    color: rgb(65, 65, 65);
    line-height: 42px;
    font-size: 28px;
    font-weight: bold;
    
}
.topbar .title:hover{
    color: #3899ec;
}
.topbar .user-avatar{
    text-decoration: none;
    background-size: 38px 38px;
    width: 38px;
    height: 38px;
    border-radius: 100%;

    border: 2px solid rgba(0,0,0,.1);
     img {
      width: 100%;
      height: 100%;
       border-radius: 50%;
    }
}
.topbar .block{
    position: absolute;
    height: 50px;
    width: 38px;
    left: 90%;
    top: 23px;

}

.topbar-side{
   position: absolute;
    left: 90%;
    top:28px;
}
.topbar-side .dropdown-menu{
    display: none;
    box-sizing: border-box;
    width: 170px;
    height: 140px;
    border: 1px rgba(212, 212, 212, .6) solid;
    border-radius: .2em;
    background-color: #fff;
}
.home-container {
  height: 1421px;
  background-color: #f0f4f7;
  font-family: fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
}

.dropdown-menu a{
    display: block;
    height: 50px;
    width: 169px;
    text-decoration: none;
    color: rgb(65, 65, 65);
    text-align: center;
    line-height: 50px;
}

.body-wrapper{
    position: relative;
    margin: 0 auto;
    width: 1280px;
    height: 1270px;
    background-color: #fff;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,0.025);
    border: 2px rgba(212, 212, 212, .5) solid;
    border-top: none;
    
}
.user-banner{
    width: 100%;
    height: 200px;
    background-color: #0a0a41c5;
    background-size: 1280px 200px;
}
.user-banner .setting a{
    display: block;
    position: absolute;
    right: 20px;
    top: 15px;
    text-decoration: none;
    color: rgba(255, 255, 255, 0.8);
}
.user-banner .info{
    position: absolute;
    top: 100px;
    left: 40px;
    width: 90%;
    height: 90px;
}
.info .user-avatar{
    float: left;
    width: 65px;
    height: 65px;
    background-color: #fff;
    background-size: 65px 65px;
    background-position: 1px -1px;
    border: 2px solid rgba(0,0,0,.1);
    border-radius: 50%;
     img {
      width: 100%;
      height: 100%;
       border-radius: 50%;
    }
}
.info .text-info{
    float: left;
    margin-left: 30px;
    padding-top: 10px;
}
.info .user-name{
    color: #fff;
    height: 20px;
    font-size: 20px;
    font-weight: bold;
    line-height: 20px;
    margin-bottom: 10px;
}
.info .sign{
    color: rgba(255,255,255,.8);
    height: 16px;
    font-size: 16px;
    line-height: 16px;
}
.user-tab{
    height: 70px;
    width: 100%;
    background-color: rgba(155, 155, 155, 0.3);
}

 .views{
    float: right;
    margin: 15px 30px;
    font-size: 15px;
    line-height: 15px;
    text-align: center;
}
.views .text{
    color: rgba(0,0,0,.4);
    margin-bottom: 4px;
}

 .interested{
    float: right;
    margin-right: 60px;
    margin-top: 15px;
    font-size: 15px;
    line-height: 15px;
    text-align: center;
}
.interested .text{
    color: rgba(0,0,0,.4);
    margin-bottom: 4px;
}

.user-tab .home{
    display: block;
    text-decoration: none;
    text-align:center;
    float: left;
    height: 70px;
    width: 180px;
    padding: 5px 20px;
    font-weight: bold;
    font-size: 15px;
    color: rgba(0, 0, 0, 0.6);
}
.user-tab .moreAboutMe{
    display: block;
    text-decoration: none;
    text-align:center;
    float: left;
    height: 70px;
    width: 210px;
    padding: 5px 20px;
    font-weight: bold;
    font-size: 15px;
    color: rgba(0, 0, 0, 0.6);
}

.main-block{
    position: absolute;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    left: 20px;
    top: 290px;
    width: 65%;
    height: 900px;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,0.025);
    border: 2px rgba(212, 212, 212, .5) solid;
    padding: 10px 20px;
}
.main-block .aboutme{
    height: 50px;
    font-size: 20px;
    font-weight: bold;
    line-height: 50px;
    border-bottom: 2px solid rgba(0,0,0,.05);
}
.main-block #aboutme-content{
    overflow: auto;
    padding: 1.5em 0;
    border-bottom: 2px solid rgba(0,0,0,.05);
    font-size: 15px;
    line-height: 1.5;
    height: 200px;
}
.main-block .myexpertise{
    margin: 20px 0;
    height: 50px;
    font-size: 20px;
    font-weight: bold;
    line-height: 50px;
    border-bottom: 2px solid rgba(0,0,0,.05);
}
#myexpertise-content{
    font-size: 16px;
    line-height: 1.5;
}
#myexpertise-content .left-expertise{
    display: flex;
    float: left;
    flex-direction: column;
    width: 48.5%;
    margin-right: 1.5%;
    height: 450px;
}
#myexpertise-content .right-expertise{
    display: flex;
    float: left;
    flex-direction: column;
    width: 48.5%;
    margin-left: 1.5%;
    height: 450px;
}
#myexpertise-content .expertises{
    overflow: auto;
    height: 50%;
    width: 100%;
    margin-top: 10px;
    border: 2px solid rgba(0,0,0,.05);
}

.side-bottom .contacts{
    font-size: 20px;
    font-weight: bold;
    width: 90%;
    height: 50px;
    line-height: 50px;
    border-bottom: 2px solid rgba(0,0,0,.05);
    margin: 0 auto;
}
.side-bottom #contacts-content{
    height: 230px;
    width: 90%;
    margin: 15px auto;
}
.side-block .image{
    font-size: 20px;
    font-weight: bold;
    width: 90%;
    height: 50px;
    line-height: 50px;
    border-bottom: 2px solid rgba(0,0,0,.05);
    margin: 0 auto;
}
.side-block .side-top{
    position: absolute;
    right: 20px;
    top: 290px;
    width: 30%;
    height: 550px;
    border: 2px rgba(212, 212, 212, .5) solid;
}
.side-block .side-bottom{
    position: absolute;
    right: 20px;
    top: 870px;
    width: 30%;
    height: 320px;
    border: 2px rgba(212, 212, 212, .5) solid;
}
.side-top #img-wrapper{
    width: 370px;
    height: 450px;
    margin: 20px auto;
}



.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
     background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }

</style>