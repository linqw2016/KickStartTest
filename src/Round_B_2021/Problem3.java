package Round_B_2021;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long z=scanner.nextLong();
            int sqrt=(int)Math.sqrt(z);
            long after=sqrt+1;
            while (!isPrim(after)){
                after++;
            }
            long before=sqrt;
            while (!isPrim(before)){
                before--;
            }
            if(after*before>z){
                after=before-1;
                while (!isPrim(after)){
                    after--;
                }
            }
            long ans=after*before;
            System.out.println("Case #"+(t+1)+": "+ans);
        }
    }
    public static boolean isPrim(long num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0)return false;
        }
        return true;
    }
}
