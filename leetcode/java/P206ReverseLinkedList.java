package leetcode;

import org.junit.Test;

import leetcode.LinkedListCRUD.*;

public class P206ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		return head;
		//to do

	}

	@Test
	public void test() {
		ListNode a = new ListNode(4);
		LinkedListCRUD.addNode(a, 3);
		LinkedListCRUD.addNode(a, 2);
		LinkedListCRUD.addNode(a, 1);
		LinkedListCRUD.toString(reverseList(a));
	}

}
