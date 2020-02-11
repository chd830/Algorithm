package co.kr.jungol;

import java.util.*;

/*
10 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
1이 나와야함
 */
public class 종교 {
    //    public static void main(String[] args) {
    public 종교() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> list = new ArrayList();
        for(int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            boolean flag = false;
            if(!list.isEmpty()) {
                for (int j = 0; j < list.size(); j++) {
//                    System.out.println(list.get(j).get(0));
//                    for(int k = 0; k < list.get(j).size(); k++) {
//                        System.out.print(list.get(j).get(k)+" ");
//                    }
                    if (list.get(j).get(0) == num1) {
                        list.add(j, new ArrayList(num2));
                        flag = true;
                    }
                }
//                System.out.println("\n---------");
            }
            if (!flag) {
                List<Integer> l = new ArrayList<>();
                l.add(num1);
                l.add(num2);
                list.add(l);
            }
//            System.out.println(list.size());
        }
//        Comparator<int[]> comp = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0])
//                    return o1[1] - o2[1];
//                return o1[0] - o2[0];
//            }
//        };
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
//        }
//        for(int i = 0; i < m; i++) {
//            arr[list.get(i)[0]]++;
//            arr[list.get(i)[1]]++;
//        }
        if(m == 0) {
            System.out.println(m);
            System.exit(0);
        }
        System.out.println(list.size());
    }
}
