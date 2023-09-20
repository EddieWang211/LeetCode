package Day10;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode387
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 17:59
 * @Version: v1.0
 *     给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *     示例 1：
 *
 *     输入: s = "leetcode"
 *     输出: 0
 *     示例 2:
 *
 *     输入: s = "loveleetcode"
 *     输出: 2
 *     示例 3:
 *
 *     输入: s = "aabb"
 *     输出: -1
 *     提示:
 *
 *             1 <= s.length <= 105
 *     s 只包含小写字母
 */
public class LeetCode387 {
    public int firstUniqChar(String s){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

}
