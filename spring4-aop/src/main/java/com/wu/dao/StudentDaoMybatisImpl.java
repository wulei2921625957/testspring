package com.wu.dao;

import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class StudentDaoMybatisImpl implements StudentDao {
    @Override
    public int add(String name) {
        System.out.println("mybatis添加学生：" + name);
        Random r = new Random();
        return r.nextInt();
    }

    @Override
    public void update(String name) {
        System.out.println("mybatis更新学生：" + name);
    }

    @Override
    public int find(String name) {
        Random r = new Random();
        return r.nextInt();
    }
}
