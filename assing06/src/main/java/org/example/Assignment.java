package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = generateAssignmentId();
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public double getAssignmentAverage() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }


    public ArrayList<Integer> getScores() {
        return scores;
    }

    public static int getNextId() {
        return nextId;
    }

    public void calcAssignmentAvg() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        assignmentAverage = (double) sum / scores.size();
    }

    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int randomNumber = random.nextInt(11);
            int score;
            switch (randomNumber) {
                case 0:
                    score = random.nextInt(60);
                    break;
                case 1:
                case 2:
                    score = random.nextInt(10) + 60;
                    break;
                case 3:
                case 4:
                    score = random.nextInt(10) + 70;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    score = random.nextInt(10) + 80;
                    break;
                default:
                    score = random.nextInt(11) + 90;
            }
            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                ", assignmentAverage=" + assignmentAverage +
                ", scores=" + scores +
                '}';
    }

    private String generateAssignmentId() {
        return "A" + String.format("%04d", nextId++);
    }
}
