package by.academy.it.aop_introducer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class IntroducerDemo
 *
 * Created by yslabko on 10/30/2017.
 */
public class IntroducerDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspects_introducer.xml");
        DoExtendedTask doExtendedTask = context.getBean("extended", DoExtendedTask.class);
        ((DoTask)doExtendedTask).doMainJob();
        doExtendedTask.doExtraJob();
    }
}
