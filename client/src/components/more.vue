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
                    <div class="duration">2014 - Present</div>
                    <div class="job">HITMAN</div>
                    <div class="company">Company Name</div>
                    <div class="location">Company Location</div>
                </div>
                <div class="right-content">
                    
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam luctus quam ut tristique pretium. Quisque sed arcu enim. Pellentesque quis ornare risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla quis egestas ligula. Cras congue fringilla dolor, in molestie lorem placerat nec. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut luctus pellentesque ultrices. Vestibulum molestie lobortis ligula at dapibus. Integer elementum non mauris eu tincidunt. Quisque quis rutrum elit. </div>
            </div>
            <div class="exp2">
                <div class="left-content">
                    <div class="duration">2010 - 2014</div>
                    <div class="job">JOB POSITION</div>
                    <div class="company">Company Name</div>
                    <div class="location">Company Location</div>
                </div>
                <div class="right-content">
                    Etiam at fermentum eros. Aenean porta justo enim, id maximus elit maximus vitae. Donec rhoncus venenatis dolor, ac dictum dui porttitor sed. Integer dictum egestas lorem et eleifend. Proin at consequat ante, nec luctus nisl. Nunc luctus turpis sagittis nibh iaculis aliquam. In odio sapien, faucibus quis urna sed, egestas laoreet sem. Fusce ultrices orci a molestie lacinia. Quisque vel vestibulum tellus. Donec laoreet sem vel ipsum auctor, ut feugiat enim volutpat. 
                </div>
            </div>
        </div>
        <div class="education-wrapper">
            <div class="title">Education</div>
            <div class="exp1">
                <div class="left-content">
                    <div class="duration">2014 - Present</div>
                    <div class="job">UNIVERSITY OF MELBOURNE</div>
                    <div class="company">Degree Level</div>
                    <div class="location">University Location</div>
                </div>
                <div class="right-content">
                    
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam luctus quam ut tristique pretium. Quisque sed arcu enim. Pellentesque quis ornare risus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla quis egestas ligula. Cras congue fringilla dolor, in molestie lorem placerat nec. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut luctus pellentesque ultrices. Vestibulum molestie lobortis ligula at dapibus. Integer elementum non mauris eu tincidunt. Quisque quis rutrum elit. </div>
            </div>
            <div class="exp2">
                <div class="left-content">
                    <div class="duration">2010 - 2014</div>
                    <div class="job">UNIVERSITY NAME</div>
                    <div class="company">Degree Level</div>
                    <div class="location">University Location</div>
                </div>
                <div class="right-content">
                    Etiam at fermentum eros. Aenean porta justo enim, id maximus elit maximus vitae. Donec rhoncus venenatis dolor, ac dictum dui porttitor sed. Integer dictum egestas lorem et eleifend. Proin at consequat ante, nec luctus nisl. Nunc luctus turpis sagittis nibh iaculis aliquam. In odio sapien, faucibus quis urna sed, egestas laoreet sem. Fusce ultrices orci a molestie lacinia. Quisque vel vestibulum tellus. Donec laoreet sem vel ipsum auctor, ut feugiat enim volutpat. 
                </div>
            </div>
        </div>
        <div class="expertise-wrapper">
            <div class="title">Professional Skillset</div>
            <div class="expertises1">
                <div class="blue-dot"></div>
                <div class="skill">Computer programming and coding</div>
                <div class="blue-dot"></div>
                <div class="skill">Object-oriented design</div>
            </div>
            <div class="expertises2">
                <div class="blue-dot"></div>
                <div class="skill">Software testing and debugging</div>
                <div class="blue-dot"></div>
                <div class="skill">Problem solving and logical thinking</div>
            </div>

            <div class="title" id="skills-title">Additional Skills</div>
            <div class="expertises1">
                <div class="blue-dot"></div>
                <div class="skill">Written and verbal communication</div>
                <div class="blue-dot"></div>
                <div class="skill">Teamwork</div>
            </div>
            <div class="expertises2">
                <div class="blue-dot"></div>
                <div class="skill">Software testing and debugging</div>
                <div class="blue-dot"></div>
                <div class="skill">Active Listening</div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {}
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