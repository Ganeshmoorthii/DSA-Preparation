// 1. Simple Iteration (Optimal for 1s and 0s)
public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0, max = 0;
    for (int num : nums) {
        if (num == 1) {
            count++;
            max = Math.max(max, count);
        } else {
            count = 0;
        }
    }
    return max;
}

// 2. Using Sliding Window (Template-style)
public int findMaxConsecutiveOnes(int[] nums) {
    int left = 0, right = 0, maxLen = 0;
    while (right < nums.length) {
        if (nums[right] == 1) {
            maxLen = Math.max(maxLen, right - left + 1);
        } else {
            left = right + 1;
        }
        right++;
    }
    return maxLen;
}


// 3. Brute Force (Educational)
public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
        int count = 0;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 1) count++;
            else break;
        }
        max = Math.max(max, count);
    }
    return max;
}

// 4. Allow At Most One 0 to Flip to 1
// Leetcode #487: [Max Consecutive Ones II]
public int findMaxConsecutiveOnesWithFlip(int[] nums) {
    int left = 0, zeros = 0, max = 0;

    for (int right = 0; right < nums.length; right++) {
        if (nums[right] == 0) zeros++;

        while (zeros > 1) {
            if (nums[left++] == 0) zeros--;
        }

        max = Math.max(max, right - left + 1);
    }
    return max;
}
