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
        l = [0 for i in range(128)]
        # print(l)
        for i in s:
            l[ord(i)] += 1
        for j in t:
            l[ord(j)] -= 1
        return [i for i in l if i != 0] == []


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
