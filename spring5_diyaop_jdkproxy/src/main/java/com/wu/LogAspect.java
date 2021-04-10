package com.wu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-10 19:21
 */
public class LogAspect implements InvocationHandler {
    //必须持有目标类的对象
    private Object target;


    public LogAspect(Object target) {
        this.target = target;
    }

    /**
     * 生成代理类
     */
    public Object createProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    /**
     * 回调方法
     * 当jvm调用代理对象的被代理的方法时，回由jvm自动调用这个invoke
     *
     * @param proxy  代理类
     * @param method 代理类的调用处理程序的方法对象.
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类对象：" + proxy.getClass());
        System.out.println("方法：" + method.getName());
        System.out.println("方法参数：" + args);

        if (method.getName().startsWith("add")) {
            //前置增强
            log();
        }
        Object result = method.invoke(this.target, args);

        //后置增强

        return result;
    }

    private void log() {
        System.out.println("========before advice========");
    }
}
