package com.wu.biz;


import com.wu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

 
@Service
public class StudentBizImpl {
    @Autowired
    @Qualifier("studentDaoJpaImpl")
    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentBizImpl() {
    }

//    public StudentDao getStudentDao() {
//        return studentDao;
//    }
//
//    @Autowired
//    @Qualifier("studentDaoJpaImpl")
//    public void setStudentDao(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    public int add(String name) {
        System.out.println("----------添加----------");
        int result = studentDao.add(name);
        System.out.println("----------添加----------");
        return result;
    }

    public void update(String name) {
        System.out.println("----------更新----------");
        studentDao.update(name);
        System.out.println("----------更新----------");
    }

    public void find(String name) {
        System.out.println("----------查找----------");
        studentDao.find(name);
        System.out.println("----------查找----------");
    }
}
