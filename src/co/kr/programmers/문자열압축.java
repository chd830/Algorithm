package co.kr.programmers;

public class 문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1)
            return 1;
        for(int i = 1; i < s.length(); i++) {
            String now = "";
            String comp = "";
            String tmp = "";
            int cnt = 1;
            for(int j = 0; j < s.length()/i; j++) {
                int from = i*j;
                int to = i*(j+1);

                if(to > s.length())
                    to = s.length();
                now = comp;
                comp = s.substring(from, to);

                if(now.equals(comp))
                    cnt++;
                else {
                    if(cnt > 1)
                        tmp += String.valueOf(cnt);
                    tmp += now;
                    cnt = 1;
                }
//                System.out.println(now+"\t"+comp+"\t"+tmp);
            }
            if(cnt > 1)
                tmp += String.valueOf(cnt);
            tmp += comp;
            answer = Math.min(tmp.length(), answer);
        }
        return answer;
    }
}
