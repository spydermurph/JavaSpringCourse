package is.webworks.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* is.webworks.springbootrest.service.JobService.getJob(..)) && args(postId)")
    public Object monitorTime(ProceedingJoinPoint joinPoint, int postId) throws Throwable {
        if(postId < 0){
            postId = -postId;
            LOGGER.info("updated postId");
        }

        Object object = joinPoint.proceed(new Object[]{postId});

        return object;
    }
}
