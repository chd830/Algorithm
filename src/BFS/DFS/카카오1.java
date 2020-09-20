package BFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카카오1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();
        System.out.println(solution(new_id));
    }
    public static String solution(String new_id) {
        // stage1
        new_id = new_id.toLowerCase();
        // stage2
        String copy = "";
        for(char c : new_id.toCharArray()) {
            if(c == '-' || c == '_' || c == '.' || Character.isDigit(c) || Character.isAlphabetic(c)) {
                copy += c;
            }
        }
        new_id = copy;
        // stage3
        copy = "";
        char prev = ' ';
        for(char c : new_id.toCharArray()) {
            if(c == '.' && prev == c) {
                continue;
            }
            copy += c;
            prev = c;
        }
        new_id = copy;
        // stage4
        if(new_id.length() == 1 && new_id.charAt(0) == '.') {
            new_id = "";
        }
        if(new_id.length() > 1 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length() >= 1 && new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }
        // stage5
        if(new_id.length() == 0) {
            new_id = "a";
        }
        // stage6
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        // stage7
        if(new_id.length() <= 2) {
            char lastChar = new_id.charAt(new_id.length()-1);
            while(new_id.length() != 3) {
                new_id += lastChar;
            }
        }
        return new_id;
    }
}
