<template>
  <v-container>
    <v-row no-gutters>
      <v-col cols="12" md="4" offset-md="4" :align="inputData.alignment">
        <div>
          <v-text-field label="请输入ID" v-model="userData.uid" type="number" :rules="inputData.rules"
                        :counter="count"></v-text-field>
          <v-btn @click="showId" :disabled="disable">查询{{ name }}历史头像</v-btn>
        </div>
        <div style="margin-top: 10px">
          <v-avatar v-for="i in result.imageData.list" size="45%">
            <img
                :src="'https://lilinnan.com/sntx/img?url='+result.imageData.prefix + result.imageData.uid+(i < 10 ? '0' : '')+i+result.imageData.suffix"
                alt="头像"
                class="avatar-img">
          </v-avatar>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "Search",
  data() {
    return {
      userData: {
        uid: '',
        type: ''
      },
      result: {
        imageData: {'prefix': 'aaa', 'suffix': 'bbb', 'list': [], 'uid': ''}
      },
      inputData: {
        rules: [
          value => !!value || '请输入您的ID'
        ],
        count: 11,
        alignment: 'center'
      },
      disable: false
    }
  },
  methods: {
    async showId() {
      if (this.userData.uid.trim().length === 0) {
        return alert("请输入ID");
      }
      this.userData.type = this.$route.name;
      this.disable = true;
      const {data: res} = await this.$http.get("get-avatar/" + this.userData.type + "/" + this.userData.uid).catch(
          () => {
            alert("查询失败");
            this.disable = false;
          }
      );
      this.disable = false;
      if (res['status'] !== 200) {
        return alert(res['message']);
      }
      this.result.imageData = res['message'];
      if (this.result.imageData.list.length <= 0) {
        alert("未获取到头像");
      }
    }
  },
  computed: {
    name: function () {
      switch (this.$route.name) {
        case "mainland":
          return "国服";
        case "taiwan":
          return "台服";
        case "japan":
          return "日服";
        default:
          return "NaN";
      }
    },
    count: function () {
      switch (this.$route.name) {
        case "mainland":
          return 11;
        case "taiwan":
          return 10;
        case "japan":
          return 10;
        default:
          return 0;
      }
    }
  }
}
</script>

<style lang="less" scoped>
.avatar-img {
  width: 100%;
}
</style>