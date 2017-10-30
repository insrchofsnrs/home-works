package by.academy.it.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class Work {
    @Pointcut("execution(* by.academy.it.aspects.TaskService.performJob())")
    public void performance() {

    }

    @Pointcut("execution(* by.academy.it.aspects.TaskService.performJob(String)) && args(name)")
    public void intercept(String name) {

    }

    @Pointcut("execution(* by.academy.it.aspects.TaskService.performJob(String, Integer)) && args(name, i)")
    public void intercept2args(String name, Integer i) {

    }

    @Before("performance()")
    public void beforeWork() {
        System.out.println("Execution before work");
    }

    @AfterReturning("performance()")
    public void afterWork() {
        System.out.println("Execution after work");
    }

    @AfterThrowing("performance()")
    public void afterWorkProblems() {
        System.out.println("Execution after work problems");
    }

    @Around("performance()")
    public void aroundWorkProblems(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Start");
            System.out.println("Begin time: " + System.currentTimeMillis());
            String result = (String) joinPoint.proceed();
            System.out.println("Finish time: " + System.currentTimeMillis());
            System.out.println("Status " + result);
        } catch (Throwable t) {
            System.out.println(t);
        }
    }

    @Before("intercept(name)")
    public void interceptWorkName(String name) {
        System.out.println("Intercepted work is " + name);
    }

    @Before("intercept2args(name, i)")
    public void interceptWorkName(String name, Integer i) {
        System.out.println("Intercepted work is " + name);
    }

}
