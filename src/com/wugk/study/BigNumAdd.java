package com.wugk.study;

/*
*
* Created by WUGUOKAI on 2017/10/26.
*/

public class BigNumAdd {
    public static void main(String[] args){
        int MAX = 1010;
        int[] a = new int[MAX];
        int[] b = new int[MAX];
        int N, len1, len2, i, k, up, tmp, ncase = 1;
        String str1, str2;
        str1 = "11111111111111111115234";
        str2 = "9999999999999999999999999999999999999999995678";
        len1 = str1.length();
        len2 = str2.length();
        String[] s1 = str1.split("");
        String[] s2 = str2.split("");
        for(i = len1 - 1, k = 0; i >= 0; --i) {
            a[k++] = Integer.parseInt(s1[i]);
        }
        for(i = len2 - 1, k = 0; i >= 0; --i) {
            b[k++] = Integer.parseInt(s2[i]);
        }
        for(i = 0, up = 0; i < (len1>len2 ? len1 : len2)+1; ++i)
        {
            a[i] = a[i] + b[i] + up;
            up = a[i] / 10;
            a[i] %= 10;
        }
        System.out.print(str1 + " + "+ str2 + " = ");
        String result = "";
        for(k = i; k >= 0; --k){
            result += a[k];
        }
        System.out.print(result.replaceFirst("^0*", ""));
        System.out.println();
    }
}
