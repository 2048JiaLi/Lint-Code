'''
Description
将一个字符串中的小写字母转换为大写字母。不是字母的字符不需要做改变。

Example
样例 1:

输入: str = "abc"
输出: "ABC"
样例 2:

输入: str = "aBc"
输出: "ABC"
样例 3:

输入: str = "abC12"
输出: "ABC12"
'''

class Solution:
    """
    @param str: A string
    @return: A string
    """
    def lowercaseToUppercase2(self, str1):
        # write your code here
        '''#这种方法是将小写替换成大写
        import string
        lowercase = string.ascii_lowercase
        uppercase = string.ascii_uppercase

        tmp = str.maketrans(lowercase,uppercase)
        
        return str1.translate(tmp)
        '''
        return str1.upper()

str1 = 'aBc111'
res = Solution()
print(res.lowercaseToUppercase2(str1))