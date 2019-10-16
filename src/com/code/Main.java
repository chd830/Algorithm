package com.code;

public class Main {
    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {{1,2,5},{3,2,1}};
        System.out.println(m.minPathSum(grid));
    }
}
