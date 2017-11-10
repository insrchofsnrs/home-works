package by.academy.it.hw;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect")
public class MyAspect {

    @Pointcut("execution(* *.someEvent(..))")
    private void allSomeEventMethods() {
    }

    @Pointcut("execution(* *.someEvent(String)) && args(name)")
    private void stringArgSomeEventMethods(String name) {
    }

    @Pointcut("execution(* *.someEvent(Integer, Long)) && args(a, b)")
    private  void intAndLongArgsEventMethods(Integer a, Long b){}

    @Before("intAndLongArgsEventMethods(a, b)")
    public  void messageAfterMethod(ProceedingJoinPoint joinPoint, Integer a, Long b){
        if (a==1 && b==1){
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    @Before("stringArgSomeEventMethods(name)")
    public void logBefore(String name) {
        System.out.print("Выполняется logBefore т.к. параметр не disable: ");
    }

    @AfterThrowing("allSomeEventMethods()")
    public void afterSomeThrowing (){
        System.out.println("Message after throwing");
    }

    @Around("stringArgSomeEventMethods(name)")
    public void aroundSomeEvent(ProceedingJoinPoint jp, String name) {
        if (name == "disable") {
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
