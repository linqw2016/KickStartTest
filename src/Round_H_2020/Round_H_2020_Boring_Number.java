package Round_H_2020;

import java.util.*;

public class Round_H_2020_Boring_Number {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int i=1;i<=T;i++){
            //solution
            long L=scanner.nextLong();
            long R=scanner.nextLong();
            long numsL = dealWithNum(L-1);
            long numsR = dealWithNum(R);
//            System.out.println("L:"+numsL+" R:"+numsR);
            System.out.println("Case #"+i+": "+(numsR-numsL));
            System.out.println("Case #"+i+": "+(getNums0(R)-getNums0(L-1)));
        }
    }
    //Function 1：time:O（n*log（N));space:O(1);
    private static long getNums0(long num){
        long ans=0;
//        System.out.print(num+":");
        for (long i = 0; i <=num; i++) {
            int digit=1;
            long tmp=i;
            while(tmp/10!=0){
                digit++;
                tmp/=10;
            }
            tmp=i;
            boolean flag=true;
            for (int j = 0; j < digit; j++) {
                int d=(int)tmp%10;
                if(d%2!=(digit-j)%2){
                    flag=false;
                    break;
                }
                tmp/=10;
            }
            if(flag){
//                System.out.print(i+" ");
                ans++;
            }
        }
        System.out.println();
        return ans;
    }
    //Function 2:time:O(log(N));space:O(log(N));
    private static long dealWithNum(long a){
        if(a==0)return 0;
        int digit=0;
        long tmp=a;
        List<Integer> list=new ArrayList<>();
        while(tmp>0){
            digit++;
            list.add((int)tmp%10);
            tmp/=10;
        }
        list.add(-1);
        Collections.reverse(list);
        int[] digits= list.stream().mapToInt(Integer::valueOf).toArray();
        return (long) (5*(Math.pow(5,digit-1)-1)/4+getNums(digits,1,digit));
    }
    private static long getNums(int[] digits,int curDigit,int totalDigit) {
        if(curDigit-1>0&&(curDigit-1)%2!=digits[curDigit-1]%2)return 0;
        if(curDigit==totalDigit){
            if(curDigit%2==0)return digits[curDigit]/2+1;
            else return (digits[curDigit]+1)/2;
        }
        long ans=0;
        //奇数位
        if(curDigit%2==1){
            ans+=digits[curDigit]/2*Math.pow(5,totalDigit-curDigit);
        }else{
            ans+=(digits[curDigit]+1)/2*Math.pow(5,totalDigit-curDigit);
        }
        return ans+getNums(digits,curDigit+1,totalDigit);
    }
}
