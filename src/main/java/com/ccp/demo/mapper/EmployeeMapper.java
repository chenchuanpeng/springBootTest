package com.ccp.demo.mapper;

import com.ccp.demo.po.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    void insertEmp(Employee employee);

    Employee getEmpById(Integer id);
}
