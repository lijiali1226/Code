#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = 0
        for i in nums:
            if i != 0:
                nums[k] = i
                k += 1
        for i in range(k, n):
            nums[i] = 0


num = [0, 1, 0, 3, 12]
print([i for i in num])
x = Solution()
x.moveZeroes(num)
print([i for i in num])
