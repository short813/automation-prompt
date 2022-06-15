package Classifiers;

import com.college_screener.classifiers.reject.NameValidator;
import model.Candidate;
import model.Felonies;
import model.Residency;
import model.scores.GPA;
import model.scores.StandardTestingScores;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class CapitalizationRuleTest {
    @Test
    public void When_Applicant_Has_a_First_and_Last_Name_In_The_Correct_Format_Expect_Accept() {
        // Create Applicant that has a valid first and last name format
        Candidate candidate = new Candidate("Fred", "Flintstone", Residency.CA, new GPA(3.9, 4.0), 21, new ArrayList<Felonies>(), new ArrayList<StandardTestingScores>());
        NameValidator nameValidator = new NameValidator();
        String results = nameValidator.NameValidator(candidate);
        assert (Objects.equals(results, "further review"));
    }

    @Test
    public void When_Applicant_Has_a_First_Name_Not_In_The_Correct_Format_Expect_Reject() {
        // Create Applicant that has a valid first and last name format
        Candidate candidate = new Candidate("BOB", "Wilson", Residency.CA, new GPA(3.9, 4.0), 21, new ArrayList<Felonies>(), new ArrayList<StandardTestingScores>());
        NameValidator nameValidator = new NameValidator();
        String results = nameValidator.NameValidator(candidate);
        assert (Objects.equals(results, "instant reject"));
    }

    @Test
    public void When_Applicant_Has_a_Last_Name_Not_In_The_Correct_Format_Expect_Reject() {
        // Create Applicant that has a valid first and last name format
        Candidate candidate = new Candidate("Elon", "MUsk", Residency.CA, new GPA(3.9, 4.0), 21, new ArrayList<Felonies>(), new ArrayList<StandardTestingScores>());
        NameValidator nameValidator = new NameValidator();
        String results = nameValidator.NameValidator(candidate);
        assert (Objects.equals(results, "instant reject"));
    }

    @Test
    public void When_Applicant_Has_a_First_and_Last_Name_Not_In_The_Correct_Format_Expect_Reject() {
        // Create Applicant that has a valid first and last name format
        Candidate candidate = new Candidate("ALfred", "PennyWorth", Residency.CA, new GPA(3.9, 4.0), 21, new ArrayList<Felonies>(), new ArrayList<StandardTestingScores>());
        NameValidator nameValidator = new NameValidator();
        String results = nameValidator.NameValidator(candidate);
        assert (Objects.equals(results, "instant reject"));
    }
}
