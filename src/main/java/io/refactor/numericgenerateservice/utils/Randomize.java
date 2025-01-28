package io.refactor.numericgenerateservice.utils;

public class Randomize {
    public static int rnd(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
