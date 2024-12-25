package cn.iocoder.yudao.module.hcm.enums;
import cn.iocoder.yudao.framework.common.exception.ErrorCode;
/**
 * HCM 错误码枚举类
 * <p>
 * HCM 系统，使用 1-100-000-000 段
 */
public interface ErrorCodeConstants {
    // ========== 主数据 模块 1-100-000-000 ==========
    ErrorCode POSITION_NOT_EXISTS = new ErrorCode(1_100_000_001, "职务信息不存在");
}
