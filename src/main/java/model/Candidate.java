package model;

import model.scores.GPA;
import model.scores.StandardTestingScores;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
    private String firstName;
    private String lastName;
    private Residency state;
    private GPA gpa;
    private int age;
    private List<Felonies> felonies;
    private List<StandardTestingScores> score;

    public Candidate(String firstName, String lastName, Residency state, GPA gpa, int age, ArrayList<Felonies> felonies, ArrayList<StandardTestingScores> score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.gpa = gpa;
        this.age = age;
        this.felonies = felonies;
        this.score = score;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Residency getState() {
        return this.state;
    }

    public GPA getGpa() {
        return this.gpa;
    }

    public int getAge() {
        return this.age;
    }

    public List<Felonies> getFelonies() {
        return this.felonies;
    }

    public List<StandardTestingScores> getScore() {
        return this.score;
    }
}
