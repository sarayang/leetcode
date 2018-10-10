package Bloomberg;

/**
 * Created by YANGSONG on 2018-10-10.
 */

import java.util.HashMap;

/**
 * follow up question: what cache strategy you know
 *
 * cited "秒掉之后问我还知道哪些cache protocol，聊了聊FIFO, LFU。
 * 然后问我如何修改上面写的LRU变成一个LFU，虽然对着问题灰常不开心，还是说了说LFU的设计方法。"
 *
 * Leetcode 460. LFU Cache / O(1) :
 * kick off the least frequency item if no more capacity; for several items with same
 * least frequency, use LRU rule (kick off the oldest one)
 */
class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
        this.prev = null;
        this.next = null;
    }
}
public class LRU {
    final int cap;
    HashMap<Integer, Node> map = new HashMap<>();
    final Node head = new Node(-1, -1);
    final Node tail = new Node(-1, -1);
    public LRU(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        moveToTail(node);
        return map.get(key).val;

    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() == cap) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node newOne = new Node(key, value);
        map.put(key, newOne);
        moveToTail(newOne);

    }

    private void moveToTail(Node cur) {
        cur.prev = tail.prev;
        cur.prev.next = cur;
        cur.next = tail;
        tail.prev = cur;

    }
}
