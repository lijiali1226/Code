#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        a = list(s)
        a.sort()
        b = list(t)
        b.sort()
        # print(a,b)
        if a != b:
            return False
        else:
            return True


x = Solution()
s1 = "anagram"
t1 = "nagaram"
print(x.isAnagram(s1, t1))
s2 = "rat"
t2 = "car"
print(x.isAnagram(s2, t2))
s3 = "aacc"
t3 = "ccac"
print(x.isAnagram(s3, t3))
