package cn.iocoder.yudao.module.hcm.controller.admin.organization;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.hcm.controller.admin.organization.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.organization.OrganizationDO;
import cn.iocoder.yudao.module.hcm.service.organization.OrganizationService;

@Tag(name = "管理后台 - 组织")
@RestController
@RequestMapping("/hcm/organization")
@Validated
public class OrganizationController {

    @Resource
    private OrganizationService organizationService;

    @PostMapping("/create")
    @Operation(summary = "创建组织")
    @PreAuthorize("@ss.hasPermission('hcm:organization:create')")
    public CommonResult<Long> createOrganization(@Valid @RequestBody OrganizationSaveReqVO createReqVO) {
        return success(organizationService.createOrganization(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新组织")
    @PreAuthorize("@ss.hasPermission('hcm:organization:update')")
    public CommonResult<Boolean> updateOrganization(@Valid @RequestBody OrganizationSaveReqVO updateReqVO) {
        organizationService.updateOrganization(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除组织")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('hcm:organization:delete')")
    public CommonResult<Boolean> deleteOrganization(@RequestParam("id") Long id) {
        organizationService.deleteOrganization(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得组织")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hcm:organization:query')")
    public CommonResult<OrganizationRespVO> getOrganization(@RequestParam("id") Long id) {
        OrganizationDO organization = organizationService.getOrganization(id);
        return success(BeanUtils.toBean(organization, OrganizationRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得组织列表")
    @PreAuthorize("@ss.hasPermission('hcm:organization:query')")
    public CommonResult<List<OrganizationRespVO>> getOrganizationList(@Valid OrganizationListReqVO listReqVO) {
        List<OrganizationDO> list = organizationService.getOrganizationList(listReqVO);
        return success(BeanUtils.toBean(list, OrganizationRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出组织 Excel")
    @PreAuthorize("@ss.hasPermission('hcm:organization:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportOrganizationExcel(@Valid OrganizationListReqVO listReqVO,
              HttpServletResponse response) throws IOException {
        List<OrganizationDO> list = organizationService.getOrganizationList(listReqVO);
        // 导出 Excel
        ExcelUtils.write(response, "组织.xls", "数据", OrganizationRespVO.class,
                        BeanUtils.toBean(list, OrganizationRespVO.class));
    }

}