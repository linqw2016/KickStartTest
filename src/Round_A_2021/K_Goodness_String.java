package Round_A_2021;

import java.util.Scanner;

public class K_Goodness_String {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for (int i = 0; i < T; i++) {
            StringBuilder sb=new StringBuilder("Case #"+(i+1)+": ");
            int N=scanner.nextInt();
            int K= scanner.nextInt();
            String str=scanner.next();
            char[] chars=str.toCharArray();
            int len=chars.length;
            int count=0;
            for (int j = 0; j < len/2; j++) {
                //这里注意是'！='号
                if(chars[j]!=chars[len-1-j]){
                    count++;
                }
            }
            //注意取绝对值，K可能比count小
            sb.append(" ").append(Math.abs(K-count));
            System.out.println(sb.toString());
        }
    }
}
