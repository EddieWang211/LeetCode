package Day3;
/*给你两个单链表的头节点 headA 和 headB ，
 *请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * */

public class LeetCode160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
        ListNode pointA = headA;//指针A用来标记遍历链表A
        ListNode pointB = headB;//指针B用来标记遍历链表B
        while(pointA!=pointB){
        	//两个指针同时为null代表不相交
        	if(pointA == null){//链表A遍历完后，指针A从链表B从头开始
        		pointA = headB;
        	}else if(pointB == null){//链表B遍历完后，指针B从链表A从头开始
        		pointB = headA;
        	}else{
        		pointA = pointA.next;
        		pointB = pointB.next;
        	}
        }
        return pointA;
    }
}
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
