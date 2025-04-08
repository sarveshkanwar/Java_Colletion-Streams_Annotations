package week4_assignment6.Annotations.Level2.Problem2;

import java.lang.reflect.Field;

class User {

    @MaxLength(value = 10)
    private String username;

    public User(String username) {
        validateLength(username);
        this.username = username;
    }


    private static void validateLength(String username) {
        try{
            Field field  = User.class.getDeclaredField("username");
            if(field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if(username.length() > maxLength) {
                    throw new IllegalArgumentException("username exceeds the max length of "+maxLength);
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Field not found",e);
        }
    }

    public String getUsername() {
        return username;
    }
}

public class FieldValidation {
    public static void main(String[] args) {
        try {
            User user1 = new User("Nazim");
            System.out.println(user1.getUsername());

            User user2 = new User("Venkatesh rajkumar ayeer");
            System.out.println(user2.getUsername());
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
