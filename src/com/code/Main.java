package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CountingBits c = new CountingBits();
        int[] result = c.countBits(32);
        for(int i : result)
            System.out.print(i+"\t");
    }
}
