package Round_B_2021;

import java.util.Scanner;

public class IncreasingSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder("Case #" +t+ ":");
            int len=scanner.nextInt();
            scanner.nextLine();
            String str=scanner.nextLine();
            int before=1;
            for (int i = 0; i < len; i++) {
                if(i>0){
                    if(str.charAt(i-1)<str.charAt(i)){
                        before++;
                    }else{
                        before=1;
                    }
                }
                sb.append(" "+before);
            }
            System.out.println(sb.toString());
        }
    }
}
