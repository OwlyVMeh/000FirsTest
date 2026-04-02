/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package owly.labrab8;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static owly.labrab8.LabRab8.calcDiagonalAverage;
import static owly.labrab8.LabRab8.generateMatrix;
import static owly.labrab8.LabRab8.printMatrix;
import static owly.labrab8.LabRab8.replaceNonDiagonal;

/**
 *
 * @author zhus
 */
public class LabRab8Test {

    public LabRab8Test() {
    }

    @org.junit.jupiter.api.Test
    public void testMain() throws Exception {
        int[][] expA = {{1, 1}, {1, 1}};
        int[][] testA = {{1, 1}, {1, 1}};
        int[][] expB = {{3, 2, 3}, {2, 3, 2}, {3, 2, 3}};
        int[][] testB = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
        double avg = calcDiagonalAverage(testA, testB);
        replaceNonDiagonal(testA, avg);
        if (!Arrays.deepEquals(testA, expA)) 
            throw new Exception("Test FAILED! matrix A");
        replaceNonDiagonal(testB, avg);
        if (!Arrays.deepEquals(testB, expB))
            throw new Exception("Test FAILED! matrix B");
    }
}
