package STL;

import java.util.*;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa22", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
    public static int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i < str1.length()-1; i++) {
            String tmp = str1.substring(i, i+2);
            char first = tmp.charAt(0);
            char second = tmp.charAt(1);
            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z')
                list1.add(tmp);
        }
        for(int i = 0; i < str2.length()-1; i++) {
            String tmp = str2.substring(i, i+2);
            char first = tmp.charAt(0);
            char second = tmp.charAt(1);
            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z')
                list2.add(tmp);
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int intersection = 0;
        int union = 0;
        for(String s : list1) {
            if(list2.remove(s))
                intersection++;
            union++;
        }
        union += list2.size();

        double answer = 0;
        if(union == 0)
            answer = 1;
        else
            answer = (double)intersection/union;
        return (int)(answer*65536);
    }
}
