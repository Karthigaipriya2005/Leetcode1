class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        string_num = str(x)
        len_num = len(string_num)
        mid = len_num // 2
        
        # Odd length
        if len_num % 2 == 1:
            left = string_num[:mid]
            right = string_num[mid+1:]
        else:
            left = string_num[:mid]
            right = string_num[mid:]
        
        return left == right[::-1]
