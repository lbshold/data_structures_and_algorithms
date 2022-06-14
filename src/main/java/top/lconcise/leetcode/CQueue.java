package top.lconcise.leetcode;

import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author: liusj
 * @date: 2022/6/13
 */
public class CQueue {

    private LinkedList<Integer> aList;
    private LinkedList<Integer> bList;

    public CQueue() {
        aList = new LinkedList();
        bList = new LinkedList();
    }

    public void appendTail(int value) {
        aList.addLast(value);
    }

    public int deleteHead() {
        if (!bList.isEmpty()) {
            return bList.removeLast();
        }
        if (aList.isEmpty()) return -1;

        while (!aList.isEmpty()) {
            bList.addLast(aList.removeLast());
        }
        return bList.removeLast();
    }
}
