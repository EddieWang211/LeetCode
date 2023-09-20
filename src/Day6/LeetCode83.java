package Day6;
/*给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3] 
 * */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode point = head;
    	while(point != null && point.next!=null){
    		if(point.next.val==point.val){
    			point.next=point.next.next;
    		}else{
    			point = point.next;
    		}
    	}
    	return head;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }