package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kakao02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        solution(str);
    }

    public static String solution(String p) {
        StringBuilder sb = solve(p);

        return sb.toString();
    }

    private static StringBuilder solve(String str) {

        StringBuilder u = new StringBuilder("");
        StringBuilder v = new StringBuilder("");

        int open = 0;//여는 괄호
        int close = 0;//닫는 괄호

        //u와 v를 생성
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') open++;
            else close++;

            if (open == close) {//괄호의 갯수가 같아지는 지점이 u와 v를 나누는 기준
                u.append(str.substring(0, i + 1));
                v.append(str.substring(i + 1));
                break;
            }
        }

        //v에 대해서 재귀를 통해 괄호 검사
        if (!"".equals(v.toString())) v = solve(v.toString());

        StringBuilder sb = new StringBuilder("");

        //올바르지 않은 문자열일 때,
        if (!isCorrect(u)) {

            //v의 앞,뒤로 괄호 추가
            sb.append("(" + v.toString() + ")");

            //u의 앞,뒤를 제거하고 모든 괄호를 뒤집어주고 v에 붙여준다.
            for (int i = 1; i < u.length() - 1; i++) {

                if (u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }

        } else {//올바른 괄호일 때

            //u에 뒤에 v를 붙여준다.
            sb.append(u.toString() + v.toString());
        }

        return sb;
    }

    //올바른 괄호 체크
    private static boolean isCorrect(StringBuilder u) {

        //첫 번째와 마지막이 쌍을 이루는지 체크
        return u.charAt(0) == '(' && u.charAt(u.length() - 1) == ')';
    }
}
