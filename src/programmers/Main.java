package programmers;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i =0 ; i < num; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
/*        System.out.println(Math.round((double)sum/num*10)/10);
        System.out.println(arr[num/2]);*/
        int[] check = new int[num];
        for(int key : map.keySet()) {
            System.out.print(key+": "+map.get(key)+"\t\t");
            for(int i = 0; i < num; i++) {
                if(arr[i] == key) {
                    check[i] = map.get(key);
                    map.put(key, 0);
                }
            }
        }
        System.out.println("\n");
        for(int i = 0; i < num; i++) {
            System.out.print("check: "+check[i]+"\t");
        }
        System.out.println("\n");
        for(int i = 0; i < num; i++) {
            System.out.print("arr: "+arr[i]+"\t");
        }
     /*   if(arr[num - 1] < 0) {
            System.out.println(Math.abs(arr[0] + arr[num - 1]));
        }
        else if(arr[num - 1] >= 0){
            System.out.println(Math.abs(arr[0] + arr[num - 1]));
        }*/
    }

    public static boolean solution(String s) {
        System.out.println(s.length());
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            System.out.println(Character.isDigit(c)+", "+Character.isAlphabetic(c));
            if(Character.isAlphabetic(c))
                return false;
        }
        return true;
    }
}