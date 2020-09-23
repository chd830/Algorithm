package net.acmicpc.re;

import java.util.*;

public class 카카오5 {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        String[] start = new String[logs.length];
        String[] end = new String[logs.length];
        List<Time> times = new ArrayList<>();
        for(int i = 0; i < logs.length; i++) {
            times.add(new Time(logs[i].substring(0, 8), logs[i].substring(9, logs[i].length())));
        }
        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.start.substring(0, 2).equals(o2.start.substring(0, 2))) {
                    if(o1.start.substring(3, 5).equals(o2.start.substring(3, 5))) {
                        return o1.start.substring(6, 8).compareTo(o2.start.substring(6, 8));
                    }
                    return o1.start.substring(3, 5).compareTo(o2.start.substring(3, 5));
                }
                return o1.start.substring(0, 2).compareTo(o2.start.substring(0, 2));
            }
        });

        String result = times.get(0).end;
        for(int i = 1; i < times.size(); i++) {
            if(result.substring(0, 2).equals(times.get(i).start.substring(0, 2))) {
                if(result.substring(3, 5).equals(times.get(i).start.substring(3, 5))) {
                    result = result.substring(6, 8).compareTo(times.get(i).start.substring(6, 8)) == 1 ? result : times.get(i).end;
                }
            }

        }
        return answer;
    }
    static class Time {
        String start;
        String end;
        Time(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start='" + start + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        카카오5 a = new 카카오5();
        a.solution("02:03:55", "00:14:15", new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
    }
}
