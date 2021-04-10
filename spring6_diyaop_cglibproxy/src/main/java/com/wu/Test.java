package com.wu;

import com.wu.biz.StudentImpl;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-10 19:31
 */
public class Test {
    public static void main(String[] args) {
        StudentImpl target = new StudentImpl();

        LogAspectCGLIB logAspect = new LogAspectCGLIB(target);

        Object proxy = logAspect.createProxy();  //proxy就是代理对象

        if (proxy instanceof StudentImpl) {
            StudentImpl s = (StudentImpl) proxy;
            s.find("张三");
            s.add("张三");
            s.update("张三");
        }

    }
}
