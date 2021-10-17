package com.whl.algo.math;

/*
* [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
* 返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
* */
public class Print {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[][] nums ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printA(nums);
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
