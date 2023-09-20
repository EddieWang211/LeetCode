package Day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: LeetCode146
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-09-17 - 11:33
 * @Version: v1.0
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */
public class LeetCode146 {
    //难
}

// 使用双向链表来实现
class ALNode{

    // 节点值
    public int val;
    // 当前节点的下一个节点
    public ALNode nextNode;
    // 当前节点的上一个节点
    public ALNode preNode;
    // 构造
    ALNode(int val){
        this.val = val;
    }
}

class LRUCache {

    // 利用哈希表来存储元素
    public Map<Integer, Object[]> maps;
    // 为了方便使用，默认双向链表有两个节点
    // 这样，哪怕只有一个节点时，依旧有上节点、下节点
    // 头节点
    public ALNode head;
    // 头节点
    public ALNode tail;
    // 实际容量，意味着最多存储这么多节点
    private int capacity;
    // 长度
    public int length;

    public LRUCache(int capacity) {
        // 初始化 head
        head = new ALNode(-1);
        // 初始化 tail
        tail = new ALNode(-1);
        // 初始化 maps
        maps = new HashMap<>();
        // 初始化 capacity
        this.capacity = capacity;
        // 连接 head 和 tail
        head.nextNode = tail;
        tail.preNode = head;
    }

    public int get(int key) {

        // 判断哈希表中是否存储了 key
        // 如果存在，不仅需要返回 key 的 value
        // 同样，需要操作双向链表，使得
        // 1、当前这个 key 对应的节点放到链表的最前面，即 head 的下一个节点
        // 2、其余节点维持原来的顺序
        if(maps.containsKey(key)){

            // 获取节点值
            ALNode cur = (ALNode) maps.get(key)[0];

            // 获取当前节点的上一个节点
            ALNode preNode = cur.preNode;

            // 获取当前节点的下一个节点
            ALNode nextNode = cur.nextNode;

            // 让这两个上下节点连接起来，cur 也就消失了
            preNode.nextNode = nextNode;

            nextNode.preNode = preNode;

            // 把 cur 挪到 head 的 nextNode 位置
            // 1、先获取原先 head 的 nextNode 节点
            ALNode tmp = head.nextNode;

            // 2、修改 head 的 nextNode 节点为 cur
            head.nextNode = cur;

            // 3、cur 重新连接上 tmp
            cur.nextNode = tmp;

            // 4、tmp 也连接上 cur
            tmp.preNode = cur;

            // 5、cur 上一个节点指向 head
            cur.preNode = head;

            // 最后才返回 map 的值
            return (Integer) maps.get(key)[1];
        }

        // 否则返回 -1
        return -1;
    }

    public void put(int key, int value) {

        // 判断哈希表中是否存储了 key
        // 如果存在，不仅需要返回 key 的 value
        // 同样，需要操作双向链表，使得
        // 1、key 对应的节点值 value 需要修改，采取节点替换的操作
        // 2、这个节点需要挪到最前面
        if(maps.containsKey(key)){

            // 获取节点值
            ALNode cur = (ALNode) maps.get(key)[0];

            // 获取当前节点的上一个节点
            ALNode preNode = cur.preNode;

            // 获取当前节点的下一个节点
            ALNode nextNode = cur.nextNode;

            // 让这两个上下节点连接起来，cur 也就消失了
            preNode.nextNode = nextNode;

            nextNode.preNode = preNode;

            // 把 cur 挪到 head 的 nextNode 位置
            // 1、先获取原先 head 的 nextNode 节点
            ALNode tmp = head.nextNode;

            // 2、修改 head 的 nextNode 节点为 cur
            head.nextNode = cur;

            // 3、cur 重新连接上 tmp
            cur.nextNode = tmp;

            // 4、tmp 也连接上 cur
            tmp.preNode = cur;

            // 5、cur 上一个节点指向 head
            cur.preNode = head;

            // 更新节点
            maps.put(key, new Object[]{cur, value});

            return;
        }

        // 如果哈希表中不包含 key 对应的节点，那么需要判断缓存是否满了
        // 如果满了，需要把最后一个节点删除掉
        if(length == capacity){

            // 即将被删除的节点
            ALNode delNode = tail.preNode;

            // 即将被删除的节点的上一个节点
            ALNode delPreNode = tail.preNode.preNode;

            // delPreNode 跳过了 delNode
            delPreNode.nextNode = tail;

            tail.preNode = delPreNode;

            // 哈希表移除 delNode 对应的值
            maps.remove(delNode.val);

            // 链表的长度更新一下
            length--;
        }

        // 再把 key 节点添加到最前面去
        ALNode cur = new ALNode(key);

        // 把 cur 挪到 head 的 nextNode 位置
        // 1、先获取原先 head 的 nextNode 节点
        ALNode tmp = head.nextNode;

        // 2、修改 head 的 nextNode 节点为 cur
        head.nextNode = cur;

        // 3、cur 重新连接上 tmp
        cur.nextNode = tmp;

        // 4、tmp 也连接上 cur
        tmp.preNode = cur;

        // 5、cur 上一个节点指向 head
        cur.preNode = head;

        // 更新哈希表
        maps.put(key, new Object[]{cur, value});

        // 更新 length
        length++;

        return;
    }
}
