package org.bradleyhart.training;

public class LineLimit {
    private int value;

    private LineLimit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LineLimit lineLimit(int value){
        return new LineLimit(value);
    }

    boolean isReached(int distanceFromHead) {
        return (distanceFromHead + 1) % getValue() == 0;
    }

    boolean isReachedOnNonSpace(int index, char character) {
        return isReached(index) && character != ' ';
    }

    boolean isReachedOnSpace(int index, char character) {
        return isReached(index) && character == ' ';
    }

}
