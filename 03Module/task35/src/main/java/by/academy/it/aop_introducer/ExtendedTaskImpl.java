package by.academy.it.aop_introducer;

import org.springframework.stereotype.Component;

/**
 * Class ExtendedTaskImpl
 *
 * Created by yslabko on 10/30/2017.
 */
@Component("extended")
public class ExtendedTaskImpl implements DoExtendedTask {

    public void doExtraJob() {
        System.out.println("Класс-аспект ExtendedTaskImpl выполняет дополнительную работу.");
    }
}
