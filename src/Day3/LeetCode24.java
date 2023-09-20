package Day3;

/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 *你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * */
public class LeetCode24 {
	public ListNode swapPairs(ListNode head) {
    	if(head == null||head.next == null){
    		return head;
    	}
    	ListNode subhead = swapPairs(head.next.next);
    	ListNode nodenext = head.next;//相当于已经处理好的 head.next.next后全部的nodelist
    	head.next = subhead;
    	nodenext.next = head;
    	return nodenext;
    	
    }
}

