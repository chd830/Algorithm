package daily;

public class day_0202 {
    static int[] arr = {1, 2, 3};
    static int[] sub = new int[2];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        visited = new boolean[arr.length];
        perm(0);
        sb.append("\n");
        visited = new boolean[arr.length];
        comb(0, 0);
        sb.append("\n");
        doublePerm(0);
        sb.append("\n");
        doubleComb(0, 0);
        sb.append("\n");
        visited = new boolean[arr.length];
        subset(0);
        sb.append("\n");
        System.out.println(sb);
    }
    static void print() {
        for(int i : sub) {
            sb.append(i).append("\t");
        }
        sb.append("\n");
    }
    static void perm(int idx) {
        if(idx == sub.length) {
            print();
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = arr[i];
                perm(idx+1);
                visited[i] = false;
            }
        }

    }
    static void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            print();
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = arr[i];
                comb(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
    static void doublePerm(int idx) {
        if(idx == sub.length) {
            print();
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            sub[idx] = arr[i];
            doublePerm(idx+1);
        }
    }
    static void doubleComb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            print();
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            sub[subIdx] = arr[i];
            doubleComb(i, subIdx+1);
        }
    }
    static void subset(int idx) {
        for(int i = 0; i < arr.length; i++) {
            sb.append(visited[i] ? arr[i]+"\t" : "");
        }
        sb.append("\n");
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                subset(i+1);
                visited[i] = false;
            }
        }
    }
}
