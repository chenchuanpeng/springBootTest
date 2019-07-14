package com.ccp.demo.controller;

import com.ccp.demo.mapper.EmployeeMapper;
import com.ccp.demo.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 员工实体类
 * 通过mybatis 配置文件实现
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping(value = "employee/{id}",produces = "application/json")
    @ResponseBody
    public Employee getEmpById(@PathVariable Integer id){
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }

    @RequestMapping(value = "employee")
    @ResponseBody
    public Employee insertEmp(Employee emp){
        employeeMapper.insertEmp(emp);
        return emp;
    }

}
