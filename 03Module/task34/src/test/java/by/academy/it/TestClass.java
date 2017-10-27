package by.academy.it;

import by.academy.it.pojos.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Context.xml"})
public class TestClass {
    @Autowired
    private Person person;

    @Test
    public void personTest(){
        Assert.assertEquals("Tom", person.getPetName());
    }
}
