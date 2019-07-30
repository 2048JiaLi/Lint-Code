'''
给定一个非负整数, 你可以选择交换它的两个数位. 返回你能获得的最大的合法的数.

给定的数字在 [0, 10^8] 范围内

您在真实的面试中是否遇到过这个题？  
样例
样例1:

输入: 2736
输出: 7236
解释: 交换数字2和数字7.
样例2:

输入: 9973
输出: 9973
解释: 不用交换.
'''
digit = 9973
tmp = str(digit)
state = True
result = str(digit)
while state and len(tmp) != 0:
    max_d = max(tmp)    #字符串为空时，会报错
    position = tmp.find(max_d)
    if position == 0:
        tmp = tmp[1:]
    else:
        pos_tmp = result.find(tmp[0])
        pos_res = result.rfind(max_d)
        result = list(result)
        result[pos_tmp] = max_d
        result[pos_res] = tmp[0]
        state = False 
print(result)
#print(int(''.join(result)))