package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무조각2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        for(int k = 0; k < 5; k++) {
                            System.out.print(arr[k]+" ");
                        }
                        System.out.println();
                    }
                }
            }
    }
}
