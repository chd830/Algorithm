package co.kr.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 영어끝말잇기 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
//        System.out.println(Arrays.toString(solution(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"})));
    }
    public static int[] solution(int n, String[] words) {
        int idx = 0;
        // 가장 먼저 탈락하는 사람과 몇 번 째에 탈락하는지
        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        for(int i = 1; i < words.length; i++) {
            idx = i;
            if(map.containsKey(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))
                return new int[] {idx%n+1, idx/n+1};
            map.put(words[i], 1);
        }
        return new int[] {0, 0};
    }
}
