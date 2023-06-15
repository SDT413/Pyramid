package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {
    //This is algorithm works a lot faster because it doesn't use recursion for calculations.
 @Override
  public long pyramidMaximumTotal(Pyramid pyramid) { // the algorithm itself is quite simple.
      // It starts from the second row and adds the maximum value from the previous row to the current element.
     // The maximum value is the maximum of the two adjacent elements in the previous row.
      // The result is the value of the top element, which presents the end value for this path.
      int rows = pyramid.getRows();
      int[][] data = pyramid.getData();
      for (int i = 1; i < rows; i++) {
          for (int j = 0; j < rows-i; j++) {
              data[i][j] += Math.max(data[i - 1][j], data[i - 1][j + 1]);
          }
        }
      return  data[rows-1][0];
  }
}

