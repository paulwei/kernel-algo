package com.whl.algo.算法分类.广度遍历;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
* [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
* 返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
* */
public class 对角线打印 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[][] nums ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        System.out.println(nums.length);
        print(nums);
    }

    public static void print(int[][] nums){
       Queue<Pair> queue = new LinkedList<>();
       Set<Pair> set = new HashSet<>();
       int n = nums.length;
       queue.add(new Pair<Integer,Integer>(0,n-1));
       while (!queue.isEmpty()){
           Pair<Integer,Integer> p = queue.poll();
           int i = p.getKey();
           int j = p.getValue();
//           System.out.println(String.format("i:%s,j:%s",i,j));
           if(set.add(p)){
               System.out.println(nums[i][j]);
           }
           if(j>=1){
               queue.add(new Pair(i,j-1));
           }
           if(i<n-1){
               Pair pp = new Pair(i+1,j);
               queue.add(pp);
//               System.out.println("pp:"+pp);
           }

       }

    }


    public static void printA(int[][] nums){
        int n = nums.length;
        int i=0;
        int j=n-1;

        while(i>=0 && i<n && j>=0 && j<n){
//            System.out.println(String.format("i:%s,j:%s",i,j));
            i++;
            j--;
            int x=0;
            int y= i;
            while (x<=j){
                System.out.println(nums[x++][y++]);
            }
//            if(i>0){
//                i--;
//            }else{
//                i++;
//            }
//            if(j<n){
//                j++;
//            }else{
//                j--;
//            }
//            int x=i;
//            int y=0;

        }
}

}
