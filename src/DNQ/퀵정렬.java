package DNQ;

import java.util.Arrays;

public class 퀵정렬 {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println(Arrays.toString(arr));
        quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static int pivot(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for(int j = left; j < right; j++) {
            if(arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, right, i);
        return i;
    }
    static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
    static void quick(int[] arr, int left, int right) {
        if(left >= right)
            return;

        int pivot = pivot(arr, left, right);
        quick(arr, left, pivot-1);
        quick(arr, pivot+1, right);

    }
}
