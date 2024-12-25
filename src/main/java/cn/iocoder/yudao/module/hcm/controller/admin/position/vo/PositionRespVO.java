package cn.iocoder.yudao.module.hcm.controller.admin.position.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 职务信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PositionRespVO {

    @Schema(description = "职务ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "14648")
    @ExcelProperty("职务ID")
    private Long id;

    @Schema(description = "职务编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("职务编码")
    private String code;

    @Schema(description = "职务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("职务名称")
    private String name;

    @Schema(description = "职务英文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("职务英文名称")
    private String englishName;

    @Schema(description = "默认职级", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("默认职级")
    private Integer defaultLevel;

    @Schema(description = "状态（0正常 1停用）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "状态（0正常 1停用）", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}