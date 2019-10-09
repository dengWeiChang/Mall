import http from '@/utils/http'


export function getAllOrderByPage(params) {
  return http({
    url:'/api/order/list',
    method:'get',
    params:params
  })
}
