package week4_assignment6.Annotations.Level1.Problem1;

import java.lang.reflect.Method;

class MyClass {

    @ImportantMethod(Level = "CRITICAL")
    public void criticalMethod() {
        System.out.println("Critical method called");
    }

    @ImportantMethod
    public void importantMethod() {
        System.out.println("Important method called");
    }

    public void normalMethod() {
        System.out.println("Normal method called");
    }
}

public class Reflection_API {
    public static void main(String[] args) {
        Class<MyClass> obj = MyClass.class;

        for(Method method : obj.getDeclaredMethods()) {
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method : "+method.getName() + " | "+"Importance Level : "+annotation.Level());
            }
        }
    }
}


