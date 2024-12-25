package cn.iocoder.yudao.module.hcm.controller.admin.position.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 职务信息新增/修改 Request VO")
@Data
public class PositionSaveReqVO {

    @Schema(description = "职务ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "14648")
    private Long id;

    @Schema(description = "职务编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "职务编码不能为空")
    private String code;

    @Schema(description = "职务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "职务名称不能为空")
    private String name;

    @Schema(description = "职务英文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "职务英文名称不能为空")
    private String englishName;

    @Schema(description = "默认职级", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "默认职级不能为空")
    private Integer defaultLevel;

    @Schema(description = "状态（0正常 1停用）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

}