package com.wu.biz;

import com.wu.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class StudentBizImplTest {

    @Autowired

    private StudentBizImpl studentBiz;

    @Test
    public void testGetStudentDao() {
        studentBiz.add("张三");
    }

    
    public void testAdd() {
    }

    public void testUpdate() {
    }
}