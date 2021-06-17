package Round_B_2021;

import java.util.*;
//input error
public class Problem4 {
    static class Tag{
        int L;
        long A;
        Tag(int l,long a){
            this.L=l;
            this.A=a;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N=scanner.nextInt();
            int Q=scanner.nextInt();
            List<Long> ans=new ArrayList<>();
            Tag[][] M=new Tag[N+1][N+1];
            int X=0,Y=0,Li=0;
            long Ai=0;
            int Cj=0,Wj=0;
            for (int i = 0; i < N - 1; i++) {
                X=scanner.nextInt();
                Y=scanner.nextInt();
                Li=scanner.nextInt();
                Ai=scanner.nextLong();
                M[X][Y]=new Tag(Li,Ai);
                M[Y][X]=new Tag(Li,Ai);
            }
            //init path[];
            int[] path=new int[N+1];
            Arrays.fill(path,-1);
            path[1]=0;
            boolean[] visited=new boolean[N+1];
            Arrays.fill(visited,false);
            Queue<Integer> q=new LinkedList<>();
            q.add(1);
            visited[1]=true;
            while (!q.isEmpty()){
                int tmp=q.poll();
                for (int i = 1; i < N + 1; i++) {
                    if(M[tmp][i]!=null&&!visited[i]){
                        path[i]=tmp;
                        visited[i]=true;
                        q.add(i);
                    }
                }
            }
            for (int i = 0; i < Q; i++) {
                Cj=scanner.nextInt();
                Wj=scanner.nextInt();
                int start=Cj;
                long gcdans=0;
                while(path[start]!=0){
                    if(gcdans==1)break;
                    int before=path[start];
                    int L=M[before][start].L;
                    if(L<=Wj){
                        gcdans=gcd(gcdans,M[before][start].A);
                    }
                    start=before;
                }
                ans.add(gcdans);
            }
            System.out.print("Case #"+(t+1)+":");
            for (long a : ans) {
                System.out.print(" "+a);
            }
            System.out.println();
        }
    }
    public static long gcd(long a,long b){
        //let a>=b;
        if(a<b){
            long tmp=a;
            a=b;
            b=tmp;
        }
        if(b==0)return a;
        if(a%b==0)return b;
        return gcd(b,a%b);
    }
}