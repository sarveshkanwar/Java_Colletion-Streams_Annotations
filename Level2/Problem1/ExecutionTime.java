package week4_assignment6.Annotations.Level2.Problem1;

import java.lang.reflect.Method;

class Execution {
    @LogExecutionTime()
    public static void program1Execution() {
        System.out.println("Executing program1...");
        for(int i=0;i<10;i++) {
        }
    }

    @LogExecutionTime
    public static void program2Execution() {
        System.out.println("Executing program2...");
        for(int i=0;i<100;i++) {
        }
    }
}

public class ExecutionTime {
    public static void main(String[] args) throws Exception {

        Class<Execution> obj = Execution.class;

        for(Method method : obj.getDeclaredMethods()) {
            if(method.isAnnotationPresent(LogExecutionTime.class)) {
                Long startTime = System.nanoTime();
                method.invoke(obj);
                Long endTime = System.nanoTime();

                Long duration = endTime - startTime;
                System.out.println("Method : "+method.getName() + " | " + "Duration : "+duration+"ms");
                System.out.println("--------------------------");
            }
        }
    }
}
