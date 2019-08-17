## Description
**Given an input string, reverse the string word by word.**

## Clarification
**What constitutes a word?**
A sequence of non-space characters constitutes a word and some words have punctuation at the end.
**Could the input string contain leading or trailing spaces?**
Yes. However, your reversed string should not contain leading or trailing spaces.
**How about multiple spaces between two words?**
Reduce them to a single space in the reversed string.
```
Example
Example 1:
	Input:  "the sky is blue"
	Output:  "blue is sky the"
	
	Explanation: 
	return a reverse the string word by word.

Example 2:
	Input:  "hello world"
	Output:  "world hello"
	
	Explanation: 
	return a reverse the string word by word.
```
## Python
```
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
```
