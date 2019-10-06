import java.util.*;

/**
 * @author https://www.chuckfang.top
 * @date Created on 2019/10/6 21:43
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 *
 * 返回所有不常用单词的列表。
 *
 * 您可以按任何顺序返回列表。
 * 示例 1：
 *
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 */
public class S884_uncommon_words_from_two_sentences {
    public static void main(String[] args) {
        String A = "this apple is sweet", B = "this apple is sour";
        String[] strings =  uncommonFromSentences(A, B);
        System.out.println(Arrays.toString(strings));

    }

    static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>(400);
        List<String> list = new ArrayList<>(400);
        for (String a : A.split(" ")) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        for (String b : B.split(" ")) {
            count.put(b, count.getOrDefault(b, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
