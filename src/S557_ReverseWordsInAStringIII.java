/**
 * @author https://www.chuckfang.top
 * @date Created on 2019/8/24 13:55
 */
public class S557_ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int length = s1.length;
        for (int i = 0; i < length; i++) {
            char[] c = s1[i].toCharArray();
            reverseString(c);
            stringBuilder.append(String.valueOf(c)).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    static void reverseString(char[] s) {
        char temp;
        int length = s.length;
        for (int i = 0; i < length/2; i++) {
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
}
