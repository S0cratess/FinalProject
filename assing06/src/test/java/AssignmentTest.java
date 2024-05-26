package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AssignmentTest {

    @Test
    void testCalcAssignmentAvg() {
        Assignment assignment = new Assignment("Assignment 1", 0.3, 100);

        List<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(70);
        assignment.setScores(scores);

        assignment.calcAssignmentAvg();

        Assertions.assertEquals(80.0, assignment.getAssignmentAverage());
    }

    @Test
    void testIsAssignmentsTotalWeightValid() {
        List<Assignment> assignments1 = new ArrayList<>();
        assignments1.add(new Assignment("Assignment 1", 0.3, 100));
        assignments1.add(new Assignment("Assignment 2", 0.4, 100));
        assignments1.add(new Assignment("Assignment 3", 0.3, 100));


        List<Assignment> assignments2 = new ArrayList<>();
        assignments2.add(new Assignment("Assignment 1", 0.3, 100));
        assignments2.add(new Assignment("Assignment 2", 0.4, 100));

        Assertions.assertTrue(Assignment.isAssignmentsTotalWeightValid(assignments1));

        Assertions.assertFalse(Assignment.isAssignmentsTotalWeightValid(assignments2));
    }
}
