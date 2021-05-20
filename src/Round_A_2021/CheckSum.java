package Round_A_2021;

import java.util.*;

public class CheckSum {
    public static class Edges{
        int row;
        int col;
        int weight;
        Edges(int row,int col,int weight){
            this.row=row;
            this.col=col;
            this.weight=weight;
        }
    }
    public static class UnionFind{
        int N;
        int[] parents;
        int[] sizes;
        UnionFind(int n){
            this.N=n;
            parents=new int[N];
            sizes=new int[N];
            for (int i = 0; i < N; i++) {
                parents[i]=i;
                sizes[i]=1;
            }
        }
        public int find(int x){
            if(parents[x]==x)return x;
            return parents[x]=find(parents[x]);//路径压缩
        }
        public void connect(int x,int y){
            int xp=find(x);
            int yp=find(y);
            if(xp!=yp){
                if(sizes[xp]>sizes[yp]){
                    parents[yp]=xp;
                    sizes[xp]+=sizes[yp];
                }else {
                    parents[xp]=yp;
                    sizes[yp]+=sizes[xp];
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] A = new int[N][N];
            int[][] B = new int[N][N];
            int[] R = new int[N];
            int[] C = new int[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    B[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                R[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                C[i] = scanner.nextInt();
            }
            UnionFind unionFind = new UnionFind(2 * N);
            int total = 0;
            List<Edges> edgesList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (B[i][j] != 0) {
                        //unionFind.connect(i, N + j);
                        total += B[i][j];
                        edgesList.add(new Edges(i, N + j, B[i][j]));
                    }
                }
            }
            Edges[] edges = edgesList.toArray(new Edges[0]);
            Arrays.sort(edges, (o1, o2) -> o2.weight - o1.weight);
            int MaxCost = 0;
            for (Edges e :
                    edges) {
                if (unionFind.find(e.row) == unionFind.find(e.col)) {
                    continue;
                }
                MaxCost += e.weight;
                unionFind.connect(e.row, e.col);
            }
            //return total-MaxCost;
            System.out.println("Case #" + t + ": " + (total - MaxCost));
        }
    }
}
