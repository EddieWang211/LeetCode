package Day4;


/*给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * */
public class LeetCode92 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode fakenode = new ListNode(-1);// 指向left结点
		fakenode.next = head;
		ListNode point1 = fakenode;
		ListNode point2 = head;
		for (int i = 1; i < left; i++) {
			point1 = point1.next;
			point2 = point2.next;
		}
		for(int i =0;i<right-left;i++){
			ListNode temp = point2.next;
			point2.next=point2.next.next;
			temp.next = point1.next;
			point1.next = temp;
		}
		return fakenode.next;
	}
}
