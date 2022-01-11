package com.swexpertacademy;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Solution
//{
//    private final static int CMD_INIT				= 1;
//    private final static int CMD_BUY				= 2;
//    private final static int CMD_SELL				= 3;
//    private final static int CMD_CANCEL				= 4;
//    private final static int CMD_BEST_PROFIT		= 5;
//
//    private final static UserSolution usersolution = new UserSolution();
//
//    private static boolean run(BufferedReader br) throws Exception
//    {
//        StringTokenizer st;
//
//        int numQuery;
//
//        int mNumber, mStock, mQuantity, mPrice;
//
//        int userAns, ans;
//
//        boolean isCorrect = false;
//
//        numQuery = Integer.parseInt(br.readLine());
//
//        for (int q = 0; q < numQuery; ++q)
//        {
//            st = new StringTokenizer(br.readLine(), " ");
//
//            int cmd;
//            cmd = Integer.parseInt(st.nextToken());
//
//            switch(cmd)
//            {
//                case CMD_INIT:
//                    usersolution.init();
//                    isCorrect = true;
//                    break;
//                case CMD_BUY:
//                    mNumber = Integer.parseInt(st.nextToken());
//                    mStock = Integer.parseInt(st.nextToken());
//                    mQuantity = Integer.parseInt(st.nextToken());
//                    mPrice = Integer.parseInt(st.nextToken());
//                    userAns = usersolution.buy(mNumber, mStock, mQuantity, mPrice);
//                    ans = Integer.parseInt(st.nextToken());
//                    System.out.println("BUY:\t"+userAns+"\t"+ans);
//                    if (userAns != ans) {
//                        isCorrect = false;
//                    }
//                    break;
//                case CMD_SELL:
//                    mNumber = Integer.parseInt(st.nextToken());
//                    mStock = Integer.parseInt(st.nextToken());
//                    mQuantity = Integer.parseInt(st.nextToken());
//                    mPrice = Integer.parseInt(st.nextToken());
//                    userAns = usersolution.sell(mNumber, mStock, mQuantity, mPrice);
//                    ans = Integer.parseInt(st.nextToken());
//                    System.out.println("SELL:\t"+userAns+"\t"+ans);
//                    if (userAns != ans) {
//                        isCorrect = false;
//                    }
//                    break;
//                case CMD_CANCEL:
//                    mNumber = Integer.parseInt(st.nextToken());
//                    usersolution.cancel(mNumber);
//                    break;
//                case CMD_BEST_PROFIT:
//                    mStock = Integer.parseInt(st.nextToken());
//                    userAns = usersolution.bestProfit(mStock);
//                    System.out.println(userAns);
//                    ans = Integer.parseInt(st.nextToken());
//                    System.out.println("BEST FIT:\t"+userAns+"\t"+ans);
//                    if (userAns != ans) {
//                        isCorrect = false;
//                    }
//                    break;
//                default:
//                    isCorrect = false;
//                    break;
//            }
////            System.out.println("BUY");
////            for(UserSolution.Info i : usersolution.buyList) {
////                if(i.quantity != 0)
////                    System.out.println(i);
////            }
////            System.out.println();
////            System.out.println("SELL");
////            for(UserSolution.Info i : usersolution.sellList) {
////                if(i.quantity != 0)
////                    System.out.println(i);
////            }
////            System.out.println();
//        }
//
//        return isCorrect;
//    }
//
//    public static void main(String[] args) throws Exception
//    {
//        int TC, MARK;
//
//        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        TC = Integer.parseInt(st.nextToken());
//        MARK = Integer.parseInt(st.nextToken());
//
//        for (int testcase = 1; testcase <= TC; ++testcase)
//        {
//            int score = run(br) ? MARK : 0;
//            System.out.println("#" + testcase + " " + score);
//        }
//
//        br.close();
//    }
//}
import java.util.Scanner;

class Solution {
    private final static int board[][] = new int[10][10];

    private final static int MISS 		= 0;
    private final static int CARRIER 	= 1;
    private final static int BATTLESHIP = 2;
    private final static int CRUISER 	= 3;
    private final static int SUBMARINE 	= 4;
    private final static int DESTROYER 	= 5;

    private static int hit;
    private final static int len[] = { 5, 4, 3, 3, 2 };

    private final static int MAX_CALLCOUNT = 10000;

    private static int callcount;
    private static int limit;

    private final static UserSolution usersolution = new UserSolution();

    public static int fire(int r, int c)
    {
        if (r < 0 || r > 9 || c < 0 || c > 9 || callcount >= MAX_CALLCOUNT)
        {
            callcount = MAX_CALLCOUNT;
            return 0;
        }

        ++callcount;

        int ret = board[r][c];

        if (board[r][c] > 0) --hit;
        board[r][c] = 0;

        return ret;
    }

    private static int seed;

    private static int pseudo_rand()
    {
        seed = seed * 214013 + 2531011;
        return (seed >> 16) & 0x7fff;
    }

    private static boolean check(int r, int c, int d, int l)
    {
        if (d == 1)
        {
            for (int m = 0; m < l; ++m)
                if (board[r][c + m] > 0)
                    return false;
            return true;
        }
        else
        {
            for (int m = 0; m < l; ++m)
                if (board[r + m][c] > 0)
                    return false;
            return true;
        }
    }

    private static void doarrangement()
    {
        for (int r = 0; r < 10; ++r)
            for (int c = 0; c < 10; ++c)
                board[r][c] = 0;

        for (int k = 0; k < 5; ++k)
        {
            while(true)
            {
                int r, c, d;

                d = pseudo_rand() % 2;
                if (d == 1)
                {
                    r = pseudo_rand() % 10;
                    c = pseudo_rand() % (10 - len[k] + 1);
                    if (check(r, c, d, len[k]))
                    {
                        for (int l = 0; l < len[k]; ++l)
                            board[r][c + l] = k + 1;
                        break;
                    }
                }
                else
                {
                    r = pseudo_rand() % (10 - len[k] + 1);
                    c = pseudo_rand() % 10;
                    if (check(r, c, d, len[k]))
                    {
                        for (int l = 0; l < len[k]; ++l)
                            board[r + l][c] = k + 1;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        int TC, totalscore, totalcallcount;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();

        totalscore = totalcallcount = 0;
        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = 100, callcount4tc = 0;

            seed = sc.nextInt();
            limit = sc.nextInt();

            usersolution.init(limit);

            for (int game = 0; game < 10; ++game)
            {
                doarrangement();

                hit = 0;
                for (int k = 0; k < 5; ++k)
                    hit += len[k];

                callcount = 0;
                usersolution.play();

                if (hit != 0)
                    callcount = MAX_CALLCOUNT;

                if (callcount > limit)
                    score = 0;

                callcount4tc += callcount;
            }

            System.out.println("#" + testcase + " " + score + " " + callcount4tc);

            totalscore += score;
            totalcallcount += callcount4tc;
        }

        System.out.println("total score = " + totalscore / TC + ", total callcount = " + totalcallcount);
        sc.close();
    }
}