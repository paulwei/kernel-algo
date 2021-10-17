package com.whl.algo.order;

public class HeapSort {

    static void heapSort(int []a,int len){
        int i;
        for(i=len/2;i>=0;i--){ /*把a[]构造成一个大顶堆*/
            HeapAdjust(a,i,len);
        }
        for(i=len;i>0;i--){//每次构造一个满足堆条件的，然后首尾交换，减少shu
            swap(a,0,i); /*交换堆顶最大元素和堆尾最小元素*/
            HeapAdjust(a,0,i-1);  /*把交换后的堆a[0,i-1]，再次构造成大顶顶，使堆顶元素为最大值*/
        }
    }
    static void HeapAdjust(int []a,int start,int len){
        int temp,j;
        temp=a[start];
        for(j=2*start;j<=len;j*=2){   /*从index最大的有孩子的节点开始筛选，堆排*/
            System.out.println("start:"+start+",j:"+j+",temp:"+temp+",a[start]:"+a[start]+",a[j]:"+a[j]);
            if(j<len&&a[j]<a[j+1])    /*是index=j的元素为较大的元素*/
                j++;
            if(temp>=a[j])             //父节点大于较大元素子节点比较忽略
                break;
            a[start]=a[j];            /*将较大元素赋值给父节点*/
            start=j;                  //继续左子树
        }
        a[start]=temp;
    }
    static void swap(int a[],int low,int high){
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
    }
    public static void main(String[]args){
        int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
        heapSort(b, b.length - 1);
        for(int w:b){
            System.out.print(" "+w);
        }
    }


}
