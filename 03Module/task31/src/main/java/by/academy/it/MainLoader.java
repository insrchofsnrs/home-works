package by.academy.it;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLoader {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
        Pet pet = context.getBean("pet", Pet.class);
        System.out.println(pet.getPerson().getName());
    }
}
