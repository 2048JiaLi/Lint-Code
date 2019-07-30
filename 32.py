
''' 同类型题目滑动窗口， 1117
描述
给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的最短子串。

*如果在source中没有这样的子串，返回""。
*如果有多个这样的子串，保证在source中始终只有一个唯一的最短子串。
*目标字符串可能包含重复字符，最小窗口应覆盖所有字符，包括目标中的重复字符

###说明
在答案的子串中的字母在目标字符串中是否需要具有相同的顺序？

——不需要。

样例
例1:

输入:
""
""
输出:
""
例2:

输入:
"ADOBECODEBANC"
"ABC"
输出:
"BANC"
'''


"""
@param source : A string
@param target: A string
@return: A string denote the minimum window, return "" if there is no such a string
"""
import collections
def minWindow(source , target): #target中元素不重复
    # write your code here
    left,right = 0,0
    cnt = 0
    res = ""
    d = collections.defaultdict(int)
    diff = float('inf')

    tmp = collections.defaultdict(int)
    for t in target:
        tmp[t] += 1

    while right < len(source):
        if d[source[right]] == 0 and set(source[right]).issubset(target):
            cnt += 1
        d[source[right]] += 1

        while left<=right and cnt==len(set(target)) and equal(d,target):#判断窗口内是否包含了所有target元素，equal()使target串元素可重复
            if right-left < diff:
                diff = right - left
                res = source[left:right+1]
            
            d[source[left]] -= 1
            #if d[source[left]] == 0 and set(source[left]).issubset(target):
            if d[source[left]] == 0 and set(source[left]).issubset(target):
                del d[source[left]]
                cnt -= 1
            left += 1
        
        right += 1
    return res

def equal(d,target):    #用于解决target串中有重复元素出现
    tmp = collections.defaultdict(int)
    for t in target:
        tmp[t] += 1

    for t in set(target):
        if tmp[t] > d[t]:
            return False
    return True

if __name__=='__main__':
    #source = "ADOBECODEBANC"
    #target = "ABC"
    source ="abcdecf"
    target = "acc"

    res = minWindow(source,target)
    print(res)
