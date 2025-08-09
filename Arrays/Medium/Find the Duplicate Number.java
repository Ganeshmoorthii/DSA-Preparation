// 1. Sorting (O(n log n) time, O(1) extra space)
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1; // shouldn't happen
    }
}

// 2. HashSet (O(n) time, O(n) space)
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return num;
        }
        return -1;
    }
}

// 3. Binary Search on Value Range (O(n log n) time, O(1) space)
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}

// 4. Floyd’s Cycle Detection (Tortoise & Hare) — O(n) time, O(1) space
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Phase 1: Find intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find cycle start (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}

// 5. Negative Marking (O(n) time, O(1) space)
class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) return index;
            nums[index] = -nums[index];
        }
        return -1;
    }
}
