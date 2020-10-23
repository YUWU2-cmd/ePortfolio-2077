<template>
    <div id="more-body">
   <div class="body-wrapper">
        <div class="title-wrapper">
            <i class="iconfont icon-setting" style="margin-left:98%; margin-top:30px; font-size: 25px; color: rgba(0,0,0,0.3); cursor: pointer" @click="goSetting"></i>
            <div class="content-wrapper">
                <div class="blue-dot"></div>
                <div class="title">More About Me</div>
            </div>
        </div>
        <div class="experience-wrapper">
            <div class="title">Experience</div>
            <div class="exp1">
                <div class="left-content">
                    <div class="duration">{{experienceForm.experiences[0].duration}}</div>
                    <div class="job">{{experienceForm.experiences[0].position}}</div>
                    <div class="company">{{experienceForm.experiences[0].companyName}}</div>
                    <div class="location">{{experienceForm.experiences[0].companyLocation}}</div>
                </div>
                <div class="right-content">
                    
                    {{experienceForm.experiences[0].description}}</div>
            </div>
            <div class="exp2">
                <div class="left-content">
                    <div class="duration">{{experienceForm.experiences[1].duration}}</div>
                    <div class="job">{{experienceForm.experiences[1].position}}</div>
                    <div class="company">{{experienceForm.experiences[1].companyName}}</div>
                    <div class="location">{{experienceForm.experiences[1].companyLocation}}</div>
                </div>
                <div class="right-content">
                   {{experienceForm.experiences[1].description}} 
                </div>
            </div>
        </div>
        <div class="education-wrapper">
            <div class="title">Education</div>
            <div class="exp1">
                <div class="left-content">
                    <div class="duration">{{educationForm.educations[0].duration}}</div>
                    <div class="job">{{educationForm.educations[0].schoolName}}</div>
                    <div class="company">{{educationForm.educations[0].degree}}</div>
                    <div class="location">{{educationForm.educations[0].schoolLocation}}</div>
                </div>
                <div class="right-content">
                    
                    {{educationForm.educations[0].description}}</div>
            </div>
            <div class="exp2">
                <div class="left-content">
                    <div class="duration">{{educationForm.educations[1].duration}}</div>
                    <div class="job">{{educationForm.educations[1].schoolName}}</div>
                    <div class="company">{{educationForm.educations[1].degree}}</div>
                    <div class="location">{{educationForm.educations[1].schoolLocation}}</div>
                </div>
                <div class="right-content">
                    {{educationForm.educations[1].description}}
                </div>
            </div>
        </div>
        <div class="expertise-wrapper">
            <div class="title">Professional Skillset</div>
            <div class="expertises1">
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.proList[0]}}</div>
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.proList[1]}}</div>
            </div>
            <div class="expertises2">
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.proList[2]}}</div>
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.proList[3]}}</div>
            </div>

            <div class="title" id="skills-title">Additional Skills</div>
            <div class="expertises1">
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.addList[0]}}</div>
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.addList[1]}}</div>
            </div>
            <div class="expertises2">
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.addList[2]}}</div>
                <div class="blue-dot"></div>
                <div class="skill">{{skillForm.addList[3]}}</div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
     data(){
        return {
            experienceForm: {
                experiences:[
                    {
                        duration:'1999-2000',
                        position:'1',
                        companyName:'3',
                        companyLocation:'4',
                        description:''
                    },
                    {
                        duration:'1999-2000',
                        position:'2',
                        companyName:'www',
                        companyLocation:'g',
                        description:'wdw'
                    }
                ],
                siteId:''
                 
            },
           educationForm: {
               educations:[
                    {
                        duration:'1999-2000',
                        schoolName:'ds',
                        degree:'3',
                        schoolLocation:'4',
                        description:''
                    },
                    {
                        duration:'1999-2000',
                        schoolName:'ddd',
                        degree:'35',
                        schoolLocation:'ffff',
                        description:'qqq'
                    }
               ],
               siteId:''
           },
            skillForm:{
                proList:["a","b","c","d"],
                addList:['1','2','3','4'],
                siteId:''
            }
            
            

        }
    },
    created() {
            this.getExperienceData()
            this.getEducationData()
            this.getSkillData()
    },
     methods:{
         goSetting(){
            this.$router.push('/classic/moreSetting')
        },
        async getExperienceData() {
            this.experienceForm.siteId = window.localStorage.getItem("nowSiteId")
            var extem = {siteId: this.experienceForm.siteId}
            var data1 = this.$qs.stringify(extem)
            
            const { data: aa } = await this.$http.post('/api/home/get/classic/experience',data1, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (aa.message != "Success!") return this.$message.error('get about fail！')
            if(aa.obj.experiences.length != 0){
                this.experienceForm = aa.obj
            }
            
        },
        async getEducationData() {
            this.educationForm.siteId = window.localStorage.getItem("nowSiteId")
            var edtem = {siteId: this.educationForm.siteId}
            var data2 = this.$qs.stringify(edtem)
            
            const { data: bb } = await this.$http.post('/api/home/get/classic/education',data2, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (bb.message != "Success!") return this.$message.error('get about fail！')
            
            if (bb.obj.educations.length != 0){
                this.educationForm = bb.obj
            }
        },
        async getSkillData() {
            this.skillForm.siteId = window.localStorage.getItem("nowSiteId")
            var sktem = {siteId: this.skillForm.siteId}
            var data3 = this.$qs.stringify(sktem)
           
            const { data: cc } = await this.$http.post('/api/home/get/classic/skill',data3, {headers:{'Content-Type':'application/x-www-form-urlencoded'}})
            if (cc.message != "Success!") return this.$message.error('get about fail！')
            if(cc.obj.proList.length != 0 && cc.obj.addList.length != 0){
                var tempArray1 = []
                var tempArray2 = []
                for(var i=0;i<4;i++){
                    tempArray1.push(cc.obj.proList[i].skillName)
                    tempArray2.push(cc.obj.addList[i].skillName)
                }
                this.skillForm.proList=tempArray1
                this.skillForm.addList=tempArray2
            }
            
        },
    }
}
</script>

<style lang="less" scoped>
#more-body .body-wrapper{
    background-color: #e6dace;
    height: 3100px;
    width: 100%;
    
}

