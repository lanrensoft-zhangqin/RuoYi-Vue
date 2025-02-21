package com.ruoyi.app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SendEmailUtils;
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

import javax.annotation.Resource;

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

    @Resource
    private SendEmailUtils sendEmailUtils;
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
        int i = bizVisitorService.insertBizVisitor(bizVisitor);
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", bizVisitor.getName());
        variables.put("phoneNumber", bizVisitor.getPhoneNumber());
        variables.put("workplace", bizVisitor.getWorkplace());
        variables.put("idNumber", bizVisitor.getIdNumber());
        variables.put("licensePlate", bizVisitor.getLicensePlate());
        variables.put("parkingTime", bizVisitor.getParkingTime());
        variables.put("department", bizVisitor.getDepartment());
        variables.put("interviewee", bizVisitor.getInterviewee());
        variables.put("reason", bizVisitor.getReason());
        variables.put("visitDate", DateUtils.dateTime(bizVisitor.getVisitDate()));
        sendEmailUtils.send(bizVisitor.getName()+" 访问登记","3060349@qq.com,492297036@qq.com", variables,"visit-form-template");
        return toAjax(1);
    }

}
