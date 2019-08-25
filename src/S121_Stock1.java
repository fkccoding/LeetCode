/**
 * @Author: www.chuckfang.top
 * @Date: 2019/3/22 10:44
 */
public class S121_Stock1 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 4};
        long l = System.nanoTime();
        System.out.println("最大利润为：" + maxProfit(arr) + "元");
        System.out.println(System.nanoTime() - l);

        long l1 = System.nanoTime();
        System.out.println("最大利润为：" + maxProfit1(arr) + "元");
        System.out.println(System.nanoTime() - l1);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > profit) {
                    profit = temp;
                }
            }
        }
        return profit;
    }

    static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
