import http from '@/utils/http'

export function getAllGoods(params) {
  return http({
    url:'/api/spu/list',
    method:'get',
    params:params
  })
}
