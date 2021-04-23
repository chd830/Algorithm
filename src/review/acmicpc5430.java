package review;

import java.util.*;
import java.io.*;

// AC
public class acmicpc5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        loop: for(int t = 0; t < T; t++) {
            String str = br.readLine();
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            String arrays = br.readLine();
            arrays = arrays.replaceAll("\\[", "").replaceAll("\\]", "");
            StringTokenizer token = new StringTokenizer(arrays, "\\,");
            for(int i = 0; i < N; i++) {
                list.add(Integer.parseInt(token.nextToken()));
            }
            boolean dir = true;
            int start = 0;
            int end = N;
            for(char c : str.toCharArray()) {
                switch (c) {
                    case 'R':
                        dir = !dir;
                        break ;
                    case 'D':
                        if(start == end) {
                            System.out.println("error");
                            continue loop;
                        }
                        if(dir) {
                            start++;
                        }
                        else {
                            end--;
                        }
                        break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if(dir) {
                sb.append("[");
                for(int i = start; i < end; i++) {
                    sb.append(list.get(i));
                    if(i != end-1)
                        sb.append(",");
                }
                sb.append("]");
            }
            else {
                sb.append("[");
                for(int i = end-1; i >= start; i--) {
                    sb.append(list.get(i));
                    if(i != start)
                        sb.append(",");
                }
                sb.append("]");
            }
            System.out.println(sb);
        }
    }
}
/*
1
RRDDDDDRRRRRDRDDDRRRRRDRRDRRRR
18
[65,14,87,67,55,58,23,51,85,41,69,25,31,63,70,64,59,21]
 */