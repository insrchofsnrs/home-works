package by.academy.it;

/**
 * Created by Smile on 19.09.2017.
 */
public class Fibonachi {

    public  int fib(int n){
        int x = 0;
        int y = 1;
        for (int i = 1; i <= n; i++) {
            x+=y;
            y=x-y;
        }
        return x;
    }
}
