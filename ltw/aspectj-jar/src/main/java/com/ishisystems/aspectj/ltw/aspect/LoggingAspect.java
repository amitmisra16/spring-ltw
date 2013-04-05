/**
 * 
 */
package com.ishisystems.aspectj.ltw.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author amit.misra
 *
 */
@Aspect
@Configurable
public class LoggingAspect {
	
	@Pointcut("execution(public * com.ishisystems.spring.app..*.*(..))")
	public void loggingAroundAdvice() {
		
	}
	
	@Around("loggingAroundAdvice()")
	public Object logMethodEntryAndExit(final ProceedingJoinPoint aJoinPoint) throws Throwable {
		final Logger LOGGER = Logger.getLogger(aJoinPoint.getSignature().getDeclaringType());
		LOGGER.info(String.format(">>> Entered method: %s", aJoinPoint.getSignature().toLongString()));
		try {
			final Object returnObject = aJoinPoint.proceed(aJoinPoint.getArgs());
			LOGGER.info(String.format("<<< Exited method: %s", aJoinPoint.getSignature().toLongString()));
			return returnObject;
		} catch (Throwable e) {
			LOGGER.warn(String.format("%s occurred while executing %s", e.getClass().getName(),aJoinPoint.getSignature().toLongString()), e);
			throw e;
		}
	}
}
