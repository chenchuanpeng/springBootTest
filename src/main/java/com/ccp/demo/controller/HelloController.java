package com.ccp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "helloController")
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "sayHello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("searchDepartmentList")
    @ResponseBody
    public List<Map<String,Object>> searchDepartmentList(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select  * from department");
        return maps;
    }
}
