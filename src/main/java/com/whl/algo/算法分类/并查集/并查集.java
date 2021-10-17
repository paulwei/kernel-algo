package com.whl.algo.算法分类.并查集;

import java.util.HashMap;
import java.util.Map;

public class 并查集 {
    private static Map<Integer,Integer> father = new HashMap<Integer,Integer>();;

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
        }
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            father.put(rootX,rootY);
        }
    }

    public int find(int x) {
        int root = x;

        while(father.get(root) != null){
            root = father.get(root);
        }

        while(x != root){
            int original_father = father.get(x);
            father.put(x,root);
            x = original_father;
        }

        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

 /*   public static void main(String[] args) {
        public static void main(String[] args) {
            int[][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
            int result = findCircleNum(isConnected);
            System.out.println(result);
        }

    }*/

}
