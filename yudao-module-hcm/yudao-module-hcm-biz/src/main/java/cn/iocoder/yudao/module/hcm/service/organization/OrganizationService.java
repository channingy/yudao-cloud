package cn.iocoder.yudao.module.hcm.service.organization;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.hcm.controller.admin.organization.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.organization.OrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 组织 Service 接口
 *
 * @author admin
 */
public interface OrganizationService {

    /**
     * 创建组织
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOrganization(@Valid OrganizationSaveReqVO createReqVO);

    /**
     * 更新组织
     *
     * @param updateReqVO 更新信息
     */
    void updateOrganization(@Valid OrganizationSaveReqVO updateReqVO);

    /**
     * 删除组织
     *
     * @param id 编号
     */
    void deleteOrganization(Long id);

    /**
     * 获得组织
     *
     * @param id 编号
     * @return 组织
     */
    OrganizationDO getOrganization(Long id);

    /**
     * 获得组织列表
     *
     * @param listReqVO 查询条件
     * @return 组织列表
     */
    List<OrganizationDO> getOrganizationList(OrganizationListReqVO listReqVO);

    /**
     * 获得公司列表
     *
     * @return 公司列表
     */
    List<OrganizationDO> getCompanyList();

}