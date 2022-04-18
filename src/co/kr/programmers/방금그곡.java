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
//        System.out.println(solution("CCB", new String[] {"03:00,03:08,adsd,CCB#CCB", "04:00,04:08,BAR,ABC"}));
//        System.out.println(solution("CC#BCC#BCC#", new String[] {"03:00,03:08,FOO,CC#"}));
//        System.out.println(solution("CDEFGACE#", new String[] {"23:00,00:06,HELLO,CDEFGACE#"}));
        System.out.println(solution("ABC", new String[] {"12:00,12:14,HELLO,CDEFGAB", "11:00,11:14,WORLD,ABCDEF"}));
    }

    public static String solution(String m, String[] musicinfos) {
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("E#", "e");
        String answer = "";
        String minimum = "23:59";
        int playtime = 0;
        for(String info : musicinfos) {
            String[] music = info.split(",");
            String[] starttime = music[0].split(":");
            String[] endtime = music[1].split(":");

            int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
            int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour * 60);
            String str = "";
            music[3] = music[3].replaceAll("C#", "c");
            music[3] = music[3].replaceAll("D#", "d");
            music[3] = music[3].replaceAll("F#", "f");
            music[3] = music[3].replaceAll("G#", "g");
            music[3] = music[3].replaceAll("A#", "a");
            music[3] = music[3].replaceAll("E#", "e");
            for(int i = 0; i < min; i++)
                str += music[3].charAt(i%music[3].length());
            if(str.contains(m)) {
                if(playtime < str.length()) {
                    playtime = str.length();
                    answer = music[2];
                }
            }
        }
        return answer.length() == 0 ? "(None)" : answer;
    }
}
