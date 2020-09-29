<template>
    <div id="projects-body">
    <div class="body-wrapper">
        <div class="title-wrapper">
            <div class="content-wrapper">
                <div class="blue-dot"></div>
                <div class="title">Projects</div>
            </div>
            <p class="intro">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam luctus quam ut tristique pretium. Quisque sed arcu enim. Pellentesque quis ornare risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla quis egestas ligula. Cras congue fringilla dolor, in molestie lorem placerat nec. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut luctus pellentesque ultrices. </p>
        </div>
        <div class="project-wrapper">
            <div class="project" id="proj1">
                <div class="left-content">
                    <div class="header">
                        <div class="proj-name">Project name 01</div>
                        <div class="role">Role Title</div> 
                    </div>
                    <p class="content">

                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam luctus quam ut tristique pretium. Quisque sed arcu enim. Pellentesque quis ornare risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla quis egestas ligula. Cras congue fringilla dolor, in molestie lorem placerat nec. </p>
                </div>
                <div class="right-content"> <img src="../assets/p1.jpg" alt=""/></div>
            </div>
            <div class="project" id="proj2">
                <div class="left-content">
                    <div class="header">
                        <div class="proj-name">Project name 02</div>
                        <div class="role">Role Title</div> 
                    </div>
                    <p class="content">

                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam luctus quam ut tristique pretium. Quisque sed arcu enim. Pellentesque quis ornare risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla quis egestas ligula. Cras congue fringilla dolor, in molestie lorem placerat nec. </p>
                </div>
                <div class="right-content"> <img src="../assets/p2.jpg" alt=""/></div>
            </div>
            <div class="project" id="proj3">
                <div class="left-content">
                    <div class="header">
                        <div class="proj-name">Project name 03</div>
                        <div class="role">Role Title</div> 
                    </div>
                    <p class="content">

                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam luctus quam ut tristique pretium. Quisque sed arcu enim. Pellentesque quis ornare risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla quis egestas ligula. Cras congue fringilla dolor, in molestie lorem placerat nec. </p>
                </div>
                <div class="right-content"> <img src="../assets/p3.jpg" alt=""/></div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {}
</script>

<style lang="less" scoped>
#projects-body .body-wrapper{
    
    background-color: #e6dace;
    width: 100%;
    height: 1900px;
}

#projects-body .title-wrapper{
    height: 400px;
    width: 100%;
    overflow: hidden;
}
#projects-body .title-wrapper .content-wrapper{
    width: 180px;
    height: 50px;
    margin: 80px auto;
}
#projects-body .title-wrapper .content-wrapper .blue-dot{
    float: left;
    width: 20px;
    height: 20px;
    background-color: rgba(0, 80, 255, 1);
    margin-top: 15px;
}
#projects-body .title-wrapper .content-wrapper .title{
    float: left;
    font-size: 35px;
    font-weight: bold;
    line-height: 1.33em;
    margin-left: 8px;
}
#projects-body .title-wrapper .intro{
    font-size: 17px;
    line-height: 1.5em;
    text-align: center;
    width: 668px;
    margin: 0 auto;
    color: #000000bd;
}
#projects-body .project-wrapper{
    width: 750px;
    height: 1400px;
    margin: 0 auto;
}
#projects-body .project-wrapper .project{
    width: 100%;
    height: 400px;
    background-color: #fff;
    box-shadow: -5px 5px 17px 0px rgba(138,131,124,0.23);
    margin-bottom: 100px;
}

#projects-body .project-wrapper .project .left-content{
    float: left;
    width: 428px;
    height: 100%;
    overflow: hidden;
}
#projects-body .project-wrapper .project .right-content{
    float: left;
    width: 322px;
    height: 100%;
    background-size: 322px 400px;
    overflow: hidden;
     img {
      width: 100%;
      height: 100%;
    }
}

#projects-body .project-wrapper .project .left-content .header{
    width: 100%;
    height: 50px;
    margin-top: 60px;
    border-left: 10px #0050ff solid;
    box-sizing: border-box;
    padding: 0 30px;
}
#projects-body .project-wrapper .project .left-content .header .proj-name{
    font-size: 20px;
    height: 30px;
    font-weight: 800;
    color: #0050ff;
}
#projects-body .project-wrapper .project .left-content .header .role{
    height: 20px;
    font-size: 17px;
    color: #000000b9;
}
#projects-body .project-wrapper .project .left-content .content{
    width: 366px;
    font-size: 17px;
    line-height: 1.5em;
    color: #000000b9;
    margin: 30px auto 0;
}

</style>