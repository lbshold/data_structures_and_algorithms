package top.lconcise.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author: liusj
 * @date: 2022/6/14
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode listNode01  = new ListNode(1);
        listNode01.next = new ListNode(2);
        listNode01.next.next = new ListNode(3);

        reversePrint(listNode01);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int[] reversePrint(ListNode head) {
        // 遍历链表
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 反转遍历List
        int[] array = new int[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
            array[j] = list.get(i);
        }

        return array;
    }


    public int[] reversePrint02(ListNode head){
        // 反转
        ListNode reverseHead = reverse(head);
        List<Integer> list = new ArrayList<>();
        while (reverseHead!=null){
            list.add(reverseHead.val);
            reverseHead = reverseHead.next;
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * 迭代反转
     */
    public ListNode reverse(ListNode head){
        ListNode pre = null;

        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
