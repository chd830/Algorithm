package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class K번째수 {
    public static void main(String[] args) {
        solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
            int[] copy = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(copy);
            result[idx++] = copy[command[2]-1];
        }
        return result;
    }

}
