import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author https://www.chuckfang.top
 * @date Created on 2019-08-19 20:36
 */
public class S20_ValidParentheses {
    public static void main(String[] args) {
        String s = "{[}]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        List list = new ArrayList();
        for (char aChar : chars) {
            // 相当于进栈
            list.add(aChar);
            // 根据list的情况来做判断
            // list的长度如果小于1，肯定是不能出栈的，所以不用考虑小于1的情况
            if (list.size() > 1) {
                char c1 = (char) list.get(list.size() - 2);
                char c2 = (char) list.get(list.size() - 1);
                boolean valid = (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
                if (valid) {
                    // 相当于出栈
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                }
            }
        }
        if (list.size() != 0) {
            System.out.println(list.size());
            System.out.print(list);
            return false;
        }
        return true;
    }

    /*private static boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        List list = new ArrayList();
        Stack<Character> stack = new Stack<Character>();
        for (char aChar : chars) {
            stack.push(aChar);
            if (stack.capacity() > 1) {
                char c1 = (char) stack.;
                char c2 = (char) list.get(list.size() - 1);
                boolean valid = (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
                if (valid) {
                    // 相当于出栈
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                }
            }
        }
        if (list.size() != 0) {
            System.out.println(list.size());
            System.out.print(list);
            return false;
        }
        return true;
    }*/
}
