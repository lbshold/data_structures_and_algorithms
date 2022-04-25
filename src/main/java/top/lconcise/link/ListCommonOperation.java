package top.lconcise.link;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 链表的常见算法.
 *
 * @author: liusj
 * @date: 2022/4/8
 */
public class ListCommonOperation {

    /**
     * 单向链表反转
     * 方式一：递归
     * <p>
     * 1. 结束条件 head.next == null;
     * 2. 递推公式 head.next.next = head; head.next = null;
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n), 其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     */
    public static ListNode reverse01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse01(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 单向链表反转
     * 方式二：迭代
     * <p>
     * 时间复杂度：0(n),其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     */
    public static ListNode reverse02(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode node = head.next;
            head.next = pre;
            pre = head;
            head = node;
        }

        return pre;
    }

    /**
     * 两个有序链表的合并.
     * <p>
     * 时间复杂度：O(n+m),其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉l1或者l2的头结点(直到至少有一个链表为空)，
     * 函数(mergeTwoList)至多只会递归调用每个节点一次。因此时间复杂度取决于合并后的链表长度，即O(n+m)
     * 空间复杂度：O(n+m),其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于
     * 递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+m 次，因此空间复杂度为O(n+m)
     *
     * @param l1
     * @param l2
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 删除链表倒数第N个节点.
     * <p>
     * 方式一：
     * 1. 获取链表长度
     * 2. 遍历链表，找到节点length-n，该节点 current.next = current.next.next;
     * <p>
     * 时间复杂度：O(L),其中L为链表长度
     * 空间复杂度：0(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = pre;

        int length = getListNodeLength(head);

        int subLength = length - n;
        while (subLength != 0) {
            current = current.next;
            --subLength;
        }

        current.next = current.next.next;
        return pre.next;
    }

    /**
     * 删除链表倒数第N个节点.
     * <p>
     * 方式二：
     * 先入栈，再出栈。
     * <p>
     * 时间复杂度：O(L)，其中L为链表长度
     * 空间复杂度：0(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndO2(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode current = pre;
        Deque<ListNode> stack = new LinkedList<>();

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (n != 0) {
            stack.pop();
            --n;
        }
        stack.peek().next = stack.peek().next.next;
        return pre.next;
    }

    public static int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
