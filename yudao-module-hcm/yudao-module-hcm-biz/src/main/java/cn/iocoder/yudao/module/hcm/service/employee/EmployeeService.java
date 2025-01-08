package cn.iocoder.yudao.module.hcm.service.employee;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.hcm.controller.admin.employee.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.employee.EmployeeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 员工 Service 接口
 *
 * @author admin
 */
public interface EmployeeService {

    /**
     * 创建员工
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createEmployee(@Valid EmployeeSaveReqVO createReqVO);

    /**
     * 更新员工
     *
     * @param updateReqVO 更新信息
     */
    void updateEmployee(@Valid EmployeeSaveReqVO updateReqVO);

    /**
     * 删除员工
     *
     * @param id 编号
     */
    void deleteEmployee(Long id);

    /**
     * 获得员工
     *
     * @param id 编号
     * @return 员工
     */
    EmployeeDO getEmployee(Long id);

    /**
     * 获得员工分页
     *
     * @param pageReqVO 分页查询
     * @return 员工分页
     */
    PageResult<EmployeeDO> getEmployeePage(EmployeePageReqVO pageReqVO);

}