import http from '@/utils/http'
const url = "http://localhost:8080"
export function getAllOrderByPage(params) {
  return http({
    baseURL: url,
    url:'/api/order/list',
    method:'get',
    params:params
  })
}

export function getOrderDetail(id) {
  return http({
    baseURL: url,
    url:'/api/order/' + id,
    method:'get'
  })
}
