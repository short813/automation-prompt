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

public class GpaAbove90PercentRuleTest {
    @Test
    public void When_Applicant_Has_a_GPA_Percentage_Greater_Than_90_Percent_Expect_Accept() {
        // Create Applicant that has a GPA that is less than 90% of the scale
        Candidate candidate = new Candidate("Fred", "Flintstone", Residency.CA, new GPA(4.8, 5.0), 21, new ArrayList<Felonies>(), new ArrayList<StandardTestingScores>());
        GPAAccept gpaAccept = new GPAAccept();
        // Get Decision
        String results = gpaAccept.GPACheck(candidate);
        // Review Decision
        assert (Objects.equals(results, "instant accept"));
    }
}
