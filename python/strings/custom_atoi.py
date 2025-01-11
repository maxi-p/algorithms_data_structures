class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip().rstrip()
        if len(s) == 0:
            return 0

        isPositive = False if s[0] == '-' else True
        if s[0] == '-' or s[0] == '+':
            s = s[1:len(s)]

        # removing leading zeros
        i = 0
        while i < len(s) and s[i] == '0':
            i += 1 
        s = s[i:len(s)]
        
        # stopping at the first non-digit instance
        i = 0
        while i < len(s) and ord(s[i]) >= 48 and ord(s[i]) <= 57:
            i += 1
        s = s[0:i]

        maxNumNeg = 2 ** 31
        maxNumPos = maxNumNeg - 1
        sign = 1 if isPositive else -1
        if len(s) > 10:
            return -maxNumNeg if sign == -1 else maxNumPos
        
        maxNumStr = "2147483648"
        if len(s) == 10:
            for i in range(0, 10):
                if i == 9:
                    if sign == -1 and s[9] > '8':
                        return -maxNumNeg
                    if sign == 1 and s[9] > '7':
                        return maxNumPos
                else:
                    if s[i] > maxNumStr[i]:
                        return -maxNumNeg if sign == -1 else maxNumPos
                    elif s[i] < maxNumStr[i]:
                        break
            
        res = 0
        mult = 1
        for i in range(len(s)-1, -1, -1):
            value = ord(s[i]) - 48
            res += value * mult
            mult *= 10
        
        
        return res * sign
        