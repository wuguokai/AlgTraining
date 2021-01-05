package wgk.alg.training;

/**
 * @author wuguokai
 */
public class Test {
    public static void main(String[] args) {
        int a = 4; // 100
        int b = 2; // 10
        System.out.println(a & b); // & 与：  100 & 10 = 000 => 0
        System.out.println(a ^ b); // ^ 异或：  100 ^ 10 = 110 => 6
        System.out.println(a | b); // | 或： 100 | 10 = 110 => 6
        System.out.println(~ a); // ~ 非： ~ 100 => ..00100 (32位) => （取反 -1） ..11011 - 1 = ..11010 => （取反） 101 = 5 => （取负） -5
    }
}
