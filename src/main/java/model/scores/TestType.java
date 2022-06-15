package model.scores;

public enum TestType {
    SAT(1920),
    ACT(27);
    private int acceptScore;

    TestType(int acceptScore) {
        this.acceptScore = acceptScore;
    }

    public int getInstantAcceptScore() {
        return this.acceptScore;
    }
}

