<template>
  <div class="content">
    <el-row>
      <el-col :span="4" v-for="(o, index) in examRank" :key="o" :offset="index > 0 ? 2 : 0">
        <el-card :body-style="{ padding: '0px' }">
          <img src="../../assets/img/ai1.jpg" class="image">
          <div style="padding: 14px;">
            <span>{{o.name}}</span>
            <div class="bottom clearfix">
              <el-button type="text" class="button" @click="startExam(o.name)">立即测试</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'rankList',
  data() {
    return {
      examRank: [],
      currentDate: new Date()
    }
  },
  created() {
    let user = window.localStorage.getItem("user")
    if (user !== null) {
      this.searchExamRank()
    }
    
  },
  methods: {
    searchExamRank() {
      this.$API
        .post('/exam/rank/list')
        .then(data => {
          console.log(data)
          var res = data
          //debugger
          if (res && res.code === 0) {
            console.log('请求成功，数据是:', res)
            this.examRank = res.data
          } else {
          }
        })
        .catch(error => {})
    },
    startExam(name) {
      window.localStorage.setItem("rank",name);
      this.$router.push({ path: this.redirect || '/exam/examPaper' })
    }
  }
}
</script>

<style lang="scss" scoped>
.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: '';
}

.clearfix:after {
  clear: both;
}
.content {
  margin-top: 100px;
  margin-left: 100px;
}
</style>
