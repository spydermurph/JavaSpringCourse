package is.webworks.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class-name.method-name(args)
    //@Before("execution(* is.webworks.springbootrest.service.JobService.*(..))")
    @Before("execution(* is.webworks.springbootrest.service.JobService.getAllJobs(..)) || execution(* is.webworks.springbootrest.service.JobService.updateJobs(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method called " + joinPoint.getSignature().getName());
    }

    @After("execution(* is.webworks.springbootrest.service.JobService.getAllJobs(..)) || execution(* is.webworks.springbootrest.service.JobService.updateJobs(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method executed " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* is.webworks.springbootrest.service.JobService.getAllJobs(..)) || execution(* is.webworks.springbootrest.service.JobService.updateJobs(..))")
    public void logMethodException(JoinPoint joinPoint){
        LOGGER.info("Method threw exception " + joinPoint.getSignature().getName());
    }

    @After("execution(* is.webworks.springbootrest.service.JobService.getAllJobs(..)) || execution(* is.webworks.springbootrest.service.JobService.updateJobs(..))")
    public void logMethodReturning(JoinPoint joinPoint){
        LOGGER.info("Method executed successfully " + joinPoint.getSignature().getName());
    }
}
