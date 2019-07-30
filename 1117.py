'''
1117. 最小范围
中文English
有k个升序排列的数组，寻找一个最小范围，使每个数组中至少有一个元素被包含。

样例
样例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释: 
List 1: [4, 10, 15, 24,26], 24在[20,24]中.
List 2: [0, 9, 12, 20], 20在[20,24]中.
List 3: [5, 18, 22, 30], 22在[20,24]中.

注意事项:
*范围[a,b]比范围[c,d]小，当且仅当b-a < d-c，或是a < c且b-a == d-c.
*给定数组包含重复元素，故升序是指后面元素大于等于前面元素。
*1 <= k <= 3500
*-105<=元素值<=105.     ##若数据都是正值，会简单点
'''
print(__doc__)

'''
算法思想：
虽然每个数组都是有序的，但是考虑到他们之间的数字差距可能很大，
所以我们最好还是合并成一个数组统一处理比较好，但是合并成一个大数组还需要保留其原属数组的序号，
所以我们大数组中存pair对，同时保存数字和原数组的序号。然后我们重新按照数字大小进行排序，
这样我们的问题实际上就转换成了求一个最小窗口，使其能够同时包括所有数组中的至少一个数字。

???????? 没看懂为什么要这样做
我们用两个指针left和right来确定滑动窗口的范围，
我们还要用一个哈希表来建立每个数组与其数组中数字出现的个数之间的映射，
变量cnt表示当前窗口中的数字覆盖了几个数组，diff为窗口的大小，
我们让right向右滑动，然后判断如果right指向的数字所在数组没有被覆盖到，cnt自增1，
然后哈希表中对应的数组出现次数自增1，
然后我们循环判断如果cnt此时为k(数组的个数)且left不大于right，
那么我们用当前窗口的范围来更新结果，
然后此时我们想缩小窗口，通过将left向右移，移动之前需要减小哈希表中的映射值，
因为我们去除了数字，如果此时映射值为0了，说明我们有个数组无法覆盖到了，cnt就要自减1。
'''
import collections
def smallestRange(nums):  #原文：https://blog.csdn.net/fuxuemingzhu/article/details/82932656 
    """
    :type nums: List[List[int]]
    :rtype: List[int]
    """
    v  = []
    for i in range(len(nums)):
        for num in nums[i]:
            v.append((num, i))
    v.sort()
    left, right, n = 0, 0, len(v)
    d = collections.defaultdict(int)
    k = len(nums)
    cnt = 0
    res = [0, 0]    #变量cnt表示当前窗口中的数字覆盖了几个数组，diff为窗口的大小
    diff = float('inf')     #正无穷数
    while right < n:
        if d[v[right][1]] == 0: #默认值为0  
            cnt += 1        #right指向的数字所在数组没有被覆盖到，cnt自增1，
        d[v[right][1]] += 1#哈希表中对应的数组出现次数自增1
        while left <= right and cnt == k:   #判断如果cnt此时为k(数组的个数)且left不大于right
            if v[right][0] - v[left][0] < diff:
                diff = v[right][0] - v[left][0]
                res = [v[left][0], v[right][0]]

            d[v[left][1]] -= 1
            if d[v[left][1]] == 0:
                del d[v[left][1]]
                cnt -= 1    #因为我们去除了数字，如果此时映射值为0了，说明我们有个数组无法覆盖到了，cnt就要自减1。
            left += 1   #想缩小窗口，通过将left向右移，移动之前需要减小哈希表中的映射值

        right += 1
    return res

if __name__ == "__main__":
    nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
    print(smallestRange(nums))