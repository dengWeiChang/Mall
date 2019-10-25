import http from '@/utils/http';

const url = "http://localhost:9002";

/**
 * 用户收货地址
 * @param id
 */
export function getUserShopCartByUserId(userId) {
  return http({
    baseURL: url,
    url:'/api/cart/' + userId,
    method:'get',
  })
}
