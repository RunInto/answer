/**
 * 配置编译环境和线上环境之间的切换
 *
 * baseUrl: 域名地址
 *可加其他变量控制
 */

let baseUrl

if (process.env.NODE_ENV === 'dev') {
  baseUrl = 'http://49.232.167.233:8888'
} else {
  baseUrl = 'http://49.232.167.233:8888'
}

export {
  baseUrl
}


