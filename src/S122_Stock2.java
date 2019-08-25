import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: www.chuckfang.top
 * @Date: 2019/4/9 7:18
 */
public class S122_Stock2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};    //  7,1,5,3,6,4    1,2,3,4,5     7,6,4,3,1   [1,9,6,9,1,7,1,1,5,9,9,9]
        System.out.println("最大利润为：" + maxProfit(arr) + "元");
    }

    static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        ArrayList<Integer> maxprofit = new ArrayList<>();
        int minprice = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                if (prices[i] < minprice)   //求出极小值
                    minprice = prices[i];

                else if (prices[i] > prices[i + 1]) {  //当知道第二天股票要下降时，在当天卖出，也就是获利
                    maxprofit.add(prices[i] - minprice);
                    minprice = Integer.MAX_VALUE;
                }
            }

            else if (i == len-1){
                if (prices[i - 1] <= prices[i]) {   // 注意这里还需要判断等于的情况，不然碰到连续几个相同的数字，将不会进入这个条件
                    maxprofit.add(prices[i] - minprice);
                }
            }
        }
        int sum = 0;
        for (Integer integer : maxprofit) {
            System.out.println(integer);
            sum += integer;
        }
        return sum;
    }

    public static int maxProfit1(int[] prices){
        int len = prices.length;
        int profit = 0;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i + 1] - prices[i]> 0) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
