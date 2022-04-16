package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17680
public class 캐시 {
    public static void main(String[] args) {
        // 50 21
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }
    public static int solution(int cacheSize, String[] cities) {
        int time = 0;
        if(cacheSize == 0)
            return cities.length*5;
        List<String> list = new ArrayList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            if(list.contains(city)) {
                list.add(city);
                list.remove(list.indexOf(city));
                time += 1;
                continue;
            }
            else if(list.size() < cacheSize) {
                list.add(city);
            }
            else {
                list.remove(0);
                list.add(city);
            }
            time += 5;
        }
        return time;
    }
}
