package cn.iocoder.yudao.module.hcm.controller.admin.organization.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 组织新增/修改 Request VO")
@Data
public class OrganizationSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11396")
    private Long id;

    @Schema(description = "组织编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "组织编码不能为空")
    private String code;

    @Schema(description = "组织简称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "组织简称不能为空")
    private String shortName;

    @Schema(description = "组织全称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "组织全称不能为空")
    private String fullName;

    @Schema(description = "组织英文名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "组织英文名不能为空")
    private String englishName;

    @Schema(description = "组织层级", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "组织层级不能为空")
    private Integer level;

    @Schema(description = "组织类别", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "组织类别不能为空")
    private String category;

    @Schema(description = "生效日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "生效日期不能为空")
    private LocalDateTime estDate;

    @Schema(description = "失效日期")
    private LocalDateTime expDate;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "负责人", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "负责人不能为空")
    private String leader;

    @Schema(description = "负责人工号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "负责人工号不能为空")
    private String leaderEmpNo;

    @Schema(description = "父级编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27538")
    @NotNull(message = "父级编号不能为空")
    private Long parentId;

}