#!/usr/bin/env python3
# -*- coding: utf-8 -*-


# Definition for a binary tree node.
class CNode:
    left, right, val = None, None, 0

    def __init__(self, val):
        # initializes the val members
        self.left = None
        self.right = None
        self.val = val


class CBOrdTree:
    def __init__(self):
        # initializes the node member
        self.node = None

    @staticmethod
    def add(val):
        # creates a new node and returns it
        return CNode(val)

    def insert(self, node, val):
        # inserts a new val
        if node is None:
            # it there isn't any val
            # adds it and returns
            return self.add(val)
        else:
            # enters into the tree
            if val <= node.val:
                # if the val is less than the stored one
                # goes into the left-sub-tree
                node.left = self.insert(node.left, val)
            else:
                # processes the right-sub-tree
                node.right = self.insert(node.right, val)
            return node

    def print(self, node):
        # prints the tree path
        if node is None:
            pass
        else:
            self.print(node.left)
            print(node.val, )
            self.print(node.right)

    def print_rev(self, node):
        # prints the tree path in reverse
        # order
        if node is None:
            pass
        else:
            self.print_rev(node.right)
            print(node.val, )
            self.print_rev(node.left)

    def invertTree(self, node):
        """
        :type node: TreeNode
        :rtype: TreeNode
        """
        if node is None:
            return None
        temp = node.left
        node.left = node.right
        node.right = temp
        self.invertTree(node.left)
        self.invertTree(node.right)
        return node


if __name__ == "__main__":
    # create the binary tree
    BTree = CBOrdTree()
    # add the node node
    root = BTree.add(0)
    # ask the user to insert values
    for i in range(0, 5):
        data = int(input("insert the node value nr %d: " % i))
        # insert values
        BTree.insert(root, data)
    print("\n")

    BTree.print(root)
    print("\n")
    BTree.print_rev(root)
    print("\n")

    print(BTree.invertTree(None))
    a = BTree.invertTree(root)
    BTree.print(a)
