package com.devhcm.aspects;

import com.devhcm.metier.Compte;
import com.devhcm.metier.MetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
    @Pointcut(value = "execution(* *..metier.MetierBanqueImpl.retirer(..))")
    public void pc1() {}

    @Around("pc1() && args(code,montant)")
    public Object autourRetirer(Long code, double montant, ProceedingJoinPoint pjp, JoinPoint joinPoint) throws Throwable {
        MetierBanqueImpl metierBanque = (MetierBanqueImpl) joinPoint.getTarget();
        Compte c = metierBanque.consulter(code);
        if(c.getSolde()<montant) throw new RuntimeException("Solde insuffisant !");
        return pjp.proceed();
    }
}
