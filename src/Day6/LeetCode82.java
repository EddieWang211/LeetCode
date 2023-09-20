package Day6;
/*给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，
 *只留下不同的数字 。返回 已排序的链表 
 *输入：head = [1,2,3,3,4,4,5]
 *输出：[1,2,5]
 * */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode fakenode = new ListNode(-1);
    	fakenode.next = head;
    	ListNode point = fakenode;			//指针指向虚假头节点
    	while(point.next!=null&&point.next.next!=null){//当指针的下一个以及下下一个结点存在时
    		if(point.next.val==point.next.next.val){//如果下个值等于下下一个值
    			int value = point.next.val;//value记录下这个值
    			while(point.next!=null&&point.next.val==value){
    				//一直跳过结点，直到指针下一个值和value不一样
    				point.next=point.next.next;
    			}
    		}else{
    			point = point.next;
    		}
    	}
    	return fakenode.next;
    }
}
