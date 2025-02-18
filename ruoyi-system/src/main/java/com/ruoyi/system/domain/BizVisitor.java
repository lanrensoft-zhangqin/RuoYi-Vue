package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 访客信息对象 biz_visitor
 * 
 * @author zhangqin
 * @date 2025-02-18
 */
public class BizVisitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键，自动递增 */
    private Long id;

    /** UUID，唯一标识符 */
    private String uuid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String workplace;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String idNumber;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlate;

    /** 停车时间 */
    @Excel(name = "停车时间")
    private Long parkingTime;

    /** 访问部门 */
    @Excel(name = "访问部门")
    private String department;

    /** 被访人 */
    @Excel(name = "被访人")
    private String interviewee;

    /** 访问事由 */
    @Excel(name = "访问事由")
    private String reason;

    /** 访问日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "访问日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date visitDate;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setWorkplace(String workplace) 
    {
        this.workplace = workplace;
    }

    public String getWorkplace() 
    {
        return workplace;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setLicensePlate(String licensePlate) 
    {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() 
    {
        return licensePlate;
    }
    public void setParkingTime(Long parkingTime) 
    {
        this.parkingTime = parkingTime;
    }

    public Long getParkingTime() 
    {
        return parkingTime;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setInterviewee(String interviewee) 
    {
        this.interviewee = interviewee;
    }

    public String getInterviewee() 
    {
        return interviewee;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setVisitDate(Date visitDate) 
    {
        this.visitDate = visitDate;
    }

    public Date getVisitDate() 
    {
        return visitDate;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .append("workplace", getWorkplace())
            .append("idNumber", getIdNumber())
            .append("licensePlate", getLicensePlate())
            .append("parkingTime", getParkingTime())
            .append("department", getDepartment())
            .append("interviewee", getInterviewee())
            .append("reason", getReason())
            .append("visitDate", getVisitDate())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
