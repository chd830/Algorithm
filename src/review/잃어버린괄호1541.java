package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strs = br.readLine();
        String[] str = strs.split("-");
        String []tmp = str[0].split("\\+");
        int first=0;
        for (String t : tmp) {
            first += Integer.parseInt(t);
        }
        int sum = 0;
        for(int i=1; i<str.length; i++){
            String []temp = str[i].split("\\+");
            for (String t : temp)
                sum += Integer.parseInt(t);
        }
        System.out.println(first-sum);
    }
}
