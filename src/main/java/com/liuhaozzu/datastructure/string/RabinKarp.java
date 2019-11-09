package com.liuhaozzu.datastructure.string;

public class RabinKarp {
    private String pat;
    private long patHash;
    private int M;
    private long Q;//一个很大的素数
    private int R=256;
    private long RM;//R^(M-1)%Q

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM=1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;//用于减去第一个数字时的计算
        }
        patHash = hash(pat, M);
    }

    public int search(String txt) {
        //在文本中查找相等的散列值
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) {
            return 0;//一開始就匹配成功了
        }
        for (int i = M; i < N; i++) {
            //减去第一个数字，加上最后一个数字，再次检查匹配
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                if (check(i - M + 1)) {
                    return i - M + 1;//找到匹配
                }
            }
        }
        return N;
    }


    public boolean check(int i) {
        return true;
    }

    private long hash(String pat, int m) {
        return 0;
    }

    private long longRandomPrime() {
        return 0;
    }
}
