package com.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangwei
 * 2020/4/8 11:13
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _260_OnlyOnceNum3 {

    /**
     * HashMap 空间复杂度 O(N)
     * 两次遍历，一次统计个数，一次找出个数为1的元素
     *
     * @param nums
     * @return
     */
    public int[] solution1(int[] nums) {
        int[] res = new int[2];
        if (nums.length < 2) return res;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1)
                res[j++] = nums[i];
        }

        return res;
    }

    /**
     * Set 空间复杂度 O(N)
     * 一次遍历，若当前元素已在集合中出现过，则移除，否则加进去，最后剩下的就是需要返回的
     *
     * @param nums
     * @return
     */
    public int[] solution2(int[] nums) {
        if (nums.length < 2) return new int[2];
        Set<Integer> set = new HashSet<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        return new int[]{iterator.next(), iterator.next()};
    }

    /**
     * 异或 空间复杂度 O(1)
     * 首先，根据二进制某一位是1还是0，可以把所有数字分为两组，并且相同的数字肯定肯定在同一组
     * 比如 1，2，3，2，3，5
     * A:任选一个位置作为区分标志，2，2在一组，3，3在一组
     * B:但我们需要将1和5分到不同组，
     * 因为只有两个数字是唯一的，所以只要把1和5也分开就能同时满足A和B，并且相同元素在同一组内
     * 这样，在组内，对全部元素进行异或，重复元素就会消失，剩下的就是唯一
     *
     * 那么，满足A好办，随便取个位置就可以，要怎么满足B呢？
     * 我们可以这样想，假如1和5的二进制有三个位置不同，那么我们从这三个位置随便取一个位置作为区分标准，是不是就可以满足B，当然A也就满足了
     *
     * 所以接下来，我们要找到 1 和 5 哪几个位置不同(也就是在这个位置上，1的二进制是1，5的二进制是0，或1的二进制是0，5的二进制是1)
     * 首先，我们对数组全部元素做异或，消除重复元素，最终也就是 1^5,结果记为bit
     * 异或本身就是二进制运算，对于每一个位置，相同为0不同为1，所以bit就是我们想要的结果，它就代表了1和5哪几位不同
     *
     * 接下来，bit里面有好几位是1(也就是1和5有好几位不一样)，我们需要找出一个位置即可，并且需要把其他位置变为0
     * 这样就得到一个只有一个位置是1其他位置都是0的数，用它作为区分标准，就可实现上面说到的A和B
     *
     * 假设bit里面有三位1，这里我们提供一种保留最后一个1，把其他位置变为0的做法
     * 那就是 【bit & -bit】
     *
     * 我们就用1和5举例子，
     * 首先在计算机中用补码表示
     *           1 ：0001
     *           5 : 0101
     * bit = 1 ^ 5 : 0100 也就是4
     * 因为负数牵扯到正负号所以我们假设每个数是8位，最高位符号位0为正，1为负
     * bit(+4)  原码反码补码 0000 0100
     * -bit(-4) 原码: 1000 0100
     *          反码：1111 1011
     *          补码：1111 1100
     * bit & -bit:   0000 0100 flag
     * 这个flag就是我们要找的区分标准
     *
     * 接下来，根据flag将nums划分为2组，分别在组内进行异或，即可
     *
     * 怎么根据flag划分：nums[i] & flag
     * flag只有1位是1，所以相与的结果，如果 x 这个位置是0，那么结果就是0，如果x这个位置是1，那么结果就是一个>0的数，所以根据想与的结果是否为0就可分为两组。
     *
     * @param nums
     * @return
     */
    public int[] solution3(int[] nums) {
        int[] res = new int[2];
        if (nums.length < 2) return res;
        int bitDiff = 0;
        // 去除掉重复元素，只剩下 1 ^ 5
        for (int i = 0; i < nums.length; i++) {
            bitDiff ^= nums[i];
        }
        // 从 1 ^ 5 的结果，得到一个区分标准
        bitDiff &= -bitDiff;
        for (int i = 0; i < nums.length; i++) {
            // 根据这一位是1还是0，划分为两组
            if ((nums[i] & bitDiff) != 0)
                // 组内分别异或，重复元素消失，只剩下唯一
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(5 ^ 1);
    }
}
