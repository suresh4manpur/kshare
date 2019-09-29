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
	final Logger log1 = LoggerFactory.getLogger(LoggingAspect.class);
	
    @Around("execution(public * com.kshare.dao..*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        final Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());
        final Object[] args = pjp.getArgs();
        final String methodName = pjp.getSignature().getName();

        log.debug("{}(): {}", methodName, args);

        final Object result = pjp.proceed();

        log.debug("{}(): result={}", methodName, result);

        return result;
    }
    @AfterThrowing (pointcut = "execution(* com.kshare.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable
    {
    	ex.printStackTrace();
    	log1.error(ex.getStackTrace().toString());
    }
    
}
