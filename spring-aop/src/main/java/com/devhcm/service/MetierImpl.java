package com.devhcm.service;

import com.devhcm.aspects.Log;
import com.devhcm.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles={"USER"})
    public void process() {
        System.out.println("Business Processing ...");
    }

    @Override
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data = 78;
        System.out.println("Business Computing and returning result ...");
        return data;
    }
}
