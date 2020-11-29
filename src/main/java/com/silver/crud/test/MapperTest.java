package com.silver.crud.test;

import com.silver.crud.bean.Department;
import com.silver.crud.bean.Employee;
import com.silver.crud.bean.EmployeeExample;
import com.silver.crud.dao.DepartmentMapper;
import com.silver.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Description
 *
 * @author wanghan
 * @date 2020/7/14 13:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    /**
     * departmentmapper test
     */
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void CRUDTest() {
        departmentMapper.insertSelective(new Department(null, "开发部"));
        departmentMapper.insertSelective(new Department(null, "测试部"));
    }

    @Test
    public void insertEmp() {
        employeeMapper.insertSelective(new Employee(null, "jerry", "M", "jerry@163.com", 1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            employeeMapper.insertSelective(new Employee(null, uid, "M", uid+"@163.com", 1));
        }
    }
    @Test
    public void queryemp(){
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(25);
        System.out.println(employee);
    }
}
