package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        solution(new String[] {"m", "m", "j", "n", "v", "f"}, new String[] {"j", "f", "m", "n"});
    }
    public static String solution(String[] participants, String[] completions) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String participant : participants) {
            if(map.containsKey(participant)) {
                map.put(participant, map.get(participant)+1);
            }
            else {
                map.put(participant, 1);
            }
        }
        for(String completion : completions) {
            if(map.containsKey(completion)) {
                map.put(completion, map.get(completion)-1);
            }
        }
        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }
        return "";
    }
}
