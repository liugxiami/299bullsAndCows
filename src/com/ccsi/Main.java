package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String secret="1123";
        String guess="0111";
        System.out.println(getHint(secret,guess));
    }
    public static String getHint(String secret,String guess){
        int bull=0;
        int cow=0;
        int total=0;
        int[] s=new int[10];                 //数字是0~9
        int[] g=new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i)==guess.charAt(i)) bull++;
        }
        for (int i = 0; i < secret.length(); i++) {
            s[secret.charAt(i)-'0']++;
        }
        for (int i = 0; i < guess.length(); i++) {       //统计各数字出现的次数
            g[guess.charAt(i)-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            total+=Math.min(s[i],g[i]);                   //重复出现的总次数
        }
        cow=total-bull;
        return String.format("%dA%dB",bull,cow);
    }
}
