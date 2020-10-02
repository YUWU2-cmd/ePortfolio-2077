<template>
    <div class="main-block">
        <el-collapse v-model="activeName" accordion>
            <el-collapse-item title="Lorem Ipsum" name="1">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer faucibus scelerisque tellus non vestibulum. Morbi luctus finibus suscipit. In vitae tristique ipsum. Nullam elementum faucibus magna non malesuada. Nulla faucibus tortor bibendum tincidunt hendrerit. Nunc enim libero, mattis non turpis in, finibus placerat felis. Mauris arcu eros, condimentum eu gravida at, mattis at tellus.</p>
                <p>In et dolor turpis. Sed eget velit sed metus consequat tempus. Phasellus nec eleifend tellus, at varius mauris. Aliquam lacinia neque lacus, et luctus dui ultricies mollis. Nam vulputate, ante ut vulputate aliquam, nisi erat feugiat purus, at dapibus elit dolor at massa. Fusce sit amet commodo mi, quis venenatis enim. Phasellus risus magna, dapibus in risus sed, pharetra rutrum ipsum. Duis non ante ut sapien vehicula sollicitudin et vitae sem. Praesent ac nisl porta, mollis elit a, suscipit ligula. Aliquam sem eros, fermentum nec diam at, feugiat tincidunt nulla. Vestibulum iaculis elit ut est facilisis sagittis. Cras ut est sollicitudin, aliquet augue vitae, tristique metus.</p>
                <p>Quisque convallis cursus laoreet. Praesent laoreet fermentum porta. Donec aliquam, neque euismod vulputate auctor, nisl nisl condimentum velit, eget euismod ipsum mi sit amet ligula. Duis dolor tellus, interdum quis nisl in, fringilla vulputate sem. Fusce tortor eros, consequat nec malesuada nec, ultrices et eros. Etiam mollis et dui at elementum. Suspendisse vestibulum finibus purus a pellentesque.</p>
                <p>Curabitur eleifend accumsan pellentesque. Quisque interdum tincidunt viverra. Ut dictum finibus convallis. Praesent pellentesque nibh sed tristique imperdiet. Cras fringilla dui enim, blandit finibus dolor accumsan vel. In tristique cursus egestas. Mauris tincidunt purus eu libero pharetra euismod. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed venenatis ipsum sed tellus viverra cursus. Nulla convallis ornare varius. Donec ullamcorper ornare libero id fringilla. Nullam nec ligula gravida, mattis enim vitae, consequat ligula. Aliquam non turpis vitae felis imperdiet commodo. Pellentesque vehicula blandit sem a efficitur. Phasellus interdum tellus in diam tempor, ut rutrum lectus imperdiet. Cras scelerisque vel justo non laoreet.</p>
                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec facilisis nisl lectus, vitae accumsan orci gravida in. Quisque pharetra molestie ex, id maximus nulla faucibus nec. Phasellus at pellentesque risus. Fusce at ex in felis blandit ornare. Maecenas ornare nibh non ultrices elementum. Maecenas auctor nulla sed nisl bibendum dictum at vitae magna. Aenean aliquet neque purus, a vestibulum ipsum pretium non. In nec varius tortor. Aenean auctor lectus id justo viverra, in luctus ante tincidunt. Suspendisse ac purus quis quam sagittis iaculis. Mauris in felis mauris. Aliquam erat volutpat. Nam sit amet nulla ex. Proin vestibulum aliquam aliquam.</p>
            </el-collapse-item>
            <el-collapse-item title="Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..." name="2">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris a quam urna. Morbi vitae ex ligula. Fusce a orci dapibus, pretium odio vel, faucibus velit. Nulla mollis dolor vel orci molestie, eu aliquet eros commodo. Morbi a mi vel erat interdum hendrerit quis vitae mauris. Ut arcu nisl, dictum vel nisi vitae, commodo aliquam turpis. Quisque purus nisl, imperdiet a ullamcorper at, fermentum eu ligula. Vestibulum tristique lorem quis consequat placerat. Fusce laoreet, libero eu pharetra lacinia, ex sem tincidunt ante, ac venenatis leo urna in augue. Nullam non est elit.</p>
                <p>Vivamus at dui ac ligula convallis auctor ut sit amet sapien. Donec id feugiat lectus. Nullam a iaculis risus. Morbi porttitor neque sem, in efficitur metus scelerisque et. Vivamus id accumsan turpis. Aenean in vulputate justo, id volutpat sapien. Donec ut odio tortor. Etiam eget lacus est.</p>
            </el-collapse-item>
            <el-collapse-item title="Neque porro " name="3">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dignissim congue urna non suscipit. Ut eu nibh quis lacus ornare interdum at sit amet tortor. Donec consequat sagittis lacinia. Sed facilisis dui est, ac auctor enim laoreet in. Aenean interdum nulla eu nisl placerat, in venenatis urna facilisis. Donec id metus sed risus interdum lacinia nec at massa. Donec vehicula vulputate dui nec malesuada. Sed a ex ligula. Duis at nisl viverra, ultricies ligula ac, fringilla libero. Duis non urna luctus, hendrerit purus nec, blandit elit. Morbi eu risus ut dui ornare tempus at et sapien. Nulla turpis magna, tempus feugiat odio a, aliquam fermentum eros.</p>
                <p>Maecenas justo enim, iaculis vel elementum ac, interdum non ex. Nunc condimentum turpis eu nulla dignissim ornare. Vestibulum id dolor pellentesque, efficitur urna eu, facilisis ligula. Integer leo dolor, ultricies ut ante at, maximus suscipit lorem. Quisque sit amet lectus quam. Donec ipsum ligula, laoreet sed tortor eget, consectetur condimentum nulla. Integer in lacus vulputate, porttitor neque et, facilisis nisi. Vivamus vulputate ac dui sit amet aliquet. Nulla ultricies ut eros at mattis. Vestibulum non pretium mi, vel hendrerit ligula. Cras lobortis aliquet mauris, quis laoreet ipsum pretium non. Vivamus sed commodo elit, id faucibus sapien.</p>
                <p>Vivamus suscipit sapien id commodo sollicitudin. Pellentesque aliquam neque orci, nec suscipit ligula finibus a. Donec nibh massa, sagittis vel elit ut, efficitur elementum massa. Vivamus a condimentum neque. Donec vitae augue convallis metus efficitur iaculis. Nam id lacus molestie, auctor diam vel, dignissim sapien. Sed molestie interdum libero non maximus. Vestibulum eu neque rutrum tortor tristique rutrum. Fusce a efficitur nibh. Phasellus volutpat venenatis vehicula.</p>
            </el-collapse-item>
            <el-collapse-item title="est qui dolorem ipsum " name="4">
                <p></p>
                <p></p>
            </el-collapse-item>
        </el-collapse>

        <form @submit.prevent="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="picture" v-on:change="onChange($event)">
        <button type="submit">上传图片</button>
        </form>

        <div>上传信息:
        <p v-text="result"></p>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            activeName: "1",
            picture: {},
            result: '',
        };
    },
    methods: {
    onChange: function (event) {
      this.picture = event.target.files[0]; // get input file object
      console.log(this.picture);
    },

    upload: function () {
      var that = this;
      var formData = new FormData();
      formData.append('picture', this.picture);
      // specify Content-Type, with formData as well
      this.$http.post('https://jsonplaceholder.typicode.com/posts/', formData, {
        headers: { 'Content-Type': 'multipart/form-data' }
      }).then(function (res) {
        res.json().then(function (result) {
          that.result = result.info;
          console.log(that.result);
        });
      }, function (res) {
        console.log(res.body);
      });
    }
  }

}
</script>

<style lang="less" scoped>
.main-block{
    position: absolute;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    left: 11%;
    top: 310px;
    width: 80%;
    height: 900px;
    box-shadow: 0 .25rem .125rem 0 rgba(0,0,0,0.025);
    border: 2px rgba(212, 212, 212, .5) solid;
    padding: 10px 20px;
}
</style>