package Day11;

/**
 * ClassName: LeetCode303
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-14 - 10:53
 * @Version: v1.0
 */
public class LeetCode303 {
}
class NumArray {
    int newnums[];
    public NumArray(int[] nums) {
        int n = nums.length;
        newnums = new int[n+1];
        newnums[0]=0;
        for (int i = 0; i < n; i++) {
            newnums[i+1] = newnums[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return newnums[right+1]- newnums[left];
    }
}
