package Concept;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타일리쉬들여쓰기 {
    private static int[][] m;
    private static int[][] dap;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            m = new int[p][4];
            for (int i = 0; i < p; i++) {
                String line = br.readLine();
                int index = 0;
                while(line.charAt(index) == '.') {
                    index++;
                }
                m[i][0] = index;
                if (i > 0) {
                    m[i][1] = m[i-1][1];
                    m[i][2] = m[i-1][2];
                    m[i][3] = m[i-1][3];
                }
                for (int j = index; j < line.length(); j++) {
                    switch (line.charAt(j)) {
                        case '(':
                            m[i][1]++;
                            break;
                        case ')':
                            m[i][1]--;
                            break;
                        case '{':
                            m[i][2]++;
                            break;
                        case '}':
                            m[i][2]--;
                            break;
                        case '[':
                            m[i][3]++;
                            break;
                        case ']':
                            m[i][3]--;
                            break;
                    }
                }
            }
            dap = new int[q][4];
            for (int i = 0; i < q; i++) {
                String line = br.readLine();
                int index = 0;

                if (i > 0) {
                    dap[i][1] = dap[i-1][1];
                    dap[i][2] = dap[i-1][2];
                    dap[i][3] = dap[i-1][3];
                }
                for (int j = index; j < line.length(); j++) {
                    switch (line.charAt(j)) {
                        case '(':
                            dap[i][1]++;
                            break;
                        case ')':
                            dap[i][1]--;
                            break;
                        case '{':
                            dap[i][2]++;
                            break;
                        case '}':
                            dap[i][2]--;
                            break;
                        case '[':
                            dap[i][3]++;
                            break;
                        case ']':
                            dap[i][3]--;
                            break;
                    }
                }
            }

            for (int i = 0; i < q; i++) {
                dap[i][0] = -2;
            }
            for (int R = 1; R <= 20; R++) {
                for (int C = 1; C <= 20; C++) {
                    for (int S = 1; S <= 20; S++) {
                        if(check(R,C,S)) {
                            cal(R,C,S);
                        }
                    }
                }
            }
            sb.append('#').append(testCase).append(" 0");
            for (int i = 1; i < dap.length; i++) {
                sb.append(' ').append(dap[i][0]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void cal(int R, int C, int S) {
        for (int i = 1; i < dap.length; i++) {
            int x = dap[i-1][1]*R+ dap[i-1][2]*C + dap[i-1][3]*S;
            if (dap[i][0] == -2) {
                dap[i][0] = x;
            } else if (dap[i][0] != x) {
                dap[i][0] = -1;
            }
        }
    }
    public static boolean check(int R, int C, int S) {
        for (int i = 1; i < m.length; i++) {
            if (m[i][0] != m[i-1][1]*R + m[i-1][2]*C + m[i-1][3]*S) {
                return false;
            }
        }
        return true;
    }
}
