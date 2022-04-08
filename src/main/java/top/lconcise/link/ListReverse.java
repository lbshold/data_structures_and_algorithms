package top.lconcise.link;

/**
 * 单向列表反正.
 *
 * @author: liusj
 * @date: 2022/4/8
 */
public class ListReverse {

    /**
     * 递归.
     * <p>
     * 1. 结束条件 head.next == null;
     * 2. 递推公式 head.next.next = head; head.next = null;
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n), 其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     *
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
     * 迭代.
     * <p>
     * 时间复杂度：0(n),其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     *
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
}
