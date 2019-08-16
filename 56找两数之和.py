numbers=[1,0,-1]
target=0

class Solution:
    """
    @param numbers: An array of Integer
    @param target: target = numbers[index1] + numbers[index2]
    @return: [index1, index2] (index1 < index2)
    """
    def twoSum(self, numbers, target):
        # write your code here
        
        res = {}
        for i in range(len(numbers)):
            tmp = target - numbers[i]
            if tmp in res:
                return res[tmp],i
            else:
                res[numbers[i]] = i