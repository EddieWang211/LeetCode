package Day9;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode205
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-13 - 14:04
 * @Version: v1.0
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 */
public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            if (map1.containsKey(char1)&&map1.get(char1)!=char2){
                return false;
            }
            if (map2.containsKey(char2)&&map2.get(char2)!=char1){
                return false;
            }
            if(!map1.containsKey(s)){
                map1.put(char1,char2);
            }
            if(!map2.containsKey(t)){
                map2.put(char2,char1);
            }
        }
        return true;
    }
}
