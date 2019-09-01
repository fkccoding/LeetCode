import java.util.concurrent.ConcurrentHashMap;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * @author https://www.chuckfang.top
 * @date Created on 2019/8/26 09:15
 */
public class S204_CountPrimes {
    public static void main(String[] args) {
        int i = 100099;
        int n = countPrimes1(i);
        System.out.println("小于" + i + "的质数个数为" + n);
    }

    // 超时
    static int countPrimes(int n) {
        // 两个终止条件
        if (n <= 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        }

        for (int i = 2; i < n - 1; i++) {
            // 判断n-1是否是质数，如果是的话直接返回小于n-1的质数的个数
            if ((n-1)%i == 0){
                return countPrimes(n-1);
            }
        }
        return countPrimes(n -1) + 1;
    }

    // 厄拉多塞筛法
    static int countPrimes1(int n) {
        int[] primes = new int[n];
        for (int i = 0; i < n; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i] == 1){
                for (int j = 2; j * i < n; j++) {
                    primes[j*i] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1){
                count++;
            }
        }
        return count;
    }
}
