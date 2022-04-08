package top.lconcise.link;

/**
 * @author: liusj
 * @date: 2022/4/8
 */
public class Demo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addTail(2);
        head.addTail(3);
        head.addTail(4);

        head.forEach();

//        ListNode reverse01 = ListReverse.reverse01(head);
//        reverse01.forEach();
        ListNode reverse02 = ListReverse.reverse02(head);
        reverse02.forEach();
    }
}
