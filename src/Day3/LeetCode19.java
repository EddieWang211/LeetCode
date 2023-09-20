package Day3;

/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 *输入：head = [1,2,3,4,5], n = 2
 *输出：[1,2,3,5]
 * */
public class LeetCode19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null){
    		return null;
    	}
    	ListNode fakehead = new ListNode(-1);//虚假头节点
    	fakehead.next=head;
    	ListNode pointA = head;//指向头节点的指针A
    	ListNode pointB = fakehead;//指向虚假头节点的指针B
    	for(int i = 0;i <n ;i++){//先把A向后移动n位
    		pointA = pointA.next;
    	}
    	while(pointA != null){//同时移动两个指针,当A指向null时，B正好指向倒数第n位的前一个
    		pointB = pointB.next;
    		pointA = pointA.next;
    	}
    	pointB.next=pointB.next.next;//删除结点
    	return fakehead.next;
    }
}
