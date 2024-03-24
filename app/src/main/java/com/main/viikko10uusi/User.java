package com.main.viikko10uusi;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

    private Boolean bachelor;
    private Boolean master;

    private Boolean licentiate;

    private Boolean doctor;
    public User (String firstName, String lastName, String email, String degreeProgram, Boolean bachelor, Boolean master, Boolean licentiate, Boolean doctor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.bachelor = bachelor;
        this.master = master;
        this.licentiate = licentiate;
        this.doctor = doctor;
    }




    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }
}
