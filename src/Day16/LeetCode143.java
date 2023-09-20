package Day16;

/**
 * ClassName: LeetCode143
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-19 - 20:14
 * @Version: v1.0
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode143 {
    public void reorderList(ListNode head) {
    ListNode mid = middleNode(head);
    ListNode lefthead = head;
    ListNode righthead = mid.next;
    mid.next = null;
    righthead = reverseList(righthead);
    while (righthead!=null&&lefthead!=null){
        ListNode rightheadnext = righthead.next;
        ListNode leftheadnext = lefthead.next;
        lefthead.next = righthead;
        lefthead = leftheadnext;
        righthead.next = lefthead;
        righthead = rightheadnext;
    }
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null)  return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
