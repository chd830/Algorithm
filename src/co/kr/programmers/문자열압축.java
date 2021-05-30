package co.kr.programmers;

public class 문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        int num = 1;
        String tmp = "";
        int answer = 0;
        int len = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            for (int j = 0; j <= s.length(); j += i) {
                if (i <= s.substring(j).length()) {
                    if (tmp.matches(s.substring(j, j + i))) num++;
                    else {
                        if (num > 1) answer += Integer.toString(num).length();
                        answer += tmp.length();
                        tmp = s.substring(j, j + i);
                        num = 1;
                    }
                } else {
                    if (num > 1) answer += Integer.toString(num).length();
                    answer += s.substring(j - i).length();
                }
            }
            if (len > answer) len = answer;
            answer = 0;
            num = 1;
            tmp = "";
        }
        return len;
    }
}