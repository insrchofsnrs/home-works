package by.academy.it.hw;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect")
public class MyAspect {

    @Pointcut("execution(* *.someEvent(..))")
    private void allSomeEventMethods(){}

    @Pointcut("execution(* *.someEvent(String)) && args(name)")
    private void stringArgSomeEventMethods(String name){}

    @Before("stringArgSomeEventMethods(name)")
    public void logBefore(String name){
        System.out.print("Выполняется logBefore т.к. параметр не disable: ");
    }



   @Around("stringArgSomeEventMethods(name)")
    public void aroundSomeEvent(ProceedingJoinPoint jp, String name){
        if (name=="disable"){
            System.out.println("aroundSomeEvent Метод не выполняется т.к. параметр disable!");
        } else {
            try {
                System.out.println("просто должен выполнится метод");
                jp.proceed();
            } catch (Throwable throwable) {
                System.out.println("Error" + throwable);
                throwable.printStackTrace();
            }
        }
    }
}
