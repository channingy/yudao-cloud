package cn.iocoder.yudao.module.hcm.service.position;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.hcm.controller.admin.position.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.position.PositionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.hcm.dal.mysql.position.PositionMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.hcm.enums.ErrorCodeConstants.*;

/**
 * 职务信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public Long createPosition(PositionSaveReqVO createReqVO) {
        // 插入
        PositionDO position = BeanUtils.toBean(createReqVO, PositionDO.class);
        positionMapper.insert(position);
        // 返回
        return position.getId();
    }

    @Override
    public void updatePosition(PositionSaveReqVO updateReqVO) {
        // 校验存在
        validatePositionExists(updateReqVO.getId());
        // 更新
        PositionDO updateObj = BeanUtils.toBean(updateReqVO, PositionDO.class);
        positionMapper.updateById(updateObj);
    }

    @Override
    public void deletePosition(Long id) {
        // 校验存在
        validatePositionExists(id);
        // 删除
        positionMapper.deleteById(id);
    }

    private void validatePositionExists(Long id) {
        if (positionMapper.selectById(id) == null) {
            throw exception(POSITION_NOT_EXISTS);
        }
    }

    @Override
    public PositionDO getPosition(Long id) {
        return positionMapper.selectById(id);
    }

    @Override
    public PageResult<PositionDO> getPositionPage(PositionPageReqVO pageReqVO) {
        return positionMapper.selectPage(pageReqVO);
    }

}