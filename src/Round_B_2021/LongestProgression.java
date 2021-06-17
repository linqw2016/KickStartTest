package Round_B_2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestProgression {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for (int t = 1; t < T+1; t++) {
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=scanner.nextInt();
            }
            if(n<=3){
                System.out.println("Case #"+t+": "+n);
                continue;
            }
            int[] D=new int[n-1];
            Map<Integer,Integer> DMap=new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                D[i]=arr[i+1]-arr[i];
            }
            int startD=0;
            for (int i = 0; i < n - 1; i++) {
                if(i>0){
                    if(D[i]!=D[i-1]){
                        DMap.put(startD,i-startD);
                        DMap.put(i-1,i-startD);
                        startD=i;
                    }
                }
            }
            DMap.put(startD,n-1-startD);
            DMap.put(n-2,n-1-startD);

            int ans=0;
            startD=0;
            for (int i = 1; i < n - 1; i++) {
                if(D[i]!=D[startD]){
                    if(i+1<n-1){
                        if(D[i+1]+D[i]==2*D[startD]){
                            if(i+2<n-1){
                                if(D[i+2]==D[startD]){
                                    ans=Math.max(ans,DMap.get(i+2)+DMap.get(startD)+3);
                                }else{
                                    ans=Math.max(ans,i-startD+3);
                                }
                            }else {
                                ans=Math.max(ans,i-startD+3);
                            }
                        }else{
                            ans=Math.max(ans,i-startD+2);
                        }
                    }else {
                        ans=Math.max(ans,i-startD+2);
                    }
                    startD=i;
                }
            }
            ans=Math.max(ans,n-startD);
            startD=n-2;
            for (int i = n-2; i >=0; i--) {
                if(D[i]!=D[startD]){
                    if(i-1>=0){
                        if(D[i-1]+D[i]==2*D[startD]){
                            if(i-2>=0){
                                if(D[i-2]==D[startD]){
                                    ans=Math.max(ans,DMap.get(i-2)+DMap.get(startD)+3);
                                }else{
                                    ans=Math.max(ans,startD-i+3);
                                }
                            }else {
                                ans=Math.max(ans,startD-i+3);
                            }
                        }else{
                            ans=Math.max(ans,startD-i+2);
                        }
                    }else {
                        ans=Math.max(ans,startD-i+2);
                    }
                    startD=i;
                }
            }
            System.out.println("Case #"+t+": "+ans);
        }
    }
}
