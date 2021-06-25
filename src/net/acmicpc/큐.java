package net.acmicpc;

import java.util.*;
import java.io.*;

// 10845
public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while(N-- > 0) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push":
                    list.add(str[1]);
                    break;
                case "pop":
                    if(list.size() > 0) {
                        sb.append(list.get(0)).append("\n");
                        list.remove(0);
                    }
                    else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":
                    if(list.size() == 0)
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if(list.size() == 0)
                        sb.append(-1).append("\n");
                    else
                        sb.append(list.get(0)).append("\n");
                    break;
                case "back":
                    if(list.size()== 0)
                        sb.append(-1).append("\n");
                    else
                        sb.append(list.get(list.size()-1)).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
