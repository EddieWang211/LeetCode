package Day4;
/*给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点
 * */
public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast!=null&&fast.next!=null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
}
