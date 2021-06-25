import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println("----------17----------");
        System.out.println(solution("17"));
        System.out.println("----------2----------");
        System.out.println(solution("2"));
        System.out.println("----------222----------");
        System.out.println(solution("222"));
        System.out.println("----------1276543---------");
        System.out.println(solution("1276543"));

    }
    static boolean[] prime = new boolean[12345678];
    static boolean[] visited;
    static int[] sub;
    static int answer;
    public static int solution(String numbers) {
        answer = 0;
        setPrime();
        for(int i = 1; i <= numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            sub = new int[i];
            perm(0, numbers);
        }
        return answer;
    }
    static void setPrime() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i <= 10000000; i++) {
            for(int j = i+i; j <= 10000000; j += i) {
                prime[j] = false;
            }
        }
    }
    static void perm(int idx, String numbers) {
        if(idx == sub.length) {
            String num = "";
            for(int i : sub)
                num += i;
            int n = Integer.parseInt(num);
            if(prime[n]) {
                prime[n] = false;
                answer++;
            }
            return;
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = numbers.charAt(i)-'0';
                perm(idx+1, numbers);
                visited[i] = false;
            }
        }
    }
}