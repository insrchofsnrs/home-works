package by.academy.it.hw;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Loader {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myaspect.xml");
        TestMethods bean = (TestMethods) context.getBean("testMethods");
        bean.someEvent("что угодно толко бы не  disable");
        //bean.someEvent("disable");
        //bean.someEvent(1,2l);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
