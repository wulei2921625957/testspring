package com.wu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-09 19:34
 */

@Aspect   //切面类
@Component
@Order(value = 100)
public class LogAspect2 {

    //定义切入点
    @Pointcut("execution(* com.wu.biz.StudentBizImpl.add*(..))")
    private void add() {
    }

    @Pointcut("execution(* com.wu.biz.StudentBizImpl.update*(..))")
    private void update() {
    }

    @Pointcut("add() || update()")
    private void addAndUpdate() {
    }

    @Pointcut("execution(* com.wu.biz.StudentBizImpl.find*(..))")
    private void find() {
    }


    //测试增强顺序
    @Around("com.wu.aspect.LogAspect2.find()")
    public void log2(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("---100----环绕前");
        jp.proceed();
        System.out.println("---100----环绕后");
    }
}
