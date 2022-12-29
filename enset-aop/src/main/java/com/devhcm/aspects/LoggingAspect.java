package com.devhcm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    long t1, t2;

    @Pointcut(value = "execution(* *..metier.MetierBanqueImpl.*(..))")
    public void pc1() {}

    @Before("pc1()")
    public void avant(JoinPoint jp) {
        t1 = System.currentTimeMillis();
        logger.info("--- Avant execution de la methode " + jp.getSignature() + " ---");
    }

    @After("pc1()")
    public void apres(JoinPoint jp) {
        logger.info("--- Apres execution de la methode " + jp.getSignature() + " ---");
        t2 = System.currentTimeMillis();
        logger.info("### Execution took "+ (t2-t1) + "milliseconds ! ###");
    }
}
