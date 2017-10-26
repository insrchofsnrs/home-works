package by.academy.it;

/**
 * Created by Smile on 19.09.2017.
 */
public class Fibonachi {
    public static void main(String[] args) {
        System.out.println(fib(100));
    }
    public static Long fib(int n){
        Long x = 0L;
        Long y = 1L;
        for (int i = 1; i <= n; i++) {
            x+=y;
            y=x-y;
        }
        return x;
    }
}
