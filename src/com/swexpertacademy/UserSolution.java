package com.swexpertacademy;

import java.util.*;

//class UserSolution
//{
//    static class BuyInfo implements Comparable<BuyInfo> {
//        int number;
//        int stock;
//        int quantity;
//        int price;
//        BuyInfo(int number, int stock, int quantity, int price) {
//            this.number = number;
//            this.stock = stock;
//            this.quantity = quantity;
//            this.price = price;
//        }
//
//        @Override
//        public String toString() {
//            return "Info{" +
//                    "number=" + number +
//                    ", stock=" + stock +
//                    ", quantity=" + quantity +
//                    ", price=" + price +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(BuyInfo o) {
//            if(this.price == o.price)
//                return Integer.compare(this.number, o.number);
//            return -Integer.compare(this.price, o.price);
//        }
//    }
//    static class SellInfo implements Comparable<SellInfo> {
//        int number;
//        int stock;
//        int quantity;
//        int price;
//        SellInfo(int number, int stock, int quantity, int price) {
//            this.number = number;
//            this.stock = stock;
//            this.quantity = quantity;
//            this.price = price;
//        }
//
//        @Override
//        public String toString() {
//            return "Info{" +
//                    "number=" + number +
//                    ", stock=" + stock +
//                    ", quantity=" + quantity +
//                    ", price=" + price +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(SellInfo o) {
//            if(this.price == o.price)
//                return Integer.compare(this.number, o.number);
//            return Integer.compare(this.price, o.price);
//        }
//    }
//    public static List<SellInfo> sellList;
//    public static List<BuyInfo> buyList;
//    public static List<Integer>[] stockList;
//
//    public void init()
//    {
//        sellList = new ArrayList<>();
//        buyList = new ArrayList<>();
//        stockList = new ArrayList[6];
//        for(int i = 0; i < stockList.length; i++)
//            stockList[i] = new ArrayList<>();
//    }
//
//    public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
//    {
//        for(int i = 0; i < sellList.size(); i++) {
//            SellInfo info = sellList.get(i);
//            if(info.quantity != 0 && info.price <= mPrice) {
//                int tmp = mQuantity;
//                mQuantity -= info.quantity;
//                info.quantity -= tmp;
//                if(info.quantity < 0) {
//                    mQuantity = info.quantity*-1;
//                    info.quantity = 0;
//                }
//                if(mQuantity < 0) {
//                    info.quantity = mQuantity*-1;
//                    mQuantity = 0;
//                }
//                stockList[mStock].add(info.price);
//                sellList.add(i, info);
//                sellList.remove(i+1);
//            }
//        }
//        if(mQuantity != 0)
//            buyList.add(new BuyInfo(mNumber, mStock, mQuantity, mPrice));
//        Collections.sort(buyList);
//        Collections.sort(sellList);
//        return mQuantity;
//    }
//
//    public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
//    {
//        for(int i = 0; i < buyList.size(); i++) {
//            BuyInfo info = buyList.get(i);
//            if(info.quantity != 0 && info.price >= mPrice) {
//                int tmp = mQuantity;
//                info.quantity -= mQuantity;
//                mQuantity -= tmp;
//                if(mQuantity < 0) {
//                    info.quantity = mQuantity*-1;
//                    mQuantity = 0;
//                }
//                if(info.quantity < 0) {
//                    mQuantity = info.quantity*-1;
//                    info.quantity = 0;
//                }
//                stockList[mStock].add(info.price);
//                buyList.add(i, info);
//                buyList.remove(i+1);
//            }
//        }
//        if(mQuantity != 0)
//            sellList.add(new SellInfo(mNumber, mStock, mQuantity, mPrice));
//        Collections.sort(buyList);
//        Collections.sort(sellList);
//        return mQuantity;
//    }
//
//    public void cancel(int mNumber)
//    {
//        for(int i = 0; i < buyList.size(); i++) {
//            if(buyList.get(i).number == mNumber) {
//                buyList.remove(i);
//                return;
//            }
//        }
//        for(int i = 0; i < sellList.size(); i++) {
//            if(sellList.get(i).number == mNumber) {
//                sellList.remove(i);
//                return;
//            }
//        }
//    }
//
//    public int bestProfit(int mStock)
//    {
////        System.out.println("BEST PROFIT");
////        for(int i : stockList[mStock])
////            System.out.print(i+" ");
////        System.out.println();
//        int max = 0;
//        for(int i = 0; i < stockList[mStock].size()-1; i++) {
//            for(int j = i+1; j < stockList[mStock].size(); j++) {
//                max = Math.max(stockList[mStock].get(j) - stockList[mStock].get(i), max);
//            }
//        }
//        return max > 0 ? max : 0;
//    }
//}
class UserSolution
{
    // Main API :
    //   Solution.fire(int r, int c)

    private final static int MISS 		= 0;
    private final static int CARRIER 	= 1;
    private final static int BATTLESHIP = 2;
    private final static int CRUISER 	= 3;
    private final static int SUBMARINE 	= 4;
    private final static int DESTROYER 	= 5;

    public void init(int limit)
    {

    }

    public void play()
    {
        int num = 100;
        while(num >= 0) {
            int r = num/10;
            int c = num%10;
            num /= 2;
            if(visited[r][c])
                continue;
            if(Solution.fire(r, c) != 0)
                findShip(r, c);
        }
        num = 50;
        while(num <= 100) {
            int r = num/10;
            int c = num%10;
            num /= 2;
            num *= 3;
            if(visited[r][c])
                continue;
            if(Solution.fire(r, c) != 0)
                findShip(r, c);
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
    static boolean[][] visited = new boolean[10][10];

    static void findShip(int r, int c) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r, c));
        visited[r][c] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 8; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy] && Solution.fire(dx, dy) != 0) {
                    que.add(new Node(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
    }
    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < 10 && c < 10;
    }
}