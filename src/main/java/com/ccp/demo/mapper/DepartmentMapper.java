package com.ccp.demo.mapper;

import com.ccp.demo.po.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select(value = "select * from department where id=#{id}")
    Department searchDepartmentById(Integer id);

    @Options(useGeneratedKeys = true)
    @Insert(value = "insert into department(departmentName) values(#{departmentName})")
    int insertDepartment(Department department);

    @Select(value = "select * from department")
    List<Department> searclAllDepartmentList();

}
