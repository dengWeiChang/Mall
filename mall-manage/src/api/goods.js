import http from '@/utils/http'


export function addGoods(data) {
  return http({
    url:'/api/goods/',
    method:'post',
    data:data
  })
}
