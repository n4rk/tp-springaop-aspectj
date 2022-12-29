package com.devhcm.aspects;

public aspect FirstAspect {
    pointcut pc1(): execution(* test.Main.main(..));
    /*before():pc1() {
        System.out.println("*-----------------------------------*");
        System.out.println("Before main() using AspectJ syntax !");
        System.out.println("*-----------------------------------*");
    }
    after():pc1() {
        System.out.println("*-----------------------------------*");
        System.out.println("After main() using AspectJ syntax !");
        System.out.println("*-----------------------------------*");
    }*/
    void around():pc1() {
        System.out.println("*-----------------------------------*");
        System.out.println("Before main() using AspectJ syntax !");
        System.out.println("*-----------------------------------*");
        // --> pointcut operation's execution
        proceed();
        System.out.println("*-----------------------------------*");
        System.out.println("After main() using AspectJ syntax !");
        System.out.println("*-----------------------------------*");
    }
}
