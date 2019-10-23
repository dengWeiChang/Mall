import http from '@/utils/http';

const url = "http://localhost:80";

/**
 * 商品列表导航
 * @param id
 */
export function getGoodsNavByCategoryId(type) {
  return http({
    baseURL: url,
    url:'/api/goods/nav/category/' + type,
    method:'get'
  })
}
