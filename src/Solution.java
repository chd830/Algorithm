////////import java.util.*;
////////
////////class Solution {
////////    public static void main(String[] args) {
////////        System.out.println("----------17----------");
////////        System.out.println(solution("17"));
////////        System.out.println("----------2----------");
////////        System.out.println(solution("2"));
////////        System.out.println("----------222----------");
////////        System.out.println(solution("222"));
////////        System.out.println("----------1276543---------");
////////        System.out.println(solution("1276543"));
////////
////////    }
////////    static boolean[] prime = new boolean[12345678];
////////    static boolean[] visited;
////////    static int[] sub;
////////    static int answer;
////////    public static int solution(String numbers) {
////////        answer = 0;
////////        setPrime();
////////        for(int i = 1; i <= numbers.length(); i++) {
////////            visited = new boolean[numbers.length()];
////////            sub = new int[i];
////////            perm(0, numbers);
////////        }
////////        return answer;
////////    }
////////    static void setPrime() {
////////        Arrays.fill(prime, true);
////////        prime[0] = false;
////////        prime[1] = false;
////////        for(int i = 2; i <= 10000000; i++) {
////////            for(int j = i+i; j <= 10000000; j += i) {
////////                prime[j] = false;
////////            }
////////        }
////////    }
////////    static void perm(int idx, String numbers) {
////////        if(idx == sub.length) {
////////            String num = "";
////////            for(int i : sub)
////////                num += i;
////////            int n = Integer.parseInt(num);
////////            if(prime[n]) {
////////                prime[n] = false;
////////                answer++;
////////            }
////////            return;
////////        }
////////        for(int i = 0; i < numbers.length(); i++) {
////////            if(!visited[i]) {
////////                visited[i] = true;
////////                sub[idx] = numbers.charAt(i)-'0';
////////                perm(idx+1, numbers);
////////                visited[i] = false;
////////            }
////////        }
////////    }
////////}
//////

