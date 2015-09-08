package org.bradleyhart.training;

public class Limit {
    private int value;

    public Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Limit limit(int value){
        return new Limit(value);
    }
}
