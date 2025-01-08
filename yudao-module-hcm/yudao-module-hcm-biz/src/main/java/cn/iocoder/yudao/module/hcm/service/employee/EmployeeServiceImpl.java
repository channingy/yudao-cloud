package cn.iocoder.yudao.module.hcm.service.employee;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.hcm.controller.admin.employee.vo.*;
import cn.iocoder.yudao.module.hcm.dal.dataobject.employee.EmployeeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.hcm.dal.mysql.employee.EmployeeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.hcm.enums.ErrorCodeConstants.*;

/**
 * 员工 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Long createEmployee(EmployeeSaveReqVO createReqVO) {
        // 插入
        EmployeeDO employee = BeanUtils.toBean(createReqVO, EmployeeDO.class);
        employeeMapper.insert(employee);
        // 返回
        return employee.getId();
    }

    @Override
    public void updateEmployee(EmployeeSaveReqVO updateReqVO) {
        // 校验存在
        validateEmployeeExists(updateReqVO.getId());
        // 更新
        EmployeeDO updateObj = BeanUtils.toBean(updateReqVO, EmployeeDO.class);
        employeeMapper.updateById(updateObj);
    }

    @Override
    public void deleteEmployee(Long id) {
        // 校验存在
        validateEmployeeExists(id);
        // 删除
        employeeMapper.deleteById(id);
    }

    private void validateEmployeeExists(Long id) {
        if (employeeMapper.selectById(id) == null) {
            throw exception(EMPLOYEE_NOT_EXISTS);
        }
    }

    @Override
    public EmployeeDO getEmployee(Long id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public PageResult<EmployeeDO> getEmployeePage(EmployeePageReqVO pageReqVO) {
        return employeeMapper.selectPage(pageReqVO);
    }

}