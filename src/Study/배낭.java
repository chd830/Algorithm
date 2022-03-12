package Study;

public class 배낭 {
    public static void main(String[] args) {
        int[] weight = {6, 4, 3, 5};
        int[] val = {13, 8, 6, 12};
        int[][] dp = new int[1000][1000];

        for(int i = 1; i < weight.length; i++) {
            for(int j = 1; j < val.length; j++) {
                if(j >= weight[i])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+val[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[weight.length-1][val.length-1]);
    }
}
