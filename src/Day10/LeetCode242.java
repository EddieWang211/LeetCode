package Day10;

/**
 * ClassName: LeetCode242
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 17:57
 * @Version: v1.0
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        //仅包含小写字母，构造一个26位的数组
        int nums [] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            nums[num]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int num = t.charAt(i) - 'a';
            nums[num]--;
            if (nums[num]<0){
                return false;
            }
        }
        return true;
    }
}
