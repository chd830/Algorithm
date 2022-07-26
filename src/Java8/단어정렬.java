package Java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1181
public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++)
            set.add(br.readLine());
        // 576ms
//        Iterator<String> iter = set.iterator();
//        List<String> words = new ArrayList<>();
//        while(iter.hasNext())
//            words.add(iter.next());
//        Collections.sort(words);
//        Collections.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        });
//        for(String word : words)
//            System.out.println(word);
        // 564ms
//        set.stream().sorted().sorted((a, b) -> a.length()-b.length())
//                .forEach(System.out::println);
        // 784ms
//        set.stream().sorted().sorted(Comparator.comparing(String::length))
//                .forEach(System.out::println);
    }
}
