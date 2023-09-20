package Day6;

/*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 *并且每个节点只能存储 一位 数字。
 *请你将两个数相加，并以相同形式返回一个表示和的链表。
 *你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *输出：[8,9,9,9,0,0,0,1]
 * */
public class LeetCode2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode point1 = l1;
		ListNode point2 = l2;
		int carrybit = 0;
		ListNode fakenode = new ListNode();
		ListNode point = fakenode;
		while (point1 != null || point2 != null) {
			ListNode newnode = new ListNode();
			point.next = newnode;
			if (point1 == null && point2 != null) {
				newnode.val = (point2.val + carrybit) % 10;
				carrybit = (carrybit + point2.val) / 10;
				point = newnode;
				point2 = point2.next;
			} else if (point1 != null && point2 == null) {
				newnode.val = (point1.val + carrybit) % 10;
				carrybit = (carrybit + point1.val) / 10;
				point = newnode;
				point1 = point1.next;
			} else {
				newnode.val = (point2.val + carrybit + point1.val) % 10;
				carrybit = (carrybit + point2.val+point1.val) / 10;
				point = newnode;
				point2 = point2.next;
				point1 = point1.next;
			}
		}
		if(carrybit==1){
			ListNode lastnode = new ListNode(1);
			point.next = lastnode;
		}
		return fakenode.next;
	}
}
