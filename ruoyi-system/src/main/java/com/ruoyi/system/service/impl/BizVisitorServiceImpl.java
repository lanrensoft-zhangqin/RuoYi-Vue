package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizVisitorMapper;
import com.ruoyi.system.domain.BizVisitor;
import com.ruoyi.system.service.IBizVisitorService;

/**
 * 访客信息Service业务层处理
 * 
 * @author zhangqin
 * @date 2025-02-18
 */
@Service
public class BizVisitorServiceImpl implements IBizVisitorService 
{
    @Autowired
    private BizVisitorMapper bizVisitorMapper;

    /**
     * 查询访客信息
     * 
     * @param id 访客信息主键
     * @return 访客信息
     */
    @Override
    public BizVisitor selectBizVisitorById(Long id)
    {
        return bizVisitorMapper.selectBizVisitorById(id);
    }

    /**
     * 查询访客信息列表
     * 
     * @param bizVisitor 访客信息
     * @return 访客信息
     */
    @Override
    public List<BizVisitor> selectBizVisitorList(BizVisitor bizVisitor)
    {
        return bizVisitorMapper.selectBizVisitorList(bizVisitor);
    }

    /**
     * 新增访客信息
     * 
     * @param bizVisitor 访客信息
     * @return 结果
     */
    @Override
    public int insertBizVisitor(BizVisitor bizVisitor)
    {
        bizVisitor.setCreateTime(DateUtils.getNowDate());
        return bizVisitorMapper.insertBizVisitor(bizVisitor);
    }

    /**
     * 修改访客信息
     * 
     * @param bizVisitor 访客信息
     * @return 结果
     */
    @Override
    public int updateBizVisitor(BizVisitor bizVisitor)
    {
        bizVisitor.setUpdateTime(DateUtils.getNowDate());
        return bizVisitorMapper.updateBizVisitor(bizVisitor);
    }

    /**
     * 批量删除访客信息
     * 
     * @param ids 需要删除的访客信息主键
     * @return 结果
     */
    @Override
    public int deleteBizVisitorByIds(Long[] ids)
    {
        return bizVisitorMapper.deleteBizVisitorByIds(ids);
    }

    /**
     * 删除访客信息信息
     * 
     * @param id 访客信息主键
     * @return 结果
     */
    @Override
    public int deleteBizVisitorById(Long id)
    {
        return bizVisitorMapper.deleteBizVisitorById(id);
    }
}
