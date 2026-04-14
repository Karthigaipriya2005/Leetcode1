class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # Edge case: if numRows is 1, zigzag is just the string itself
        if numRows == 1 or numRows >= len(s):
            return s

        # Fixed: Initialize rows as a list containing numRows empty lists
        rows = [[] for _ in range(numRows)]

        i = 0
        while i < len(s):
            # Downward direction
            row = 0
            # Fixed: 'nowRows' typo changed to 'numRows'
            while row < numRows and i < len(s):
                rows[row].append(s[i])
                row = row + 1
                i = i + 1
            
            # Upward direction (ZigZag)
            # Fixed: Start at numRows - 2 to avoid repeating the last row
            row = numRows - 2
            while row > 0 and i < len(s):
                rows[row].append(s[i])
                row = row - 1
                i = i + 1
        
        # Fixed: Strings don't have .add(). Use "".join() for efficiency.
        result = []
        for r in rows:
            for c in r:
                result.append(c)

        return "".join(result)
