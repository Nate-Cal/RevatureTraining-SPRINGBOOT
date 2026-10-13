package com.revature.HelloSpring;

import com.revature.models.Cat;
import com.revature.models.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);

        /*
            Before we can see the Beans in action, we need ot create our ApplicationContext
         */

        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");



        String[] beanNames = ac.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println();

        // Now, let's instantiate some Owners and Cats to see DEPENDENCY INJECTION at work

        Owner owner = ac.getBean(Owner.class);
        System.out.println(owner);

        System.out.println();

        Cat cat = ac.getBean(Cat.class);
        System.out.println(cat);
	}

}
