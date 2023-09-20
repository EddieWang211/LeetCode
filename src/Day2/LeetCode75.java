package Day2;

/*
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题
 */
/*
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class LeetCode75 {
	// public void sortColors(int[] nums) {
	// int n = nums.length;
	// int number1 = 0;
	// for(int i = 0;i<n;i++){
	// if(nums[i]!=2){
	// nums[number1]=nums[i];
	// number1++;
	// }
	// }
	// for(int j = number1;j<n;j++){
	// nums[j]=2;
	// }
	// int number2 = 0;
	// for(int i = 0;i<number1;i++){
	// if(nums[i]!=1){
	// nums[number2]=nums[i];
	// number2++;
	// }
	// }
	// for(int j = number2;j<number1;j++){
	// nums[j]=1;
	// }
	// }

	public void sortColors(int[] nums) {
		int left = 0;
		int index = 0;
		int right = nums.length - 1;
		while (index <= right) {
			int temp = nums[index];
			if (temp == 0) {
				swap(nums, left, index);
				left++;
				index++;
			} else if (temp == 2) {
				swap(nums, right, index);
				right--;
			} else {
				index++;
			}
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
