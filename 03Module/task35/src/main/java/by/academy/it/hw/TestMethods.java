package by.academy.it.hw;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("testMethods")
public class TestMethods {

    public void someEvent(String name){
        System.out.println(name);
    }
    public void someEvent(Integer a, Long b){
        System.out.println(a + b);
    }


    public void someEventWithThrow(String name) throws IOException {
        System.out.println(name);
        throw new IOException("some excepltion");
    }
}
