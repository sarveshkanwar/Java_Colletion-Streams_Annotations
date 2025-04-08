package week4_assignment6.Annotations.Level3.Problem3;

public class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "is_active")
    private boolean active;

    public User(String username, int age, boolean active) {
        this.username = username;
        this.age = age;
        this.active = active;
    }
}
