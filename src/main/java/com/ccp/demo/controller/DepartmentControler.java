package com.ccp.demo.controller;

import com.ccp.demo.mapper.DepartmentMapper;
import com.ccp.demo.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DepartmentControler {

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping(value = "department/{id}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Department searchDepartmentByid(@PathVariable("id")Integer id){
        return departmentMapper.searchDepartmentById(id);
    }

    @RequestMapping(value = "department")
    @ResponseBody
    public Department insertDepartment(Department department){
        departmentMapper.insertDepartment(department);
        return department;
    }

}
