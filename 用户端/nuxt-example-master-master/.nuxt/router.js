import Vue from 'vue'
import Router from 'vue-router'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _471839fa = () => interopDefault(import('..\\pages\\admin\\index.vue' /* webpackChunkName: "pages_admin_index" */))
const _0fdb78d2 = () => interopDefault(import('..\\pages\\echart\\index.vue' /* webpackChunkName: "pages_echart_index" */))
const _436e3e6d = () => interopDefault(import('..\\pages\\fixbar\\index.vue' /* webpackChunkName: "pages_fixbar_index" */))
const _7fcb84f6 = () => interopDefault(import('..\\pages\\sometest\\index.vue' /* webpackChunkName: "pages_sometest_index" */))
const _ce9c016a = () => interopDefault(import('..\\pages\\testlang\\index.vue' /* webpackChunkName: "pages_testlang_index" */))
const _262592d8 = () => interopDefault(import('..\\pages\\userAuth\\index.vue' /* webpackChunkName: "pages_userAuth_index" */))
const _9bed466a = () => interopDefault(import('..\\pages\\exam\\countDown.vue' /* webpackChunkName: "pages_exam_countDown" */))
const _2d879d95 = () => interopDefault(import('..\\pages\\exam\\exam.vue' /* webpackChunkName: "pages_exam_exam" */))
const _3f70a927 = () => interopDefault(import('..\\pages\\exam\\examPaper.vue' /* webpackChunkName: "pages_exam_examPaper" */))
const _14c0038b = () => interopDefault(import('..\\pages\\login\\login2.vue' /* webpackChunkName: "pages_login_login2" */))
const _3b8d7d8b = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages_index" */))

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: decodeURI('/'),
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/admin",
    component: _471839fa,
    name: "admin"
  }, {
    path: "/echart",
    component: _0fdb78d2,
    name: "echart"
  }, {
    path: "/fixbar",
    component: _436e3e6d,
    name: "fixbar"
  }, {
    path: "/sometest",
    component: _7fcb84f6,
    name: "sometest"
  }, {
    path: "/testlang",
    component: _ce9c016a,
    name: "testlang"
  }, {
    path: "/userAuth",
    component: _262592d8,
    name: "userAuth"
  }, {
    path: "/exam/countDown",
    component: _9bed466a,
    name: "exam-countDown"
  }, {
    path: "/exam/exam",
    component: _2d879d95,
    name: "exam-exam"
  }, {
    path: "/exam/examPaper",
    component: _3f70a927,
    name: "exam-examPaper"
  }, {
    path: "/login/login2",
    component: _14c0038b,
    name: "login-login2"
  }, {
    path: "/",
    component: _3b8d7d8b,
    name: "index"
  }],

  fallback: false
}

export function createRouter () {
  return new Router(routerOptions)
}
