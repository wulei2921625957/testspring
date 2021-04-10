package com.wu.biz;

import com.wu.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentBizImplTest {

    //现在是用CGLIB进行动态代理，要注入实现类
    @Autowired
    private StudentBizImpl studentBiz;


    @Test
    public void testAdd() {
        studentBiz.add("张三");
    }

    @Test
    public void testUpdate() {
        studentBiz.update("张三");
    }

    @Test
    public void find() {
        studentBiz.find("张三");
    }

}