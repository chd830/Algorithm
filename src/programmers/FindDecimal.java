package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindDecimal {
    /*
        1. numbers에서 나올 수 있는 모든 숫자를 list로 만들기
        2. list에 있는 숫자가 소수인지 확인하기
     */
    static int answer = 0;

    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        while(set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if(a == 2)
                answer++;
            if(a % 2 != 0 && isDecimal(a)) {
                answer++;
            }
        }
        return answer;
    }
    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }

    public boolean isDecimal(int num) {
        if(num == 0 || num == 1)
            return false;
        int count = 0;
        for(int a = 1; a < num; a++) {
            if(num % a == 0)
                count++;
        }
        if(count > 1)
            return false;
        return true;
    }
}
