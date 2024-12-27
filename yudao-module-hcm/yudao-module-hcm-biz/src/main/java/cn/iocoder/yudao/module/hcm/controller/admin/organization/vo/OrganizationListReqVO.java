package cn.iocoder.yudao.module.hcm.controller.admin.organization.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 组织列表 Request VO")
@Data
public class OrganizationListReqVO {

    @Schema(description = "组织编码")
    private String code;

    @Schema(description = "组织简称", example = "芋艿")
    private String shortName;

    @Schema(description = "组织全称", example = "芋艿")
    private String fullName;

    @Schema(description = "组织英文名", example = "张三")
    private String englishName;

    @Schema(description = "组织层级")
    private Integer level;

    @Schema(description = "组织类别")
    private String category;

    @Schema(description = "生效日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] estDate;

    @Schema(description = "失效日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] expDate;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @Schema(description = "负责人")
    private String leader;

    @Schema(description = "负责人工号")
    private String leaderEmpNo;

    @Schema(description = "父级编号", example = "27538")
    private Long parentId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}