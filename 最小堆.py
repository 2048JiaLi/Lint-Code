#https://mp.weixin.qq.com/s?__biz=MzAxMjUyNDQ5OA==&mid=2653561285&idx=1&sn=db03247c2ba54b5f17fda97d76d4bc48&chksm=806e0f78b719866e4c5c7003a848b81e2196ce53bb117cc048a2409a64d8793adf89590a88da&mpshare=1&scene=23&srcid=&sharer_sharetime=1573174915359&sharer_shareid=146e00a5d117656b5e8159f8890e708c#rd

class Heap(object):
    def __init__(self, array):  #堆以数组表示
        self.array = array
        for index in range(len(array)//2 -1,-1,-1):
            self.sink(index,self.array)

    def __str__(self):
        return str(self.array)

    def __len__(self):
        return len(self.array)

    def insert(self, num):  #插入元素   
        self.array.append(num)      #先把放到堆的末尾
        index = len(self.array) - 1     #该元素在数组中的位置

        parent_index = index // 2       #堆可看作是一个完全二叉树，性质：对于任意一个父节点的序号n来说（这里n从0算），它的子节点的序号一定是2n+1,2n+2
        #// 表示整除（向下取整）
        while parent_index>=0 and self.array[parent_index]>num: #始终与父节点交换位置
            self.array[parent_index],self.array[index] = self.array[index],self.array[parent_index]
            if parent_index==0:
                break
            index = parent_index
            parent_index = parent_index//2

    def pop(self):  #删除元素，在堆中是默认删除顶点元素， 即最大堆时删除最大元素，最小堆时删除最小元素；
        #删除array[0]
        end_ele = self.array.pop()  #最后一个元素替换到顶点，然后再下沉
        pop_value = self.array[0]   #所需删除的元素

        self.array[0] = end_ele
        self.sink(0,self.array)     #顶点用最后一个元素替换后，需要下沉满足堆定义
        return pop_value

    def sink(self, index, array):
        left_node_index = index*2 + 1 #左孩子节点
        right_node_index = index*2 + 2  #右孩子节点
        if left_node_index<len(array):          #有左孩子，可能会下沉
            left_ele = array[left_node_index]   
            if right_node_index >= len(array):  #没有右孩子
                min_value = left_ele
                min_index = left_node_index
            else:                               #有右孩子
                right_ele = array[right_node_index]
                if left_ele<right_ele:
                    min_value = left_ele
                    min_index = left_node_index
                else:
                    min_value = right_ele
                    min_index = right_node_index
            
            if array[index] > min_value:    #交换元素位置
                array[index],array[min_index] = array[min_index],array[index]

            self.sink(min_index,array)

        self.array[:len(array)] = array