package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = {"sat","lea","arm","sin","the","nod","guy","ins","rod"};
        List<List<String>> result = g.groupAnagrams(strs);

        for(List<String> l : result ){
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println("");
        }
    }
}
