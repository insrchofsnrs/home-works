package by.academy.it;

import by.academy.it.pojos.Cat;
import by.academy.it.pojos.Dog;
import by.academy.it.pojos.IPet;
import by.academy.it.pojos.Person;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.awt.*;

@Configuration
@ComponentScan (basePackages = "by.academy.it.pojos",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Dog.class))
public class NoXmlConfiguration {
    @Bean (value = "person",
            autowire = Autowire.BY_NAME)
    public Person person(){
        Person p = new Person();
        //p.initPerson();
        return p;
    }
    @Bean (value = "cat",
            autowire = Autowire.BY_NAME
    )
    public IPet cat (){
        IPet cat = new Cat();
        return cat;
    }
    @Bean(value = "dog",
            autowire = Autowire.BY_NAME
    )
    public IPet dog (){
        IPet dog = new Cat();
        return dog;
    }
}

