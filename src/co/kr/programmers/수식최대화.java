package co.kr.programmers;

import java.util.ArrayList;

public class 수식최대화 {
    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }

    private static char[] cal = {'+', '-', '*'}; //조합에 사용
    private static char[] temp = new char[3]; //모든 조합
    private static boolean[] visit = new boolean[3]; //방문 체크
    private static ArrayList<Long> nums = new ArrayList<Long>(); //주어진 숫자 담기
    private static ArrayList<Character> ops = new ArrayList<Character>(); //주어진 문자 담기
    private static long answer; //답

    public static long solution(String expression) {
        answer = 0;

        String[] num = expression.replaceAll("\\*", " ").replaceAll("-", " ").replaceAll("\\+", " ").split(" ");
        for(String n : num)
            nums.add(Long.parseLong(n));
        String oper = expression.replaceAll("\\d", "");
        for(char c : oper.toCharArray())
            ops.add(c);
        dfs(0);
        return answer;
    }

    // permutation
    public static void dfs(int start) {
        if (start == 3) {
            math();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp[start] = cal[i];
                dfs(start + 1);
                visit[i] = false;
            }
        }
    }

    public static void math() {
        // 주어진 숫자와 연산 그대로 복사
        ArrayList<Long> copyNums = new ArrayList<>(nums);
        ArrayList<Character> copyOps = new ArrayList<Character>(ops);

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < copyOps.size(); j++) {
                if (temp[i] == copyOps.get(j)) {
                    //숫자2개, 연산자1개 보내서 연산
                    Long res = calc(copyNums.remove(j), copyNums.remove(j), temp[i]);
                    //연산결과값 넣기
                    copyNums.add(j, res);
                    copyOps.remove(j);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(copyNums.get(0)));

    }

    public static Long calc(Long num1, Long num2, char op) {
        switch (op) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        return (long) 0;
    }
}
