package 구현;

// https://programmers.co.kr/learn/courses/30/lessons/84512
public class 모음사전 {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }
    static char[] alph = {'A', 'E', 'I', 'O', 'U'};
    public static int solution(String word) {
        cnt = 0;
        result = 0;
        recur("", word);
        return result;
    }
    static int result;
    static int cnt;
    static void recur(String word, String compare) {
        if(word.equals(compare)) {
            result = cnt;
            return;
        }
        for(int i = 0; i < alph.length; i++) {
            if(word.length() < 5) {
                cnt++;
                recur(word + alph[i], compare);
            }
        }
    }
}
