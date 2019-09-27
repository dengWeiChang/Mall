import http from '@/utils/http'

export function getAllBrand(params) {
  return http({
    url:'/api/brand/list',
    method:'get',
    params:params
  })
}

export function addBrand(datas) {
  return http({
    url:'/api/brand',
    method:'post',
    data:datas
  })
}

export function editBrand(datas) {
  return http({
    url:'/api/brand',
    method:'put',
    data:datas
  })
}

export function deleteBrand(id) {
  return http({
    url:'/api/brand/' + id,
    method:'delete'
  })
}

export function getBrandByCategoryId(id) {
  return http({
    url:'/api/brand/category/' + id,
    method:'get'
  })
}
