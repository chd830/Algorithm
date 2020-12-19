package review;

import java.io.*;

public class 팰린드롬만들기 {
    static String str;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        isPalindrome(str);
        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            isPalindrome(str + sb.reverse().toString());
            sb.reverse();
        }
        System.out.println(min);
    }

    public static void isPalindrome(String strs) {
        StringBuilder sb = new StringBuilder();
        for(char c : strs.toCharArray()) {
            sb.append(c);
        }
//        System.out.println(strs+"\t"+sb);
        if(sb.reverse().toString().equals(strs)) {
            min = Math.min(min, sb.length());
        }
    }
}
