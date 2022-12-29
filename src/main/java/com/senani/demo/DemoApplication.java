package com.senani.demo;

import com.senani.demo.aop.BusinessAOP;
import com.senani.demo.model.AtValue;
import com.senani.demo.model.BuilderSample;
import com.senani.demo.model.Course;
import com.senani.demo.model.LoginResult;
import com.senani.demo.model.BuilderDefault;
import com.senani.demo.model.delegate.UserDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //to enable auto-configuration
//@PropertySource("classpath:app-properties.yml")
public class DemoApplication implements CommandLineRunner {
    @Autowired
    BusinessAOP businessAOP;

    //Where to search for beans => Automatically Spring scans package com.senani.demo and its' sub packages for beans
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
        BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
        Properties properties = applicationContext.getBean(Properties.class);
        System.out.println("binarySearch = " + binarySearch.search(new int[]{1, 2, 3}, 1));
        System.out.println("binarySearch2 = " + binarySearch2.search(new int[]{1, 2, 3}, 1));
        System.out.println("Property = " + properties.getUrl());

        Course c1 = new Course(1, "English");
        Course c2 = new Course(1, "Science");
        Course c3 = new Course(2, "Maths");
        System.out.println("c1=c2 " + c1.equals(c2));
        System.out.println("c1= " + c1);
        System.out.println("c1=c3 " + c1.equals(c3));
        System.out.println("c1 hashcode = " + c1.hashCode());
        System.out.println("c2 hashcode = " + c2.hashCode());

        AtValue av = new AtValue(1, "A");

        LoginResult lr1 = new LoginResult("A", "B", true);
        LoginResult lr2 = new LoginResult("C", "D", false);
        lr1.tokenRefreshUrl("AB");
        lr2.tokenRefreshUrl("AB");
        System.out.println("lr1=lr2 " + lr1.equals(lr2));

        BuilderSample bs = BuilderSample.builder().loginId("A").tokenValidity(false).build();

        UserDelegate ud = new UserDelegate();
        ud.setFirstName("A"); //setter comes from ContactInformationSupport

        BuilderDefault bdBuilder = BuilderDefault.builder().build();
        BuilderDefault bdConstructor = new BuilderDefault();
        System.out.println("bdBuilder name= " + bdBuilder.getName()); //Only if @Builder.Default is used
        System.out.println("bdConstructor name= " + bdConstructor.getName());
    }

    //Spring Boot will automatically call the run method of all beans implementing the
    // interface CommandLineRunner after the application context has been loaded
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>> Spring Boot Started-1");
        System.out.println(businessAOP.calculateSomething());
    }

    @Bean
    CommandLineRunner run(BinarySearchImpl binarySearch) {
        return args -> {
            System.out.println(">>>> Spring Boot Started-2"); //will run after the application has initialized
        };
    }
}
