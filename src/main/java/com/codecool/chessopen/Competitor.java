package com.codecool.chessopen;

public class Competitor implements Comparable<Competitor> {
    private String name;
    private int maxScore;

    public Competitor(String name, int[] results) {
        this.name = name;
        setMaxScore(results);
    }

    public void setMaxScore(int[] results) {
        this.maxScore = results[0] + results[1] + results[2] + results[3] + results[4];
    }

    public int getMaxScore() {
        return maxScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Competitor o) {
        return Double.compare(this.maxScore, o.getMaxScore());
    }
}
