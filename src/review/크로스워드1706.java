package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 크로스워드1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        char[][] puzzles = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                puzzles[i][j] = str.charAt(j);
            }
        }
        List<String> words = new ArrayList<>();
        //가로
        for(int i = 0; i < R; i++) {
            int cnt = 0;
            String str = "";
            for(int j = 0; j < C; j++) {
                if(puzzles[i][j] == '#') {
                    cnt = 0;
                    if(str.length() > 1) {
                        words.add(str);
                    }
                    str = "";
                    continue;
                }
                str += puzzles[i][j];
            }
            if(str.length() > 1) {
                words.add(str);
            }
        }
        //세로
        for(int i = 0; i < C; i++) {
            int cnt = 0;
            String str = "";
            for(int j = 0; j < R; j++) {
                if(puzzles[j][i] == '#') {
                    cnt = 0;
                    if(str.length() > 1) {
                        words.add(str);
                    }
                    str = "";
                    continue;
                }
                str += puzzles[j][i];
            }
            if(str.length() > 1) {
                words.add(str);
            }
        }
//        for(String word : words) {
//            System.out.println(word);
//        }
        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
