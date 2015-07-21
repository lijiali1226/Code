package leetcode;

import org.junit.Test;


import leetcode.LinkedListCRUD.*;

public class P019RemoveNthNodeFromEndOfList {
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i=n;
		ListNode temp=head;
		while(head.next!=null){
		while(i>0){
			temp=temp.next;
			i--;
		}
		if(temp.next==null){
			temp.next=temp.next.next;
		}
		head=head.next;
		}
		LinkedListCRUD.toString(head);
		LinkedListCRUD.toString(temp);
		return head;
	}
	
	@Test
	public void test(){
		ListNode a =new ListNode(4);
		LinkedListCRUD.addNode(a,3);
		LinkedListCRUD.addNode(a,2);
		LinkedListCRUD.addNode(a,1);
		LinkedListCRUD.toString(removeNthFromEnd(a,2));
	}

	
}
