import java.util.Arrays;

/**
 * 字母异位词
 * @author https://www.chuckfang.top
 * @date Created on 2019/9/16 08:47
 */
public class S242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        char[] counter = new char[128];

        for (int i = 0; i < ss.length; i++) {
            counter[ss[i]]++;
            counter[ts[i]]--;
        }
        for (char c : counter) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    // 更简洁，但是时间增多，
    // 因为每次调用CharAt时间会比直接数组下标拿费时间
    static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int c : counter) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    // 官方：排序
    // 给两个字符串排序，比较排序后的字符串是否相等
    static boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
