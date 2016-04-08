#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Definition for singly-linked list.


class ListNode(object):
    def __init__(self, val):
        self.val = val
        self.next = None


class LinkedList(object):
    def __init__(self):
        self.val = None

    @staticmethod
    def add(val):
        return ListNode(val)

    def insert(self, node, val):
        if node is None:
            return self.add(val)
        else:
            node.next = self.insert(node.next, val)
        return node

    @staticmethod
    def print(node):
        while node is not None:
            print(node.val)
            node = node.next


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None
        temp = head
        while temp.next is not None:
            temp = temp.next
        tail = temp
        ret = tail

        while tail.next != head:
            temp = head
            while temp.next is None or temp.next != tail:
                temp = temp.next
            temp.next = temp.next.next
            tail.next = temp
            tail = tail.next
        return ret


a = LinkedList()
root = a.add(1)
# print(root)
for i in range(5):
    a.insert(root, i)
    # print(i)
# print(a)
a.print(root)

x = Solution()
a.print(x.reverseList(root))
