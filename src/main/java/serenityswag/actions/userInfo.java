package serenityswag.actions;

public enum userInfo {


    standard_user("standard_user", "secret_sauce", "description1"),
    locked_out_user("locked_out_user", "secret_sauce", "description2"),
    problem_user("problem_user", "secret_sauce", "description3"),
    performance_glitch_user("performance_glitch_user", "secret_sauce", "description4");


    private final String username;
    private final String password;
    private final String description;


    userInfo(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }
}
