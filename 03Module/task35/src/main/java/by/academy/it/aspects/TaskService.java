package by.academy.it.aspects;

import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskService {

    public void performJob() {
        System.out.println("Perform Job");
    }

    public String performJobAround() {
        System.out.println("Perform around Job");
        return "SUCCESS";
    }


    public void performExceptionJob() throws Exception {
        System.out.println("Throw exception in Job");
        throw new Exception("ExceptionJob");
    }

    public void performJob(String newName) {
        System.out.println("Job name: " + newName);
    }
}
