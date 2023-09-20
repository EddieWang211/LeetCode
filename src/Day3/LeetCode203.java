package Day3;
/*给你一个链表的头节点 head 和一个整数 val ，
 *请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
    	if(head == null){
    		return null;
    	}
    	ListNode fakehead = new ListNode(0);//虚假头节点
    	fakehead.next =head;
    	ListNode point = fakehead;
    	while(point.next!=null){
    		if(point.next.val == val){
    			point.next = point.next.next;
    		}else{
    			point = point.next;
    		}
    	}
    	return fakehead.next;
    }
}
