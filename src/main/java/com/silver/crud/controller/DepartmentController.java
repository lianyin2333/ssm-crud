package com.silver.crud.controller;

import com.silver.crud.bean.Department;
import com.silver.crud.bean.Msg;
import com.silver.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description
 * 部门相关请求
 *
 * @author wanghan
 * @date 2020/7/14 13:25
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有部门信息
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> departments =departmentService.getDepts();
        return Msg.success().add("depts",departments);
    }
}
