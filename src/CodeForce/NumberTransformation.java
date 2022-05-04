package CodeForce;

import java.util.*;
import java.io.*;

// CodeForce: Number Transformation
public class NumberTransformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            if(y%x == 0)
                sb.append("1 ").append(y/x).append("\n");
            else
                sb.append("0 0\n");
        }
        System.out.println(sb.toString());
    }
}
