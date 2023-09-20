package Day4;
/*有一个单链表的 head，我们想删除它其中的一个节点 node。
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * */
public class LeetCode237 {
    public void deleteNode(ListNode node) {
    /*将要删除的结点的值改成它的下一个结点的值 然后删除它下一个结点
     * */
    node.val=node.next.val;
    node.next=node.next.next;
    }
}
