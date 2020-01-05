<template>
  <div class="app-container">
    <el-form ref="form" :model="topic" label-width="120px">
      <el-form-item label="题目">
        <el-input type="textarea" v-model="topic.title"></el-input>
      </el-form-item>
      <el-form-item label="类别">
        <el-select v-model="topic.selectCategory" placeholder="请选择题型">
          <el-option
            v-for="item in topic.category"
            v-bind:key="item.id"
            :label="item.cname"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-row v-if="topic.selectCategory == 2">
        <el-col :span="6">
          <el-form-item label="A">
            <el-input v-model="topic.options.A"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="B">
            <el-input v-model="topic.options.B"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="C">
            <el-input v-model="topic.options.C"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="D">
            <el-input v-model="topic.options.D"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row v-if="topic.selectCategory == 3">
        <el-col :span="4">
          <el-form-item label="A">
            <el-input v-model="topic.options.A"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="B">
            <el-input v-model="topic.options.B"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="C">
            <el-input v-model="topic.options.C"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="D">
            <el-input v-model="topic.options.D"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="E">
            <el-input v-model="topic.options.E"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="F">
            <el-input v-model="topic.options.F"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item v-if="topic.selectCategory == 2 || topic.selectCategory == 3" label="正确答案">
        <el-input v-model="topic.result"></el-input>
      </el-form-item>
      <el-form-item v-if="topic.selectCategory == 1" label="正确答案">
        <el-select v-model="topic.result" placeholder="请选择对错">
          <el-option label="正确" value="正确"/>
          <el-option label="错误" value="错误"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addTopic">添加</el-button>
        <el-button @click="onCancel">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { searchCategory, addTopic } from "@/api/topic";
export default {
  data() {
    return {
      topic: {
        title: "", //标题
        category: [],
        selectCategory: "", //选择的类别
        options: {
          A: "",
          B: "",
          C: "",
          D: "",
          E: "",
          F: ""
        },
        result: ""
      }
    };
  },
  created: function() {
    this.searchCategory();
  },
  methods: {
    searchCategory() {
      searchCategory().then(response => {
        this.topic.category = response.data.data;
      });
    },
    onCancel() {
      this.$message({
        message: "cancel!",
        type: "warning"
      });
    },
    addTopic() {
      let params = {
        title: this.topic.title,
        selectCategory: this.topic.selectCategory,
        options: this.topic.options,
        result: this.topic.result
      };
      addTopic(params).then(response => {
        console.log(response);
      });
    }
  }
};
</script>

<style scoped>
.line {
  text-align: center;
}
</style>

