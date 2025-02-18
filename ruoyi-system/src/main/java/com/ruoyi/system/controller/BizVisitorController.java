package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BizVisitor;
import com.ruoyi.system.service.IBizVisitorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 访客信息Controller
 * 
 * @author zhangqin
 * @date 2025-02-18
 */
@RestController
@RequestMapping("/business/visit")
public class BizVisitorController extends BaseController
{
    @Autowired
    private IBizVisitorService bizVisitorService;

    /**
     * 查询访客信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:visit:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizVisitor bizVisitor)
    {
        startPage();
        List<BizVisitor> list = bizVisitorService.selectBizVisitorList(bizVisitor);
        return getDataTable(list);
    }

    /**
     * 导出访客信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:visit:export')")
    @Log(title = "访客信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizVisitor bizVisitor)
    {
        List<BizVisitor> list = bizVisitorService.selectBizVisitorList(bizVisitor);
        ExcelUtil<BizVisitor> util = new ExcelUtil<BizVisitor>(BizVisitor.class);
        util.exportExcel(response, list, "访客信息数据");
    }

    /**
     * 获取访客信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:visit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizVisitorService.selectBizVisitorById(id));
    }

    /**
     * 新增访客信息
     */
    @PreAuthorize("@ss.hasPermi('business:visit:add')")
    @Log(title = "访客信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizVisitor bizVisitor)
    {
        return toAjax(bizVisitorService.insertBizVisitor(bizVisitor));
    }

    /**
     * 修改访客信息
     */
    @PreAuthorize("@ss.hasPermi('business:visit:edit')")
    @Log(title = "访客信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizVisitor bizVisitor)
    {
        return toAjax(bizVisitorService.updateBizVisitor(bizVisitor));
    }

    /**
     * 删除访客信息
     */
    @PreAuthorize("@ss.hasPermi('business:visit:remove')")
    @Log(title = "访客信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizVisitorService.deleteBizVisitorByIds(ids));
    }
}
