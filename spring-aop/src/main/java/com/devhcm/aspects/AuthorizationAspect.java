package com.devhcm.aspects;

import com.devhcm.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "pjp,securedByAspect")
    public Object secure(ProceedingJoinPoint pjp, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean authorize = false;
        for (String r : roles) {
            if (SecurityContext.hasRole(r)) {
                authorize = true;
                break;
            }
        }
        if (authorize) {
            Object result = pjp.proceed();
            return result;
        }
        throw new RuntimeException("403 : Unauthorized Access !!");
    }
}
