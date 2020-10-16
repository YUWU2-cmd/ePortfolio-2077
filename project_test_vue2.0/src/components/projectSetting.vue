<template>
    <div id="projects-body">
    <div class="body-wrapper">
        <div class="title-wrapper">
            <div class="content-wrapper">
                <div class="blue-dot"></div>
                <div class="title">Projects</div>
            </div>
            <p class="intro">
                    <el-input
                    type="textarea"
                    :autosize="{ minRows: 5, maxRows: 5}"
                    placeholder="Please write something about yourself"
                    v-model="projectForm.summary">
                    </el-input>
            </p>
        </div>
        <div class="project-wrapper">
            <div class="project" id="proj1">
                <div class="left-content">
                    <div class="header">
                        <el-input placeholder="Please write something about yourself" v-model="projectForm.projects[0].projectName"></el-input>
                        <el-input placeholder="Please write something about yourself" v-model="projectForm.projects[0].position"></el-input>
                    </div>
                    <p class="content">

                        <el-input
                        type="textarea"
                        :autosize="{ minRows: 6, maxRows: 8}"
                        placeholder="Please write something about yourself"
                        v-model="projectForm.projects[0].description">
                        </el-input>
                    </p>
                </div>
                <div class="right-content"> 
                    <el-upload
                        style="margin-top: 35px; padding-right: 10%"
                        action="/api/home/upload/img"
                        :on-success="handleSuccess1"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :data="{siteId: projectForm.siteId}"
                        list-type="picture">
                        <el-button style="margin-left: 50px" size="small" type="primary">Upload</el-button>
                        <div slot="tip" class="el-upload__tip">jpg/png only，500kb limit</div>
                  </el-upload>
                </div>
            </div>
            <div class="project" id="proj2">
                <div class="left-content">
                    <div class="header">
                         <el-input placeholder="Please write something about yourself" v-model="projectForm.projects[1].projectName"></el-input>
                        <el-input placeholder="Please write something about yourself" v-model="projectForm.projects[1].position"></el-input>
                    </div>
                    <p class="content">

                         <el-input
                        type="textarea"
                        :autosize="{ minRows: 6, maxRows: 8}"
                        placeholder="Please write something about yourself"
                        v-model="projectForm.projects[1].description">
                        </el-input>
                    </p>
                </div>
                <div class="right-content">  
                        <el-upload
                            style="margin-top: 35px; padding-right: 10%"
                            action="/api/home/upload/img"
                            :on-success="handleSuccess2"
                            :on-preview="handlePreview"
                            :on-remove="handleRemove"
                            :data="{siteId: projectForm.siteId}"
                            list-type="picture">
                            <el-button style="margin-left: 50px" size="small" type="primary">Upload</el-button>
                            <div slot="tip" class="el-upload__tip">jpg/png only，500kb limit</div>
                    </el-upload>
                  </div>
            </div>
            <div class="project" id="proj3">
                <div class="left-content">
                    <div class="header">
                        <el-input placeholder="Please write something about yourself" v-model="projectForm.projects[2].projectName"></el-input>
                        <el-input placeholder="Please write something about yourself" v-model="projectForm.projects[2].position"></el-input>
                    </div>
                    <p class="content">

                         <el-input
                        type="textarea"
                        :autosize="{ minRows: 6, maxRows: 8}"
                        placeholder="Please write something about yourself"
                        v-model="projectForm.projects[2].description">
                        </el-input>
                    </p>
                </div>
                <div class="right-content">  
                    <el-upload
                        style="margin-top: 35px; padding-right: 10%"
                        action="/api/home/upload/img"
                        :on-success="handleSuccess3"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :data="{siteId: projectForm.siteId}"
                        list-type="picture">
                        <el-button style="margin-left: 50px" size="small" type="primary">Upload</el-button>
                        <div slot="tip" class="el-upload__tip">jpg/png only，500kb limit</div>
                    </el-upload>
                  </div>
                <el-button type="primary" style="margin-left: 43%; margin-top: 15px" plain @click="upload">upload</el-button>
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
                        projectName: 'Project name 01',
                        description: 'Lorem ipsum dolor sit amet',
                        position: 'Role Title',
                        image: null
                    },
                    {
                        projectName: 'Project name 02',
                        description: 'Lorem ipsum dolor sit amet',
                        position: 'Role Title',
                        image: null
                    },
                    {
                        projectName: 'Project name 03',
                        description: 'Lorem ipsum dolor sit amet',
                        position: 'Role Title',
                        image: null
                    }
                ],
                siteId:''
            },
        }
    },
    created() {
            this.getProjectData()
    },
     methods:{
          handleRemove(file, fileList) {
        console.log(file, fileList);
        },
        handlePreview(file) {
            console.log(file);
        },
        handleSuccess1(response, file, fileList) {
            this.projectForm.projects[0].image = response.obj;
        },
        handleSuccess2(response, file, fileList) {
            this.projectForm.projects[1].image = response.obj;
        },
        handleSuccess3(response, file, fileList) {
            this.projectForm.projects[2].image = response.obj;
        },
        async upload(){
            this.projectForm.siteId = window.localStorage.getItem("nowSiteId")
            const { data: res } = await this.$http.post('/api/home/update/classic/project',this.projectForm)
            if (res.message != "Success!") return this.$message.error('upload fail！')
            this.$message.success('upload success！')
        },
        async getProjectData() {
            this.projectForm.siteId = window.localStorage.getItem("nowSiteId")
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
    margin-top: 60px;
}

</style>