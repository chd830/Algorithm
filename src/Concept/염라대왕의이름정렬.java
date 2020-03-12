package Concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class 염라대왕의이름정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+"\n");
            int N = sc.nextInt();
            TreeSet<String> name = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String pre, String next) {
                    //글자의 길이가 짧은 순서대로
                    if(pre.length() != next.length()) {
                        return pre.length() - next.length();
                    }
                    else { //길이가 같으면 사전 순
                        return pre.compareTo(next); //오름차순
                    }
                }
            });
            for(int i = 0; i < N; i++) {
                name.add(sc.next());
            }
//            String[] name = new String[N];
//            for(int i = 0; i < N; i++) {
//                name[i] = sc.next();
//            }
//            Arrays.sort(name, new Comparator<String>() {
//                @Override
//                public int compare(String pre, String next) {
//                    //글자의 길이가 짧은 순서대로
//                    if(pre.length() != next.length()) {
//                        return pre.length() - next.length();
//                    }
//                    else { //길이가 같으면 사전 순
//                        return pre.compareTo(next); //오름차순
//                    }
//                }
//            });
//            //시작부터 끝까지 name에서 가장 작은 값을 가진 것과 바꾼다.
//            for(int i = 0; i < N; i++) {
//                int minIdx = i;
//                for(int j = i+1; j < N; j++) {
//                    if(compare(name[minIdx], name[j]) > 0) {
//                        minIdx = j;
//                    }
//                }
//                String temp = name[i];
//                name[i] = name[minIdx];
//                name[minIdx] = temp;
//            }
            String prev = "";
            for(String s : name) {
                if(prev.equals(s)) {
                    continue;
                }
                sb.append(s+"\n");
                prev = s;
            }
        }
        System.out.println(sb);
    }
    public static int compare(String pre, String next) {
        //글자의 길이가 짧은 순서대로
        if(pre.length() != next.length()) {
            return pre.length() - next.length();
        }
        else { //길이가 같으면 사전 순
            return pre.compareTo(next); //오름차순
        }
    }
}
