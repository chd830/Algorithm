package Concept;

import java.util.*;

// https://blog.naver.com/ndb796/221282210534
public class SegmentTree {

    public static void main(String[] args) {
        init(0, a.length-1, 1);
        System.out.println(Arrays.toString(tree));
        System.out.println(sum(0, a.length-1, 1, 0, a.length));
    }
    static int init(int start, int end, int node) {
        if(start == end)
            return tree[node] = a[start];
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2)+init(mid+1, end, node*2+1);
    }
    static int sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start)
            return 0;
        if(left <= start && end <= right)
            return tree[node];
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right)+sum(mid+1, end, node*2+1, left, right);
    }
    static void update(int start, int end, int node, int idx, int diff) {
        if(idx < start || idx > end)
            return;
        tree[node] += diff;
        if(start == end)
            return;
        int mid = (start+end)/2;
        update(start, mid, node*2, idx, diff);
        update(mid+1, end, node*2+1, idx, diff);
    }
    static int[] tree = new int[20];
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
}
