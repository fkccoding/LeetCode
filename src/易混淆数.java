import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: www.chuckfang.top
 * @Date: 2019/4/14 16:36
 */
public class 易混淆数 {
    public static void main(String[] args) {
        System.out.println(confusingNumber(89));
    }

    static boolean confusingNumber(int N) {

        String s = String.valueOf(N);
        if (s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("7")) {
            return false;
        }

        char[] nums = s.toCharArray();
        int[] anums = new int[nums.length];
        for (int i = nums.length - 1,j = 0; i >= 0; i--, j++) {
            if ('0' == nums[i]) {
                anums[j] = 0;
            } else if ('1' == nums[i]) {
                anums[j] = 1;
            } else if ('6' == nums[i]) {
                anums[j] = 9;
            }else if ('8' == nums[i]) {
                anums[j] = 8;
            } else if ('9' == nums[i]) {
                anums[j] = 6;
            }
        }
        String s1 = Arrays.toString(anums);
        String s2 = Arrays.toString(nums);
        return !s2.equals(s1);
    }
}
