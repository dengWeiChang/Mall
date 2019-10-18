import http from '@/utils/http';

const url = "http://localhost:80";

export function getAllCategoryNavList (params) {
  return http({
    baseURL: url,
    url: '/api/category/h5/list',
    method: 'get',
    params: params
  });
}

export function getAllNavigationPictureList (params) {
  return http({
    baseURL: url,
    url: '/api/category/h5/picture/list',
    method: 'get',
    params: params
  });
}
