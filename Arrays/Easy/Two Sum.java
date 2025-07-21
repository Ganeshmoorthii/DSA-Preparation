// Solution 1: Brute Force (Nested Loops)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

// Solution 2: Using HashMap (Optimal)
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[] { map.get(rem), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}

// Solution 3: Two Pointers (Sorted Array only)
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] original = nums.clone();
        Arrays.sort(nums); // O(n log n)

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                // Find original indices
                int first = -1, second = -1;
                for (int k = 0; k < original.length; k++) {
                    if (original[k] == nums[i] && first == -1) first = k;
                    else if (original[k] == nums[j] && second == -1) second = k;
                }
                return new int[] { first, second };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {};
    }
}

//  Solution 4: Using a Set (Only for “Pair Exists” Yes/No type)
import java.util.HashSet;

class Solution {
    public boolean hasTwoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }
}
