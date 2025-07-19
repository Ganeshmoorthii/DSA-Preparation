// 1. Two-Pointer Approach (Best – In-place & Efficient)
public void moveZeroes(int[] nums) {
    int index = 0; // position to place the next non-zero

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[index++] = nums[i];
        }
    }

    // Fill remaining positions with 0
    while (index < nums.length) {
        nums[index++] = 0;
    }
}

// 2. Swap Method (Alternative In-place)
public void moveZeroes(int[] nums) {
    int lastNonZeroFoundAt = 0;

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            int temp = nums[lastNonZeroFoundAt];
            nums[lastNonZeroFoundAt] = nums[i];
            nums[i] = temp;
            lastNonZeroFoundAt++;
        }
    }
}

// 3. Using Extra Array (Not In-place)
public int[] moveZeroesToEnd(int[] nums) {
    int[] result = new int[nums.length];
    int index = 0;

    for (int num : nums) {
        if (num != 0) {
            result[index++] = num;
        }
    }

    // Remaining places are already 0
    return result;
}

// 4. Brute Force (Avoid)
public void moveZeroes(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
        for (int j = 0; j < nums.length - 1 - i; j++) {
            if (nums[j] == 0 && nums[j+1] != 0) {
                // swap
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
}
