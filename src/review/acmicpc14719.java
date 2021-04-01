package review;

import java.util.*;
import java.io.*;

// 빗물
public class acmicpc14719 {
    static int trap(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int water = 0, i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    // find the smaller height between the two sides
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    // calculate the area
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int res = 0;
        int[] arr = new int[m];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i < m-1; i++) {
            int left = 0;
            int right = 0;
            for(int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for(int j = i+1; j < m; j++) {
                right = Math.max(right, arr[j]);
            }
            res += Math.max(0, Math.min(left, right)-arr[i]);
        }
        System.out.println(res);
    }
}
