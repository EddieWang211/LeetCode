package Day17;

/**
 * ClassName: LeetCode605
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-20 - 9:09
 * @Version: v1.0
 */
public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length&&n>0; ) {
            if (flowerbed[1]==1){
                i+=2;
            }else if (i==flowerbed.length-1||flowerbed[i+1]==0){
                n--;
                i+=2;
            }else {
                i+=3;
            }
        }
        return n<=0;
    }
}