#more-body .title-wrapper{
    height: 300px;
    width: 100%;
    overflow: hidden;
}
#more-body .title-wrapper .content-wrapper{
    width: 300px;
    height: 50px;
    margin: 100px auto;
}
#more-body .title-wrapper .content-wrapper .blue-dot{
    float: left;
    width: 20px;
    height: 20px;
    background-color: rgba(0, 80, 255, 1);
    margin-top: 15px;
}
#more-body .title-wrapper .content-wrapper .title{
    float: left;
    font-size: 35px;
    font-weight: bold;
    line-height: 1.33em;
    margin-left: 8px;
}
#more-body .experience-wrapper{
    height: 900px;
    width: 730px;
    margin: 0 auto;
} 
#more-body .education-wrapper{
    height: 900px;
    width: 730px;
    margin: 80px auto;
}
#more-body .expertise-wrapper{
    height: 600px;
    width: 730px;
    margin: 150px auto;
    box-shadow: -5px 5px 17px 0px rgba(138,131,124,0.23);
    background-color: #fff;
    box-sizing: border-box;
    padding: 80px 40px;
}

#more-body .title{
    height: 100px;
    font-size: 25px;
    font-weight: 800;
}
#more-body .exp1{
    width: 100%;
    height: 370px;
    box-shadow: -5px 5px 17px 0px rgba(138,131,124,0.23);
    background-color: #fff;
    margin-bottom: 60px;
}
#more-body .exp2{
    width: 100%;
    height: 370px;
    box-shadow: -5px 5px 17px 0px rgba(138,131,124,0.23);
    background-color: #fff;
}
#more-body .left-content{
    float: left;
    width: 40%;
    height: 100%;
    box-sizing: border-box;
    padding: 60px 50px;
    font-size: 14px;
    line-height: 2em;
    color: #000000b2;
}
#more-body .left-content .duration{
    color: #0050FF;
    font-size: 20px;
    font-weight: bold;
}
#more-body .left-content .job{
    color: black;
    font-weight: bold;
    font-size: 14px;
    letter-spacing: 0.1em;
}

#more-body .right-content{
    float: left;
    width: 60%;
    height: 100%;
    line-height: 1.5em;
    font-size: 17px;
    box-sizing: border-box;
    padding: 40px 20px 0;
    overflow: hidden;
    color: #000000ca;
}
.expertise-wrapper .expertises1,
.expertise-wrapper .expertises2{
    width: 100%;
    height: 17px;
    margin-bottom: 40px;
}
.expertise-wrapper .blue-dot{
    float: left;
    width: 16px;
    height: 16px;
    background-color: #0051ffd0;
}
.expertise-wrapper .skill{
    float: left;
    font-size: 14px;
    color: #000000d2;
    margin-left: 15px;
    margin-right: 80px;
}
#skills-title{
    margin-top: 80px;
}
</style>