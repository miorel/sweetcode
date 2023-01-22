def is_palindrome(s, lo, hi):
    while lo < hi:
        if s[lo] != s[hi]:
            return False
        lo += 1
        hi -= 1
    return True

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        cur = []
        def traverse(start):
            if start == len(s):
                res.append(cur[:])
                return
            
            for end in range(start, len(s)):
                if not is_palindrome(s, start, end):
                    continue
                
                cur.append(s[start:end + 1])
                traverse(end + 1)
                cur.pop()

        traverse(0)

        return res