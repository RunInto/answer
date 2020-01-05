<template>
  <div>
    <Goodbanner/>

    <!-- Tabs -->
    <my-tabs
      :tabList="tabList"
      :tabIndex="tabIndex"
      :point_left="point_left"
      @changeTab="changeTab"
    >
      <keep-alive>
        <transition enter-active-class="animated fadeIn" mode="out-in">
          <component :is="currentContent"></component>
        </transition>
      </keep-alive>
    </my-tabs>
  </div>
</template>

<script>
import Goodbanner from '~/components/banner.vue'

import Tabs from '~/components/tabs.vue'

import MyTabs from '~/components/tabs.vue'

export default {
  components: {
    Goodbanner
  },
  data() {
    return {
      numberadd: 0,
      activejjfa: 1,
      // tabs
      tabIndex: 0,
      
      currentContent: 'one',
      point_left: 140,
      tabList: [
        // {
        //   iconssrc: 'index001', // 正常icons 515151
        //   iconssrchover: 'index001_hover', // hovericons ff9600
        //   openurl: '',
        //   number: 0,
        //   component: 'one',
        //   title: '单选'
        // },
        // {
        //   iconssrc: 'index002',
        //   iconssrchover: 'index002_hover',
        //   openurl: '',
        //   number: 1,
        //   component: 'two',
        //   title: '多选'
        // },
        // {
        //   iconssrc: 'index003',
        //   iconssrchover: 'index003_hover',
        //   openurl: '',
        //   number: 2,
        //   component: 'three',
        //   title: '判断'
        // }
      ]
    }
  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll)
  },
  methods: {
    // tabs
    changeTab: function(tab) {
      this.tabIndex = tab.number
      this.currentContent = tab.component
      this.point_left = 140 + tab.number * 300
    },
    // 滚动改变数字入参数 number
    handleScroll() {
      this.scrolled = window.scrollY
      if (this.scrolled > 1200) {
        this.numberadd = 952798
        // console.log(this.numberadd)
        // console.log(this.number)
      } else if (this.scrolled < 800 || this.scrolled > 3000) {
        this.numberadd = 0
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.testi18n {
  font-size: 48px;
  color: red;
}

.zb {
  height: 200px;
}
.fixed-bg {
  height: 300px;
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-position: center center;
  .sologan {
    padding-top: 64px;
    .fixed-h1-add {
      font-size: 36px;
      color: #ffffff;
      text-align: center;
      margin-top: 60px;
    }
    .fixed-h1-add2 {
      font-size: 18px;
      color: #ffffff;
      padding-top: 0px;
      text-align: center;
      margin-top: 20px;
    }
  }
}
</style>
