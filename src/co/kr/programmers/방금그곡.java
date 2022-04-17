package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17683
public class 방금그곡 {
    public static void main(String[] args) {
//        System.out.println(solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
//        System.out.println(solution("ABC", new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        System.out.println(solution("A#", new String[] {"12:00,12:01,HELLO,A#"}));
//        System.out.println(solution("A#", new String[] {"12:00,12:01,HELLO,A#", "12:00,12:06,FOO,A#"}));
//        System.out.println(solution("CCB", new String[] {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"}));
//        System.out.println(solution("CC#BCC#BCC#", new String[] {"03:00,03:08,FOO,CC#"}));
        System.out.println(solution("CDEFGAC", new String[] {"23:00,00:06,HELLO,CDEFGA"}));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int playtime = 0;
        for(String info : musicinfos) {
            String[] music = info.split(",");
            int temp = time(music[0], music[1]);
            int time = temp;
            String str = "";
            for(int i = 0; temp > 0; i++) {
                if(i == music[3].length())
                    i = 0;
                str += music[3].charAt(i);
                if(i < music[3].length()-1 && music[3].charAt(i+1) == '#') {
                    str += '#';
                    i++;
                }
                temp--;
            }
            if(check(str, m) && playtime < time) {
                playtime = time;
                answer = music[2];
            }
        }
        return answer;
    }
    static boolean check(String str, String m) {
        for(int i = 0; i <= str.length()-m.length(); i++) {
            if(str.charAt(i) == m.charAt(0)) {
                if(str.contains(m)) {
                    if(i+m.length() >= str.length() || (i+m.length() < str.length() && str.charAt(i+m.length()) != '#'))
                        return true;
                }
            }
        }
        return false;
    }
    static int time(String t1, String t2) {
        int result = 0;
        int m1 = Integer.parseInt(t1.split(":")[0]);
        int s1 = Integer.parseInt(t1.split(":")[1]);
        int m2 = Integer.parseInt(t2.split(":")[0]);
        int s2 = Integer.parseInt(t2.split(":")[1]);
        result = s2-s1;
        if(result < 0) {
            result += 60;
            m2++;
        }
        if(m2-m1 < 0)
            m2 += 24;
        result += (m2-m1)*60;
        return result;
    }
}
