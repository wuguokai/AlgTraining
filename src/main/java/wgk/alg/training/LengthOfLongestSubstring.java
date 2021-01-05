package wgk.alg.training;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author wuguokai
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
//        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int r = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            result = Math.max(result, set.size());
        }
        return result;
    }
}
