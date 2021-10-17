package com.java.thread.type;

public class RepeatStr {
    public static void main(String[] args) {
        boolean result = isRepeat("abab".toCharArray());
        System.out.println(result);
    }
    public static boolean isRepeat(char[] arrs){
        int len = arrs.length;
        for(int k=1;k<len;k++){
            int i=0;
            int j=i+k;
            boolean isRepeat = true;
            while(j<len){
                isRepeat = isRepeat && arrs[i]==arrs[j];
                i++;
                j++;
            }
            if(isRepeat){
                return isRepeat;
            }
        }
        return  false;

    }
}

