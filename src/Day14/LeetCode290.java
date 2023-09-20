package Day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: LeetCode290
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-18 - 0:29
 * @Version: v1.0
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
    String[] str = s.split(" ");
    if(str.length!=pattern.length()){
        return false;
    }
        Map<Character,String>map1 = new HashMap<>();
        Map<String,Character>map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = str[i];
            if(map1.containsKey(c)&&map1.get(c).equals(word) == false){
                return false;
            }
            if (map2.containsKey(word)&&map2.get(word)!=c){
                return false;
            }
            if(!map1.containsKey(c)){
                map1.put(c,word);
            }
            if (!map2.containsKey(word)){
                map2.put(word,c);
            }
        }
        return true;
    }
}
