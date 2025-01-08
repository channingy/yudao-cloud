package cn.iocoder.yudao.module.hcm.controller.admin.employee;

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

import cn.iocoder.yudao.module.hcm.controller.admin.employee.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.employee.EmployeeDO;
import cn.iocoder.yudao.module.hcm.service.employee.EmployeeService;

@Tag(name = "管理后台 - 员工")
@RestController
@RequestMapping("/hcm/employee")
@Validated
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @PostMapping("/create")
    @Operation(summary = "创建员工")
    @PreAuthorize("@ss.hasPermission('hcm:employee:create')")
    public CommonResult<Long> createEmployee(@Valid @RequestBody EmployeeSaveReqVO createReqVO) {
        return success(employeeService.createEmployee(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新员工")
    @PreAuthorize("@ss.hasPermission('hcm:employee:update')")
    public CommonResult<Boolean> updateEmployee(@Valid @RequestBody EmployeeSaveReqVO updateReqVO) {
        employeeService.updateEmployee(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除员工")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('hcm:employee:delete')")
    public CommonResult<Boolean> deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得员工")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hcm:employee:query')")
    public CommonResult<EmployeeRespVO> getEmployee(@RequestParam("id") Long id) {
        EmployeeDO employee = employeeService.getEmployee(id);
        return success(BeanUtils.toBean(employee, EmployeeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得员工分页")
    @PreAuthorize("@ss.hasPermission('hcm:employee:query')")
    public CommonResult<PageResult<EmployeeRespVO>> getEmployeePage(@Valid EmployeePageReqVO pageReqVO) {
        PageResult<EmployeeDO> pageResult = employeeService.getEmployeePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, EmployeeRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出员工 Excel")
    @PreAuthorize("@ss.hasPermission('hcm:employee:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportEmployeeExcel(@Valid EmployeePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<EmployeeDO> list = employeeService.getEmployeePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "员工.xls", "数据", EmployeeRespVO.class,
                        BeanUtils.toBean(list, EmployeeRespVO.class));
    }

}