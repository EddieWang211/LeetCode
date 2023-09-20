package Day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: LeetCode49
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-16 - 22:51
 * @Version: v1.0
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        // 互为字母异位词的两个字符串包含的字母相同
        // 因此两个字符串中的相同字母出现的次数一定是相同的
        // 可以将每个字母出现的次数使用字符串表示，作为哈希表的键
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {

            // 由于都是小写字母，因此直接用 26 个长度的数组代替原来的 HashMap ，比直接使用 HashMap 更优秀
            // counts 代表每个小写字母出现的频次
            int[] counts = new int[26];

            // 利用 for 循环，统计 str 当中每个字母出现的频次
            for (int i = 0; i < str.length(); i++) {

                // 对于数组类型，其下标为 int 类型
                // 可以直接使用 char 类型变量，默认强制转换，存储的就是字母对应的 ASCII 码
                // 比如 str.charAt(i) 是 b 字符，那么 b - a = 1，即 counts[1] 表示记录 b 出现的频次
                counts[str.charAt(i) - 'a']++;

            }

            // String 类是不可变类，即一旦一个 String 对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。
            // Java 提供了两个可变字符串类 StringBuffer 和 StringBuilder，中文翻译为“字符串缓冲区”
            // StringBuffer：线程安全
            // StringBuilder：线程不安全
            StringBuffer sb = new StringBuffer();

            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            for (int i = 0; i < 26; i++) {

                if (counts[i] != 0) {

                    // 先记录字母，比如记录了字母 k
                    sb.append((char) ('a' + i));
                    // 再记录次数，比如记录了次数 9
                    sb.append(counts[i]);
                }
            }

            // 转换为字符串的形式，比如为 a1k9x7
            String key = sb.toString();

            // 在哈希表 map 当中找出这个 key 对应的字符串 str 来
            // 1、如果有这个 key，那么这个 key 对应的 数组 会新增一个 str 进去
            // 2、如果没有这个 key，那么会初始化一个数组，用来新增这个 str
            List<String> list = map.getOrDefault(key, new ArrayList<String>());

            // str 加入到 list 当中
            list.add(str);

            // map 进行更新
            map.put(key, list);

        }

        // 返回结果
        return new ArrayList<List<String>>(map.values());
}
}
