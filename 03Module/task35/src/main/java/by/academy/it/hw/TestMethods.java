package by.academy.it.hw;

import org.springframework.stereotype.Service;

@Service("testMethods")
public class TestMethods {

    public void someEvent(String name){
        System.out.println(name);
    }
}
