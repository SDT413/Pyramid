package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually... 
 */
public class NaivePyramidSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
    }

    private long getTotalAbove(int row, int column, Pyramid pyramid) {
        if (row == 0)
        {
            // Previous variant did nothing(returned 0), when it reached the top of the pyramid.
            return pyramid.get(row, column); // So, I changed it to return the value of the top element,
            // which presents the end value for this path.
        }
        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalAbove(row - 1, column, pyramid);
        long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);
        return Math.max(left, right);
    }
    //This is a recursive solution, which is not the best solution for this problem,
    // since it will take a lot of time to calculate the result.
    //The better solution is implemented in YourSolver.java
}