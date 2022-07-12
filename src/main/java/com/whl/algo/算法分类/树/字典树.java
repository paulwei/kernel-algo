package com.whl.algo.算法分类.树;

/*
* 前缀树，trier,字典树，空间换时间
* 匹配前缀,词频统计，前缀统计
*
* */
public class 字典树 {
    public static void buildTree(TrieNode root,String str){
        if(root==null || str==null){
            return;
        }
        int j=0;
        for(Character c:str.toCharArray()){
            int i = c-'0';
            if(root.nextNode[i]==null){
                root.nextNode[i]=new TrieNode(c);
            }
            root=root.nextNode[i];
            root.prefix++;
            if((j++)==(str.length()-1)){
                root.isEnd=true;
                root.word=str;
            }
        }
        root.count++;
    }

    //查找该单词是否存在，如果存在返回数量，不存在返回-1
    public static int search(TrieNode root,String str){
        if(root==null||str.length()==0){
            return -1;
        }
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
            //如果该分支不存在，表名该单词不存在
            if(root.nextNode[c[i]-'a']==null){
                return -1;
            }
            //如果存在，则继续向下遍历
            root=root.nextNode[c[i]-'a'];
        }

        //如果count==0,也说明该单词不存在
        if(root.count==0){
            return -1;
        }
        return root.count;
    }

    //查询以str为前缀的单词数量
    public static int searchPrefix(TrieNode root,String str){
        if(root==null||str.length()==0){
            return -1;
        }
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
            //如果该分支不存在，表名该单词不存在
            if(root.nextNode[c[i]-'a']==null){
                return -1;
            }
            //如果存在，则继续向下遍历
            root=root.nextNode[c[i]-'a'];
        }
        return root.prefix;
    }
}


class TrieNode{
    boolean isEnd;
    String word;
    Character c;
    int count ;   //精确单词统计
    int prefix ;//前缀统计
    TrieNode[] nextNode=new TrieNode[26];
    public TrieNode(Character c){
        this.c=c;
        this.count=0;
        this.prefix=0;
    }
}