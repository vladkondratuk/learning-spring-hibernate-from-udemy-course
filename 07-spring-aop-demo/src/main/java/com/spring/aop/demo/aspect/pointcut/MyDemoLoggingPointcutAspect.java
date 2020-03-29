package com.spring.aop.demo.aspect.pointcut;

import com.spring.aop.demo.aspect.MyDemoLoggingAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingPointcutAspect {

    private static Logger log = LoggerFactory.getLogger(MyDemoLoggingAspect.class);

    @Before("com.spring.aop.demo.aspect.pointcut.AopDeclaration.forCopyDaoPackageNoGetterSetter()")
    public void beforeAnyMethodInPackageAdvice() {
        log.info("Executing @Before advice on any method in com.spring.aop.demo.copydao.* package");
    }
}
