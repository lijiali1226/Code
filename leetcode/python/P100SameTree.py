#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import random


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class Tree(object):
    def __init__(self):
        self.val = None

    @staticmethod
    def add(val):
        return TreeNode(val)

    def insert(self, node, val):
        if node is None:
            return self.add(val)
        elif val <= node.val:
            node.left = self.insert(node.left, val)
        else:
            node.right = self.insert(node.right, val)
        return node

    def print(self, node):
        if node is None:
            pass
        else:
            self.print(node.left)
            print(node.val)
            self.print(node.right)


class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """

        if p is None and q is None:
            return True
        elif (p is None and q is not None) or (q is None and p is not None) or (p.val != q.val):
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)


a = Tree()
root_a = a.add(5)
b = Tree()
root_b = b.add(5)

l = random.sample([i for i in range(1, 10)], 5)
print(l)
for j in l:
    # print(j)
    a.insert(root_a, j)
# a.print(root_a)

l = random.sample([i for i in range(1, 10)], 5)
print(l)
for j in l:
    # print(j)
    b.insert(root_b, j)
# b.print(root_b)

x = Solution()
print(x.isSameTree(TreeNode(0), TreeNode(0)))
print(x.isSameTree(root_a, root_b))
