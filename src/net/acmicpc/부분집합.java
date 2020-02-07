package net.acmicpc;

public class 부분집합 {
    static int[] arr = {2,4,6};
    static boolean[] sel;
    public static void main(String[] args) {
        sel = new boolean[arr.length];
        powerset(0, 0);
    }
    static void powerset(int idx, int sum) {
    	if(idx == arr.length) {
    		System.out.println(sum);
    		return;
    	}
    	powerset(idx + 1, sum + arr[idx]);
    	powerset(idx + 1, sum);
    }
    static void powerset(int idx) {
        if(idx == sel.length) {
            for(int i = 0; i < sel.length; i++) {
                if(sel[i])
                    System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        sel[idx] = true;
        powerset(idx+1);
        sel[idx] = false;
        powerset(idx+1);
    }
}