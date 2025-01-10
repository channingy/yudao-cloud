package cn.iocoder.yudao.module.hcm.controller.admin.position;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.hcm.controller.admin.position.vo.PositionPageReqVO;
import cn.iocoder.yudao.module.hcm.controller.admin.position.vo.PositionRespVO;
import cn.iocoder.yudao.module.hcm.controller.admin.position.vo.PositionSaveReqVO;
import cn.iocoder.yudao.module.hcm.dal.dataobject.position.PositionDO;
import cn.iocoder.yudao.module.hcm.service.position.PositionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 职务信息")
@RestController
@RequestMapping("/hcm/position")
@Validated
public class PositionController {

    @Resource
    private PositionService positionService;

    @PostMapping("/create")
    @Operation(summary = "创建职务信息")
    @PreAuthorize("@ss.hasPermission('hcm:position:create')")
    public CommonResult<Long> createPosition(@Valid @RequestBody PositionSaveReqVO createReqVO) {
        return success(positionService.createPosition(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新职务信息")
    @PreAuthorize("@ss.hasPermission('hcm:position:update')")
    public CommonResult<Boolean> updatePosition(@Valid @RequestBody PositionSaveReqVO updateReqVO) {
        positionService.updatePosition(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除职务信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('hcm:position:delete')")
    public CommonResult<Boolean> deletePosition(@RequestParam("id") Long id) {
        positionService.deletePosition(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得职务信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hcm:position:query')")
    public CommonResult<PositionRespVO> getPosition(@RequestParam("id") Long id) {
        PositionDO position = positionService.getPosition(id);
        return success(BeanUtils.toBean(position, PositionRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得职务信息分页")
    @PreAuthorize("@ss.hasPermission('hcm:position:query')")
    public CommonResult<PageResult<PositionRespVO>> getPositionPage(@Valid PositionPageReqVO pageReqVO) {
        PageResult<PositionDO> pageResult = positionService.getPositionPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PositionRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出职务信息 Excel")
    @PreAuthorize("@ss.hasPermission('hcm:position:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPositionExcel(@Valid PositionPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PositionDO> list = positionService.getPositionPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "职务信息.xls", "数据", PositionRespVO.class,
                        BeanUtils.toBean(list, PositionRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "获取职务精简信息列表")
    @PreAuthorize("@ss.hasPermission('hcm:position:query')")
    public CommonResult<List<PositionRespVO>> getPositionSimpleList() {
        List<PositionDO> list = positionService.getPositionSimpleList();
        return success(BeanUtils.toBean(list, PositionRespVO.class));
    }

}