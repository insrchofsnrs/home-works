package by.academy.it;

import org.junit.Assert;
import org.junit.Test;

public class TestFib {
    @Test
    public void testFib(){
        Fibonachi fib = new Fibonachi();
        Assert.assertEquals(55,fib.fib(10));
    }
}
