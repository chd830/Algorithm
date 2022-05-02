package CodeForce;

import java.util.*;
import java.io.*;

// CodeForce: Number Transformation
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            if(x > y)
                sb.append("0 0\n");
            else if(x == y)
                sb.append("3 1\n");
            else if(y%x != 0)
                sb.append("0 0\n");
            else {
                int div = y / x;
                int start = 1;
                int end = div;
                int result = 0;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (div % mid == 0)
                        result = mid;
                    if (div / mid > mid)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                if (result == 0)
                    sb.append("0 0\n");
                else {
                    int cnt = 0;
                    while(div > 1) {
                        div /= start;
                        cnt++;
                    }
                    sb.append(cnt).append(" ").append(result).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
