package by.academy.it;

import by.academy.it.pojos.Cat;
import by.academy.it.pojos.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Context.xml"})
public class XmlTestClass {

    @Autowired
    private Person person;
    @Autowired
    private Cat cat;

    @Test
    public void personTest(){
        Assert.assertEquals("Tom", person.getPetName());
    }

    @Test
    public void catTest(){
        Assert.assertEquals("Evgeny", cat.getPersonName());
    }

}
