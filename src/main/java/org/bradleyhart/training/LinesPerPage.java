package org.bradleyhart.training;

public class LinesPerPage {

    private int value;

    private LinesPerPage(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean hasReachedLimit(int distanceFromHead) {
        return (distanceFromHead + 1) % getValue() == 0;
    }

    public static LinesPerPage linesPerPage(int value){
        return new LinesPerPage(value);
    }
}
