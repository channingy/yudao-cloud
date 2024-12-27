package cn.iocoder.yudao.module.hcm.enums;
import cn.iocoder.yudao.framework.common.exception.ErrorCode;
/**
 * HCM 错误码枚举类
 * <p>
 * HCM 系统，使用 1-100-000-000 段
 */
public interface ErrorCodeConstants {
    // ========== 主数据 模块 1_100_000_000 ==========
    ErrorCode POSITION_NOT_EXISTS = new ErrorCode(1_100_000_001, "职务信息不存在");

    // ========== 组织结构 1_100_100_000 ==========
    ErrorCode ORGANIZATION_NOT_EXISTS = new ErrorCode(1_100_100_000, "组织不存在");
    ErrorCode ORGANIZATION_EXITS_CHILDREN = new ErrorCode(1_100_100_001, "存在存在子组织，无法删除");
    ErrorCode ORGANIZATION_PARENT_NOT_EXITS = new ErrorCode(1_100_100_002,"父级组织不存在");
    ErrorCode ORGANIZATION_PARENT_ERROR = new ErrorCode(1_100_100_003, "不能设置自己为父组织");
    ErrorCode ORGANIZATION_SHORT_NAME_DUPLICATE = new ErrorCode(1_100_100_004, "已经存在该组织简称的组织");
    ErrorCode ORGANIZATION_PARENT_IS_CHILD = new ErrorCode(1_100_100_005, "不能设置自己的子Organization为父Organization");
}
