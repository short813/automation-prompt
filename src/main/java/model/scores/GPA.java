package model.scores;

public class GPA {
    private double score;
    private double scale;
    public GPA(double score, double scale) {
        this.score = score;
        this.scale = scale;
    }

    public double getScore() {
        return this.score;
    }

    public double getScale() {
        return this.scale;
    }

    public double getPercentage() {
        return this.score / this.scale;
    }
}
