package week4_assignment6.Annotations.Level3.Problem3;

public class JsonTest {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Nazim", 20, true);
        String json = JsonSerializer.convertToJson(user);
        System.out.println(json);
    }
}
