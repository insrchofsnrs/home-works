package by.academy.it.aop_introducer;

import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskService implements DoTask {
    @Override
    public void doMainJob() {
        System.out.println("Класс TaskService выполняет основную работу.");
    }
}
