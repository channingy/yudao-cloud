package cn.iocoder.yudao.module.hcm.controller.admin.employee.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 员工 Response VO")
@Data
@ExcelIgnoreUnannotated
public class EmployeeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27799")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "工号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("工号")
    private String empNo;

    @Schema(description = "员工姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("员工姓名")
    private String name;

    @Schema(description = "姓名拼音")
    @ExcelProperty("姓名拼音")
    private String namePinyin;

    @Schema(description = "英文名", example = "芋艿")
    @ExcelProperty("英文名")
    private String englishName;

    @Schema(description = "入职日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("入职日期")
    private LocalDateTime entryDate;

    @Schema(description = "离职日期")
    @ExcelProperty("离职日期")
    private LocalDateTime leaveDate;

    @Schema(description = "公司", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("公司")
    private Long company;

    @Schema(description = "末级组织", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("末级组织")
    private Long orgUnit;

    @Schema(description = "组织层级", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("组织层级")
    private Integer orgLevel;

    @Schema(description = "职位")
    @ExcelProperty("职位")
    private Long job;

    @Schema(description = "职务")
    @ExcelProperty("职务")
    private String position;

    @Schema(description = "职级")
    @ExcelProperty("职级")
    private String rank;

    @Schema(description = "职等")
    @ExcelProperty("职等")
    private String jobLevel;

    @Schema(description = "原工号")
    @ExcelProperty("原工号")
    private String oldEmpNo;

    @Schema(description = "证件类型", example = "2")
    @ExcelProperty("证件类型")
    private String idType;

    @Schema(description = "证件号码")
    @ExcelProperty("证件号码")
    private String idNumber;

    @Schema(description = "出生日期")
    @ExcelProperty("出生日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] birthDate;

    @Schema(description = "年龄")
    @ExcelProperty("年龄")
    private Integer age;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("性别")
    private Integer gender;

    @Schema(description = "国籍")
    @ExcelProperty("国籍")
    private String nationality;

    @Schema(description = "民族")
    @ExcelProperty("民族")
    private String ethnicGroup;

    @Schema(description = "编制情况", example = "1")
    @ExcelProperty("编制情况")
    private String staffStatus;

    @Schema(description = "员工类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("员工类别")
    private String empType;

    @Schema(description = "年假制度", example = "1")
    @ExcelProperty("年假制度")
    private String annualLeaveType;

    @Schema(description = "工龄起算日")
    @ExcelProperty("工龄起算日")
    private LocalDateTime workYearsStart;

    @Schema(description = "工龄调整月")
    @ExcelProperty("工龄调整月")
    private Integer workYearsAdjust;

    @Schema(description = "工龄")
    @ExcelProperty("工龄")
    private Integer workYears;

    @Schema(description = "司龄起算日")
    @ExcelProperty("司龄起算日")
    private LocalDateTime companyYearsStart;

    @Schema(description = "司龄调整月")
    @ExcelProperty("司龄调整月")
    private Integer companyYearsAdjust;

    @Schema(description = "司龄")
    @ExcelProperty("司龄")
    private Integer companyYears;

    @Schema(description = "户籍", example = "1")
    @ExcelProperty("户籍")
    private String householdType;

    @Schema(description = "户籍地址")
    @ExcelProperty("户籍地址")
    private String householdAddr;

    @Schema(description = "移动电话")
    @ExcelProperty("移动电话")
    private String mobile;

    @Schema(description = "个人邮箱")
    @ExcelProperty("个人邮箱")
    private String personalEmail;

    @Schema(description = "公司邮箱")
    @ExcelProperty("公司邮箱")
    private String workEmail;

    @Schema(description = "居住城市")
    @ExcelProperty("居住城市")
    private String residenceCity;

    @Schema(description = "居住地址")
    @ExcelProperty("居住地址")
    private String residenceAddr;

    @Schema(description = "居住邮编")
    @ExcelProperty("居住邮编")
    private String residencePostcode;

    @Schema(description = "预入职日期")
    @ExcelProperty("预入职日期")
    private LocalDateTime preEntryDate;

    @Schema(description = "员工状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("员工状态")
    private Integer status;

    @Schema(description = "直线汇报人")
    @ExcelProperty("直线汇报人")
    private String directSupervisor;

    @Schema(description = "虚线汇报人")
    @ExcelProperty("虚线汇报人")
    private String indirectSupervisor;

    @Schema(description = "任职类型")
    @ExcelProperty("任职类型")
    private String jobNature;

    @Schema(description = "是否试用期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否试用期")
    private Boolean isProbation;

    @Schema(description = "是否在黑名单", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否在黑名单")
    private Boolean isBlacklist;

    @Schema(description = "首次入职日期")
    @ExcelProperty("首次入职日期")
    private LocalDateTime firstEntryDate;

    @Schema(description = "就业证有效期")
    @ExcelProperty("就业证有效期")
    private LocalDateTime workPermitExp;

    @Schema(description = "居住证有效期")
    @ExcelProperty("居住证有效期")
    private LocalDateTime residencePermitExp;

    @Schema(description = "签证过期日")
    @ExcelProperty("签证过期日")
    private LocalDateTime visaExp;

    @Schema(description = "招聘来源")
    @ExcelProperty("招聘来源")
    private String recruitSource;

    @Schema(description = "内部推荐人")
    @ExcelProperty("内部推荐人")
    private String referrer;

    @Schema(description = "推荐渠道")
    @ExcelProperty("推荐渠道")
    private String referChannel;

    @Schema(description = "是否兼职", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否兼职")
    private Boolean isPartTime;

    @Schema(description = "备注", example = "你说的对")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}