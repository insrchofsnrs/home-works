package by.academy.it.hw;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Loader {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("my_aspect.xml");
        TestMethods bean = context.getBean("testMethods", TestMethods.class);
        bean.someEvent("что угодно толко бы не  disable");
        //bean.someEvent("disable");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
