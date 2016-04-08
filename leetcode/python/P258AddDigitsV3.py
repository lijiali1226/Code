#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        return 0 if num == 0 else 1+((num-1) % 9)
    
    def test(self, n):
        print("test", n, self.addDigits(n))
       
    
if __name__ == '__main__':
    x = Solution()
    x.test(38)
    x.test(2)
    x.test(19)
