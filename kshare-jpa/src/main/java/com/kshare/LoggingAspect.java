package com.kshare;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	 Logger log1 = null;
	
    @Around("execution(public * com.kshare.dao..*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log1 = LoggerFactory.getLogger(pjp.getTarget().getClass());
        final Object[] args = pjp.getArgs();
        final String methodName = pjp.getSignature().getName();

        log1.debug("{}(): {}", methodName, args);

        final Object result = pjp.proceed();

        log1.debug("{}(): result={}", methodName, result);

        return result;
    }
    @AfterThrowing (pointcut = "execution(* com.kshare.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable
    {
    	ex.printStackTrace();
    	log1.error(ex.getStackTrace().toString());
    }
    
}
