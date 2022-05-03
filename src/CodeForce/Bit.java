package CodeForce;

import java.io.*;

// https://codeforces.com/problemset/problem/282/A
public class Bit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            if(str.equals("X++") || str.equals("++X"))
                result++;
            else if(str.equals("X--") || str.equals("--X"))
                result--;
        }
        System.out.println(result);
    }
}
