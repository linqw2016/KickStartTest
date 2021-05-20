package Round_A_2021;

import java.util.*;

public class Rabbit_house {
    public static class Node{
        int i;
        int j;
        int val;
        Node(int rIndex,int cIndex,int val){
            this.i=rIndex;
            this.j=cIndex;
            this.val=val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        int[][] b={{1,0},{0,1},{-1,0},{0,-1}};
        for (int t = 0; t < T; t++) {
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            int[][] matrix=new int[row][col];
            int max=-1;
            PriorityQueue<Node> queue=new PriorityQueue<>((o1, o2) -> o2.val-o1.val);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j]=scanner.nextInt();
                    max=Math.max(max,matrix[i][j]);
                    Node node=new Node(i,j,matrix[i][j]);
                    queue.add(node);
                }
            }
            long ans=0;
            while (!queue.isEmpty()){
                Node tmp=queue.poll();
                if(tmp.val!=matrix[tmp.i][tmp.j])continue;
                for (int i = 0; i < 4; i++) {
                    int x=tmp.i+b[i][0];
                    int y=tmp.j+b[i][1];
                    if(x>=0&&x<row&&y>=0&&y<col&&Math.abs(tmp.val-matrix[x][y])>1){
                        int add=tmp.val-1-matrix[x][y];
                        matrix[x][y]=tmp.val-1;
                        queue.add(new Node(x,y,tmp.val-1));
//                        replace(queue,x,y,add);
                        ans+=add;
                    }
                }
            }
            System.out.println("Case #"+(t+1)+": "+ans);
        }
    }
}
