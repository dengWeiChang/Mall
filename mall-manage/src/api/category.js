import http from '@/utils/http'
export function getAllCategoryTree(params) {
  return http({
    url:'/api/category/tree',
    method:'get',
    params:params
  })
}

export function getAllCategoryList(params) {
  return http({
    url:'/api/category/list',
    method:'get',
    params:params
  })
}

export function modifyCategoryById(data) {
  return http({
    url:'/api/category',
    method:'put',
    data:data
  })
}

export function deleteCategoryById(id) {
  return http({
    url:'/api/category/' + id,
    method:'delete'
  })
}

export function addCategory(datas) {
  return http({
    url:'/api/category/',
    method:'post',
    data:datas
  })
}
