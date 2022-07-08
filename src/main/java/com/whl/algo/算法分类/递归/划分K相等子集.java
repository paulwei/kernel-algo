package com.whl.algo.算法分类.递归;

import com.alibaba.fastjson.JSON;

import java.util.*;

/*
* 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
*
*
*
* */
public class 划分K相等子集 {

    public static Map<Integer,Integer> sumMap = new HashMap<>();

    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subset(int[] nums) {
        dfs(nums, new ArrayList<>());
        return ans;
    }

    private static void dfs(int[] nums, List<Integer> tmp) {
//        System.out.println(Arrays.toString(nums) + "," + tmp);
        ans.add(new ArrayList<>(tmp));
        if (tmp.size() == nums.length) {
            return;
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) {
                    tmp.add(num);
                    dfs(nums, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
       int[] nums = {4, 3, 2, 3, 5, 2, 1} ;
       int k = 4;
        subset(nums);
//        System.out.println("ans:"+ JSON.toJSONString(ans));
        for (List<Integer> sub:ans){
            int sum = 0;
            for(Integer e:sub){
                sum+=e;
            }
            if(sum==5){
                System.out.println(JSON.toJSONString(sub));
            }
            sumMap.put(sum,sumMap.getOrDefault(sum,0)+1);
        }
        for(Integer key :sumMap.keySet()){
            if(sumMap.get(key)>k){
                System.out.println("满足条件的K");
            }
        }

    }
}
