package Day8;

/**
 * ClassName: LeetCode641
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-08 - 18:48
 * @Version: v1.0
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 */
public class LeetCode641 {
}
class MyCircularDeque {
    int cap;
    int front;
    int last;
    int array [];

    public MyCircularDeque(int k) {
        cap = k+1;
        front = 0;
        last = 0;
        array = new int[cap];
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else{
            front = (front - 1 +cap)%cap;
            array[front] = value;
            return true;
        }

    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else{
            array[last] = value;
            last = (last + 1 )%cap;
            return true;
        }

    }

    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }else {
            front = (front+1)%cap;
            return true;
        }
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else {
            last = (last - 1+cap)%cap;
            return true;
        }
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }else {
            return array[front];
        }
    }

    public int getRear() {
        if(isEmpty()){
            return  -1;
        }else {
            return array[(last - 1 + cap) % cap];
        }
    }

    public boolean isEmpty() {
        if (last == front){
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull() {
        if((last + 1 -front)%cap == 0){
            return true;
        }else {
            return false;
        }
    }
}
