package com.array;

/**
 * @author wangwei
 * 2020/4/4 14:05
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _35_SearchInsearchPosition {

    /**
     * 一次遍历，时间复杂度 O(n)，对于 [1,2,3,4,5,6] 7 这种情况效率低下
     *
     * @param nums
     * @param target
     * @return
     */
    public int solution1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    /**
     * 二分查找
     * 找到的时候 返回的是下标
     * 没找到的时候 返回的是应该放入的位置
     * @param nums
     * @param target
     * @return
     */
    public static int solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1,2,3,4,5,6}, 1));
        System.out.println(solution2(new int[]{1,2,3,4,6}, 5));
        System.out.println(solution2(new int[]{1,2,3,4,5,6}, 0));
        System.out.println(solution2(new int[]{1,2,3,4,5,6}, 7));
    }
}