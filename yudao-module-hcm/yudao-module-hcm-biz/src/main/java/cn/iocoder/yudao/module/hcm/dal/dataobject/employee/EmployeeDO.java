package cn.iocoder.yudao.module.hcm.dal.dataobject.employee;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 员工 DO
 *
 * @author admin
 */
@TableName("hcm_employee")
@KeySequence("hcm_employee_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 工号
     */
    private String empNo;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 姓名拼音
     */
    private String namePinyin;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 入职日期
     */
    private LocalDateTime entryDate;
    /**
     * 离职日期
     */
    private LocalDateTime leaveDate;
    /**
     * 公司
     */
    private Long company;
    /**
     * 末级组织
     */
    private Long orgUnit;
    /**
     * 组织层级
     */
    private Integer orgLevel;
    /**
     * 职位
     */
    private Long job;
    /**
     * 职务
     */
    private String position;
    /**
     * 职级
     */
    private String rank;
    /**
     * 职等
     */
    private String jobLevel;
    /**
     * 原工号
     */
    private String oldEmpNo;
    /**
     * 证件类型
     */
    private String idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 出生日期
     */
    private LocalDateTime birthDate;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 国籍
     */
    private String nationality;
    /**
     * 民族
     */
    private String ethnicGroup;
    /**
     * 编制情况
     */
    private String staffStatus;
    /**
     * 员工类别
     */
    private String empType;
    /**
     * 年假制度
     */
    private String annualLeaveType;
    /**
     * 工龄起算日
     */
    private LocalDateTime workYearsStart;
    /**
     * 工龄调整月
     */
    private Integer workYearsAdjust;
    /**
     * 工龄
     */
    private Integer workYears;
    /**
     * 司龄起算日
     */
    private LocalDateTime companyYearsStart;
    /**
     * 司龄调整月
     */
    private Integer companyYearsAdjust;
    /**
     * 司龄
     */
    private Integer companyYears;
    /**
     * 户籍
     */
    private String householdType;
    /**
     * 户籍地址
     */
    private String householdAddr;
    /**
     * 移动电话
     */
    private String mobile;
    /**
     * 个人邮箱
     */
    private String personalEmail;
    /**
     * 公司邮箱
     */
    private String workEmail;
    /**
     * 居住城市
     */
    private String residenceCity;
    /**
     * 居住地址
     */
    private String residenceAddr;
    /**
     * 居住邮编
     */
    private String residencePostcode;
    /**
     * 预入职日期
     */
    private LocalDateTime preEntryDate;
    /**
     * 员工状态（0在职 1离职）
     */
    private Integer status;
    /**
     * 直线汇报人
     */
    private String directSupervisor;
    /**
     * 虚线汇报人
     */
    private String indirectSupervisor;
    /**
     * 任职类型
     */
    private String jobNature;
    /**
     * 是否试用期
     */
    private Boolean isProbation;
    /**
     * 是否在黑名单
     */
    private Boolean isBlacklist;
    /**
     * 首次入职日期
     */
    private LocalDateTime firstEntryDate;
    /**
     * 就业证有效期
     */
    private LocalDateTime workPermitExp;
    /**
     * 居住证有效期
     */
    private LocalDateTime residencePermitExp;
    /**
     * 签证过期日
     */
    private LocalDateTime visaExp;
    /**
     * 招聘来源
     */
    private String recruitSource;
    /**
     * 内部推荐人
     */
    private String referrer;
    /**
     * 推荐渠道
     */
    private String referChannel;
    /**
     * 是否兼职
     */
    private Boolean isPartTime;
    /**
     * 备注
     */
    private String remark;

}