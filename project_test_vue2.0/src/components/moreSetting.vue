<template>
    <div id="more-body">
   <div class="body-wrapper">
        <div class="title-wrapper">
            <div class="content-wrapper">
                <div class="blue-dot"></div>
                <div class="title">More About Me</div>
            </div>
        </div>
        <div class="experience-wrapper">
            <div class="title">Experience</div>
            <div class="exp1">
                <div class="left-content">
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[0].startTime"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[0].position"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[0].companyName"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[0].companyLocation"></el-input>
                </div>
                <div class="right-content">
                    
                   <el-input
                    type="textarea"
                    :autosize="{ minRows: 9, maxRows: 13}"
                    placeholder="Please write something about yourself"
                    v-model="experienceForm.experiences[0].description">
                    </el-input>
                </div>
            </div>
            <div class="exp2">
                <div class="left-content">
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[1].startTime"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[1].position"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[1].companyName"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="experienceForm.experiences[1].companyLocation"></el-input>
                </div>
                <div class="right-content">
                    <el-input
                    type="textarea"
                    :autosize="{ minRows: 9, maxRows: 13}"
                    placeholder="Please write something about yourself"
                    v-model="experienceForm.experiences[1].description">
                    </el-input>
                </div>
            </div>
            <el-button type="primary" style="margin-left: 43%; margin-top: 10px" plain @click="upload('ex')">upload</el-button>
        </div>
        <div class="education-wrapper">
            <div class="title">Education</div>
            <div class="exp1">
                <div class="left-content">
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[0].startTime"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[0].schoolName"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[0].degree"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[0].schoolLocation"></el-input>
                </div>
                <div class="right-content">
                    
                   <el-input
                    type="textarea"
                    :autosize="{ minRows: 9, maxRows: 13}"
                    placeholder="Please write something about yourself"
                    v-model="educationForm.educations[0].description">
                    </el-input>
                </div>
            </div>
            <div class="exp2">
                <div class="left-content">
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[1].startTime"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[1].schoolName"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[1].degree"></el-input>
                    <el-input placeholder="Please write something about yourself" v-model="educationForm.educations[1].schoolLocation"></el-input>
                </div>
                <div class="right-content">
                   <el-input
                    type="textarea"
                    :autosize="{ minRows: 9, maxRows: 13}"
                    placeholder="Please write something about yourself"
                    v-model="educationForm.educations[1].description">
                    </el-input>
                </div>
            </div>
            <el-button type="primary" style="margin-left: 43%; margin-top: 10px" plain @click="upload('ed')">upload</el-button>
        </div>
        <div class="expertise-wrapper">
            <div class="title">Professional Skillset</div>
            <div class="expertises1">
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.proList[0]"></el-input></div>
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.proList[1]"></el-input></div>
            </div>
            <div class="expertises2">
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.proList[2]"></el-input></div>
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.proList[3]"></el-input></div>
            </div>

            <div class="title" id="skills-title">Additional Skills</div>
            <div class="expertises1">
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.addList[0]"></el-input></div>
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.addList[1]"></el-input></div>
            </div>
            <div class="expertises2">
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.addList[2]"></el-input></div>
                <div class="blue-dot"></div>
                <div class="skill"><el-input placeholder="Please write something about yourself" v-model="skillForm.addList[3]"></el-input></div>
            </div>
            <el-button type="primary" style="margin-left: 43%; margin-top: 60px" plain @click="upload('sk')">upload</el-button>
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
                        startTime:'1999',
                        endTime:'2',
                        position:'1',
                        companyName:'3',
                        companyLocation:'4',
                        description:''
                    },
                    {
                        startTime:'2000',
                        endTime:'2',
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
                        startTime:'2020',
                        endTime:'2',
                        schoolName:'ds',
                        degree:'3',
                        schoolLocation:'4',
                        description:''
                    },
                    {
                        startTime:'2021',
                        endTime:'2',
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
         upload(sth){
             if(sth =='ex'){
                 this.uploadex()
             }if(sth == 'ed'){
                 this.uploaded()
             }if(sth == 'sk'){
                 this.uploadsk()
             }
         },
        async uploadex(){
            this.experienceForm.siteId = window.localStorage.getItem("nowSiteId")
            const { data: a } = await this.$http.post('/api/home/update/classic/experience',this.experienceForm)
            if (a.message != "Success!") return this.$message.error('upload fail！')
        },
        async uploaded(){
            this.educationForm.siteId = window.localStorage.getItem("nowSiteId")
            const { data: b } = await this.$http.post('/api/home/update/classic/education',this.educationForm)
            if (b.message != "Success!") return this.$message.error('upload fail！')
        },
        async uploadsk(){
            this.skillForm.siteId = window.localStorage.getItem("nowSiteId")
            const { data: c } = await this.$http.post('/api/home/update/classic/skill',this.skillForm)
            if (c.message != "Success!") return this.$message.error('upload fail！')
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