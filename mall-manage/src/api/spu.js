import http from '@/utils/http'
const url = "http://localhost:8080"
export function getAllGoods(params) {
  return http({
    baseURL: url,
    url:'/api/spu/list',
    method:'get',
    params:params
  })
}
