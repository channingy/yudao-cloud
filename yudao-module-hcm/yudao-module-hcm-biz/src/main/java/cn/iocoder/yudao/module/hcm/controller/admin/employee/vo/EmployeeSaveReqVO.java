package cn.iocoder.yudao.module.hcm.controller.admin.employee.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 员工新增/修改 Request VO")
@Data
public class EmployeeSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27799")
    private Long id;

    @Schema(description = "工号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "工号不能为空")
    private String empNo;

    @Schema(description = "员工姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "员工姓名不能为空")
    private String name;

    @Schema(description = "姓名拼音")
    private String namePinyin;

    @Schema(description = "英文名", example = "芋艿")
    private String englishName;

    @Schema(description = "入职日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "入职日期不能为空")
    private LocalDateTime entryDate;

    @Schema(description = "离职日期")
    private LocalDateTime leaveDate;

    @Schema(description = "公司", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "公司不能为空")
    private Long company;

    @Schema(description = "末级组织", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "末级组织不能为空")
    private Long orgUnit;

    @Schema(description = "组织层级", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "组织层级不能为空")
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
    private LocalDateTime birthDate;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "性别不能为空")
    private Integer gender;

    @Schema(description = "国籍")
    private String nationality;

    @Schema(description = "民族")
    private String ethnicGroup;

    @Schema(description = "编制情况", example = "1")
    private String staffStatus;

    @Schema(description = "员工类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "员工类别不能为空")
    private String empType;

    @Schema(description = "年假制度", example = "1")
    private String annualLeaveType;

    @Schema(description = "工龄起算日")
    private LocalDateTime workYearsStart;

    @Schema(description = "工龄调整月")
    private Integer workYearsAdjust;

    @Schema(description = "工龄")
    private Integer workYears;

    @Schema(description = "司龄起算日")
    private LocalDateTime companyYearsStart;

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
    private LocalDateTime preEntryDate;

    @Schema(description = "员工状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "员工状态不能为空")
    private Integer status;

    @Schema(description = "直线汇报人")
    private String directSupervisor;

    @Schema(description = "虚线汇报人")
    private String indirectSupervisor;

    @Schema(description = "任职类型")
    private String jobNature;

    @Schema(description = "是否试用期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否试用期不能为空")
    private Boolean isProbation;

    @Schema(description = "是否在黑名单", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否在黑名单不能为空")
    private Boolean isBlacklist;

    @Schema(description = "首次入职日期")
    private LocalDateTime firstEntryDate;

    @Schema(description = "就业证有效期")
    private LocalDateTime workPermitExp;

    @Schema(description = "居住证有效期")
    private LocalDateTime residencePermitExp;

    @Schema(description = "签证过期日")
    private LocalDateTime visaExp;

    @Schema(description = "招聘来源")
    private String recruitSource;

    @Schema(description = "内部推荐人")
    private String referrer;

    @Schema(description = "推荐渠道")
    private String referChannel;

    @Schema(description = "是否兼职", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否兼职不能为空")
    private Boolean isPartTime;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

}