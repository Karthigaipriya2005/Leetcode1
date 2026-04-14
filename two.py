class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        while len(nums) !=0:
            first_index = len(nums)-1
            try:
                return [nums.index(target - nums.pop()),first_index]
            except:
                pass
        return []
