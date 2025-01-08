package cn.iocoder.yudao.module.hcm.controller.admin.employee.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 员工分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EmployeePageReqVO extends PageParam {

    @Schema(description = "工号")
    private String empNo;

    @Schema(description = "员工姓名", example = "赵六")
    private String name;

    @Schema(description = "姓名拼音")
    private String namePinyin;

    @Schema(description = "英文名", example = "芋艿")
    private String englishName;

    @Schema(description = "入职日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] entryDate;

    @Schema(description = "离职日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] leaveDate;

    @Schema(description = "公司")
    private Long company;

    @Schema(description = "末级组织")
    private Long orgUnit;

    @Schema(description = "组织层级")
    private Integer orgLevel;

    @Schema(description = "职位")
    private Long job;

    @Schema(description = "职务")
    private String position;

    @Schema(description = "职级")
    private String rank;

    @Schema(description = "职等")
    private String jobLevel;

    @Schema(description = "原工号")
    private String oldEmpNo;

    @Schema(description = "证件类型", example = "2")
    private String idType;

    @Schema(description = "证件号码")
    private String idNumber;

    @Schema(description = "出生日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] birthDate;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "性别")
    private Integer gender;

    @Schema(description = "国籍")
    private String nationality;

    @Schema(description = "民族")
    private String ethnicGroup;

    @Schema(description = "编制情况", example = "1")
    private String staffStatus;

    @Schema(description = "员工类别", example = "1")
    private String empType;

    @Schema(description = "年假制度", example = "1")
    private String annualLeaveType;

    @Schema(description = "工龄起算日")
    private LocalDate workYearsStart;

    @Schema(description = "工龄调整月")
    private Integer workYearsAdjust;

    @Schema(description = "工龄")
    private Integer workYears;

    @Schema(description = "司龄起算日")
    private LocalDate companyYearsStart;

    @Schema(description = "司龄调整月")
    private Integer companyYearsAdjust;

    @Schema(description = "司龄")
    private Integer companyYears;

    @Schema(description = "户籍", example = "1")
    private String householdType;

    @Schema(description = "户籍地址")
    private String householdAddr;

    @Schema(description = "移动电话")
    private String mobile;

    @Schema(description = "个人邮箱")
    private String personalEmail;

    @Schema(description = "公司邮箱")
    private String workEmail;

    @Schema(description = "居住城市")
    private String residenceCity;

    @Schema(description = "居住地址")
    private String residenceAddr;

    @Schema(description = "居住邮编")
    private String residencePostcode;

    @Schema(description = "预入职日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] preEntryDate;

    @Schema(description = "员工状态（0在职 1离职）", example = "1")
    private Integer status;

    @Schema(description = "直线汇报人")
    private String directSupervisor;

    @Schema(description = "虚线汇报人")
    private String indirectSupervisor;

    @Schema(description = "任职类型")
    private String jobNature;

    @Schema(description = "是否试用期")
    private Boolean isProbation;

    @Schema(description = "是否在黑名单")
    private Boolean isBlacklist;

    @Schema(description = "首次入职日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] firstEntryDate;

    @Schema(description = "就业证有效期")
    private LocalDate workPermitExp;

    @Schema(description = "居住证有效期")
    private LocalDate residencePermitExp;

    @Schema(description = "签证过期日")
    private LocalDate visaExp;

    @Schema(description = "招聘来源")
    private String recruitSource;

    @Schema(description = "内部推荐人")
    private String referrer;

    @Schema(description = "推荐渠道")
    private String referChannel;

    @Schema(description = "是否兼职")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Boolean[] isPartTime;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}