package cn.iocoder.yudao.module.hcm.service.organization;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.hcm.controller.admin.organization.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.organization.OrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.hcm.dal.mysql.organization.OrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.hcm.enums.ErrorCodeConstants.*;

/**
 * 组织 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public Long createOrganization(OrganizationSaveReqVO createReqVO) {
        // 校验父级编号的有效性
        validateParentOrganization(null, createReqVO.getParentId());
        // 校验组织简称的唯一性
        validateOrganizationShortNameUnique(null, createReqVO.getParentId(), createReqVO.getShortName());

        // 插入
        OrganizationDO organization = BeanUtils.toBean(createReqVO, OrganizationDO.class);
        organizationMapper.insert(organization);
        // 返回
        return organization.getId();
    }

    @Override
    public void updateOrganization(OrganizationSaveReqVO updateReqVO) {
        // 校验存在
        validateOrganizationExists(updateReqVO.getId());
        // 校验父级编号的有效性
        validateParentOrganization(updateReqVO.getId(), updateReqVO.getParentId());
        // 校验组织简称的唯一性
        validateOrganizationShortNameUnique(updateReqVO.getId(), updateReqVO.getParentId(), updateReqVO.getShortName());

        // 更新
        OrganizationDO updateObj = BeanUtils.toBean(updateReqVO, OrganizationDO.class);
        organizationMapper.updateById(updateObj);
    }

    @Override
    public void deleteOrganization(Long id) {
        // 校验存在
        validateOrganizationExists(id);
        // 校验是否有子组织
        if (organizationMapper.selectCountByParentId(id) > 0) {
            throw exception(ORGANIZATION_EXITS_CHILDREN);
        }
        // 删除
        organizationMapper.deleteById(id);
    }

    private void validateOrganizationExists(Long id) {
        if (organizationMapper.selectById(id) == null) {
            throw exception(ORGANIZATION_NOT_EXISTS);
        }
    }

    private void validateParentOrganization(Long id, Long parentId) {
        if (parentId == null || OrganizationDO.PARENT_ID_ROOT.equals(parentId)) {
            return;
        }
        // 1. 不能设置自己为父组织
        if (Objects.equals(id, parentId)) {
            throw exception(ORGANIZATION_PARENT_ERROR);
        }
        // 2. 父组织不存在
        OrganizationDO parentOrganization = organizationMapper.selectById(parentId);
        if (parentOrganization == null) {
            throw exception(ORGANIZATION_PARENT_NOT_EXITS);
        }
        // 3. 递归校验父组织，如果父组织是自己的子组织，则报错，避免形成环路
        if (id == null) { // id 为空，说明新增，不需要考虑环路
            return;
        }
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            // 3.1 校验环路
            parentId = parentOrganization.getParentId();
            if (Objects.equals(id, parentId)) {
                throw exception(ORGANIZATION_PARENT_IS_CHILD);
            }
            // 3.2 继续递归下一级父组织
            if (parentId == null || OrganizationDO.PARENT_ID_ROOT.equals(parentId)) {
                break;
            }
            parentOrganization = organizationMapper.selectById(parentId);
            if (parentOrganization == null) {
                break;
            }
        }
    }

    private void validateOrganizationShortNameUnique(Long id, Long parentId, String shortName) {
        OrganizationDO organization = organizationMapper.selectByParentIdAndShortName(parentId, shortName);
        if (organization == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的组织
        if (id == null) {
            throw exception(ORGANIZATION_SHORT_NAME_DUPLICATE);
        }
        if (!Objects.equals(organization.getId(), id)) {
            throw exception(ORGANIZATION_SHORT_NAME_DUPLICATE);
        }
    }

    @Override
    public OrganizationDO getOrganization(Long id) {
        return organizationMapper.selectById(id);
    }

    @Override
    public List<OrganizationDO> getOrganizationList(OrganizationListReqVO listReqVO) {
        return organizationMapper.selectList(listReqVO);
    }

}