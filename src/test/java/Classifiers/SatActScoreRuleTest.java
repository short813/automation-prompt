package Classifiers;

import com.college_screener.Application_Screener;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import model.scores.TestType;
import org.junit.Test;

import java.util.ArrayList;

public class SatActScoreRuleTest {
    @Test
    public void When_Applicant_SAT_Score_Valid_Expect_Accept() {

        // Create Applicant with 1920 SAT score
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(1930, TestType.SAT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),standardScore);
        // Get Decision
        Application_Screener screen_results = new Application_Screener();
        String results = screen_results.Screenerv2(candidate);
        // Review Decision
    }


}
