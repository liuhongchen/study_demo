import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName:Main03
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2020-01-03 15:41
 * @author:892698613@qq.com
 */
public class Main03 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String numsStr = sc.nextLine();
        String[] nums = numsStr.split(" ");
        int n=Integer.parseInt(nums[0]);
        if (n<2){
            System.out.println("error");
            return;
        }
        int k=Integer.parseInt(nums[1]);

        int[] lows=new int[n];
        int[] highs=new int[n];
        for(int i=0;i<n;i++){
            String temp=sc.nextLine();
            String[] temps=temp.split(" ");
            lows[i]=Integer.parseInt(temps[0]);
            highs[i]=Integer.parseInt(temps[1]);
        }
        Arrays.sort(lows);
        Arrays.sort(highs);
        System.out.println(lows[1]+" "+highs[highs.length-2]);
    }
}
