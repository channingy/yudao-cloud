package cn.iocoder.yudao.module.hcm.dal.mysql.employee;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hcm.dal.dataobject.employee.EmployeeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.hcm.controller.admin.employee.vo.*;

/**
 * 员工 Mapper
 *
 * @author admin
 */
@Mapper
public interface EmployeeMapper extends BaseMapperX<EmployeeDO> {

    default PageResult<EmployeeDO> selectPage(EmployeePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<EmployeeDO>()
                .eqIfPresent(EmployeeDO::getEmpNo, reqVO.getEmpNo())
                .likeIfPresent(EmployeeDO::getName, reqVO.getName())
                .eqIfPresent(EmployeeDO::getNamePinyin, reqVO.getNamePinyin())
                .likeIfPresent(EmployeeDO::getEnglishName, reqVO.getEnglishName())
                .betweenIfPresent(EmployeeDO::getEntryDate, reqVO.getEntryDate())
                .betweenIfPresent(EmployeeDO::getLeaveDate, reqVO.getLeaveDate())
                .eqIfPresent(EmployeeDO::getCompany, reqVO.getCompany())
                .eqIfPresent(EmployeeDO::getOrgUnit, reqVO.getOrgUnit())
                .eqIfPresent(EmployeeDO::getOrgLevel, reqVO.getOrgLevel())
                .eqIfPresent(EmployeeDO::getJob, reqVO.getJob())
                .eqIfPresent(EmployeeDO::getPosition, reqVO.getPosition())
                .eqIfPresent(EmployeeDO::getRank, reqVO.getRank())
                .eqIfPresent(EmployeeDO::getJobLevel, reqVO.getJobLevel())
                .eqIfPresent(EmployeeDO::getOldEmpNo, reqVO.getOldEmpNo())
                .eqIfPresent(EmployeeDO::getIdType, reqVO.getIdType())
                .eqIfPresent(EmployeeDO::getIdNumber, reqVO.getIdNumber())
                .betweenIfPresent(EmployeeDO::getBirthDate, reqVO.getBirthDate())
                .eqIfPresent(EmployeeDO::getAge, reqVO.getAge())
                .eqIfPresent(EmployeeDO::getGender, reqVO.getGender())
                .eqIfPresent(EmployeeDO::getNationality, reqVO.getNationality())
                .eqIfPresent(EmployeeDO::getEthnicGroup, reqVO.getEthnicGroup())
                .eqIfPresent(EmployeeDO::getStaffStatus, reqVO.getStaffStatus())
                .eqIfPresent(EmployeeDO::getEmpType, reqVO.getEmpType())
                .eqIfPresent(EmployeeDO::getAnnualLeaveType, reqVO.getAnnualLeaveType())
                .eqIfPresent(EmployeeDO::getWorkYearsStart, reqVO.getWorkYearsStart())
                .eqIfPresent(EmployeeDO::getWorkYearsAdjust, reqVO.getWorkYearsAdjust())
                .eqIfPresent(EmployeeDO::getWorkYears, reqVO.getWorkYears())
                .eqIfPresent(EmployeeDO::getCompanyYearsStart, reqVO.getCompanyYearsStart())
                .eqIfPresent(EmployeeDO::getCompanyYearsAdjust, reqVO.getCompanyYearsAdjust())
                .eqIfPresent(EmployeeDO::getCompanyYears, reqVO.getCompanyYears())
                .eqIfPresent(EmployeeDO::getHouseholdType, reqVO.getHouseholdType())
                .eqIfPresent(EmployeeDO::getHouseholdAddr, reqVO.getHouseholdAddr())
                .eqIfPresent(EmployeeDO::getMobile, reqVO.getMobile())
                .eqIfPresent(EmployeeDO::getPersonalEmail, reqVO.getPersonalEmail())
                .eqIfPresent(EmployeeDO::getWorkEmail, reqVO.getWorkEmail())
                .eqIfPresent(EmployeeDO::getResidenceCity, reqVO.getResidenceCity())
                .eqIfPresent(EmployeeDO::getResidenceAddr, reqVO.getResidenceAddr())
                .eqIfPresent(EmployeeDO::getResidencePostcode, reqVO.getResidencePostcode())
                .betweenIfPresent(EmployeeDO::getPreEntryDate, reqVO.getPreEntryDate())
                .eqIfPresent(EmployeeDO::getStatus, reqVO.getStatus())
                .eqIfPresent(EmployeeDO::getDirectSupervisor, reqVO.getDirectSupervisor())
                .eqIfPresent(EmployeeDO::getIndirectSupervisor, reqVO.getIndirectSupervisor())
                .eqIfPresent(EmployeeDO::getJobNature, reqVO.getJobNature())
                .eqIfPresent(EmployeeDO::getIsProbation, reqVO.getIsProbation())
                .eqIfPresent(EmployeeDO::getIsBlacklist, reqVO.getIsBlacklist())
                .betweenIfPresent(EmployeeDO::getFirstEntryDate, reqVO.getFirstEntryDate())
                .eqIfPresent(EmployeeDO::getWorkPermitExp, reqVO.getWorkPermitExp())
                .eqIfPresent(EmployeeDO::getResidencePermitExp, reqVO.getResidencePermitExp())
                .eqIfPresent(EmployeeDO::getVisaExp, reqVO.getVisaExp())
                .eqIfPresent(EmployeeDO::getRecruitSource, reqVO.getRecruitSource())
                .eqIfPresent(EmployeeDO::getReferrer, reqVO.getReferrer())
                .eqIfPresent(EmployeeDO::getReferChannel, reqVO.getReferChannel())
                .betweenIfPresent(EmployeeDO::getIsPartTime, reqVO.getIsPartTime())
                .eqIfPresent(EmployeeDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(EmployeeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(EmployeeDO::getId));
    }

}