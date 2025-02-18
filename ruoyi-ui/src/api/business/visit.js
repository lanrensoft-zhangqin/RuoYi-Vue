import request from '@/utils/request'

// 查询访客信息列表
export function listVisit(query) {
  return request({
    url: '/business/visit/list',
    method: 'get',
    params: query
  })
}

// 查询访客信息详细
export function getVisit(id) {
  return request({
    url: '/business/visit/' + id,
    method: 'get'
  })
}

// 新增访客信息
export function addVisit(data) {
  return request({
    url: '/business/visit',
    method: 'post',
    data: data
  })
}
// 新增访客信息
export function addVisitByApp(data) {
  return request({
    url: '/app/visit',
    method: 'post',
    data: data
  })
}
// 修改访客信息
export function updateVisit(data) {
  return request({
    url: '/business/visit',
    method: 'put',
    data: data
  })
}

// 删除访客信息
export function delVisit(id) {
  return request({
    url: '/business/visit/' + id,
    method: 'delete'
  })
}
