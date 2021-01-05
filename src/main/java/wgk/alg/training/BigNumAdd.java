package wgk.alg.training;

/*
* 大数相加
* 1. 大数转换成数组
* 2. 逐位相加，考虑进位,0
*
* Created by WUGUOKAI on 2017/10/26.
*/

public class BigNumAdd {
    public static void main(String[] args){
        String str1, str2;
        str1 = "11111111111111111115234";
        str2 = "9999999999999999999999999999999999999999995678";
        System.out.print(str1 + " + "+ str2 + " = ");
        System.out.print(bigNumAdd(str1, str2));
        System.out.println();
    }

    public static String bigNumAdd(String str1, String str2) {
        int MAX = 5100;
        int[] a = new int[MAX];
        int[] b = new int[MAX];
        int N, len1, len2, i, k, up, tmp, ncase = 1;
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
        for(i = 0, up = 0; i < (Math.max(len1, len2))+1; ++i)
        {
            a[i] = a[i] + b[i] + up;
            up = a[i] / 10;
            a[i] %= 10;
        }
        StringBuilder result = new StringBuilder();
        for(k = i; k >= 0; --k){
            result.append(a[k]);
        }
        String num = result.toString().replaceFirst("^0*", "");
        return num.equals("") ? "0" : num;
    }
}
