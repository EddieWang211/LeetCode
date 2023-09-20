package Day11;

/**
 * ClassName: LeetCode1588
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-14 - 11:11
 * @Version: v1.0
 *给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 */
public class LeetCode1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int answer = 0;
        int prearr [] = new int[arr.length+1];
        prearr[0] = 0;
        //构造前缀和数组
        for (int i = 0; i < arr.length; i++) {
            prearr[i+1]=prearr[i]+arr[i];
        }
        //从每一位元素开始遍历
        for (int i = 0;i<arr.length;i++){
            //遍历奇数步长
            for (int j = 1; j <arr.length; j+=2) {
                //如果步长加起始元素没有超出范围
                if(i+j-1<arr.length){
                    answer +=prearr[i+j]-prearr[i];
                }
            }
        }
        return answer;
    }
}
