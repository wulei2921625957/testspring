package com.wu;

import com.wu.biz.Student;
import com.wu.biz.StudentImpl;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-10 19:31
 */
public class Test {
    public static void main(String[] args) {
        Student target = new StudentImpl();

        LogAspect logAspect = new LogAspect(target);

        Object proxy = logAspect.createProxy();  //proxy就是代理对象

        if (proxy instanceof Student) {
            Student s = (Student) proxy;
            s.find("张三");
            s.add("张三");
            s.update("张三");
        }

    }
}
