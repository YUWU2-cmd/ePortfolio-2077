<template>
    <div id="projects-body">
    <div class="body-wrapper">
        <div class="title-wrapper">
            <i v-show="!isViewerMode" class="iconfont icon-setting" style="margin-left:98%; margin-top:30px; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <div class="content-wrapper">
                <div class="blue-dot"></div>
                <div class="title">Projects</div>
            </div>
            <div class="intro">{{projectForm.summary}}</div>
        </div>
        <div class="project-wrapper">
            <div class="project" id="proj1">
                <div class="left-content">
                    <div class="header">
                        <div class="proj-name">{{projectForm.projects[0].projectName}}</div>
                        <div class="role">{{projectForm.projects[0].position}}</div> 
                    </div>
                    <p class="content">

                        {{projectForm.projects[0].description}} </p>
                </div>
                <div class="right-content"> <img :src="projectForm.projects[0].image" alt=""/></div>
            </div>
            <div class="project" id="proj2">
                <div class="left-content">
                    <div class="header">
                        <div class="proj-name">{{projectForm.projects[1].projectName}}</div>
                        <div class="role">{{projectForm.projects[1].position}}</div> 
                    </div>
                    <p class="content">

                    {{projectForm.projects[1].description}}</p>
                </div>
                <div class="right-content"> <img :src="projectForm.projects[1].image " alt=""/></div>
            </div>
            <div class="project" id="proj3">
                <div class="left-content">
                    <div class="header">
                        <div class="proj-name">{{projectForm.projects[2].projectName}}</div>
                        <div class="role">{{projectForm.projects[2].position}}</div> 
                    </div>
                    <p class="content">

                        {{projectForm.projects[2].description}}</p>
                </div>
                <div class="right-content"> <img :src="projectForm.projects[2].image" alt=""/></div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
     data(){
        return {
            projectForm: {
                seriesName: 'ver2',
                summary:'1',
                projects:[
                    {
                        projectName: '',
                        description: 'go all2',
                        position: 'assasin2',
                        image: null
                    },
                    {
                        projectName: '',
                        description: 'now all2',
                        position: 'assasin32',
                        image: null
                    },
                    {
                        projectName: 'kkk',
                        description: 'now all3',
                        position: '333333333',
                        image: null
                    }
                    
                ],
                siteId:''
            },
            isViewerMode : false
        }
    },
    created() {
            this.verifyViewerMode()
            this.getProjectData()
    },
     methods:{
         goSetting(){
            this.$router.push('/classic/projectSetting')
        },
        verifyViewerMode(){
            if(typeof(this.$route.params.id) != "undefined"){ 
                this.isViewerMode = true 
            }
        },
        async getProjectData() {
            if(this.isViewerMode == true){
                this.projectForm.siteId = this.$route.params.id
            }else{this.projectForm.siteId = window.localStorage.getItem("nowSiteId")}
            var extem = {siteId: this.projectForm.siteId}
            var data1 = this.$qs.stringify(extem)
            
            const { data: re } = await this.$http.post('/api/home/get/classic/project',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (re.message != "Success!") return this.$message.error('get about fail！')
            this.projectForm = re.obj
        }
    }
}
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
    display: block;
    font-size: 17px;
    line-height: 1.5em;
    height: 7.5em;
    text-align: center;
    width: 668px;
    margin: 0 auto;
    color: #000000bd;
    word-wrap:break-word;
    overflow: hidden;
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
    word-wrap:break-word;
}

</style>