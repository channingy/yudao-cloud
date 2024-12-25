package cn.iocoder.yudao.module.hcm.dal.dataobject.position;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 职务信息 DO
 *
 * @author 芋道源码
 */
@TableName("hcm_position")
@KeySequence("hcm_position_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionDO extends BaseDO {

    /**
     * 职务ID
     */
    @TableId
    private Long id;
    /**
     * 职务编码
     */
    private String code;
    /**
     * 职务名称
     */
    private String name;
    /**
     * 职务英文名称
     */
    private String englishName;
    /**
     * 默认职级
     */
    private Integer defaultLevel;
    /**
     * 状态（0正常 1停用）
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}