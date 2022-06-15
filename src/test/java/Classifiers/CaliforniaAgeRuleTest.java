package Classifiers;

import com.college_screener.classifiers.accept.ResidencyAccept;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class CaliforniaAgeRuleTest {

    @Test
    public void When_Applicant_Lives_In_California_And_Is_In_The_Age_Range_Expect_Accept(){
    // Create Applicant that lives in California and is in the age range of 17 and 26
    Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),new ArrayList<StandardTestingScores>());
    ResidencyAccept residencyAccept = new ResidencyAccept();
    String results = residencyAccept.ResidencyCheck(candidate);
    assert(Objects.equals(results,"instant accept"));
    }
    @Test
    public void When_Applicant_Lives_In_California_And_Is_Not_In_The_Age_Range_Expect_Further_Review(){
        // Create Applicant that lives in California and is not in the age range of 17 and 26
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),35, new ArrayList<Felonies>(),new ArrayList<StandardTestingScores>());
        ResidencyAccept residencyAccept = new ResidencyAccept();
        String results = residencyAccept.ResidencyCheck(candidate);
        assert(Objects.equals(results,"further review"));
    }

    @Test
    public void When_Applicant_Lives_In_California_And_Is_Over_80_Expect_Accept(){
        // Create Applicant that lives in California and is over the age of 80
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),81, new ArrayList<Felonies>(),new ArrayList<StandardTestingScores>());
        ResidencyAccept residencyAccept = new ResidencyAccept();
        String results = residencyAccept.ResidencyCheck(candidate);
        assert(Objects.equals(results,"instant accept"));
    }

    @Test
    public void When_Applicant_Lives_Outside_of_California_Expect_Further_Review(){
        // Create Applicant that lives in California and is not in the age range of 17 and 26
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.other,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),new ArrayList<StandardTestingScores>());
        ResidencyAccept residencyAccept = new ResidencyAccept();
        String results = residencyAccept.ResidencyCheck(candidate);
        assert(Objects.equals(results,"further review"));
    }

    @Test
    public void When_Applicant_Lives_Outside_Of_California_And_Is_Over_80_Expect_Accept(){
        // Create Applicant that lives in California and is not in the age range of 17 and 26
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.other,new GPA(3.9,4.0),81, new ArrayList<Felonies>(),new ArrayList<StandardTestingScores>());
        ResidencyAccept residencyAccept = new ResidencyAccept();
        String results = residencyAccept.ResidencyCheck(candidate);
        assert(Objects.equals(results,"instant accept"));
    }
}
