package cn.iocoder.yudao.module.hcm.controller.admin.organization.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 组织 Response VO")
@Data
@ExcelIgnoreUnannotated
public class OrganizationRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11396")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "组织编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("组织编码")
    private String code;

    @Schema(description = "组织简称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("组织简称")
    private String shortName;

    @Schema(description = "组织全称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("组织全称")
    private String fullName;

    @Schema(description = "组织英文名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("组织英文名")
    private String englishName;

    @Schema(description = "组织层级", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("组织层级")
    private Integer level;

    @Schema(description = "组织类别", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("组织类别")
    private String category;

    @Schema(description = "生效日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("生效日期")
    private LocalDateTime estDate;

    @Schema(description = "失效日期")
    @ExcelProperty("失效日期")
    private LocalDateTime expDate;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "负责人", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("负责人")
    private String leader;

    @Schema(description = "负责人工号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("负责人工号")
    private String leaderEmpNo;

    @Schema(description = "父级编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27538")
    @ExcelProperty("父级编号")
    private Long parentId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}