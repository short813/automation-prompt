package Classifiers;

import com.college_screener.classifiers.reject.FelonyValidator;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import org.junit.Test;

import java.util.ArrayList;
import java.time.Year;
import java.util.Objects;

public class FeloniesRuleTest {
    @Test
    public void When_Applicant_Has_a_Felony_Within_The_Last_5_Years_Expect_Reject() {
    // Create Applicant with a felony within the last 5 years
    ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
    Felonies  first_felony = new Felonies(Year.of(2020));
    feloniesArrayList.add(first_felony);
    Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, feloniesArrayList,new ArrayList<StandardTestingScores>());
    FelonyValidator felonyValidator = new FelonyValidator();
    String results = felonyValidator.FelonyCheck(candidate);
    assert(Objects.equals(results,"instant reject"));
    }

    @Test
    public void When_Applicant_Does_Not_Have_a_Felony_Within_The_Last_5_Years_Expect_Further_Review() {
        // Create Applicant with a felony within the last 5 years
        ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
        Felonies  first_felony = new Felonies(Year.of(2010));
        feloniesArrayList.add(first_felony);
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, feloniesArrayList,new ArrayList<StandardTestingScores>());
        FelonyValidator felonyValidator = new FelonyValidator();
        String results = felonyValidator.FelonyCheck(candidate);
        assert(Objects.equals(results,"further review"));
    }

    @Test
    public void When_Applicant_Does_Not_Have_Any_Felonies_Expect_Further_Review() {
        // Create Applicant with a felony within the last 5 years
        ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, feloniesArrayList,new ArrayList<StandardTestingScores>());
        FelonyValidator felonyValidator = new FelonyValidator();
        String results = felonyValidator.FelonyCheck(candidate);
        assert(Objects.equals(results,"further review"));
}
}
