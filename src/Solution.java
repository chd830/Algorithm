////////////import java.util.*;
////////////
////////////class Solution {
////////////    public static void main(String[] args) {
////////////        System.out.println("----------17----------");
////////////        System.out.println(solution("17"));
////////////        System.out.println("----------2----------");
////////////        System.out.println(solution("2"));
////////////        System.out.println("----------222----------");
////////////        System.out.println(solution("222"));
////////////        System.out.println("----------1276543---------");
////////////        System.out.println(solution("1276543"));
////////////
////////////    }
////////////    static boolean[] prime = new boolean[12345678];
////////////    static boolean[] visited;
////////////    static int[] sub;
////////////    static int answer;
////////////    public static int solution(String numbers) {
////////////        answer = 0;
////////////        setPrime();
////////////        for(int i = 1; i <= numbers.length(); i++) {
////////////            visited = new boolean[numbers.length()];
////////////            sub = new int[i];
////////////            perm(0, numbers);
////////////        }
////////////        return answer;
////////////    }
////////////    static void setPrime() {
////////////        Arrays.fill(prime, true);
////////////        prime[0] = false;
////////////        prime[1] = false;
////////////        for(int i = 2; i <= 10000000; i++) {
////////////            for(int j = i+i; j <= 10000000; j += i) {
////////////                prime[j] = false;
////////////            }
////////////        }
////////////    }
////////////    static void perm(int idx, String numbers) {
////////////        if(idx == sub.length) {
////////////            String num = "";
////////////            for(int i : sub)
////////////                num += i;
////////////            int n = Integer.parseInt(num);
////////////            if(prime[n]) {
////////////                prime[n] = false;
////////////                answer++;
////////////            }
////////////            return;
////////////        }
////////////        for(int i = 0; i < numbers.length(); i++) {
////////////            if(!visited[i]) {
////////////                visited[i] = true;
////////////                sub[idx] = numbers.charAt(i)-'0';
////////////                perm(idx+1, numbers);
////////////                visited[i] = false;
////////////            }
////////////        }
////////////    }
////////////}
//////////
//////
////// -kakaopay
//////import java.util.*;
//////class Solution {
//////    public static void main(String[] args) {
////////        System.out.println(solution(12345678, 10, 20, 250000, 10000000, 4));
//////        System.out.println(solution(1000000000, 50, 99, 100000, 0, 6));
//////    }
//////
//////    public static int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
//////
//////        while (months-- > 0) {
//////            String sub = String.valueOf(money);
//////            sub = sub.substring(0, sub.length() - 2) + "00";
//////            long m = Integer.parseInt(sub);
//////            if (money < threshold) {
//////                break;
//////            }
//////            else {
//////                int tmp = money-threshold;
//////                int rate = tmp/ranksize+minratio;
//////                if(rate > maxratio) {
//////                    rate = maxratio;
//////                }
//////                m *= rate;
//////                m /= 100;
//////                System.out.println(money+"\t"+rate+"\t"+m);
//////                money -= m;
//////            }
//////        }
//////        return money;
//////    }
//////}
//////
//////import java.util.Arrays;
//////
//////class Solution {
//////    public static void main(String[] args) {
//////        System.out.println(Arrays.toString(solution(4, 3, new int[][] {
//////                {1, 1, 2, 4, 3},
//////                {3, 2, 1, 2, 3},
//////                {4, 1, 1, 4, 3},
//////                {2, 2, 1, 3, 3}
//////        })));
//////    }
//////    public static int[] solution(int rows, int columns, int[][] swipes) {
//////        int[][] arr = new int[rows][columns];
//////        for(int i = 0, val = 1; i < rows; i++) {
//////            for(int j = 0; j < columns; j++) {
//////                arr[i][j] = val++;
//////            }
//////        }
//////        int[] answer = new int[swipes.length];
//////        int idx = 0;
//////        for(int[] swipe : swipes) {
//////            print(arr);
//////            for(int i = 0; i < swipe.length; i++)
//////                swipe[i]--;
//////            int d = swipe[0];
//////            int x1 = swipe[1];
//////            int y1 = swipe[2];
//////            int x2 = swipe[3];
//////            int y2 = swipe[4];
//////            int sum = 0;
//////            switch(d) {
//////                case 0:
//////                    for(int i = y2; i >= y1; i--) {
//////                        sum += arr[x2][i];
//////                    }
//////                    for(int i = y1; i <= y2; i++) {
//////                        int cur = arr[x1][i];
//////                        for(int j = x1+1; j <= x2; j++) {
//////                            int tmp = arr[j][i];
//////                            arr[j][i] = cur;
//////                            cur = tmp;
//////                        }
//////                        arr[x1][i] = cur;
//////                    }
//////                    break;
//////                case 1:
//////                    for(int i = y2; i >= y1; i--) {
//////                        sum += arr[x1][i];
//////                    }
//////                    for(int i = y1; i <= y2; i++) {
//////                        int cur = arr[x2][i];
//////                        for(int j = x2-1; j >= x1; j--) {
//////                            int tmp = arr[j][i];
//////                            arr[j][i] = cur;
//////                            cur = tmp;
//////                        }
//////                        arr[x2][i] = cur;
//////                    }
//////                    break;
//////                case 2:
//////                    for(int i = x2; i >= x1; i--) {
//////                        sum += arr[i][y2];
//////                    }
//////                    for(int i = x1; i <= x2; i++) {
//////                        int cur = arr[i][y1];
//////                        for(int j = y1+1; j <= y2; j++) {
//////                            int tmp = arr[i][j];
//////                            arr[i][j] = cur;
//////                            cur = tmp;
//////                        }
//////                        arr[i][y1] = cur;
//////                    }
//////                    break;
//////                case 3:
//////                    for(int i = x2; i >= x1; i--) {
//////                        sum += arr[i][y1];
//////                    }
//////                    for(int i = x1; i <= x2; i++) {
//////                        int cur = arr[i][y2];
//////                        for(int j = y2-1; j >= y1; j--) {
//////                            int tmp = arr[i][j];
//////                            arr[i][j] = cur;
//////                            cur = tmp;
//////                        }
//////                        arr[i][y2] = cur;
//////                    }
//////                    break;
//////            }
//////            answer[idx++] = sum;
//////        }
//////        print(arr);
//////        return answer;
//////    }
//////    static void print(int[][] arr) {
//////        for(int i = 0; i < arr.length; i++) {
//////            System.out.println(Arrays.toString(arr[i]));
//////        }
//////        System.out.println();
//////    }
//////}
//////
//////import java.util.ArrayList;
//////import java.util.List;
//////
//////class Solution {
//////    public static void main(String[] args) {
//////        System.out.println(solution("abbbcbbb", "bbb"));
//////    }
//////    public static int solution(String line1, String line2) {
//////        int cnt = 0;
//////        char[] lineTochar = line2.toCharArray();
//////        String str = "";
//////        int p = 0;
//////        while(str.length() <= line1.length()) {
//////            str = transform(lineTochar, p++);
//////            for(int i = 0; i <= line1.length()-str.length(); i++) {
//////                if(compare(line1.substring(i, i+str.length()), str))
//////                    cnt++;
//////            }
//////        }
//////        return cnt;
//////    }
//////    // 기존의 문자열과 변형된 문자열의 비교
//////    static boolean compare(String s1, String s2) {
//////        for(int i = 0; i < s1.length(); i++) {
//////            if(s2.charAt(i) == '-')
//////                continue;
//////            if(s1.charAt(i) == s2.charAt(i))
//////                continue;
//////            return false;
//////        }
//////        return true;
//////    }
//////    static String transform(char[] charArr, int cnt) {
//////        String str = "";
//////        for(int i = 0; i < charArr.length; i++) {
//////            str += charArr[i];
//////            int j = 0;
//////            while(i != charArr.length-1 && j++ < cnt) {
//////                str += "-";
//////            }
//////        }
//////        return str;
//////    }
//////}
//////
//////import java.util.*;
//////
//////class Solution {
//////    public static void main(String[] args) {
////////        System.out.println(Arrays.toString(solution(new long[] {35, 25, 3, 8, 7}, new int[][] {{1, 2, 5}, {2, 1, 5}, {1, 3, 2}, {3, 5, 20}, {3, 4, 2}, {4, 5, 1}})));
//////        System.out.println(Arrays.toString(solution(new long[] {8, 13, 5, 8}, new int[][] {{1, 3, 10}, {3, 4, 1}, {4, 2, 2}, {2, 1, 3}})));
//////    }
//////    static class Generator implements Comparable<Generator> {
//////        int cur;
//////        int toward;
//////        int val;
//////
//////        Generator(int cur, int toward, int val) {
//////            this.cur = cur;
//////            this.toward = toward;
//////            this.val = val;
//////        }
//////
//////        @Override
//////        public int compareTo(Generator o) {
//////            if (this.cur == o.cur)
//////                return Integer.compare(this.toward, o.toward);
//////            return Integer.compare(this.cur, o.cur);
//////        }
//////
//////        @Override
//////        public String toString() {
//////            return "Generator{" +
//////                    "cur=" + cur +
//////                    ", toward=" + toward +
//////                    ", val=" + val +
//////                    '}';
//////        }
//////    }
//////    public static int[] solution(long[] ages, int[][] wires) {
//////        int[] answer = new int[ages.length];
//////        List<Generator>[] list = new ArrayList[ages.length+1];
//////        for(int i = 0; i <= ages.length; i++) {
//////            list[i] = new ArrayList<>();
//////        }
//////        for(int[] wire : wires) {
//////            list[wire[0]].add(new Generator(wire[0], wire[1], wire[2]));
//////        }
//////        for(int i = 0; i <= ages.length; i++) {
//////            Collections.sort(list[i]);
//////        }
//////        for(int i = 1; i <= ages.length; i++) {
//////            for(Generator g : list[i]) {
//////                System.out.println(g);
//////            }
//////        }
//////        int idx = 0;
//////        int date = 0;
//////        boolean[] end = new boolean[ages.length+1];
//////        while(idx < ages.length) {
//////            for (int i = 0; i < ages.length; i++) {
//////                if(ages[i] == 0 && !end[i+1]) {
//////                    answer[idx++] = i+1;
//////                    end[i+1] = true;
//////                }
//////                if(ages[i] == 0 && end[i+1]) {
//////                    if(list[i+1] == null) {
//////                        continue;
//////                    }
//////                    for (Generator g : list[i+1]) {
//////                        if(!end[g.toward] && g.val <= 0) {
//////                            answer[idx++] = g.toward;
//////                            end[g.toward] = true;
//////                        }
//////                        if(g.val > 0) {
//////                            g.val--;
//////                        }
//////                    }
//////                    continue;
//////                }
//////                if(ages[i] > 0)
//////                    ages[i]--;
//////            }
//////            date++;
//////        }
//////        return answer;
//////    }
//////}
////
//////import java.util.LinkedList;
//////import java.util.List;
//////import java.util.Scanner;
//////
//////public class Solution {
//////    private static int[] dx = {0, 1, 0, -1};
//////    private static int[] dy = {1, 0, -1, 0};
//////    private static int n, l, k;
//////    private static int[][] board;
//////    private static List<int[]> snake;
//////
//////    public static void main(String[] args) {
//////        snake = new LinkedList<>();
//////        snake.add(new int[]{0, 0});
//////        Scanner sc = new Scanner(System.in);
//////        n = sc.nextInt();
//////        board = new int[n][n];
//////        k = sc.nextInt();
//////        for (int i = 0; i < k; i++) {
//////            int x = sc.nextInt();
//////            int y = sc.nextInt();
//////            board[x - 1][y - 1] = 1; // 사과의 위치 설정
//////        }
//////        l = sc.nextInt();
//////        int[][] dir = new int[l][2];
//////        for (int i = 0; i < l; i++) {
//////            dir[i][0] = sc.nextInt();
//////            char temp = sc.next().charAt(0);
//////            dir[i][1] = (temp == 'L') ? -1 : 1; // L -> -1, D -> 1
//////        }
//////        int time = solution(0, 0, 0, dir);
//////        System.out.println(time);
//////    }
//////
//////    private static int solution(int curX, int curY, int currentDir, int[][] dir) {
//////        int time = 0;
//////        int turn = 0;
//////        while (true) {
//////            time++;
//////            int nextX = curX + dx[currentDir];
//////            int nextY = curY + dy[currentDir];
//////            if (isFinish(nextX, nextY)) break;
//////            if (board[nextX][nextY] == 2) { // 사과를 먹으면
//////                snake.add(new int[]{nextX, nextY});
//////            } else {
//////                snake.add(new int[]{nextX, nextY});
//////                snake.remove(0); // snake 꼬리 제거
//////            }
//////            curX = nextX;
//////            curY = nextY;
//////            if (turn < l) {
//////                if (time == dir[turn][0]) { // 다음 방향 설정
//////                    currentDir = nextDir(currentDir, dir[turn][1]);
//////                    turn++;
//////                }
//////            }
//////        }
//////        return time;
//////    }
//////
//////    private static int nextDir(int current, int dir) { // current 현재, dir 다음 방향
//////        int next = (current + dir) % 4;
//////        if (next == -1) next = 3;
//////        return next;
//////    }
//////
//////    private static boolean isFinish(int x, int y) {
//////        if (x == -1 || x == n || y == -1 || y == n) { // 다음 위치가 보드판 밖으로 나갔는지
//////            return true;
//////        }
//////        for (int i = 0; i < snake.size(); i++) { // 뱀 몸통이랑 닿았는지
//////            int[] s = snake.get(i);
//////            if (s[0] == x && s[1] == y) return true;
//////        }
//////        return false;
//////    }
//////}
//////
//////import java.util.*;
//////
//////class Solution {
//////    public static void main(String[] args) {
//////        System.out.println(solution(new String[] {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3));
//////    }
//////    public static int solution(String[] id_list, int k) {
//////        int answer = 0;
//////        HashMap<String, Integer> total = new HashMap<>();
//////        for(String id : id_list) {
//////            HashMap<String, Integer> map = new HashMap<>();
//////            StringTokenizer token = new StringTokenizer(id);
//////            while(token.hasMoreTokens()) {
//////                String customer = token.nextToken();
//////                if(!map.containsKey(customer)) {
//////                    if(total.containsKey(customer) && total.get(customer) >= k)
//////                        continue;
//////                    if(map.containsKey(customer))
//////                        continue;
//////                    map.put(customer, 1);
//////                    answer++;
//////                    if(!total.containsKey(customer))
//////                        total.put(customer, 1);
//////                    else
//////                        total.put(customer, total.get(customer)+1);
//////                }
//////            }
//////        }
//////        return answer;
//////    }
//////}
//////
//////import java.util.Arrays;
//////
//////class Solution {
//////    static int[][] arr;
//////    static int count;
//////    static int cnt;
//////    static int end;
//////    static int x;
//////    static int y;
//////    public static int[] solution(int n, int jump) {
//////        arr = new int[n][n];
//////        count = 2;
//////        arr[0][0] = 1;
//////        end = n*n+1;
//////        while(count < end)
//////            fill(jump);
//////        return new int[]{x+1, y+1};
//////    }
//////
//////    static void print() {
//////        for(int i = 0; i < arr.length; i++)
//////            System.out.println(Arrays.toString(arr[i]));
//////        System.out.println();
//////    }
//////
//////    static void fill(int jump) {
//////        int row = 0;
//////        int col = 0;
//////        int k = 0;
//////
//////        if(cnt == 0)
//////            cnt = jump;
//////        for (int n = arr.length; n > 0; n -= 2) {
//////            for (col = 0; col < n; col++) {
//////                if(arr[k][k+col] == 0)
//////                    cnt--;
//////                if(cnt == 0) {
//////                    arr[k][k + col] = count++;
//////                    cnt = jump;
//////                    if(count == end) {
//////                        x = k;
//////                        y = k+col;
//////                        return;
//////                    }
//////                }
//////            }
//////
//////            if(cnt == 0)
//////                cnt = jump;
//////            for (row = 1; row < n; row++) {
//////                if(arr[k+row][arr.length-k-1] == 0)
//////                    cnt--;
//////                if(cnt == 0) {
//////                    arr[k + row][arr.length - k - 1] = count++;
//////                    cnt = jump;
//////                    if(count == end) {
//////                        x = k+row;
//////                        y = arr.length-k-1;
//////                        return;
//////                    }
//////                }
//////            }
//////
//////            if(cnt == 0)
//////                cnt = jump;
//////            for (col = 1; col < n; col++) {
//////                if(arr[k+row-1][arr.length-k-col-1] == 0)
//////                    cnt--;
//////                if(cnt == 0) {
//////                    arr[k+row-1][arr.length-k-col-1] = count++;
//////                    cnt = jump;
//////                    if(count == end) {
//////                        x = k+row-1;
//////                        y = arr.length-k-col-1;
//////                        return;
//////                    }
//////                }
//////            }
//////
//////            if(cnt == 0)
//////                cnt = jump;
//////            for (col = 1; col < n - 1; col++) {
//////                if(arr[arr.length-k-col-1][k] == 0)
//////                    cnt--;
//////                if(cnt == 0) {
//////                    arr[arr.length-k-col-1][k] = count++;
//////                    cnt = jump;
//////                    if(count == end) {
//////                        x = arr.length-k-col-1;
//////                        y = k;
//////                        return;
//////                    }
//////                }
//////            }
//////            k++;
//////        }
//////        print();
//////    }
//////}
//////
//////import java.util.*;
//////
//////class Solution {
//////    public static void main(String[] args) {
//////        System.out.println(Arrays.toString(solution(new String[] {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"})));
//////    }
//////    static class Grade implements Comparable<Grade> {
//////        String problem;
//////        String grade;
//////        Grade(String problem, String grade) {
//////            this.problem = problem;
//////            this.grade = grade;
//////        }
//////
//////        @Override
//////        public String toString() {
//////            return "Grade{" +
//////                    "problem='" + problem + '\'' +
//////                    ", grade='" + grade + '\'' +
//////                    '}';
//////        }
//////
//////        @Override
//////        public boolean equals(Object obj) {
//////            return this.problem == ((Grade)obj).problem && this.grade == ((Grade)obj).grade;
//////        }
//////
//////        @Override
//////        public int compareTo(Grade o) {
//////            return Integer.compare(Integer.parseInt(this.problem), Integer.parseInt(o.problem));
//////        }
//////    }
//////
//////    public static String[] solution(String[] logs) {
//////        List<String> answerList = new ArrayList<>();
//////        HashMap<String, Integer> findNums = new HashMap<>();
//////        for(String log : logs) {
//////            StringTokenizer token = new StringTokenizer(log);
//////            findNums.put(token.nextToken(), 1);
//////        }
//////        List<Grade>[] grades = new ArrayList[findNums.size()];
//////        for(int i = 0; i < grades.length; i++)
//////            grades[i] = new ArrayList<>();
//////        String[] nums = new String[findNums.size()];
//////        int idx = 0;
//////        findNums = new HashMap<>();
//////        for(String log : logs) {
//////            StringTokenizer token = new StringTokenizer(log);
//////            String num = token.nextToken();
//////            if(findNums.containsKey(num)) {
//////                for(int i = 0; i < nums.length; i++) {
//////                    if(nums[i].equals(num)) {
//////                        idx = i;
//////                        break;
//////                    }
//////                }
//////                Grade g = new Grade(token.nextToken(), token.nextToken());
//////                for(int i = 0; i < grades[idx].size(); i++) {
//////                    if(grades[idx].get(i).problem.equals(g.problem)) {
//////                        grades[idx].remove(i);
//////                        break;
//////                    }
//////                }
//////
//////                grades[idx].add(g);
//////            }
//////            else {
//////                findNums.put(num, 1);
//////                for(int i = 0; i < nums.length; i++) {
//////                    if(nums[i] == null) {
//////                        idx = i;
//////                        break;
//////                    }
//////                }
//////                grades[idx].add(new Grade(token.nextToken(), token.nextToken()));
//////                nums[idx] = num;
//////            }
//////        }
//////        for(int i = 0; i < nums.length; i++) {
//////            Collections.sort(grades[i]);
//////            for(Grade g : grades[i])
//////                System.out.println(g);
//////            System.out.println();
//////        }
//////        boolean[] check = new boolean[nums.length];
//////        for(int i = 0; i < nums.length-1; i++) {
//////            loop: for(int j = i+1; j < nums.length; j++) {
//////                if(grades[i].size() == grades[j].size()) {
//////                    boolean flag = true;
//////                    for(int k = 0; k < grades[i].size(); k++) {
//////                        flag = true;
//////                        System.out.println(grades[i].get(k)+"\t"+grades[j].get(k)+"\t"+grades[i].get(k).problem.equals(grades[j].get(k).problem) +"\t"+ grades[i].get(k).grade.equals(grades[j].get(k).grade));
//////                        if(!(grades[i].get(k).problem.equals(grades[j].get(k).problem) || !(grades[i].get(k).grade.equals(grades[j].get(k).grade)))) {
//////                            System.out.println(grades[i].get(k)+"\t"+grades[j].get(k));
//////                            continue loop;
//////                        }
//////                    }
//////                    if(flag) {
//////                        if(!check[i]) {
//////                            check[i] = true;
//////                            answerList.add(nums[i]);
//////                        }
//////                        if(!check[j]) {
//////                            check[j] = true;
//////                            answerList.add(nums[j]);
//////                        }
//////                    }
//////                }
//////            }
//////        }
//////
//////        if(answerList.size() == 0)
//////            return new String[] {"None"};
//////        String[] answer = new String[answerList.size()];
//////        for(int i = 0; i < answer.length; i++) {
//////            answer[i] = answerList.get(i);
//////        }
//////        Arrays.sort(answer);
//////        return answer;
//////    }
//////}
//////
//////import java.util.*;
//////
//////class Solution {
//////    public static void main(String[] args) {
//////        System.out.println(solution(new int[][] {{1, -7, -2, 1, -1},{2, 3, 0, -1, -2},{1, -1, 6, -1, -2},{-1, 1, -2, 0, 4},{10, 5, -3, -1, 1}}));
////////        System.out.println(solution(new int[][] {{-10, 20, 30}, {-10, 0, 10}, {-20, 40, 1}}));
//////    }
//////    static int max;
//////    public static int solution(int[][] board) {
//////        max = 0;
//////        visited = new boolean[board.length][board[0].length];
//////        dfs(0, 0, board[0][0], board);
//////        return max;
//////    }
//////    static boolean[][] visited;
//////    static int[][] dir = {{0, 1}, {1, 0}};
//////    static void dfs(int x, int y, int sum, int[][] board) {
//////        if(x == board.length-1 && y == board[0].length-1) {
//////            max = Math.max(max, sum);
//////            return;
//////        }
//////        for(int d = 0; d < dir.length; d++) {
//////            int dx = x + dir[d][0];
//////            int dy = y + dir[d][1];
//////            if(dx >= 0 && dy >= 0 && dx < board.length && dy < board[0].length && !visited[dx][dy]) {
//////                visited[dx][dy] = true;
//////                if(board[dx][dy] == 0)
//////                    dfs(dx, dy, Math.max(sum, sum*-1), board);
//////                else
//////                    dfs(dx, dy, sum+board[dx][dy], board);
//////                visited[dx][dy] = false;
//////            }
//////        }
//////    }
//////}
////
////import java.util.*;
////
////class Solution {
////    public static void main(String[] args) {
////        System.out.println(solution(new int[] {9, -1, -5}));
//////        System.out.println(solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33}));
////    }
////    static int answer;
////    public static int solution(int[] a) {
////        answer = 0;
////        list = new ArrayList<>();
////        for (int i = 0; i < a.length; i++) {
////            recur(a, i, true);
////            recur(a, i, false);
////        }
////        Collections.sort(list);
////        return list.size();
////    }
////    static List<Integer> list;
////    static void recur(int[] a, int idx, boolean flag) {
////        System.out.println(Arrays.toString(a)+"\t"+idx+"\t"+(flag ? "최댓값" : "최솟값"));
////        if (a.length == 1) {
////            if(list.contains(a[0])) {
////                return;
////            }
////            System.out.println(Arrays.toString(a));
////            list.add(a[0]);
////            answer++;
////            return;
////        }
////        if(idx+1 >= a.length)
////            return;
////        int[] tmp = new int[a.length - 1];
////        if (flag) {
////            int max = Math.max(a[idx], a[idx + 1]);
////            for (int i = 0, j = 0; j < tmp.length; i++) {
////                if (i == idx) {
////                    tmp[j] = max;
////                    j++;
////                    i++;
////                } else
////                    tmp[j++] = a[i];
////            }
////        } else {
////            int min = Math.min(a[idx], a[idx + 1]);
////            for (int i = 0, j = 0; j < tmp.length; i++) {
////                if (i == idx) {
////                    tmp[j] = min;
////                    j++;
////                    i++;
////                } else
////                    tmp[j++] = a[i];
////            }
////        }
////        for (int i = 0; i < tmp.length; i++) {
////            recur(tmp, i, !flag);
////        }
////    }
////}
//
//import java.util.*;
//
//// # Line 온라인 코딩테스트
//
////class Solution {
////    public static void main(String[] args) {
////        System.out.println(solution("execute"));
////    }
////    public static String solution(String source) {
////        String dest = "";
////        while(source.length() != 0) {
////            int[] alph = new int[26];
////            for (char c : source.toCharArray()) {
////                alph[c - 97]++;
////            }
////            for(int i = 0; i < 26; i++) {
////                if(alph[i] >= 1) {
////                    dest += (char) (i + 97);
////                    source = source.replaceFirst(String.valueOf((char)(i+97)), "");
////                }
////            }
////        }
////        return dest;
////    }
////}
//
////class Solution {
////    public static void main(String[] args) {
////        int[][] res = solution(3, 5);
////        for(int i = 0; i < res.length; i++)
////            System.out.println(Arrays.toString(res[i]));
////        System.out.println();
////
////        res = solution(5, 4);
////        for(int i = 0; i < res.length; i++)
////            System.out.println(Arrays.toString(res[i]));
////    }
////    static int idx;
////    static int x;
////    static int y;
////    static int[][] answer;
////    public static int[][] solution(int r, int c) {
////        answer = new int[r][c];
////        idx = 1;
////        x = 0;
////        y = c-1;
////        while(idx < r*c) {
////            // pos가 1일때 x값이 증가하고 -1일 때 x값이 감소함
////            left(1);
////            down(1);
////            right(-1);
////            left(-1);
////            up(1);
////            right(1);
////        }
////        return answer;
////    }
////    static void left(int pos) {
////        while(y >= 0 && answer[x][y] == 0) {
////            answer[x][y] = idx++;
////            y--;
////        }
////        y++;
////        x += pos;
////    }
////    static void down(int pos) {
////        while(x < answer.length && answer[x][y] == 0) {
////            answer[x][y] = idx++;
////            x++;
////        }
////        x--;
////        y += pos;
////    }
////    static void right(int pos) {
////        while(y < answer[0].length && answer[x][y] == 0) {
////            answer[x][y] = idx++;
////            y++;
////        }
////        y--;
////        x += pos;
////    }
////    static void up(int pos) {
////        while(x >= 0 && answer[x][y] == 0) {
////            answer[x][y] = idx++;
////            x--;
////        }
////        x++;
////        y += pos;
////    }
////}
//
//
////class Solution {
////    public static void main(String[] args) {
//////        System.out.println(solution(
//////                new int[][] {{0, 2, 0}, {1, 0, 5}, {3, 4, 0}},
//////                new int[][] {{0, 2, 0}, {2, 0, 1}, {2, 1, 0}}));
////        System.out.println(solution(
////                new int[][] {{0, 0, 2, 0}, {1, 0, 3, 2}, {0, 0, 0, 0}, {3, 0, 0, 4}},
////                new int[][] {{0, 0, 2, 0}, {5, 0, 2, 5}, {0, 0, 0, 0}, {5, 0, 0, 5}}
////        ));
////    }
////
////    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
////    static class Node {
////        int x;
////        int y;
////        int count;
////        int d;
////        Node(int x, int y, int count, int d) {
////            this.x = x;
////            this.y = y;
////            this.count = count;
////            this.d = d;
////        }
////
////        @Override
////        public String toString() {
////            return "Node{" +
////                    "x=" + x +
////                    ", y=" + y +
////                    ", count=" + count +
////                    ", d=" + d +
////                    '}';
////        }
////    }
////    static Node n;
////    public static int solution(int[][] board, int[][] durability) {
////        if(board[0][0] != 0)
////            return 0;
////        n = new Node(0, 0, 0, 0);
////        dfs(board, durability, n);
////        return n.count;
////    }
////    // 방향 오른쪽 왼쪽 아래 위
////    static void dfs(int[][] board, int[][] durability, Node n) {
////        int dx = n.x + dir[n.d][0];
////        int dy = n.y + dir[n.d][1];
////        if(dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length)
////            return;
////        if(board[dx][dy] != 0 && durability[dx][dy] != 0) {
////            durability[dx][dy]--;
////            n.x = dx;
////            n.y = dy;
////            n.count++;
////            switch (board[dx][dy]) {
////                case 1:
////                    if(n.d == 1)
////                        n.d = 2;
////                    else if(n.d == 3)
////                        n.d = 0;
////                    else if(n.d == 0)
////                        n.d = 1;
////                    else if(n.d == 2)
////                        n.d = 3;
////                    break;
////                case 2:
////                    if(n.d == 0)
////                        n.d = 2;
////                    else if(n.d == 3)
////                        n.d = 1;
////                    else if(n.d == 2)
////                        n.d = 3;
////                    else if(n.d == 1)
////                        n.d = 0;
////                    break;
////                case 3:
////                    if(n.d == 1)
////                        n.d = 3;
////                    else if(n.d == 2)
////                        n.d = 0;
////                    else if(n.d == 0)
////                        n.d = 1;
////                    else if(n.d == 3)
////                        n.d = 2;
////                    break;
////                case 4:
////                    if(n.d == 0)
////                        n.d = 3;
////                    else if(n.d == 2)
////                        n.d = 1;
////                    else if(n.d == 1)
////                        n.d = 0;
////                    else if(n.d == 3)
////                        n.d = 2;
////                    break;
////                case 5:
////                    if(n.d == 0)
////                        n.d = 1;
////                    else if(n.d == 1)
////                        n.d = 0;
////                    else if(n.d == 2)
////                        n.d = 3;
////                    else
////                        n.d = 2;
////                    break;
////            }
////        }
////        else {
////            n.x = dx;
////            n.y = dy;
////            n.count++;
////            if(dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length)
////                return;
////        }
////        dfs(board, durability, n);
////    }
////}
//
////import java.util.*;
////
////class Solution {
////    public static void main(String[] args) {
////        System.out.println(solution(new int[][] {{0, 0, 1, 1, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 1, 0, 1}}));
////    }
////    public static int solution(int[][] grid) {
////        int r = grid.length;
////        int c = grid[0].length;
////        boolean[][] visited = new boolean[r][c];
////        int answer = 0;
////        int max = Math.max(r, c);
////        while(max-- > 0) {
////            for (int i = 0; i < r; i++) {
////                for (int j = 0; j < c; j++) {
////                    boolean check = true;
////                    int min = Integer.MAX_VALUE;
////                    if (grid[i][j] != 0) {
////                        if (i + 1 < r) {
////                            if (!visited[i + 1][j])
////                                min = Math.min(min, grid[i + 1][j]);
////                            else
////                                visited[i + 1][j] = true;
////                            if (grid[i + 1][j] == 0)
////                                check = false;
////                        }
////                        if (i - 1 >= 0) {
////                            if (!visited[i - 1][j])
////                                min = Math.min(min, grid[i - 1][j]);
////                            else
////                                visited[i - 1][j] = true;
////                            if (grid[i - 1][j] == 0)
////                                check = false;
////                        }
////                        if (j + 1 < c) {
////                            if (!visited[i][j + 1])
////                                min = Math.min(min, grid[i][j + 1]);
////                            else
////                                visited[i][j + 1] = true;
////                            if (grid[i][j + 1] == 0)
////                                check = false;
////                        }
////                        if (j - 1 >= 0) {
////                            if (!visited[i][j - 1])
////                                min = Math.min(min, grid[i][j - 1]);
////                            else
////                                visited[i][j - 1] = true;
////                            if (grid[i][j - 1] == 0)
////                                check = false;
////                        }
////                        if (check) {
////                            grid[i][j] = min + 1;
////                            answer = Math.max(grid[i][j], answer);
////                        }
////                    }
////                }
////            }
////        }
////        return answer;
////    }
////}
//
//// # 라인 핀테크
//
////import java.util.*;
////
////class Solution {
////    public static void main(String[] args) {
//////        System.out.println(Arrays.toString(solution(new String[] {"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"})));
//////        System.out.println(Arrays.toString(solution(new String[] {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"})));
////        System.out.println(Arrays.toString(solution(new String[] {"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"})));
////    }
////    static class Product {
////        int price;
////        int count;
////        Product(int price, int count) {
////            this.price = price;
////            this.count = count;
////        }
////    }
////    public static int[] solution(String[] record) {
////        int first = 0;
////        int last = 0;
////
////        int buy = 0;
////
////        List<Product> firstList = new ArrayList<>();
////        List<Product> lastList = new ArrayList<>();
////
////        for(int i = 0; i < record.length; i++) {
////            StringTokenizer token = new StringTokenizer(record[i]);
////            switch (token.nextToken()) {
////                case "P":
////                    int val = Integer.parseInt(token.nextToken());
////                    int cnt = Integer.parseInt(token.nextToken());
////                    firstList.add(new Product(val, cnt));
////                    lastList.add(new Product(val, cnt));
////                    break;
////                case "S":
////                    token.nextToken();
////                    int count = Integer.parseInt(token.nextToken());
////                    buy += count;
////                    // 선입선출
////                    for(int j = 0; j < firstList.size(); j++) {
////                        Product p = firstList.get(j);
////                        if(p.count <= 0)
////                            continue;
////                        if(p.count >= buy) {
////                            first += p.price * buy;
////                            p.count -= buy;
////                            buy = 0;
////                            break;
////                        }
////                        else {
////                            if(buy > p.count) {
////                                first += p.price * p.count;
////                                int tmp = buy;
////                                buy -= p.count;
////                                p.count -= tmp;
////                            }
////                            else {
////                                first += p.price * buy;
////                                int tmp = buy;
////                                buy -= p.count;
////                                p.count -= tmp;
////                                break;
////                            }
////                        }
////                    }
////                    // 후입선출
////                    for(int j = lastList.size()-1; j >= 0; j--) {
////                        Product p  = lastList.get(j);
////                        if(p.count == 0)
////                            continue;
////                        if(p.count >= count) {
////                            last += p.price * count;
////                            p.count -= count;
////                            break;
////                        }
////                        else {
////                            last += p.price * p.count;
////                            int tmp = p.count;
////                            p.count -= tmp;
////                            count -= tmp;
////                        }
////                    }
////                    break;
////            }
////        }
////
////        return new int[] { first, last };
////    }
////}
//
////class Solution {
////    public static void main(String[] args) {
////        // 연속적인 부분배열을 만든 후 증가-감소로 이루어진 배열찾기
////
////
////    }
////    static void subset() {
////
////    }
////    public static int solution(int[] arr) {
////        int answer = 0;
////        return answer;
////    }
////}
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(5, 12)));
//    }
//
//    static class Pos {
//        int x;
//        int y;
//        Pos(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    public static int[] solution(int n, int k) {
//        int[] answer = new int[2];
//        int[][] arr = new int[n][n];
//        int idx = 1;
//        Pos cur = new Pos(0, 0);
//        Pos next = new Pos(0, 0);
//        Pos prev = new Pos(0, 0);
//        arr[0][0] = idx++;
//        while(idx <= n*n) {
//            int max = 0;
//            int min = Integer.MAX_VALUE;
//            for(int i = 0; i < n; i++) {
//                for(int j = n-1; j >= 0; j--) {
//                    int distance = Math.abs(cur.x-i)+Math.abs(cur.y-j);
//                    if(cur.x == 0 && cur.y == 0) {
//                        if(distance >= max && arr[i][j] == 0) {
//                            max = distance;
//                            next.x = i;
//                            next.y = j;
//                        }
//                    }
//                    else {
//                        distance = Math.abs(Math.abs(cur.x - i) + Math.abs(cur.y - j) - Math.abs(prev.x-i) - Math.abs(prev.y-j));
//                        System.out.println("("+i+", "+j+")\t"+distance);
//                        if(distance <= min && arr[i][j] == 0 && next.y >= j) {
//                            min = distance;
//                            next.x = i;
//                            next.y = j;
//                        }
//                    }
//                }
//            }
//            prev = cur;
//            cur = next;
//            arr[next.x][next.y] = idx++;
//            for(int i = 0; i < n; i++)
//                System.out.println(Arrays.toString(arr[i]));
//            System.out.println();
//        }
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                if(arr[i][j] == k) {
//                    answer[0] = i;
//                    answer[1] = j;
//                }
//            }
//        }
//        return answer;
//    }
//}

//import java.util.*;
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(4, 8)));
//    }
//    public static int[] solution(int n, long k) {
//        int[] arr = new int[n];
//        int tmp = n;
//        List<Integer> list = new ArrayList<>();
//        for(int i = 1; i <= n; i++)
//            list.add(i);
//        k--;
//        for(int i = 0; i < n; i++) {
//            int num = abs(tmp--);
//            arr[i] = list.get((int) (k / num));
//            list.remove((int) (k / num));
//            k %= num;
//        }
//        return arr;
//    }
//    static int abs(int n) {
//        int sum = 1;
//        for(int i = 2; i < n; i++) {
//            sum *= i;
//        }
//        return sum;
//    }
//}

