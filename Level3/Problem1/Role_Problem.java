package week4_assignment6.Annotations.Level3.Problem1;

import java.lang.reflect.Method;

class Service {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("admin task executed successfully");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("user task executed successfully");
    }
}

public class Role_Problem {

    static String currentRole = "ADMIN";

    public static void main(String[] args) throws Exception {
        Service service = new Service();
        Class<?> obj = service.getClass();

        for(Method method : obj.getDeclaredMethods()){
            if(method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAnnotation = method.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAnnotation.value();

                System.out.println("Trying to access "+method.getName());

                if(requiredRole.equals(currentRole)){
                    method.invoke(service);
                }else {
                    System.out.println("Access Denied ! Required role is " + requiredRole + ", Current role : "+currentRole);
                }
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
