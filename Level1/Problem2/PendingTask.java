package week4_assignment6.Annotations.Level1.Problem2;

import java.lang.reflect.Method;

class Project {
    @Todo(task = "Implement user authentcation", assignedTo = "Nazim", priority = "HIGH")
    public static void authenticateUser() {
        System.out.println("Authenticate user...");
    }

    @Todo(task = "Optimize the code", assignedTo = "Harmanjeet",priority = "LOW")
    public static void optimizeQueries() {
        System.out.println("Optimizing queries...");
    }

    @Todo(task = "Add logging",assignedTo = "Vansh",priority = "MEDIUM")
    public static void addLogging() {
        System.out.println("Add Logging...");
    }
}

public class PendingTask {
    public static void main(String[] args) {

        Class<Project> obj = Project.class;

        for(Method method : obj.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method : "+method.getName());
                System.out.println("Task : "+todo.task());
                System.out.println("Assigned To : "+todo.assignedTo());
                System.out.println("Priority : "+todo.priority());
                System.out.println("-----------------------------------");

            }
        }

    }
}
