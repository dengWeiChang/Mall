import http from '@/utils/http'

export function getSpecGroupByCatId(id) {
  return http({
    url:'/api/spec/group/category/' + id,
    method:'get'
  })
}
