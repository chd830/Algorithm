package net.acmicpc;

public class CountingBits {
    public int[] countBitsSimple(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        if(num < 1)
            return result;
        result[1] = 1;
        for(int i = 2; i <= num; i++) {
            result[i] = getBinary(i);
        }
        return result;
    }
    public int getBinary(int num) {
        int count = 0;
        System.out.print(num);
        while(num > 1) {
            if(num % 2 == 1)
                count++;
            if(num / 2 == 1)
                count++;
            num /= 2;
        }
        System.out.println(", count: "+count);
        return count;
    }
}
