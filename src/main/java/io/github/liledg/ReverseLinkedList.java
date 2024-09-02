package io.github.liledg;

public class ReverseLinkedList {

  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(0);
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    listNode.next = listNode1;
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    System.out.println(reverseList(listNode));
  }

  public static class ListNode {
    int      val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }

  }


}
