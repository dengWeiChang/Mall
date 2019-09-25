import http from '@/utils/http'

export function getSpecGroupByCatId(id) {
  return http({
    url:'/api/spec/group/category/' + id,
    method:'get'
  })
}

export function addSpecGroup(data) {
  return http({
    url:'/api/spec/group/category/',
    method:'post',
    data:data
  })
}

export function modifySpecGroup(data) {
  return http({
    url:'/api/spec/group/category/',
    method:'put',
    data:data
  })
}

export function deleteSpecGroupById(id) {
  return http({
    url:'/api/spec/group/' + id,
    method:'delete'
  })
}
