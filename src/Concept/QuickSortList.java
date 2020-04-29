package Concept;

import java.util.*;

public class QuickSortList {

    private static List<String> targetList = new ArrayList<>(Arrays.asList("a", "c", "ac", "ad", "e","ce"));

    public static void main( String[] args ) {
//        List<String> tes = new ArrayList<>(Arrays.asList("아에이", "아이", "아에이오", "아", "아에이오우"));
//        quick(targetList, 0, targetList.size()-1);
        targetList = sort(targetList);
        for(String t : targetList) {
            System.out.println(t);
        }
    }
    static void quick(List<String> list, int x, int y) {
        if(x >= y) {
            return;
        }
        int pivot = x;
        int left = pivot + 1;
        int right = y;
        while(left < right) {
            while(left <= y && list.get(left).compareTo(list.get(pivot)) >= 0) {
                left++;
            }
            while(right >= pivot && list.get(pivot).compareTo(list.get(right)) < 0) {
                right--;
            }
            if(left< right) {
                swap(list, left, right);
            }
            else {
                swap(list, right, pivot);
            }
        }
        quick(list, x, right-1);
        quick(list, right+1, y);
    }
    static void swap(List<String> list, int left, int right) {
        String temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
    public static List<String> sort(List<String> targetList) {
        if (targetList.size() > 1) {
            return merge(
                    sort(targetList.subList(0, targetList.size() / 2)),
                    sort(targetList.subList(targetList.size() / 2, targetList.size()))
            );
        } else {
            return targetList;
        }
    }

    public static List<String> merge (List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        int rightIdx = 0;

        for (String l : left) {
            while (right.size() > rightIdx && l.compareTo(right.get(rightIdx)) >= 0) {
                result.add(right.get(rightIdx));
                rightIdx++;
            }
            result.add(l);
        }
        for (int i = rightIdx; i < right.size(); i ++) {
            result.add(right.get(i));
        }
        return result;
    }
}
