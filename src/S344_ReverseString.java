import java.util.Arrays;

/**
 * @author https://www.chuckfang.top
 * @date Created on 2019/8/24 13:09
 */
public class S344_ReverseString {
    public static void main(String[] args) {
        char[] s ={'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        char temp;
        int length = s.length;
        for (int i = 0; i < length/2; i++) {
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
}
