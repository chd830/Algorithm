package com.code;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        /*
        n > 4 일때, ((n - 3) * 3) > n이기 때문에
         */
        while (n > 4) {
            product *= 3;
            n -= 3;
            System.out.println(product+", "+n);
        }
        product *= n;
        System.out.println(product+", "+n);

        return product;
    }
}
