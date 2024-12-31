import java.util.HashMap;

public class Authenticator {
    private HashMap<String, User> users = new HashMap<>();

    public Authenticator() {
        users.put("John", new User("John", "pass2"));
        users.put("Jane", new User("Jane", "pass3"));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.authenticate(password);
    }
}