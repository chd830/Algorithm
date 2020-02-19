package com.swexpertacademy;

import java.util.Scanner;

//최대상금
public class d3_1244 {
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str = sc.next();
            int num = sc.nextInt();
            array = new int[str.length()];
            array = makeArray(str);
            int max = Integer.parseInt(str);
            String maxStr = "";
            for(int i = 0; i < num; i++) {
                max = 0;
                maxStr = "";
                for(int j = 0; j < str.length()-1; j++) {
                    for(int k = j+1; k < str.length(); k++) {
                        swap(j, k, array);
                        str = toNumber(array);
                        if(max <= Integer.parseInt(str)) {
                            max = Integer.parseInt(str);
                            maxStr = str;
                        }
//                        System.out.print(str+" ");
                        swap(k, j, array);
                    }
//                    System.out.println("\t\tmax: "+maxStr);
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
    public static int[] makeArray(String str) {
        for(int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i) - '0';
        }
        return array;
    }
    public static void swap(int j, int k, int[] array) {
        int temp = array[j];
        array[j] = array[k];
        array[k] = temp;
    }
    public static String toNumber(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a);
        }
        return sb.toString();
    }
}
