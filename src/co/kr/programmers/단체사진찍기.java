package co.kr.programmers;

//import java.util.Arrays;

public class 단체사진찍기 {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[] {"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[] {"M~C<2", "C~M>1"}));
    }
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static String[] sub = new String[friends.length];
    static boolean[] visited = new boolean[friends.length];
    public static int solution(int n, String[] data) {
        answer = 0;
        perm(0, data);
        return answer;
    }
    static boolean check(String str, String[] data) {
        boolean check = true;
        for(String d : data) {
            if(!check)
                return false;
            int start = str.indexOf(d.charAt(0));
            int end = str.indexOf(d.charAt(2));
            int term = Math.abs(start - end);
            int num = d.charAt(4)-'0';
            switch (d.charAt(3)) {
                case '=':
                    check = term == num+1 ? true : false;
                    break;
                case '>':
                    check = term > num+1 ? true : false;
                    break;
                case '<':
                    check = term < num+1 ? true : false;
                    break;
            }
        }
        return check;
    }
    static int answer;
    static void perm(int idx, String[] data) {
        if(idx == sub.length) {
            String str = "";
            for(String s : sub)
                str += s;
            if(check(str, data)) {
                answer++;
            }
            return;
        }
        for(int i = 0; i < friends.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = friends[i];
                perm(idx+1, data);
                visited[i] = false;
            }
        }
    }
}
