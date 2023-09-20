package Day10;

/**
 * ClassName: LeetCode383
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 17:58
 * @Version: v1.0
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        String s = magazine;
        String t = ransomNote;

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
