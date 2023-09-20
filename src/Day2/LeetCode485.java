package Day2;

/*给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。*/
/* 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.*/

public class LeetCode485 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int answer = 0;
		int n = nums.length;
		int record = 0;
		for(int i = 0;i<n;i++){
			if(nums[i]==1){
				record++;
			}
			if(nums[i]==0||i==n-1){
				if(record>answer){
					answer = record;
				}
				record = 0;
			}
		}
		return answer;
	}
}
