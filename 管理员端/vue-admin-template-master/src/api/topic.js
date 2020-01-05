import request from '@/utils/request'

export function searchCategory() {
  return request({
    url: 'http://49.232.167.233:8888/category/list',
    method: 'get',
  })
}

export function addTopic(params) {
  return request({
    url: 'http://49.232.167.233:8888/topic/addTopic',
    method: 'post',
    params
  })
}