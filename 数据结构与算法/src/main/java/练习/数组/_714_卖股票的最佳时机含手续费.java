package 练习.数组;

/**
 * ClassName:_714_卖股票的最佳时机含手续费
 * Package:练习.数组
 * Description:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @date:2020-01-19 08:46
 * @author:892698613@qq.com
 */
public class _714_卖股票的最佳时机含手续费 {


    public int maxProfit(int[] prices, int fee) {
        if (prices==null||prices.length==0)return 0;

        int in=prices[0];
        int count=0;

        for (int i = 1; i < prices.length; i++) {
            if (in==-1){
                in=prices[i];
                continue;
            }
            if (in+fee<prices[i]){
                count+=(prices[i]-in-fee);
                in=-1;
            }
        }
        return count;
    }
    //1 3 2 8 4 9
}
