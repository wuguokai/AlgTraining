package wgk.alg.training;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 *
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 *
 * @author wuguokai
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(summaryRanges2(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        } else if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int end = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                end = nums[i + 1];
                count ++;
            } else if (count > 0) {
                result.add(start + "->" + end);
                start = nums[i + 1];
                count = 0;
            } else {
                result.add(String.valueOf(start));
                start = nums[i + 1];
            }
        }
        if (end < nums[nums.length - 1]) {
            result.add(String.valueOf(nums[nums.length - 1]));
        } else if (end == nums[nums.length - 1] && end - nums[nums.length - 2] == 1) {
            result.add(start + "->" + end);
        }
        return result;
    }

    // * 输入：nums = [0,1,2,4,5,7]
    public static List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while (i < nums.length) {
            int start = i;
            i ++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                i ++;
            }
            int end = i - 1;
            StringBuilder s = new StringBuilder().append(nums[start]);
            if (start < end) {
                s.append("->");
                s.append(nums[end]);
            }
            result.add(s.toString());
        }
        return result;
    }
}
