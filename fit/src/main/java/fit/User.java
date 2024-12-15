package fit;

public class User {
    private String username;
    private boolean isAdmin;

    // Constructor to initialize User
    public User(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    // Getter for isAdmin
    public boolean isAdmin() {
        return isAdmin;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username (if needed)
    public void setUsername(String username) {
        this.username = username;
    }
}
