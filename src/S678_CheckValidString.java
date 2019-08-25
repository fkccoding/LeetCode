import java.util.ArrayList;
import java.util.List;

/**
 * @author https://www.chuckfang.top
 * @date Created on 2019-08-20 21:43
 */
public class S678_CheckValidString {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
    }

    public static boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int star = 0;
        for (char c : chars) {
            if (c == '('){
                left++;
            }
            if (c == ')'){
                if (star > 0) {
                    star--;

                }else {
                    left--;
                }

                if (left < 0){
                    return false;
                }
            }
            if (c == '*'){
                star++;
            }
        }
        return left <= 0;
    }
}
