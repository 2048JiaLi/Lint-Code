"""
@param A: an array
@param B: an array
@return: dot product of two array   
判断数组是否存在点积，以及是否为空数组
"""
def dotProduct(A, B):
    # Write your code here
    if len(A) != len(B):
        return -1
    res = 0
    for a,b in zip(A,B):
        res += a*b
    return res

if __name__=='__main__':
    A = [3,1,2]
    B = [1,2,3]
    print(dotProduct(A,B))