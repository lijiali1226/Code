#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
       
        a = sum(int(i) for i in str(num))
        while a/10 >= 1:
            num = a
            a = sum(int(i) for i in str(num))
        return a

    def test(self, n):
        print("test", n, self.addDigits(n))
       
    
if __name__ == '__main__':
    x = Solution()
    x.test(38)
    x.test(2)
    x.test(19)
