import api from '~/axios/index.js'
export function login(params) {
    return api.post('http://49.232.167.233:8888/user/login', params).then(res => {
      if (typeof res === 'undefined') {
        return null
      } else {
        return res.data
      }
    })
  }