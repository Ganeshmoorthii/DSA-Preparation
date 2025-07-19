// 1. Brute Force (Using Extra Array)
public void rotateLeft(int[] nums, int d) {
    int n = nums.length;
    d = d % n; // Handle d > n
    int[] temp = new int[n];

    for (int i = 0; i < n; i++) {
        temp[i] = nums[(i + d) % n];
    }

    for (int i = 0; i < n; i++) {
        nums[i] = temp[i];
    }
}

// 2. In-Place Using Reversal Algorithm (Most Efficient)
public void rotateLeft(int[] nums, int d) {
    int n = nums.length;
    d = d % n;

    reverse(nums, 0, d - 1);       // Reverse first d
    reverse(nums, d, n - 1);       // Reverse rest
    reverse(nums, 0, n - 1);       // Reverse whole array
}

private void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

// 3. Left Rotate One-by-One d Times (Inefficient for large d)
public void rotateLeft(int[] nums, int d) {
    int n = nums.length;
    for (int i = 0; i < d; i++) {
        int first = nums[0];
        for (int j = 0; j < n - 1; j++) {
            nums[j] = nums[j + 1];
        }
        nums[n - 1] = first;
    }
}

