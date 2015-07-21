package leetcode;

import org.junit.Test;

public class LinkedListCRUD {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isEmpty(ListNode a) {
		return a.next == null;
	}

	public static void toString(ListNode a) {
		while (a.next != null) {
			System.out.print(a.val + " ");
			a = a.next;
		}
		System.out.println(a.val);
	}

	public static void addNode(ListNode a, int val) {
		ListNode b = new ListNode(val);
		while (a.next != null) {
			a = a.next;
		}
		a.next = b;
	}

	public void removeNode(ListNode a, int val) {
		if (a.val == val) {
			// ListNode b = a.next;
			// a.val = b.val;
			// a.next = b.next;
			a.val = a.next.val;
			a.next = a.next.next;
		} else {
			while (a.next.val != val) {
				a = a.next;
			}
			a.next = a.next.next;
		}
	}

	public void removeNthNode(ListNode a, int n) {
		if (n == 1) {
			// ListNode b = a.next;
			// a.val = b.val;
			// a.next = b.next;
			a.val = a.next.val;
			a.next = a.next.next;
		} else {
			int i = 1;
			while (a.next != null && i != n - 1) {
				i++;
				a = a.next;
			}
			a.next = a.next.next;
		}
	}

	public int searchNode(ListNode a, int val) {
		if (a.val == val)
			return 1;
		int i = 1;
		while (a.val != val && a.next != null) {
			a = a.next;
			i++;
		}
		if (a.val == val)
			return i;
		return -1;
	}

	public int searchNthNode(ListNode a, int n) {
		if (n == 1)
			return a.val;
		int i = 1;
		while (i != n && a.next != null) {
			a = a.next;
			i++;
		}
		if (n > i + 1)
			return -1;
		return a.val;

	}

	public ListNode insertFrontNode(ListNode a, int val) {
		ListNode b = new ListNode(val);
		b.next = a;
		return b;
	}

	public void insertBackNode(ListNode a, int val) {
		addNode(a, val);
	}

	public void insertNthNode(ListNode a, int n, int val) {

		if (n == 1) {// !!!!!!!!!!!!!!!!!!
			a = insertFrontNode(a, val);
		} else {
			ListNode b = new ListNode(val);
			int i = 1;
			while (a.next != null && i != n - 1) {
				i++;
				a = a.next;
			}
			b.next = a.next;
			a.next = b;
		}
	}

	public void updateNthNode(ListNode a, int n, int val) {
		if (n == 1) {
			a.val = val;
		} else {
			int i = 1;
			while (a.next != null & i != n - 1) {
				i++;
				a = a.next;
			}
			a.next.val = val;
		}
	}

	@Test
	public void testLinkedList() {
		ListNode a = new ListNode(4);
		// System.out.println(isEmpty(a));
		addNode(a, 3);
		addNode(a, 2);
		addNode(a, 1);
		// System.out.println(isEmpty(a));
		toString(a);
		// removeNode(a, 1);
		// toString(a);
		// removeNthNode(a, 1);
		// toString(a);
		// insertBackNode(a, 7);
		// toString(a);
		insertNthNode(a, 1, 9);// !!!!!!!!!!
		toString(a);
		 insertNthNode(a, 3, 0);
		 toString(a);
		// a = insertFrontNode(a, 8);
		// toString(a);
		// updateNthNode(a, 3, 8);
		// toString(a);
		// updateNthNode(a, 1, 0);
		// toString(a);
		// System.out.println(searchNode(a, 1));
		// System.out.println(searchNode(a, 5));
		// System.out.println(searchNthNode(a, 1));
		// System.out.println(searchNthNode(a, 4));
	}

}