// -kakaopay
//import java.util.*;
//class Solution {
//    public static void main(String[] args) {
////        System.out.println(solution(12345678, 10, 20, 250000, 10000000, 4));
//        System.out.println(solution(1000000000, 50, 99, 100000, 0, 6));
//    }
//
//    public static int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
//
//        while (months-- > 0) {
//            String sub = String.valueOf(money);
//            sub = sub.substring(0, sub.length() - 2) + "00";
//            long m = Integer.parseInt(sub);
//            if (money < threshold) {
//                break;
//            }
//            else {
//                int tmp = money-threshold;
//                int rate = tmp/ranksize+minratio;
//                if(rate > maxratio) {
//                    rate = maxratio;
//                }
//                m *= rate;
//                m /= 100;
//                System.out.println(money+"\t"+rate+"\t"+m);
//                money -= m;
//            }
//        }
//        return money;
//    }
//}
//
//import java.util.Arrays;
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(4, 3, new int[][] {
//                {1, 1, 2, 4, 3},
//                {3, 2, 1, 2, 3},
//                {4, 1, 1, 4, 3},
//                {2, 2, 1, 3, 3}
//        })));
//    }
//    public static int[] solution(int rows, int columns, int[][] swipes) {
//        int[][] arr = new int[rows][columns];
//        for(int i = 0, val = 1; i < rows; i++) {
//            for(int j = 0; j < columns; j++) {
//                arr[i][j] = val++;
//            }
//        }
//        int[] answer = new int[swipes.length];
//        int idx = 0;
//        for(int[] swipe : swipes) {
//            print(arr);
//            for(int i = 0; i < swipe.length; i++)
//                swipe[i]--;
//            int d = swipe[0];
//            int x1 = swipe[1];
//            int y1 = swipe[2];
//            int x2 = swipe[3];
//            int y2 = swipe[4];
//            int sum = 0;
//            switch(d) {
//                case 0:
//                    for(int i = y2; i >= y1; i--) {
//                        sum += arr[x2][i];
//                    }
//                    for(int i = y1; i <= y2; i++) {
//                        int cur = arr[x1][i];
//                        for(int j = x1+1; j <= x2; j++) {
//                            int tmp = arr[j][i];
//                            arr[j][i] = cur;
//                            cur = tmp;
//                        }
//                        arr[x1][i] = cur;
//                    }
//                    break;
//                case 1:
//                    for(int i = y2; i >= y1; i--) {
//                        sum += arr[x1][i];
//                    }
//                    for(int i = y1; i <= y2; i++) {
//                        int cur = arr[x2][i];
//                        for(int j = x2-1; j >= x1; j--) {
//                            int tmp = arr[j][i];
//                            arr[j][i] = cur;
//                            cur = tmp;
//                        }
//                        arr[x2][i] = cur;
//                    }
//                    break;
//                case 2:
//                    for(int i = x2; i >= x1; i--) {
//                        sum += arr[i][y2];
//                    }
//                    for(int i = x1; i <= x2; i++) {
//                        int cur = arr[i][y1];
//                        for(int j = y1+1; j <= y2; j++) {
//                            int tmp = arr[i][j];
//                            arr[i][j] = cur;
//                            cur = tmp;
//                        }
//                        arr[i][y1] = cur;
//                    }
//                    break;
//                case 3:
//                    for(int i = x2; i >= x1; i--) {
//                        sum += arr[i][y1];
//                    }
//                    for(int i = x1; i <= x2; i++) {
//                        int cur = arr[i][y2];
//                        for(int j = y2-1; j >= y1; j--) {
//                            int tmp = arr[i][j];
//                            arr[i][j] = cur;
//                            cur = tmp;
//                        }
//                        arr[i][y2] = cur;
//                    }
//                    break;
//            }
//            answer[idx++] = sum;
//        }
//        print(arr);
//        return answer;
//    }
//    static void print(int[][] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println();
//    }
//}
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(solution("abbbcbbb", "bbb"));
//    }
//    public static int solution(String line1, String line2) {
//        int cnt = 0;
//        char[] lineTochar = line2.toCharArray();
//        String str = "";
//        int p = 0;
//        while(str.length() <= line1.length()) {
//            str = transform(lineTochar, p++);
//            for(int i = 0; i <= line1.length()-str.length(); i++) {
//                if(compare(line1.substring(i, i+str.length()), str))
//                    cnt++;
//            }
//        }
//        return cnt;
//    }
//    // 기존의 문자열과 변형된 문자열의 비교
//    static boolean compare(String s1, String s2) {
//        for(int i = 0; i < s1.length(); i++) {
//            if(s2.charAt(i) == '-')
//                continue;
//            if(s1.charAt(i) == s2.charAt(i))
//                continue;
//            return false;
//        }
//        return true;
//    }
//    static String transform(char[] charArr, int cnt) {
//        String str = "";
//        for(int i = 0; i < charArr.length; i++) {
//            str += charArr[i];
//            int j = 0;
//            while(i != charArr.length-1 && j++ < cnt) {
//                str += "-";
//            }
//        }
//        return str;
//    }
//}
//
//import java.util.*;
//
//class Solution {
//    public static void main(String[] args) {
////        System.out.println(Arrays.toString(solution(new long[] {35, 25, 3, 8, 7}, new int[][] {{1, 2, 5}, {2, 1, 5}, {1, 3, 2}, {3, 5, 20}, {3, 4, 2}, {4, 5, 1}})));
//        System.out.println(Arrays.toString(solution(new long[] {8, 13, 5, 8}, new int[][] {{1, 3, 10}, {3, 4, 1}, {4, 2, 2}, {2, 1, 3}})));
//    }
//    static class Generator implements Comparable<Generator> {
//        int cur;
//        int toward;
//        int val;
//
//        Generator(int cur, int toward, int val) {
//            this.cur = cur;
//            this.toward = toward;
//            this.val = val;
//        }
//
//        @Override
//        public int compareTo(Generator o) {
//            if (this.cur == o.cur)
//                return Integer.compare(this.toward, o.toward);
//            return Integer.compare(this.cur, o.cur);
//        }
//
//        @Override
//        public String toString() {
//            return "Generator{" +
//                    "cur=" + cur +
//                    ", toward=" + toward +
//                    ", val=" + val +
//                    '}';
//        }
//    }
//    public static int[] solution(long[] ages, int[][] wires) {
//        int[] answer = new int[ages.length];
//        List<Generator>[] list = new ArrayList[ages.length+1];
//        for(int i = 0; i <= ages.length; i++) {
//            list[i] = new ArrayList<>();
//        }
//        for(int[] wire : wires) {
//            list[wire[0]].add(new Generator(wire[0], wire[1], wire[2]));
//        }
//        for(int i = 0; i <= ages.length; i++) {
//            Collections.sort(list[i]);
//        }
//        for(int i = 1; i <= ages.length; i++) {
//            for(Generator g : list[i]) {
//                System.out.println(g);
//            }
//        }
//        int idx = 0;
//        int date = 0;
//        boolean[] end = new boolean[ages.length+1];
//        while(idx < ages.length) {
//            for (int i = 0; i < ages.length; i++) {
//                if(ages[i] == 0 && !end[i+1]) {
//                    answer[idx++] = i+1;
//                    end[i+1] = true;
//                }
//                if(ages[i] == 0 && end[i+1]) {
//                    if(list[i+1] == null) {
//                        continue;
//                    }
//                    for (Generator g : list[i+1]) {
//                        if(!end[g.toward] && g.val <= 0) {
//                            answer[idx++] = g.toward;
//                            end[g.toward] = true;
//                        }
//                        if(g.val > 0) {
//                            g.val--;
//                        }
//                    }
//                    continue;
//                }
//                if(ages[i] > 0)
//                    ages[i]--;
//            }
//            date++;
//        }
//        return answer;
//    }
//}