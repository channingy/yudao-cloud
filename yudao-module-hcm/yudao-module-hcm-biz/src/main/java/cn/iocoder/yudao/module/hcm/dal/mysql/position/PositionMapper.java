package cn.iocoder.yudao.module.hcm.dal.mysql.position;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hcm.dal.dataobject.position.PositionDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.hcm.controller.admin.position.vo.*;

/**
 * 职务信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PositionMapper extends BaseMapperX<PositionDO> {

    default PageResult<PositionDO> selectPage(PositionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PositionDO>()
                .eqIfPresent(PositionDO::getCode, reqVO.getCode())
                .likeIfPresent(PositionDO::getName, reqVO.getName())
                .likeIfPresent(PositionDO::getEnglishName, reqVO.getEnglishName())
                .eqIfPresent(PositionDO::getDefaultLevel, reqVO.getDefaultLevel())
                .eqIfPresent(PositionDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PositionDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PositionDO::getId));
    }

}