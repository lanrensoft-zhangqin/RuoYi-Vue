package com.ruoyi.app;

import java.util.UUID;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BizVisitor;
import com.ruoyi.system.service.IBizVisitorService;

/**
 * 访客信息Controller
 * 
 * @author zhangqin
 * @date 2025-02-18
 */
@RestController
@RequestMapping("/app/visit")
public class AppBizVisitorController extends BaseController
{
    @Autowired
    private IBizVisitorService bizVisitorService;


    /**
     * 新增访客信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody BizVisitor bizVisitor)
    {
        logger.info("/app/visit/add:{} ", JSON.toJSONString( bizVisitor));
        bizVisitor.setUuid(UUID.randomUUID().toString());
        bizVisitor.setStatus(0L);
        bizVisitor.setDelFlag("0");
        return toAjax(bizVisitorService.insertBizVisitor(bizVisitor));
    }

}
