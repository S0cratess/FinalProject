package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private List<Integer> scores;
    private static int nextId = 1;

    /**
     * Constructs an Assignment Obj
     * @param assignmentName name asign
     * @param weight weight asign
     * @param maxScore maximum score
     */
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

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public static int getNextId() {
        return nextId;
    }

    public void calcAssignmentAvg() {
        if (scores.isEmpty()) {
            assignmentAverage = 0.0;
        } else {
            double sum = scores.stream().mapToInt(Integer::intValue).sum();
            assignmentAverage = sum / scores.size();
        }
    }

    public void generateRandomScore() {
        Random random = new Random();
        scores.clear();
        for (int i = 0; i < maxScore; i++) {
            int score = random.nextInt(maxScore + 1);
            scores.add(score);
        }
    }

    public static boolean isAssignmentsTotalWeightValid(List<Assignment> assignments) {
        double totalWeight = assignments.stream().mapToDouble(Assignment::getWeight).sum();
        return Math.abs(totalWeight - 1.0) < 1e-5;
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
