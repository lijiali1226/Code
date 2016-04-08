#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution(object):
    def canWinNim(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n % 4 != 0

    def test(self, n):
        print(n, self.canWinNim(n))


if __name__ == '__main__':
    a = Solution()
    for i in range(1, 11):
        a.test(i)
