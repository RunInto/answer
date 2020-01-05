<template>
  <div style="margin-top:100px;" class="myfont">
    <el-container>
      <el-header>{{this.rank}}考试在线模拟题</el-header>
      <el-container>
        <el-aside style="width:70%">
          <div>
            <div>
              <span style="margin-left:20px;margin-top:20px;">判断题</span>
            </div>
            <div
              v-for="(item,index) in options.trueFalseQuestions"
              v-bind:key="item.id"
              style="margin-top:10px;margin-left:20px; "
            >
              <div>
                <span>
                  第
                  <el-tag effect="dark" size="mini">{{++index}}</el-tag>题：
                </span>
                <el-badge :value="item.answerResult" class="item">
                  <span>{{item.title}}</span>
                </el-badge>
              </div>
              <div style="margin-top:10px;">
                <el-radio-group v-model="item.selected" @change="resultChange(item)">
                  <el-radio :label="item.formatOption[0]" style="margin-top:10px;"></el-radio>
                  <el-radio :label="item.formatOption[1]" style="margin-top:10px;"></el-radio>
                </el-radio-group>
              </div>
            </div>
          </div>
          <el-divider style="margin-top:5px"></el-divider>
          <div>
            <span style="margin-left:20px;margin-top:20px;">单选题</span>
            <div
              v-for="(item,index) in options.singleChoices"
              v-bind:key="item.id"
              style="margin-top:10px;margin-left:20px;"
            >
              <div>
                <span>
                  第
                  <el-tag effect="dark" size="mini">{{++index}}</el-tag>题：
                </span>
                <el-badge :value="item.answerResult" class="item">
                  <span>{{item.title}}</span>
                </el-badge>
              </div>

              <div style="margin-top:10px;">
                <el-radio-group v-model="item.selected" @change="resultChange(item)">
                  <el-radio :label="item.formatOption[0]" style="margin-top:10px;"></el-radio>
                  <el-radio :label="item.formatOption[1]" style="margin-top:10px;"></el-radio>
                  <el-radio :label="item.formatOption[2]" style="margin-top:10px;"></el-radio>
                  <el-radio :label="item.formatOption[3]" style="margin-top:10px;"></el-radio>
                </el-radio-group>
              </div>
            </div>
            <el-divider style="margin-top:5px"></el-divider>
          </div>
          <div style="margin-bottom:20px;">
            <span style="margin-left:20px;margin-top:20px;">多选题</span>
            <div
              v-for="(item,index) in options.multipleChoices"
              v-bind:key="item.id"
              style="margin-top:10px;margin-left:20px;"
            >
              <div>
                <span>
                  第
                  <el-tag effect="dark" size="mini">{{++index}}</el-tag>题：
                </span>
                <el-badge :value="item.answerResult" class="item">
                  <span>{{item.title}}</span>
                </el-badge>
              </div>

              <div style="margin-top:10px;">
                <el-checkbox-group v-model="item.selected" @change="resultChange(item)">
                  <el-checkbox :label="item.formatOption[0]" style="margin-top:10px;"></el-checkbox>
                  <el-checkbox :label="item.formatOption[1]" style="margin-top:10px;"></el-checkbox>
                  <el-checkbox :label="item.formatOption[2]" style="margin-top:10px;"></el-checkbox>
                  <el-checkbox :label="item.formatOption[3]" style="margin-top:10px;"></el-checkbox>
                </el-checkbox-group>
              </div>
            </div>
          </div>
        </el-aside>
        <el-main style="width:30%">
          <el-row>
            <el-col :span="24">
              <i class="el-icon-alarm-clock"></i>
              <span>剩余时间 :</span>
              <count-down :endTime="this.endTime" endText="时间到，考试结束！" @callback="stopExam"></count-down>
            </el-col>
          </el-row>

          <el-divider style="margin-top:5px"></el-divider>
          <el-row>
            <el-col :span="24">
              <div>
                <i class="el-icon-user"></i>
                <span>个人信息</span>
              </div>
              <div style="margin-left:50px;">
                <div style="margin-top:20px">
                  <span>姓名: {{this.user.realname}}</span>
                </div>
                <div style="margin-top:20px">
                  <span>性别: {{this.user.gender}}</span>
                </div>
                <div style="margin-top:20px">
                  <span>等级: {{this.rank}}</span>
                </div>
              </div>
            </el-col>
          </el-row>

          <el-divider style="margin-top:5px"></el-divider>
          <el-row>
            <el-col :span="24">
              <div style="margin-top:5px">
                <i class="el-icon-star-on"></i>
                <span>判断题</span>
                <br>
                <span
                  v-for="(item,index) in options.trueFalseQuestions"
                  v-bind:key="item.id"
                  style="pading-top:10px;margin-left:1px;"
                >
                  <el-tag size="mini" effect="dark" :type="item.isDone">{{++index}}</el-tag>
                </span>
              </div>
            </el-col>
          </el-row>

          <el-divider style="margin-top:5px"></el-divider>
          <el-row>
            <el-col :span="24">
              <div style="margin-top:5px">
                <i class="el-icon-star-on"></i>
                <span>单选题</span>
                <br>
                <span
                  v-for="(item,index) in options.singleChoices"
                  v-bind:key="item.id"
                  style="pading-top:10px;margin-left:1px;"
                >
                  <el-tag effect="dark" :type="item.isDone" size="mini">{{++index}}</el-tag>
                </span>
              </div>
            </el-col>
          </el-row>
          <el-divider style="margin-top:5px"></el-divider>
          <el-row>
            <el-col :span="24">
              <div style="margin-top:5px">
                <i class="el-icon-star-on"></i>
                <span>多选题</span>
                <br>
                <span
                  v-for="(item,index) in options.multipleChoices"
                  v-bind:key="item.id"
                  style="pading-top:10px;margin-left:1px;"
                >
                  <el-tag effect="dark" :type="item.isDone" size="mini">{{++index}}</el-tag>
                </span>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <div style="margin-top:50px;margin-left:200px;">
              <el-button type="success" round :disabled="submitExam" @click="submitOption">提交答案</el-button>
            </div>
          </el-row>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import CountDown from './countDown'
