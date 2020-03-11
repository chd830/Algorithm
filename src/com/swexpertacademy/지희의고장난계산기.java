package com.swexpertacademy;

import java.util.Scanner;

//메모이제이션을 사용해서 코드 마무리짓기
public class 지희의고장난계산기 {
    static int N;
    static int min;
    static int size;
    static int[] memo;
    static boolean[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            nums = new boolean[10];
            min = Integer.MAX_VALUE;
            for(int i = 0; i < 10; i++) {
                nums[i] = sc.nextInt() == 1 ? true : false;
            }
            N = sc.nextInt();
            size = (int)Math.sqrt(N);
            memo = new int[N+1];
//            for(int i = 1; i < W; i++) {
//                if(W%i == 0) {
//                    System.out.println(i+" "+(W/i)+"\t\t");
//                    if((i == 1 && canPush((W/i)+"")) || (canPush(i + "")) && canPush((W/i) + "")) {
//                        int len = length(i + "");
//                        if (i != 1) {
//                            len += 2;
//                        }
//                        System.out.println("\t\t" + len);
//                        min = Math.min(min, len);
//                    }
//                }
//            }
            find(N, 0);
            System.out.println("#"+t+" "+(min == Integer.MAX_VALUE ? -1 : min));
        }
    }

    private static int find(int x, int cnt) {
        if(x < size && memo[x] != 0) {
            return memo[x];
        }

        // base case => 종료조건
        if(canPush(x+"")) {
            // x값이 주어진 모든 수로 누를수 있는지 검사
            // x길이를 리턴
            int count = len(x) + 1;
            if(cnt == 0) {
                min = count; // 계산 버튼을 위해 1을 더한다.
            }
            if(x < size) {
                memo[x] = count;
            }
            return count;
        }

        // 처리
        // result 값을 -1로 초기화
        int result = -1;
        // 2 ~ 제곱근 까지 반복(i)
        for (int i = 2, end = (int)Math.sqrt(x)+1; i < end; i++) {
            // i는 x의 약수, 모든 수로 누를수 있는지 검사
            if(x % i == 0 && canPush(i+"")) {
                // i의 길이를 구하고
                int len1 = len(i) + 1; // 곱하기 버튼을 위해 1을 더한다.
                // 몫이 x의 약수, 모든 수로 누를수 있는지 검사 ==> 재귀 호출
                int len2 = find(x/i, cnt+1);
                // 몫이 -1이 아니면 => x의 약수, 모든 수로 누를수
                if(len2 > -1) {
                    // i의 길이와 몫의 길이 +  *=
                    result = len1 + len2;
                    if(result < min && x == N) {
                        // 결과가 min비교해서 갱신
                        min = result;
                    }
                }
            }
        }
        if(x < size) {
            memo[x] = result;
        }
        return result;
    }

    private static int len(int x) {
        return (int)Math.log10(x)+1;
    }

    public static int length(String n) {
        System.out.print(n+" "+(N/Integer.parseInt(n)));
        return n.length() + (N/Integer.parseInt(n)+"").length();
    }

    public static boolean canPush(String n) {
        for(char c : n.toCharArray()) {
            if(!nums[c-'0']) {
                return false;
            }
        }
        return true;
    }
}
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지희의고장난계산기 {
    static int X;
    static int min;
    static boolean[] btn;
    static int[] memo;
    static int size;
    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            // min값을 초기화    Integer.MAX_VALUE
            min = Integer.MAX_VALUE;
            btn = new boolean[10];
            StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
            int num;
            for (int i = 0; i < 10; i++) {
                num = Integer.parseInt(st.nextToken());
                // btn 1이면 true로 설정
                if(num == 1) {
                    btn[i] = true;
                }
            }
            X = Integer.parseInt(in.readLine().trim());
            size = (int)Math.sqrt(X);
            memo = new int[size];
            // 처리 dfs => 재귀함수
            find(X, 0);

            // 출력
            min = (min == Integer.MAX_VALUE) ? -1 : min;
            System.out.println("#" + t + " " + min);
        }
    }

    private static int find(int row, int cnt) {
        if(row < size && memo[row] != 0) {
            return memo[row];
        }

        // base case => 종료조건
        if(isMake(row+"")) {
            // x값이 주어진 모든 수로 누를수 있는지 검사
            // x길이를 리턴
            int count = len(row) + 1;
            if(cnt == 0) {
                min = count; // 계산 버튼을 위해 1을 더한다.
            }
            if(row < size) {
                memo[row] = count;
            }
            return count;
        }

        // 처리
        // result 값을 -1로 초기화
        int result = -1;
        // 2 ~ 제곱근 까지 반복(i)
        for (int i = 2, end = (int)Math.sqrt(row)+1; i < end; i++) {
            // i는 x의 약수, 모든 수로 누를수 있는지 검사
            if(row % i == 0 && isMake(i+"")) {
                // i의 길이를 구하고
                int len1 = len(i) + 1; // 곱하기 버튼을 위해 1을 더한다.
                // 몫이 x의 약수, 모든 수로 누를수 있는지 검사 ==> 재귀 호출
                int len2 = find(row/i, cnt+1);
                // 몫이 -1이 아니면 => x의 약수, 모든 수로 누를수
                if(len2 > -1) {
                    // i의 길이와 몫의 길이 +  *=
                    result = len1 + len2;
                    if(result < min && row == X) {
                        // 결과가 min비교해서 갱신
                        min = result;
                    }
                }
            }
        }
        if(row < size) {
            memo[row] = result;
        }
        return result;
    }

    private static int len(int row) {
        return (int)Math.log10(row)+1;
    }

    private static boolean isMake(String row) {
        for (char col : row.toCharArray()) {
            if(!btn[col-'0']) {
                return false;
            }
        }
        return true;
    }
}
//    static int[] nums = new int[10];
//    static int[] memo;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        for(int test_case = 1; test_case <= T; test_case++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int i = 0; i < 10; i++) {
//                nums[i] = Integer.parseInt(st.nextToken());
//            }
//
//            int X = Integer.parseInt(br.readLine());
//
//            memo = new int[X+1];
//            Arrays.fill(memo, Integer.MAX_VALUE);
//            calc(X);
//
//            int ans = -1;
//            if(memo[X] != Integer.MAX_VALUE) {
//                ans = memo[X] + 1;
//            }
//            System.out.println("#" + test_case + " " + ans);
//        }
//        br.close();
//    }
//
//    static void calc(int X) {
//        int tmp = check(X);
//        if(tmp != -1) {
//            memo[X] = tmp;
//            return;
//        }
//
//        int range = (int) Math.sqrt(X);
//        for(int i = 2; i < range; i++) {
//            if(X % i == 0) {
//                if(memo[i] == Integer.MAX_VALUE) {
//                    calc(i);
//                }
//                if(memo[X/i] == Integer.MAX_VALUE) {
//                    calc(X/i);
//                }
//                if(memo[i] != Integer.MAX_VALUE && memo[X/i] != Integer.MAX_VALUE) {
//                    if(memo[X] > memo[i] + memo[X/i] + 1) {
//                        memo[X] = memo[i] + memo[X/i] + 1;
//                    }
//                }
//            }
//        }
//    }
//
//    static int check(int X) {
//        int cnt = 0;
//        while(X > 0) {
//            if(nums[X%10] == 0) {
//                return -1;
//            }
//            X /= 10;
//            cnt++;
//        }
//        return cnt;
//    }
//}
//    static boolean Number[] = new boolean[10];
//    static int max = Integer.MAX_VALUE;
//    static int res = max;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(st.nextToken());
//
//        for(int tc = 1; tc <= T ; tc++) {
//            st = new StringTokenizer(br.readLine());
//            for(int index = 0; index<10; index++) {
//                if(st.nextToken().toCharArray()[0] =='1') {
//                    Number[index] = true;
//                }
//                else {
//                    Number[index] = false;
//                }
//            }
//            st = new StringTokenizer(br.readLine());
//            String target = st.nextToken();
//            solution(target,1);
//            res = res == max ? -1 : res;
//            sb.append("#"+tc+" "+res+"\n");
//            res= max;
//        }
//        System.out.print(sb);
//    }
//
//    public static void solution(String target, int answer) {
//        System.out.print("\n"+target+" "+answer+"\t\t");
//        if(judge(target)) {
//            res = res > answer+target.length() ? answer+target.length() : res;
//            return;
//        }
//        int temp = Integer.parseInt(target);
//        for(int num = 2 ; num <= Math.sqrt(temp); num++) {
//            if(temp % num ==0 && judge(String.valueOf(num))) {
//                solution(String.valueOf(temp/num), answer+1+(String.valueOf(num)).length());
//            }
//        }
//
//
//    }
//
//    public static boolean judge(String target) {
//        char[] temp = target.toCharArray();
//        System.out.print(Arrays.toString(temp)+"\t");
//        int size = temp.length;
//        for(int index = 0; index < size; index++) {
//            if(Number[temp[index]-'0']) {
//                continue;
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
//    }
//}
*/
