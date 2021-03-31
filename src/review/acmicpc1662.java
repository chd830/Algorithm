package review;

import java.util.*;
import java.io.*;

// 압축
public class acmicpc1662 {
    static int[] parents = new int[50];
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        chars = br.readLine().toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(')
                stack.push(i);
            if(chars[i] == ')')
                parents[stack.pop()] = i;
        }
        System.out.println(traversal(0, chars.length));
    }
    static int traversal(int start, int end) {
        int sLength = 0;

        for (int i = start; i < end; i++) {
            if (chars[i] == '(') {
                sLength += (chars[i - 1] - '0') * traversal(i + 1, parents[i]) - 1;
                i = parents[i];
            } else {
                sLength++;
            }
        }
        return sLength;
    }
}
/*
3(3(3(2(2)2(2))))
33(562(71(9)))
 */

