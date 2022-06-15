package Classifiers;

import com.college_screener.Application_Screener;
import com.college_screener.classifiers.accept.StandardizedTesting;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import model.scores.TestType;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Objects;

public class SatActScoreRuleTest {
    @Test
    public void When_Applicant_SAT_Score_Valid_Expect_Accept() {

        // Create Applicant with 1920 SAT score
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(2000, TestType.SAT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),standardScore);
        // Get Decision
        StandardizedTesting test_check = new StandardizedTesting();
        String results = test_check.StandardizedTestingCheck(candidate);
        // Review Decision
        System.out.println(results);
        assert(Objects.equals(results, "instant accept"));
    }

    @Test
    public void When_Applicant_SAT_Score_Lower_Than_Needed_Expect_Further_Review() {

        // Create Applicant with 1920 SAT score
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(1900, TestType.SAT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),standardScore);
        // Get Decision
        StandardizedTesting test_check = new StandardizedTesting();
        String results = test_check.StandardizedTestingCheck(candidate);
        // Review Decision
        System.out.println(results);
        assert(Objects.equals(results, "further review"));
    }

    @Test
    public void When_Applicant_ACT_Score_Higher_Than_Needed_Expect_Instant_Accept() {

        // Create Applicant with 1920 SAT score
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(29, TestType.ACT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),standardScore);
        // Get Decision
        StandardizedTesting test_check = new StandardizedTesting();
        String results = test_check.StandardizedTestingCheck(candidate);
        // Review Decision
        System.out.println(results);
        assert(Objects.equals(results, "instant accept"));
    }

    @Test
    public void When_Applicant_ACT_Score_Lower_Than_Needed_Expect_Further_Review() {

        // Create Applicant with 1920 SAT score
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(20, TestType.ACT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred","Flintstone", Residency.CA,new GPA(3.9,4.0),21, new ArrayList<Felonies>(),standardScore);
        // Get Decision
        StandardizedTesting test_check = new StandardizedTesting();
        String results = test_check.StandardizedTestingCheck(candidate);
        // Review Decision
        System.out.println(results);
        assert(Objects.equals(results, "further review"));
    }
}
