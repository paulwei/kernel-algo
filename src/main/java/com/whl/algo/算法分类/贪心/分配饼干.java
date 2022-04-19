package com.whl.algo.算法分类.贪心;

import java.util.Arrays;

public class 分配饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {//先仅最小满足,用最小重量满足,如满足 gi++,si++下一个孩子,累加下一个饼干,否则
                gi++;
            }
            si++;
        }
        return gi;
    }
}
