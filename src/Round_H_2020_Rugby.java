import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Round_H_2020_Rugby {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int case_num=1;case_num<=T;case_num++){
            int n=scanner.nextInt();
            int[] X=new int[n];
            int[] Y=new int[n];
            int i=0;
            while(i<n){
                X[i]=scanner.nextInt();
                Y[i]=scanner.nextInt();
                i++;
            }
            Arrays.sort(X);
            for (int j = 0; j < n; j++) {
                X[j]-=j;
            }
            Arrays.sort(X);
            Arrays.sort(Y);
            long ans=0;
            for (int j = 0; j < n; j++) {
                ans+=Math.abs(Y[j]-Y[n/2]);
                ans+=Math.abs(X[j]-X[n/2]);
            }
            System.out.println("Case #"+case_num+": "+ans);
        }
    }
}
