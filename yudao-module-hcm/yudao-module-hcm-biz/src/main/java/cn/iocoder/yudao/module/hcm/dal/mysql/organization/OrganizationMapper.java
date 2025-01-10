package cn.iocoder.yudao.module.hcm.dal.mysql.organization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hcm.dal.dataobject.organization.OrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.hcm.controller.admin.organization.vo.*;

/**
 * 组织 Mapper
 *
 * @author admin
 */
@Mapper
public interface OrganizationMapper extends BaseMapperX<OrganizationDO> {

    default List<OrganizationDO> selectList(OrganizationListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OrganizationDO>()
                .eqIfPresent(OrganizationDO::getCode, reqVO.getCode())
                .likeIfPresent(OrganizationDO::getShortName, reqVO.getShortName())
                .likeIfPresent(OrganizationDO::getFullName, reqVO.getFullName())
                .likeIfPresent(OrganizationDO::getEnglishName, reqVO.getEnglishName())
                .eqIfPresent(OrganizationDO::getLevel, reqVO.getLevel())
                .eqIfPresent(OrganizationDO::getCategory, reqVO.getCategory())
                .betweenIfPresent(OrganizationDO::getEstDate, reqVO.getEstDate())
                .betweenIfPresent(OrganizationDO::getExpDate, reqVO.getExpDate())
                .eqIfPresent(OrganizationDO::getStatus, reqVO.getStatus())
                .eqIfPresent(OrganizationDO::getLeader, reqVO.getLeader())
                .eqIfPresent(OrganizationDO::getLeaderEmpNo, reqVO.getLeaderEmpNo())
                .eqIfPresent(OrganizationDO::getParentId, reqVO.getParentId())
                .betweenIfPresent(OrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OrganizationDO::getId));
    }

	default OrganizationDO selectByParentIdAndShortName(Long parentId, String shortName) {
	    return selectOne(OrganizationDO::getParentId, parentId, OrganizationDO::getShortName, shortName);
	}

    default Long selectCountByParentId(Long parentId) {
        return selectCount(OrganizationDO::getParentId, parentId);
    }

    default List<OrganizationDO> selectCompanyList() {
        return selectList(new LambdaQueryWrapperX<OrganizationDO>()
                .select(OrganizationDO::getId, OrganizationDO::getCode, OrganizationDO::getShortName)
                .eq(OrganizationDO::getCategory, "10")
                .eq(OrganizationDO::getStatus, 0)
                .orderByAsc(OrganizationDO::getCode));
    }

}