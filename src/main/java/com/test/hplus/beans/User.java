package com.test.hplus.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    private int id;
    //Here we are requiring the username to be at least six characters long, if it won't be, a custom message will be printed out.
    @Size(min=6, message = "{username.cannot.be.less.than.six.characters}")
    private String username;
    /*
    Here a regular expression is assigned as an allowed pattern for the password attribute.
    The regular expression defined below accepts at least one capital letter
    and the range of the password should be at between 6 and 10 characters.
     */
    @Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "Password must have one upper case, one lower and should be between 6 and 10 characters." )
    private String password;
    //@Enumerated allows us to persist an enum as a string.
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Activity cannot be left empty.")
    private String activity;
    @NotEmpty(message = "First name cannot be left empty.")
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
