#!/usr/bin/env python3
# -*- coding: utf-8 -*-


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        l = self.maxDepth(root.left)
        r = self.maxDepth(root.right)
        return max(l, r)+1


if __name__ == '__main__':
    # import doctest
    # doctest.testmod()
    a = TreeNode(5)
    print(a.maxDepth(None))