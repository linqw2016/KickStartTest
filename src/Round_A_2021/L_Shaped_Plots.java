package Round_A_2021;

import java.util.Arrays;
import java.util.Scanner;

public class L_Shaped_Plots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j]=scanner.nextInt();
                }
            }
            int[][] left = new int[row][col];
            int[][] right = new int[row][col];
            int[][] up = new int[row][col];
            int[][] down = new int[row][col];
            for (int i = 0; i < row; i++) {
                Arrays.fill(left[i], 0);
                Arrays.fill(right[i], 0);
                Arrays.fill(up[i], 0);
                Arrays.fill(down[i], 0);
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 1) {
                        if (j == 0) left[i][j] = 1;
                        else {
                            left[i][j] = left[i][j - 1] + 1;
                        }
                    }
                }
                for (int j = col - 1; j >= 0; j--) {
                    if (matrix[i][j] == 1) {
                        if (j == col - 1) right[i][j] = 1;
                        else {
                            right[i][j] = right[i][j + 1] + 1;
                        }
                    }
                }
            }
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (matrix[j][i] == 1) {
                        if (j == 0) {
                            up[j][i] = 1;
                        } else {
                            up[j][i] = up[j - 1][i] + 1;
                        }
                    }
                }
                for (int j = row - 1; j >= 0; j--) {
                    if (matrix[j][i] == 1) {
                        if (j == row - 1) down[j][i] = 1;
                        else {
                            down[j][i] = down[j + 1][i] + 1;
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 1) {
                        ans += help(left[i][j], up[i][j]);
                        ans += help(left[i][j], down[i][j]);
                        ans += help(right[i][j], up[i][j]);
                        ans += help(right[i][j], down[i][j]);
                    }
                }
            }
            System.out.println("Case #"+(t+1)+": "+ans);
        }

    }

    public static int help(int a, int b) {
        int ans = 0;
        if (a >= 2 && b >= 2) {
            int max=Math.max(a,b);
            int min=Math.min(a,b);
            if(max<4)return 0;
            else {
                ans+=(min-2)/2;
                ans+=Math.min((max-2)/2,min-1);
            }
        }
        return ans;
    }
}
