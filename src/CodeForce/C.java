package CodeForce;

import java.util.*;
import java.io.*;

// CodeForce: Infinite Replacement
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int time = 0; time < T; time++) {
            String s = br.readLine();
            String t = br.readLine();
            if(t.length() == 1) {
                if(t.equals("a"))
                    sb.append("1\n");
                else
                    sb.append("2\n");
            }
            else {
                if(t.contains("a"))
                    sb.append("-1\n");
                else {
                    long answer = 1;
                    for(int i = s.length(); i > 0; i--)
                        answer *= i;
                    sb.append(answer+2).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
