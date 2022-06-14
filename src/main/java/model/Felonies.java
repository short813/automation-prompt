package model;

import java.time.Year;
import java.time.LocalDate;


public class Felonies {
    private Year convictionDate;

    public Felonies(Year convictionDate) {
        this.convictionDate = convictionDate;

    }
    public Year getConvictionDate() {
        return this.convictionDate;
    }
}
