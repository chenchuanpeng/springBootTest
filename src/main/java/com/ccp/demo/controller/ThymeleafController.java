package com.ccp.demo.controller;

import com.ccp.demo.mapper.DepartmentMapper;
import com.ccp.demo.mapper.EmployeeMapper;
import com.ccp.demo.po.Department;
import com.ccp.demo.po.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "thymeleafController")
public class ThymeleafController {

    Logger logger = LoggerFactory.getLogger(ThymeleafController.class);

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping(value = "thymeleafHelloWord")
    public String thymeleafHelloWord(@RequestParam(value = "empId",required = false)Integer empiId, HttpServletRequest request){
        logger.info("员工ID为：",empiId);
        List<Department> departments = departmentMapper.searclAllDepartmentList();
        request.setAttribute("departments",departments);
        if(empiId != null){
            Employee empById = employeeMapper.getEmpById(empiId);
            request.setAttribute("emp",empById);
        }
        return "thymeleafHelloWord";
    }


}
