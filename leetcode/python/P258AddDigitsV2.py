#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """

        while True: 
            a = sum(int(i) for i in str(num))
            if a/10 < 1:
                break
            num = a
        return a

    def test(self, n):
        print("test", n, self.addDigits(n))
       
    
if __name__ == '__main__':
    x = Solution()
    x.test(38)
    x.test(2)
    x.test(19)
