import http from '@/utils/http';

const url = "http://localhost:9001";

/**
 * 用户收货地址
 * @param id
 */
export function getUserDeliverAddress(params) {
  return http({
    baseURL: url,
    url:'/api/user/',
    method:'get',
    params: params
  })
}

/**
 * 用户登录
 * @param datas
 */
export function loginUser(datas) {
  return http({
    baseURL: url,
    url:'/api/user/',
    method:'post',
    data:datas
  })
}
