package net.acmicpc.re;

public class 부분집합 {
    static int[] arr = {1, 2, 3};
    static boolean[] visited = new boolean[arr.length];
    public static void main(String[] args) {
        subset(0);
    }
    static void subset(int idx) {
        if(idx == arr.length) {
            for(int i = 0; i < arr.length; i++) {
                if(visited[i]) {
                    System.out.print(arr[i]+"\t");
                }
            }
            System.out.println();
            return;
        }
        visited[idx] = true;
        subset(idx+1);
        visited[idx] = false;
        subset(idx+1);
    }
}
