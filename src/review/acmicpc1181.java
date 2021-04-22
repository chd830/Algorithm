package review;

import java.util.*;
import java.io.*;

// 단어 정렬
public class acmicpc1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        String[] arr = new String[map.size()];
        int idx = 0;
        for(String s : map.keySet()) {
            arr[idx++] = s;
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    for(int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) == o2.charAt(i))
                            continue;
                        return Integer.compare(o1.charAt(i), o2.charAt(i));
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Arrays.sort(arr, comp);
        for(String s : arr)
            System.out.println(s);
    }
}
