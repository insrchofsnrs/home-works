package by.academy.it;

import java.util.*;

import static java.lang.System.currentTimeMillis;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Long a1 = currentTimeMillis();




        HashSet<Integer> coll = new LinkedHashSet<Integer>();
        Random random = new Random();
        while (coll.size() != 1000000) {
            coll.add(random.nextInt(1000000) + 1);
        }
        System.out.println(coll);

        Long a2 = currentTimeMillis()-a1;
        System.out.println(a2);


        Long a3 = currentTimeMillis();




            Integer[] mass = new Integer[1000000];
            int y = 0;
            for (int i = 0; i < 1000000; i++) {
                for (int n = 0; n <= 2000000; n++) {
                    double z = Math.random();
                    if (z >= 0 && z <= 0.1) {
                        y = 1;
                    } else if (z > 0.1 && z <= 0.2) {
                        y = 2;
                    } else if (z > 0.2 && z <= 0.3) {
                        y = 3;
                    } else if (z > 0.3 && z <= 0.4) {
                        y = 4;
                    } else if (z > 0.4 && z <= 0.5) {
                        y = 5;
                    } else if (z > 0.5 && z <= 0.6) {
                        y = 6;
                    } else if (z > 0.6 && z <= 0.7) {
                        y = 7;
                    } else if (z > 0.7 && z <= 0.8) {
                        y = 8;
                    } else if (z > 0.8 && z <= 0.9) {
                        y = 9;
                    } else if (z > 0.9 && z <= 1) {
                        y = 10;
                    }
                    mass[i] = y;

                }


            }
            System.out.println(Arrays.asList(mass));

        Long a4 = currentTimeMillis()-a3;
        System.out.println(a4);
        }

}