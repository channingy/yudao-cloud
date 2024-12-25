package cn.iocoder.yudao.module.hcm.service.position;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.hcm.controller.admin.position.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.position.PositionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 职务信息 Service 接口
 *
 * @author 芋道源码
 */
public interface PositionService {

    /**
     * 创建职务信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPosition(@Valid PositionSaveReqVO createReqVO);

    /**
     * 更新职务信息
     *
     * @param updateReqVO 更新信息
     */
    void updatePosition(@Valid PositionSaveReqVO updateReqVO);

    /**
     * 删除职务信息
     *
     * @param id 编号
     */
    void deletePosition(Long id);

    /**
     * 获得职务信息
     *
     * @param id 编号
     * @return 职务信息
     */
    PositionDO getPosition(Long id);

    /**
     * 获得职务信息分页
     *
     * @param pageReqVO 分页查询
     * @return 职务信息分页
     */
    PageResult<PositionDO> getPositionPage(PositionPageReqVO pageReqVO);

}