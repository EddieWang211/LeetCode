package Day12;

/**
 * ClassName: Offer66
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-15 - 18:02
 * @Version: v1.0
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */

public class Offer66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int left []= new int[n];
        int right[] = new int[n];
        left[0]=1;
        for (int i = 1; i <n; i++) {
            left[i]=left[i-1]*a[i-1];
        }
        right[n-1]=1;
        for (int i = n-2; i >=0 ; i--) {
            right[i] = right[i+1]*a[i+1];
        }
        int answer [] = new int [n];
        for (int i = 0; i < n; i++) {
            answer[i] = right[i]*left[i];
        }
        return answer;
    }
}
