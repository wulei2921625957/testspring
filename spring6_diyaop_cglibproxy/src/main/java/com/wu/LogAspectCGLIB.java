package com.wu;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-10 19:21
 */
public class LogAspectCGLIB implements MethodInterceptor {
    //必须持有目标类的对象
    private Object target;


    public LogAspectCGLIB(Object target) {
        this.target = target;
    }

    /**
     * 生成代理类
     */
    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallbacks(new Callback[]{this});
        return enhancer.create();
    }

    /**
     * @param o           被代理的类的类型
     * @param method      目标类中的方法
     * @param args
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println(o.getClass());
//        System.out.println(method.getName());
//        System.out.println(args);
//        System.out.println(method.getName());

        if (method.getName().startsWith("add")) {
            //前置增强
            log();
        }

        Object invoke = method.invoke(target, args);

        //后置增强
        return invoke;
    }

    private void log() {
        System.out.println("========before advice========");
    }


}
