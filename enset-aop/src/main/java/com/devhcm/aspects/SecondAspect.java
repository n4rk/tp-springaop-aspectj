package com.devhcm.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecondAspect {
    //@Pointcut(value = "execution(* *..test.Main.main(..))")
    @Pointcut(value = "execution(* test.Main.main(..))")
    public void pc2() {}

    @Before("pc2()")
    public void beforeMain() {
        System.out.println("-*******************************-");
        System.out.println("Before main() using Class syntax !");
        System.out.println("-*******************************-");
    }

    @After("pc2()")
    public void afterMain() {
        System.out.println("-*******************************-");
        System.out.println("After main() using Class syntax !");
        System.out.println("-*******************************-");
    }
}
