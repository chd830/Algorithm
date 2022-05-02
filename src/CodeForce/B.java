package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// CodeForce: Dictionary
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            int start = str.charAt(0)-'a';
            int end = str.charAt(1)-'a';
            int dict = 26*start+end;
            if(start > 0) {
                dict -= start-1;
                if(start < end)
                    dict--;
            }
            sb.append(dict).append("\n");
        }
        System.out.println(sb.toString());
    }
}
