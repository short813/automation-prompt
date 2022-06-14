package Classifiers;

import com.college_screener.classifiers.reject.AgeValidator;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class NegativeAgeRuleTest {
    @Test
    public void When_Applicant_Has_a_Negative_Age_Expect_Reject(){
        // Create Applicant with a negative age
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),-5, new ArrayList<Felonies>(),new ArrayList<StandardTestingScores>());
        AgeValidator age = new AgeValidator();
        // Get Decision
        String results = age.AgeCheck(candidate);
        // Review Decision
        assert(Objects.equals(results,"instant reject"));
    }
}
