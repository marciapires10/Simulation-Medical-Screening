package MPEI;

import java.util.Random;

public class StochasticCounter {
    private int count = 0;
    private double prob;
    private String name;

    public StochasticCounter() {
        this.prob = 0.0;
    }

    public StochasticCounter(double prob) {
        this.prob = prob;
    }

    public StochasticCounter(double prob, String name) {
        this.prob = prob;
        this.name = name;
    }

    public double value() {
        return count;
    }

    public String name() {
        return name;
    }

    public void event() {
        if (prob > 0.0) {
            double random = Math.random();
            if (random <= prob) {
                count++;
            }
        }
    }

    public static int event(int nTimes) {
        double random;
        int count = 0;
        for (int i = 0; i < nTimes; i++) {
            if ((random = Math.random()) < 0.25) {
                count++;
            }
        }
        return count;
    }
}