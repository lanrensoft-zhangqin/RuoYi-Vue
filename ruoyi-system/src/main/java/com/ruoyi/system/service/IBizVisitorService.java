package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizVisitor;

/**
 * 访客信息Service接口
 * 
 * @author zhangqin
 * @date 2025-02-18
 */
public interface IBizVisitorService 
{
    /**
     * 查询访客信息
     * 
     * @param id 访客信息主键
     * @return 访客信息
     */
    public BizVisitor selectBizVisitorById(Long id);

    /**
     * 查询访客信息列表
     * 
     * @param bizVisitor 访客信息
     * @return 访客信息集合
     */
    public List<BizVisitor> selectBizVisitorList(BizVisitor bizVisitor);

    /**
     * 新增访客信息
     * 
     * @param bizVisitor 访客信息
     * @return 结果
     */
    public int insertBizVisitor(BizVisitor bizVisitor);

    /**
     * 修改访客信息
     * 
     * @param bizVisitor 访客信息
     * @return 结果
     */
    public int updateBizVisitor(BizVisitor bizVisitor);

    /**
     * 批量删除访客信息
     * 
     * @param ids 需要删除的访客信息主键集合
     * @return 结果
     */
    public int deleteBizVisitorByIds(Long[] ids);

    /**
     * 删除访客信息信息
     * 
     * @param id 访客信息主键
     * @return 结果
     */
    public int deleteBizVisitorById(Long id);
}
