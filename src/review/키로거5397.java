package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 키로거5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            List<Character> list = new ArrayList<>();
            int idx = 0;
            int cnt = 0;
            for(char c : str.toCharArray()) {
                switch (c) {
                    case '<':
                        if(idx != 0)
                            idx--;
                        break;
                    case '>':
                        if(idx != cnt) {
                            idx++;
                        }
                        break;
                    case '-':
                        list.remove(--idx);
                        cnt--;
                        break;
                    default:
                        list.add(idx++,c);
                        cnt++;
                        break;
                }
            }
            for(int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
