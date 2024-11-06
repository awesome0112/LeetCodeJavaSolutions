package Medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfMovesInAGrid {

    private static Set<String> cache;

    public int maxMoves(int[][] grid) {
        cache = new HashSet<>();
        int result = 0;
        int max = grid[0].length - 1;
        for (int row = 0; row < grid.length; row++) {
            int tmp = maxMoves(grid, row, 0);
            if (tmp > result) result = tmp;
            if (result == max) return result;
        }
        return result;
    }

    private int maxMoves(int[][] grid, int row, int column) {
        int top = 0, mid = 0, bottom = 0;
        if (checkTop(grid, row, column)) {
            top = 1 + maxMoves(grid, row - 1, column + 1);
        }
        if (checkMid(grid, row, column)) {
            mid = 1 + maxMoves(grid, row, column + 1);
        }
        if (checkBottom(grid, row, column)) {
            bottom = 1 + maxMoves(grid, row + 1, column + 1);
        }
        return Math.max(top, Math.max(mid, bottom));
    }


    private boolean checkTop(int[][] grid, int row, int column) {
        try {
            int newRow = row - 1;
            int newCol = column + 1;
            boolean res = grid[row][column] < grid[newRow][newCol];
            if (cache.contains(newRow + "" + newCol)) return false;
            else {
                if (res) cache.add(newRow + "" + newCol);
                return res;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkMid(int[][] grid, int row, int column) {
        try {
            int newRow = row;
            int newCol = column + 1;
            boolean res = grid[row][column] < grid[newRow][newCol];
            if (cache.contains(newRow + "" + newCol)) return false;
            else {
                if (res) cache.add(newRow + "" + newCol);
                return res;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkBottom(int[][] grid, int row, int column) {
        try {
            int newRow = row + 1;
            int newCol = column + 1;
            boolean res = grid[row][column] < grid[newRow][newCol];
            if (cache.contains(newRow + "" + newCol)) return false;
            else {
                if (res) cache.add(newRow + "" + newCol);
                return res;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
