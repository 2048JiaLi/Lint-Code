s = "world"

#方法一、正则化表达式   Your submission beats 70.80% Submissions!
class Solution_one:
    """
    @param: s: A string
    @return: A string
    """
    def reverseWords(self, s):
        # write your code here
        import re
        res = re.findall(r'[^\s]+',s)
        return ' '.join(reversed(res))

#方法二、遍历一次字符串   Your submission beats 85.40% Submissions!
class Solution:
    """
    @param: s: A string
    @return: A string
    """
    def reverseWords(self, s):
        # write your code here
        res = []
        tmp = ''
        for i in range(len(s)):
            if s[i] != ' ':
                tmp = tmp+s[i]
            else:
                if tmp != '':
                    res.append(tmp)
                    tmp = ''

        if tmp != '':
            res.append(tmp)

        return ' '.join(reversed(res))