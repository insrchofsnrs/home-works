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

    @Before("allSomeEventMethods()")
    public void logBefore(){
        System.out.print("Выполняется действие т.к. параметр не disable: ");
    }
    @Around("stringArgSomeEventMethods(name)")
    public void aroundSomeEvent(ProceedingJoinPoint jp, String name){
        if (name=="disable"){
            System.out.println("Метод не выполняется т.к. параметр disable!");
        } else {
            try {
                jp.proceed();
            } catch (Throwable throwable) {
                System.out.println("Error" + throwable);
                throwable.printStackTrace();
            }
        }



    }
}
