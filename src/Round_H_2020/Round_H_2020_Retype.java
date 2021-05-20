package Round_H_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Round_H_2020_Retype {
    public static void main(String[] args) {
        final Scanner _in = new Scanner(System.in);
        int T = _in.nextInt();
        int n=1;
        while(n<=T) {
            int totalLevel=_in.nextInt();
            int nowLevel=_in.nextInt();
            int aimLevel=_in.nextInt();
            //planA:restart game;
            int ans1= nowLevel+totalLevel;
            //planB:back to aimLevel and continue;
            long ans2= (long)nowLevel-1+(nowLevel-aimLevel)+(totalLevel-aimLevel+1);
            System.out.println("Case #" + n + ": " + Math.min(ans1,ans2));
            n++;
        }
    }
}
