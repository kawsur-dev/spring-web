package entity;

import javax.validation.constraints.*;

public class User {

    @NotNull(message = "First Name Can Not be empty")
    @Size(min = 2, max = 10)
    private String firstname;

    @NotNull(message = "Last Name Can Not be empty")
    private String lastname;

    public User() {
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