import java.util.*;
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println(solution(4));
//    }
//    static boolean[][] chess;
//    static int answer;
//    public static int solution(int n) {
//        chess = new boolean[n][n];
//        answer = 0;
//        set(0);
//        return answer;
//    }
//    static void print() {
//        for (int i = 0; i < chess.length; i++) {
//            for (int j = 0; j < chess.length; j++) {
//                System.out.print(chess[i][j] ? 1 + " " : 0 + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//    static void set(int cnt) {
//        if(cnt == chess.length) {
////            print();
//            answer++;
//            return;
//        }
//        for(int i = 0; i < chess.length; i++) {
//            if(check(cnt, i)) {
//                chess[cnt][i] = true;
//                set(cnt+1);
//                chess[cnt][i] = false;
//            }
//        }
//    }
//    static boolean check(int x, int y) {
//        // up
//        for(int i = 0; i < x; i++) {
//            if(chess[i][y])
//                return false;
//        }
//        // left
//        for(int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
//            if(chess[i][j])
//                return false;
//        }
//        // right
//        for(int i = x-1, j = y+1; i >= 0 && j < chess.length; i--, j++) {
//            if(chess[i][j])
//                return false;
//        }
//        return true;
//    }
//}

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[] {1, 3, 2, 5, 4}));
    }
    static int[] visited;
    public static int solution(int sticker[]) {
        int len = sticker.length;
        visited = new int[len];
        max = 0;
        recur(0, 0, sticker);
        return max;
    }
    static int max;
    static void recur(int idx, int sum, int[] sticker) {
        boolean flag = false;
        for(int i = idx; i < visited.length; i++) {
            if(visited[i] == 0) {
                flag = true;
                if(i == 0)
                    visited[visited.length-1]++;
                else
                    visited[i-1]++;
                if(i < visited.length-1)
                    visited[i+1]++;
                else
                    visited[0]++;
                visited[i]++;
                recur(idx+1, sum+sticker[i], sticker);
                if(i > 0)
                    visited[i-1]--;
                else
                    visited[visited.length-1]--;
                if(i < visited.length-1)
                    visited[i+1]--;
                else
                    visited[0]--;
                visited[i]--;
            }
        }
        if(!flag) {
            max = Math.max(max, sum);
            return;
        }
    }
}

