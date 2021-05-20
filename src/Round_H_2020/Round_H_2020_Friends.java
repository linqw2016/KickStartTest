package Round_H_2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
2
5 2
LIZZIE KEVIN BOHDAN LALIT RUOYU
1 2
1 3
2 2
KICK START
1 2
1 2
 */
public class Round_H_2020_Friends {
    public static void main(String[] args) {
        int MAX=500000;
        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N=scanner.nextInt();
            int Q=scanner.nextInt();
            String[] strings=new String[N];
            for (int j = 0; j < N; j++) {
                strings[j]=scanner.next();
            }
            //init matrix
            int[][] matrix=new int[26][26];
            for (int j = 0; j < 26; j++) {
                Arrays.fill(matrix[j], MAX);
            }
            for (int j = 0; j < N; j++) {
                int len=strings[j].length();
                String tmp=strings[j];
                for (int k = 0; k < len; k++) {
                    for (int l = k+1; l < len; l++) {
                        matrix[tmp.charAt(k)-'A'][tmp.charAt(l)-'A']=1;
                        matrix[tmp.charAt(l)-'A'][tmp.charAt(k)-'A']=1;
                    }
                }
            }
            for (int j = 0; j < 26; j++) {
                matrix[j][j]=0;
            }
            //floyd
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if(k==j)continue;
                    for (int l = 0; l < 26; l++) {
                        if(l==k||l==j)continue;
                        if(matrix[k][j]+matrix[j][l]<matrix[k][l]){
                            matrix[k][l]=matrix[k][j]+matrix[j][l];
                        }
                    }
                }
            }
            StringBuilder sb=new StringBuilder("Case #"+(i+1)+":");
            for (int j = 0; j < Q; j++) {
                int start=scanner.nextInt()-1;
                int end=scanner.nextInt()-1;
                //BFS
                int ans=MAX;
                for (int k = 0; k < strings[start].length(); k++) {
                    char s=strings[start].charAt(k);
                    for (int l = 0; l < strings[end].length(); l++) {
                        char e=strings[end].charAt(l);
                        ans=Math.min(ans,matrix[s-'A'][e-'A']+2);
                        if(ans==MAX)ans=-1;
                    }
                }
                sb.append(" ").append(ans);
            }
            System.out.println(sb.toString());
        }
    }
}
