import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 * @author https://www.chuckfang.top
 * @date Created on 2019/8/26 22:35
 */
public class S409_LongestPalindrome {
    public static void main(String[] args) {
        int i = longestPalindrome("abccccddafbbgggkkk");
        System.out.println(i);
    }

    static int longestPalindrome(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char value : c) {
            /*if (map.get(value) == null) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }*/
            map.merge(value, 1, Integer::sum);
        }


        int n = 0;
        for (Character character : map.keySet()) {
            Integer integer = map.get(character);
            // 不管是奇数还是偶数，都加上这个数的所包含的最大偶数
            n += integer/2 * 2;
            // 如果这个数是奇数，那就还可以把剩下的一个当做回文字符串的中心，
            // 并且只能又一个中心，即当回文字符串的个数为奇数时，就不能再往字符串里面加字符了
            if (integer%2 == 1 && n%2 == 0){
                n++;
            }
        }
        return n;
    }

    static int longestPalindrome1(String s){
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
