package com.wu.biz;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-10 19:19
 */

public class StudentImpl implements Student {
    @Override
    public int add(String name) {
        System.out.println("调用了Student的add()方法");
        return 100;
    }

    @Override
    public void update(String name) {
        System.out.println("调用了Student的update()方法");
    }

    @Override
    public String find(String name) {
        System.out.println("调用了Student的find()方法");
        return name;
    }
}
