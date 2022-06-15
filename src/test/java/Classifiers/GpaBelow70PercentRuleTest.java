package Classifiers;

import com.college_screener.classifiers.accept.GPAAccept;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class GpaBelow70PercentRuleTest {
    @Test
    public void When_Applicant_Has_a_GPA_Percentage_Less_Than_70_Percent_Expect_Reject() {
        // Create Applicant that has a GPA that is less than 70% of the scale
        Candidate candidate = new Candidate("Fred", "Flintstone", Residency.CA, new GPA(2.0, 4.0), 21, new ArrayList<Felonies>(), new ArrayList<StandardTestingScores>());
        GPAAccept gpaAccept = new GPAAccept();
        // Get Decision
        String results = gpaAccept.GPACheck(candidate);
        // Review Decision
        assert (Objects.equals(results, "instant reject"));
    }
}