import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author https://www.chuckfang.top
 * @date Created on 2019/8/30 22:34
 */
public class S219_ContainsDuplicateII {
    public static void main(String[] args) {

        int[] nmus = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nmus,2));
    }
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Integer put = map.put(nums[i], i);
            if (null != put){
                if (i - put <= k){
                    return true;
                }
            }
        }
        return false;
    }

    // 官方解答
    static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}