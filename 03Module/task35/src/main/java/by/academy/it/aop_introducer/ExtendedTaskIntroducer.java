package by.academy.it.aop_introducer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExtendedTaskIntroducer {
    @DeclareParents(value = "by.academy.it.aop_introducer.DoTask+",
            defaultImpl = ExtendedTaskImpl.class)
    public static DoExtendedTask extendedTask;

    @Pointcut("execution(* by.academy.it.aop_introducer.DoTask.doMainJob(..))")
    private void settingContent() {
    }
    @Around("settingContent() && this(extendedTask)")
    private void onSettingContent(ProceedingJoinPoint joinPoint, DoExtendedTask extendedTask) throws Throwable {
        joinPoint.proceed();
    }
}
