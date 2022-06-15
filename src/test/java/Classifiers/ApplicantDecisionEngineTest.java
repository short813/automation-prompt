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
import java.util.Objects;

public class ApplicantDecisionEngineTest {
    @Test
    public void When_Applicant_Fulfills_All_Instant_Accept_Expect_Instant_Accept() {
        ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(2000, TestType.SAT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred", "Flintstone", Residency.CA, new GPA(3.9, 4.0), 21, feloniesArrayList, standardScore);
        Application_Screener application_screener = new Application_Screener();
        String results = application_screener.CandidateScreening(candidate);
        System.out.println(results);
        assert (Objects.equals(results, "instant accept"));
    }

    @Test
    public void When_Applicant_Fails_a_Criteria_Expect_Instant_Reject() {
        ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(2000, TestType.SAT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred", "Flintstone", Residency.CA, new GPA(2.0, 4.0), 21, feloniesArrayList, standardScore);
        Application_Screener application_screener = new Application_Screener();
        String results = application_screener.CandidateScreening(candidate);
        System.out.println(results);
        assert (Objects.equals(results, "instant reject"));
    }

    @Test
    public void When_Applicant_Does_Not_Have_All_Instant_Accept_Expect_Further_Review() {
        ArrayList<Felonies> feloniesArrayList = new ArrayList<>();
        ArrayList<StandardTestingScores> standardScore = new ArrayList<StandardTestingScores>();
        StandardTestingScores standardTestingScores = new StandardTestingScores(2000, TestType.SAT);
        standardScore.add(standardTestingScores);
        Candidate candidate = new Candidate("Fred", "Flintstone", Residency.other, new GPA(3.9, 4.0), 21, feloniesArrayList, standardScore);
        Application_Screener application_screener = new Application_Screener();
        String results = application_screener.CandidateScreening(candidate);
        System.out.println(results);
        assert (Objects.equals(results, "further review"));
    }
}
