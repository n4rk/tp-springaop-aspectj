package com.devhcm;

import com.devhcm.service.IMetier;
import com.devhcm.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class Main {
    public static void main(String[] args) {
        try {
            SecurityContext.authenticate("root","test",new String[]{"USER"});

            ApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(MyConfig.class);
            IMetier metier = applicationContext.getBean(IMetier.class);
            System.out.println("***************");
            System.out.println(metier.getClass().getSimpleName());
            System.out.println("***************");
            metier.process();
            System.out.println(metier.compute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

@Configuration
@ComponentScan(value = {"com.devhcm"} )
class MyConfig {}