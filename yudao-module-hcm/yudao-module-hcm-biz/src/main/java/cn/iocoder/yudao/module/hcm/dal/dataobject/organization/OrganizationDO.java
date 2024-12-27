package cn.iocoder.yudao.module.hcm.dal.dataobject.organization;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 组织 DO
 *
 * @author admin
 */
@TableName("hcm_organization")
@KeySequence("hcm_organization_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDO extends BaseDO {

    public static final Long PARENT_ID_ROOT = 0L;

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 组织编码
     */
    private String code;
    /**
     * 组织简称
     */
    private String shortName;
    /**
     * 组织全称
     */
    private String fullName;
    /**
     * 组织英文名
     */
    private String englishName;
    /**
     * 组织层级
     */
    private Integer level;
    /**
     * 组织类别
     */
    private String category;
    /**
     * 生效日期
     */
    private LocalDateTime estDate;
    /**
     * 失效日期
     */
    private LocalDateTime expDate;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 负责人
     */
    private String leader;
    /**
     * 负责人工号
     */
    private String leaderEmpNo;
    /**
     * 父级编号
     */
    private Long parentId;

}