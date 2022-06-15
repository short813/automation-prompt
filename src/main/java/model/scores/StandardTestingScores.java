package model.scores;

public class StandardTestingScores {
    //Score
    // Test Type
        //Enum of SAT or ACT
    private int score;
    private TestType testType;

    public StandardTestingScores(int score, TestType testType) {
        this.score = score;
        this.testType = testType;
    }

    public int getScore() {
        return this.score;
    }

    public TestType getTestType() {
        return this.testType;
    }
}
