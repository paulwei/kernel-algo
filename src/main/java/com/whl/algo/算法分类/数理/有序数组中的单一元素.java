package com.whl.algo.算法分类.数理;
/*
* 思路和算法 要时间复杂度 o(logn)
* 假设只出现一次的元素位于下标 xx，由于其余每个元素都出现两次，因此下标 xx 的左边和右边都有偶数个元素，数组的长度是奇数。获取mid如果mid+1相等唯一数在左边，如果不等在右边,继续递归查找
* */
public class 有序数组中的单一元素 {
    public static int singleNonDuplicate(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low<high-1){
            int mid = (high - low) / 2 + low;
            System.out.println("mid:"+arr[mid]+",low:"+arr[low]+",high:"+arr[high]);
            if(arr[mid]==arr[mid+1]){//唯一数在左边
                high=mid;
            }else{//唯一数在右边
                low=mid+1;
            }
        }
        return arr[low];
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4};
        int ans = singleNonDuplicate(arr);
        System.out.println(ans);
    }
}
