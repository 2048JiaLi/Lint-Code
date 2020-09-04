package sort;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/8 19:14
 */
public class QuickSort {
    public static void QuickSort(int[] nums, int low, int high){
        if (low >= high){return;}
        int mid = partition(nums,low,high);
        QuickSort(nums,low,mid-1);
        QuickSort(nums,mid+1,high);
    }

    public static int partition(int[] nums, int low, int high){
        int tmp = nums[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && nums[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            nums[low] = nums[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && nums[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            nums[high] = nums[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给nums[low]
        nums[low] = tmp;
        return low; // 返回tmp的正确位置
    }


    public static void main(String[] args){
        int[] nums = {18,11,0,8,12,45};
        QuickSort(nums,0,5);
        for (int i:nums){
            System.out.println(i);
        }
    }
}
