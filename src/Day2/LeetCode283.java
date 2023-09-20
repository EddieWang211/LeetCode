package Day2;
/*
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
/*
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class LeetCode283 {
	 public void moveZeroes(int[] nums) {
		int n = nums.length;
		int j = 0;
		for(int i=0;i<n;i++){
			if(nums[i]!=0){
				nums[j]=nums[i];
				j++;
			}
		}
		for(;j<n;j++){
			nums[j]=0;
		}
	    }
}
