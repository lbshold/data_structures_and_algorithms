package top.lconcise.link;

/**
 * 单向链表.
 *
 * @author: liusj
 * @date: 2022/4/8
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addTail(int data) {
        ListNode head = this;
        while (head.next != null) {
            head = head.next;
        }
        head.next = new ListNode(data);
    }

    public void forEach() {
        ListNode head = this;
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }
}
