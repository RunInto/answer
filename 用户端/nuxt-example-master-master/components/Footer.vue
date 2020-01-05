<template>
  <div class="footer">
    <div class="contain hidden-sm-and-down">
      <el-row class="footer-line1">
        <el-col :span="4">联系我</el-col>

        <el-col :span="4">微信</el-col>
      </el-row>
      <hr style=" height:2px;border:none;border-top:2px solid #444444;">
      <el-row class="footer-line2">
        <el-col :span="4">
          <div class="looper-p">致电 13920825615</div>
        </el-col>

        <el-col :span="4">
          <img style="width:100px;height:100px" src="../assets/img/wechat.jpg">
        </el-col>
      </el-row>
      <hr style=" height:2px;border:none;border-top:2px solid #444444;">

      <hr style=" height:2px;border:none;border-top:2px solid #444444;">
    </div>
  </div>
</template>
<style lang="scss" scoped>
.footer {
  width: 100%;
  background: #333333;
  color: #999;
  .bq {
    text-align: center;
    font-size: 12px;
  }
  .contain {
    width: 1200px;
    margin: 0 auto;
    padding: 20px 0 10px 0;
    .footer-line1 {
      padding: 10px 0;
      font-size: 20px;
    }
    .footer-line2 {
      padding: 24px 0;
      .looper-p {
        font-size: 12px;
        line-height: 20px;
      }
    }
    .footer-line3 {
      padding: 16px 0;
      .hhh1 {
        font-size: 16px;
      }
      .looper-p-p {
        font-size: 12px;
        padding: 4px 0;
      }
    }
  }
  a {
    color: #999;
  }
  .recordcode {
    padding-top: 6px;
    height: 16px;
    line-height: 16px;
    padding-bottom: 40px;
    text-align: center;
    a {
      font-size: 12px;
      color: #999;
      text-decoration: underline;
      i {
        display: inline-block;
        width: 14px;
        height: 16px;
        margin-right: 6px;
        background: url(https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superlanding/cosmoimg/icon_police_2763990.png?v=md5)
          0 0 no-repeat;
        vertical-align: middle;
        margin-top: -4px;
      }
    }
  }
}
</style>
