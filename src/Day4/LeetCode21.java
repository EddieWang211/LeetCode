package Day4;

/*将两个升序链表合并为一个新的 升序 链表并返回。
 *新链表是通过拼接给定的两个链表的所有节点组成的。
 *输入：l1 = [1,2,4], l2 = [1,3,4]输出：[1,1,2,3,4,4]
 * */
public class LeetCode21 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode fakenode = new ListNode(-1);
		ListNode point1 = list1;
		ListNode point2 = list2;
		ListNode point = fakenode;
		while(point1!=null&&point2!=null){
				if(point1.val>point2.val){
					point.next=point2;
					point2=point2.next;
				}else{
					point.next=point1;
					point1=point1.next;
				}
				point = point.next;
			}
		if(point1 != null){
			point.next = point1;
		} 
		if(point2 != null){
			point.next = point2;
		}
			
		return fakenode.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}