package com.code;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
<<<<<<< HEAD
        List<String> list = null;
        HashMap<Integer, Integer> map = new HashMap();
        int arr = 0;
        for(String str : strs) {
            int sum = 0;
            int mul = 1;
            int total = 0;
            for(char c : str.toCharArray()) {
                sum += c;
                mul *= c;
            }
            total = sum + mul;
            if(map.containsKey(total)) {
                result.get(map.get(total)).add(str);
            }
            else {
                list = new ArrayList();
                map.put(total, arr);
                list.add(str);
                arr++;
                result.add(list);
            }
        }
=======

>>>>>>> 40cfda8966186f66b38a393f26bd40dd84f4afc9
        return result;
    }
}