export default {
  name: 'examPaper',
  components: {
    CountDown
  },
  data() {
    return {
      isDone: '',
      submitExam: false,
      user: {},
      rank: '',
      endTime: '',
      options: {}
    }
  },
  created() {
    let user = window.localStorage.getItem('user')
    if (user !== null) {
      this.searchExamRank()
      this.searchOptions()
      let userstr = window.localStorage.getItem('user')
      this.user = JSON.parse(userstr)
      this.rank = window.localStorage.getItem('rank')
      let oldDateObj = new Date()
      let newDateObj = new Date()
      newDateObj.setTime(oldDateObj.getTime() + 30 * 60 * 1000)
      this.endTime = newDateObj.getTime() / 1000 + ''
    }
  },
  methods: {
    resultChange(item) {
      if (item.selected == '') {
        item.isDone = ''
      } else if (item.selected !== '') {
        item.isDone = 'success'
      }
    },
    searchOptions() {
      this.$API
        .get('/examPaper/searchOptions')
        .then(data => {
          console.log(data)
          var res = data
          if (res && res.code === 0) {
            console.log('请求成功，数据是:', res)
            this.options = res.data
          } else {
          }
        })
        .catch(error => {})
    },
    searchExamRank() {
      this.$API
        .post('/exam/rank/list')
        .then(data => {
          console.log(data)
          var res = data
          if (res && res.code === 0) {
            this.examRank = res.data
          } else {
          }
        })
        .catch(error => {})
    },
    stopExam() {
      this.submitExam = true
    },
    verifyAnswer() {
      for (let j = 0; j < this.options.trueFalseQuestions.length; j++) {
        let item = this.options.trueFalseQuestions[j]
        let userAnswer = item.selected
        let correctAnser = item.result
        if (correctAnser != userAnswer) {
          item.answerResult = '错误'
        } else {
          item.answerResult = ''
        }
      }

      for (let j = 0; j < this.options.singleChoices.length; j++) {
        let item = this.options.singleChoices[j]
        let userAnswer = item.selected.split('.')[0]
        let correctAnser = item.result
        if (correctAnser != userAnswer) {
          item.answerResult = '错误'
        } else {
          item.answerResult = ''
        }
      }

      for (let j = 0; j < this.options.multipleChoices.length; j++) {
        let item = this.options.multipleChoices[j]
        let userAnswer = ''
        for (let i = 0; i < item.selected.length; i++) {
          userAnswer += item.selected[i].split('.')[0] += '|'
        }
        userAnswer = userAnswer.substring(0, userAnswer.length - 1)
        let correctAnser = item.result //A|B|C
        if (correctAnser.length !== userAnswer.length) {
          item.answerResult = '错误'
          continue
        }
        for (let k = 0; k < correctAnser.length; k++) {
          if (-1 !== correctAnser.indexOf(userAnswer.charAt(k))) {
            item.answerResult = ''
          } else {
            item.answerResult = '错误'
            break
          }
        }
      }
    },
    submitOption() {
      console.log('最终的')
      console.log(this.options)
      let flag = false
      for (let j = 0; j < this.options.trueFalseQuestions.length; j++) {
        if (this.options.trueFalseQuestions[j].selected == '') {
          flag = true
        }
      }
      for (let j = 0; j < this.options.singleChoices.length; j++) {
        if (this.options.singleChoices[j].selected == '') {
          flag = true
        }
      }
      for (let j = 0; j < this.options.multipleChoices.length; j++) {
        if (this.options.multipleChoices[j].selected == '') {
          flag = true
        }
      }
      if (flag == true) {
        this.$message({
          message: '未全部作答，请把未完成的题做完再提交！',
          type: 'warning'
        })
      } else {
        this.$message({
          message: '恭喜你答题完毕,请检查错题！',
          type: 'success'
        })
        this.verifyAnswer()
      }
    }
  }
}
</script>

<style>
.myfont {
  font-family: 'Hiragino Sans GB';
}
</style>
