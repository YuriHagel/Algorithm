package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/
     * problem 1 Two Sum
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * example
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    public static int[] twoSum(int[] nums, int target) {
        // first way brute force algorithm
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }

    public static int[] twoSum2(int[] nums, int target) {
        // second way using a hashmap
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("iiiii " + nums[i]);
            int complement = target - nums[i];
            System.out.println("ooooo " + complement);
            if (mapNums.containsKey(complement)) {
                return new int[]{mapNums.get(complement), i};
            }
            mapNums.put(nums[i], i);
            System.out.println("ppppp " + mapNums);
        }
        throw new IllegalArgumentException("no match found!");
    }
}
