package week4_assignment6;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High",assignedTo = "Nazim")
    public void completeTask() {
        System.out.println("Task is completed");
    }
}

public class Tasks {
    public static void main(String[] args) throws Exception{
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority : "+taskInfo.priority());
        System.out.println("Assigned to : "+taskInfo.assignedTo());

    }
}
