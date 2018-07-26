package com.capgemini.user.profile.and.ranking.aspect;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectTime {

	Logger log = Logger.getLogger(AspectTime.class.getName());
	
	@Before("execution(public * * (..))")
	public void logMethodParameters(JoinPoint joinPoint) {
		Object[] arguments = joinPoint.getArgs();
		log.log(Level.INFO, arguments.toString());
	}
	
	
}
