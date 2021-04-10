package com.wu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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
@Order(value = 1)
public class LogAspect {

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

    //切入点表达式的完整语法
    //  execution
    //  (
    //  modifiers-pattern?
    //  ret-type-pattern declaring-type-pattern?
    //  name-pattern(param-pattern)
    //  throws-pattern?
    //  )


    //实现增强！
//    @Before("com.wu.aspect.LogAspect.addAndUpdate()")
    public void log() {
        System.out.println("------ 前置增强日志log------");
    }

    //测试增强顺序
//    @Around("com.wu.aspect.LogAspect.find()")
    public void log2(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        Signature signature = jp.getSignature();// 获得签名（这个类的信息）
        String name = signature.getName();  //获得执行的方法名
        Class type = signature.getDeclaringType();  //获得声明此成员的类，接口或方面
        Object[] args = jp.getArgs(); //获取方法中的参数信息
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println(type);
        System.out.println(name);
        System.out.println(signature);
        // 执行目标方法proceed
        jp.proceed();
        System.out.println("环绕后");
    }

    //    @Before("execution(* com.wu.biz.StudentBizImpl.find*(..))")
    public void log3() {
        System.out.println("------ 前置增强日志log------");
    }

    //    @After("execution(* com.wu.biz.StudentBizImpl.find*(..))")
    public void log4() {
        System.out.println("------ 后置增强日志log------");
    }

    //    @AfterReturning("execution(* com.wu.biz.StudentBizImpl.find*(..))")
    public void log5() {
        System.out.println("------ 返回建议后增强日志log------");
    }

    //    @AfterThrowing("execution(* com.wu.biz.StudentBizImpl.find*(..))")
    public void log6() {
        System.out.println("------ 异常增强日志log------");
    }

    //    @AfterThrowing("execution(* com.wu.biz.StudentBizImpl.find*(..))")
    public void log7() {
        System.out.println("------ 异常增强日志log------");
    }


    //测试增强顺序
    @Around("com.wu.aspect.LogAspect.find()")
    public void log8(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("---1----环绕前");
        jp.proceed();
        System.out.println("---1----环绕后");
    }
}
