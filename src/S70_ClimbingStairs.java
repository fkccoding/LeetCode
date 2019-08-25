import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: www.chuckfang.top
 * @Date: 2019/3/26 20:02
 */
public class S70_ClimbingStairs {
    public static void main(String[] args) throws IOException {
        long l = System.nanoTime();
        System.out.println(climbStairs(20));
        System.out.println(System.nanoTime() - l);

        long l1 = System.nanoTime();
        System.out.println(climbStairs1(20));
        System.out.println(System.nanoTime() - l1);

        long l2 = System.nanoTime();
        System.out.println(climbStairs2(20));
        System.out.println(System.nanoTime() - l2);
    }

    public static int climbStairs(int n) {
        if (n<= 2) {
            return n;
        } else return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int sum = 0;
        while (n-- > 2) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    // 使用了斐波那契公式（比内公式）的奇技淫巧
    public static int climbStairs2(int n) {
        double d = Math.sqrt(5);
        n = n + 1;
        return (int) ((Math.pow((1+d)/2,n) - Math.pow((1-d)/2,n)) / d + 0.5);
    }

}
