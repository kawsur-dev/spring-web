package entity;

import javax.validation.constraints.*;

public class User {

    @NotNull(message = "First Name Can Not be empty")
    @Size(min = 2, max = 10)
    private String firstname;

    @NotNull(message = "Last Name Can Not be empty")
    private String lastname;

    @NotNull
    private Gender gender;

    @NotNull
    private Country country;

    public User() {
    }

    public User(String firstname, String lastname, Gender gender, Country country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.country = country;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
